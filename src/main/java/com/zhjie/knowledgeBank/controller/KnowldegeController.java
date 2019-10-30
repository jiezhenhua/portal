package com.zhjie.knowledgeBank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * <p>Title: KnowldegeController</p>  
 * <p>Description: 知识库</p>  
 * @author zhjie  
 * @date 2019年10月26日
 */
@Controller
@RequestMapping(value="/knowledge")
public class KnowldegeController {

	//  跳转页面
	@RequestMapping("/home/portal")
    public String knowledgeHome(){
        return "knowledgeBank/knowledgeHome";
    }

}
