package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class server extends Application{
	
	TextArea textarea;
	Button startBtn;		// 서버에 접속하는 버튼
	Button exitBtn;
	ExecutorService executorService;
	
	// 클라이언트의 접속을 받아들이는 서버소켓.
	ServerSocket server;
	
	private void PrintMsg(String msg) {
		Platform.runLater(()->{
			textarea.appendText(msg + "\n");
		});
	}
	class EchoRunnable implements Runnable{
		// 가지고 있어야 하는 field
		Socket socket;		// 클라이언트와 연결된 소켓
		BufferedReader br;	// 입력을 위한 스트림
		PrintWriter out;	// 출력을 위한 스트림
		
		public EchoRunnable(Socket socket) {
			super();
			this.socket = socket;
			try {
				this.br = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				this.out = new PrintWriter(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			// 클라이언트와 echo처리 구현
			// 클라이언트가 문자열을 보내면 해당 문자열을 받아서
			// 다시 클라이언트에게 전달.
			// 한번하고 종료하는게 아니라 클라이언트가 "/EXIT/"라는 
			// 문자열을 보낼 때까지 지속.
			String line = "";
			try {
				while((line = br.readLine()) != null) {
					if(Thread.currentThread().isInterrupted()) {
						break;
					}
					// 소켓의 접속이 끊기면 소켓에서는 null값을 보낸다.
					if(line.equals("/EXIT/")) {
						break;	// 가장 근접한 loop를 탈출!
					}else {
						PrintMsg(line);
						out.println(line);
						out.flush();
					}
				}
				// 자원 반날
				out.close();
				br.close();
				socket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면구성해서 window 띄우는 코드
		// 화면기본 layout을 설정 => 화면을 동서남북중앙(5 개의 영역)으로 분리
		BorderPane root = new BorderPane();
		// BorderPane의 크기를 설정 => 화면에 띄우는 window의 크기 설정
		root.setPrefSize(700, 500);
		
		// Component생성해서 BorderPane에 부착
		textarea = new TextArea();
		root.setCenter(textarea);
		
		startBtn = new Button("Echo 서버 시작");
		startBtn.setPrefSize(250, 50);
		startBtn.setOnAction(t->{
			executorService = Executors.newCachedThreadPool();
			// 버튼에서 Action이 발생(클릭)했을 때 호출!
			// 서버프로그램을 시작
			// 클라이언트의 접속을기다린다! -> 접속이 되면Thread를 하나 생성
			// -> Thread를 시작해서 클라이언트와 Thread가 통신하도록 만든다.
			// 서버는 다시 다른 클라이언트의 접속을 기다린다!
			Runnable runnable = () ->{
				try {
					server = new ServerSocket(6767);
					PrintMsg("Echo 서버 기동!!");
					while(true) {
						PrintMsg("클라이언트 접속 대기");
						Socket s = server.accept();		// blocking
						PrintMsg("클라이언트 접속 성공");
						// 클라이언트가 접속했으니 Thread를 만들고 시작해야 한다.
						EchoRunnable r = new EchoRunnable(s);
						executorService.execute(r);		// thread 실행
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
			executorService.execute(runnable);			
		});
		exitBtn = new Button("Echo 서버 종료");
		exitBtn.setPrefSize(250, 50);
		exitBtn.setOnAction(t->{
			executorService.shutdownNow();
			try {
				server.close();
				PrintMsg("Echo 서버 중지!!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPrefSize(700, 50);
		flowPane.getChildren().add(startBtn);
		flowPane.getChildren().add(exitBtn);
		root.setBottom(flowPane);
		
		// Scene객체가 필요함.
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server Window");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}

}
