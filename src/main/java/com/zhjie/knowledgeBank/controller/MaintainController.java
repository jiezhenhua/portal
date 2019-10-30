package com.zhjie.knowledgeBank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/maintain")
public class MaintainController {

	//  跳转页面
	@RequestMapping("/maintain/portal")
    public String knowledgeHome(){
        return "/knowledgeBank/maintain";
    }

	//  跳转页面
	@RequestMapping("/knowledgeAdd/portal")
    public String knowledgeAdd(){
        return "/knowledgeBank/knowledgeAdd";
    }
}
