package com.zhjie.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/welcome")
public class WelcomeController {

	@RequestMapping(value = "/home/portal", method = RequestMethod.GET)
	public String home(){
		return "home";
	}

	@RequestMapping(value = "/content/portal", method = RequestMethod.GET)
	public String index(){
		return "content";
	}

	@RequestMapping(value = "/left/portal", method = RequestMethod.GET)
	public String left(){
		return "left";
	}

	@RequestMapping(value = "/top/portal", method = RequestMethod.GET)
	public String top(){
		return "top";
	}
	
	@RequestMapping(value = "/home2/portal", method = RequestMethod.GET)
	public String home2(){
		return "home";
	}
}
