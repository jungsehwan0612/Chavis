package com.chavis.biz.conrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.chavis.biz.user.service.userService;
import com.chavis.biz.user.vo.userVO;

@Controller
public class UserController {
	@Autowired
	userService service;
	
	@RequestMapping(value = "/user/join.do", method = RequestMethod.GET)
	public String addJoin() {	
		return "user/user_join";
	}
	@RequestMapping("/user/list.do")
	public ModelAndView getUserList() {
		ModelAndView view = new ModelAndView();
		
		view.addObject("users", service.getUserList());
		view.setViewName("user/user_list");
		return view;
	}

	@RequestMapping("/user/view.do")
	public ModelAndView getView(@RequestParam("client_id") String client_id) {
		ModelAndView view = new ModelAndView();
		
		view.addObject("user", service.getUser(client_id));
		view.setViewName("user/user_view");
		return view;
	}
	@RequestMapping("/user/remove.do")
	public String deleteUserProc(@RequestParam("client_id") String client_id) {
		service.removeUser(client_id);
		return "redirect:./list.do";
	}
	@RequestMapping("/user/modify.do")
	public ModelAndView getModifyView(@RequestParam("client_id") String client_id) {
		ModelAndView view = new ModelAndView();
		
		view.addObject("user", service.getUser(client_id));
		view.setViewName("user/user_modify");
		return view;
	}
	@RequestMapping("/user/update.do")
	public ModelAndView update(@ModelAttribute("user") userVO vo) {
		ModelAndView view = new ModelAndView();
		service.updateUser(vo);
		view.addObject("user", service.getUser(vo.getClientId()));
		view.setViewName("user/user_view");
		return view;
	}

	@ExceptionHandler(Exception.class)
	public String Ex(Exception exception,Model model) {
		// UserController 예외발생시 호출됨
		model.addAttribute("exception", exception);
		return "error";
	}
}
