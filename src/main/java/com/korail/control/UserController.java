package com.korail.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic")
public class UserController {
	
	@RequestMapping("/login")
	public void login() {
		
	}
	
}
