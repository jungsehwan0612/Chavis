package com.chavis.biz.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chavis.biz.carbodyshop.service.CarBodyshopService;
import com.chavis.biz.member.service.MemberService;
import com.chavis.biz.member.vo.MemberVO;

public class test {
	public static void main(String[] args) throws Exception {
		
		String[] config = { "applicationContext.xml" };
//		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		MemberService memberService = (MemberService) context.getBean("memberservice");
		MemberVO client = new MemberVO();

		client.setMember_id("test01");
		client.setMember_pw("1234");
		client.setMember_mname("테스트");
		client.setMember_phonenumber("00000000000");
//		clientService.addClient(client);	
//		
		for(MemberVO member : memberService.getMemberList())
			System.out.println(member);
		
		System.out.println("--------------------------");
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("client_id", "test01");
//		System.out.println(memberService.getClient(map));
//		
		memberService.getMember("oea0805");
		
//		ClientVO u2 = new ClientVO();
//		u2.setClientId("test01");
//		u2.setTel("010-9876-5432");
//		clientService.updateClient(u2);
//		
//		clientService.removeclient("test01");
		
	}
}
