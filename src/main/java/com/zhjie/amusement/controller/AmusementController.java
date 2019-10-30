package com.zhjie.amusement.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhjie.amusement.service.AmusementService;

@Controller
@RequestMapping(value="/amusement")
public class AmusementController {

	@Autowired 
	private AmusementService amusementServie;
//  跳转页面
	@RequestMapping("/amusementHome/portal")
    public String amusementHome(){
        return "amusement/amusementHome";
    }

	/**
	 * 发红包
	 * @return
	 */
	@RequestMapping("/doSendHb")
	@ResponseBody
	public Map<String,Object> doSendHb(@RequestBody(required=true) Map<String, Object> params){
		String hbCount = (String) params.get("hbCount");
		String hbSumMoney = (String) params.get("hbSumMoney");
		List<String> personArr = (List<String>) params.get("personArr");
		return amusementServie.doSendHb(new BigDecimal(hbSumMoney), Integer.parseInt(hbCount), personArr);
		
	}
}
