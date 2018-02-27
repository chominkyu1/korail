package com.korail.control;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korail.domain.UserVO;
import com.korail.dto.LoginDTO;
import com.korail.service.UserService;

@Controller
@RequestMapping("/basic")
public class UserController {
	@Inject
	private UserService userService; 
	
	@RequestMapping("/login")
	public void login() {	
	}
	@RequestMapping("/loginpost")
	public void loginPOST(String member_loginid,String member_pw) throws Exception {
		//System.out.println("로그인폼정보>>"+dto);
/*		Map<String, Object> map = new HashMap<>();
		map.put("member_loginid", member_loginid);
		map.put("member_pw", member_pw);*/
		UserVO userVO = userService.login(member_loginid,member_pw);
		System.out.println(userVO);
		if(userVO==null)
		{
			System.out.println("로그인실패");
			
		}
	}
	
}
