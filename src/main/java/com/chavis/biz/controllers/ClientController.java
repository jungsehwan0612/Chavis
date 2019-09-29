package com.chavis.biz.controllers;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chavis.biz.client.service.ClientService;
import com.chavis.biz.client.vo.ClientVO;

@Controller
public class ClientController {
	@Autowired
	ClientService service;
	
	@RequestMapping(value = "/Client/join.do", method = RequestMethod.GET)
	public String addJoin() {	
		return "Client/Client_join";
	}
	
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String loginProc(ClientVO vo,HttpServletRequest request) throws Exception {
		
		ClientVO Client = service.login(vo.getClientId(), vo.getPassword());
		if(Client != null) {
			request.getSession().setAttribute("Client", Client);
			request.getSession().setAttribute("login", Client);
			
			return "redirect:index.do";
		}else {
			request.setAttribute("msg", "로그인 정보를 다시 입력하세요.");
			
			return "redirect:login.do";
		}
	}
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {		
		HttpSession session = request.getSession();
		if(session!=null)
			session.invalidate();
		
		request.setAttribute("msg", "로그아웃 되었습니다.");
		System.out.println("로그아웃 되었습니다.");
		
		return "redirect:login.do";
	}
	
	@RequestMapping(value="/Client/list.do")
	public @ResponseBody List<ClientVO> getClientList(){
		return service.getClientList();
	}

	@RequestMapping(value="/Client/view.do", method=RequestMethod.POST)
	public @ResponseBody ClientVO getClient(@RequestParam("client_id") String client_id) {
		return service.getClient(client_id);
	}
	
	
	@RequestMapping(value="/Client/remove.do", method=RequestMethod.POST)
	public @ResponseBody int removeClient(@RequestParam("client_id") String client_id) {
		return service.removeClient(client_id);
	}
	
	@RequestMapping("/Client/modify.do")
	public ModelAndView getModifyView(@RequestParam("client_id") String client_id) {
		ModelAndView view = new ModelAndView();
		
		view.addObject("Client", service.getClient(client_id));
		view.setViewName("Client/Client_modify");
		return view;
	}
	
	@RequestMapping("/Client/update.do")
	public ModelAndView update(@ModelAttribute("Client") ClientVO vo) {
		ModelAndView view = new ModelAndView();
		service.updateClient(vo);
		view.addObject("Client", service.getClient(vo.getClientId()));
		view.setViewName("Client/Client_view");
		return view;
	}

	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception,Model model) {
		// ClientController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
	
	@RequestMapping(value="/Client/clientlist", method = RequestMethod.POST)
	public @ResponseBody List<ClientVO> selectClientList(@RequestBody Map<String, Object> param){
		return service.selectClientList(param);
	}
}
