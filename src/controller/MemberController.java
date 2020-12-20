package controller;

import exception.NoUsernameException;
import exception.WrongOriginPwdException;
import exception.WrongPwdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;
import entity.Member;
import exception.DuplicateUsernameException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@ExceptionHandler(DuplicateUsernameException.class)
	public ModelAndView registExceptionHandler(Exception e){
		return new ModelAndView("register-1","e",e);
	}
	
	@RequestMapping("/regist")
	public String regist(Member member)throws Exception{
		memberService.regist(member);
		return "register-2";
	}

	@ExceptionHandler(value = {NoUsernameException.class})
	public ModelAndView loginExcepthinHandler(Exception e){
		return new ModelAndView("login","e",e);
	}

	@ExceptionHandler(value = {WrongPwdException.class})
	public ModelAndView wrongPwdExcepthinHandler(Exception e){
		return new ModelAndView("login","e",e);
	}


	@RequestMapping("/login")
	public String login(Member member, HttpSession session)throws Exception{
		Member m = memberService.login(member);
		session.setAttribute("member",m);
		return "redirect:/subscription/center";
	}

	@RequestMapping("/memberExit")
	public String memberExit(HttpSession session){
		session.removeAttribute("member");
		return "hotel";
	}


	@RequestMapping("/edit")
	public String edit(Member member,HttpSession session){
		memberService.editMember(member);
		session.removeAttribute("member");
		return "login";
	}

	@ExceptionHandler(value = {WrongOriginPwdException.class})
	public ModelAndView wrongOriginPwdExcepthinHandler(Exception e){
		return new ModelAndView("editPassword","e",e);
	}

	@RequestMapping("/editPwd")
	public String editPwd(Member member, HttpServletRequest request) throws WrongOriginPwdException {
		HttpSession session = request.getSession();
		member = (Member) session.getAttribute("member");

		String pwd = request.getParameter("password");
		String newPwd = request.getParameter("newPassword");

		memberService.editPwd(member,pwd,newPwd);
		session.removeAttribute("member");
		return "login";
	}
}
