package com.loginpage.login.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class WebController {
	@GetMapping("/login")
	public String loginPage(Principal principal){
		if(principal==null){
			return "login";
		}return "redirect:/home";
	}

	@GetMapping("/home")
	public String homePage(){
		return "home";
	}
}