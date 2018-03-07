package com.korail.control;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.korail.domain.MemberVO;
import com.korail.dto.IdsearchDTO;
import com.korail.service.UserService;

@Controller
@RequestMapping("/basic")
public class UserController {
	@Inject
	private UserService userService; 
	
	@RequestMapping("/login")
	public void login() {	
		System.out.println("로그인시도");
	}
	@RequestMapping("/mainView2")
	public void mainView2() {
	}
	@RequestMapping(value="/loginpost", method = RequestMethod.POST)
	public String loginPOST(String member_Loginid,String member_Pw, 
			HttpSession session, HttpServletRequest request) throws Exception {
		
		MemberVO memberVO = userService.login(member_Loginid,member_Pw);
		System.out.println(memberVO);
		if(memberVO != null) {
			session.setAttribute("memberVO", memberVO);
		}else if(memberVO == null)
		{
			System.out.println("로그인실패");
			return "redirect:login";
		}
		return "redirect:mainView";
	}
	
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("memberVO", null);
        return "redirect:login";
    }
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public void memberInsertget() {
		System.out.println("야호");
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String memberInsert(MemberVO memberVO,RedirectAttributes attr) throws Exception {
		System.out.println("시작");
		Date from = memberVO.getMember_Birth_jsp();
		SimpleDateFormat daFormat = new SimpleDateFormat("yyyy/MM/dd");
		String date = daFormat.format(from);
		memberVO.setMember_Birth(date);
		String member_Profile = "C:\\Users\\Playdata\\Desktop\\erd\\"+memberVO.getMember_Profile();
		memberVO.setMember_Profile(member_Profile);
		System.out.println("userVO2>>"+memberVO);
		userService.insert(memberVO);
		System.out.println("post체크");
		return "redirect:/basic/login";
	}
	
	
	@RequestMapping(value= "/idsearch" ,method=RequestMethod.GET)
	public void idSearchGet() throws Exception {
	}
	@RequestMapping(value= "/idsearch" ,method=RequestMethod.POST)
	public void idSearchPost(IdsearchDTO idsearchDTO,Model model) throws Exception {
		System.out.println(idsearchDTO);
		String member_Loginid = userService.idSearch(idsearchDTO);
		System.out.println(member_Loginid);
		model.addAttribute("member_Loginid",member_Loginid);
	}
	@RequestMapping("/mainView")
	public void mainPage() {
	}
	
	
	
}
