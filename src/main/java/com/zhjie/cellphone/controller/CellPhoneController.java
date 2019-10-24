package com.zhjie.cellphone.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhjie.cellphone.service.CellPhoneService;
import com.zhjie.common.util.CellPhoneCityUtil;

@Controller
@RequestMapping(value="/cellphone")
public class CellPhoneController {

	@Autowired 
	private  CellPhoneService cellPhoneService ;
//  跳转页面
	@RequestMapping("/cellPhoneHome/portal")
    public String cellPhoneHome(){
        return "cellphone/cellPhoneHome";
    }
	@RequestMapping("/generateCellPhoneNum")
    @ResponseBody
	public Map<String,Object> generateCellPhoneNum(String cellphonestr){
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("data", cellPhoneService.generateCellPhoneNum(cellphonestr));
		return result;
		
	}
	
	@RequestMapping("/getCellPhoneCity")
    @ResponseBody
	public Map<String,Object> getCellPhoneCity(String cellphoneNum){
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("data", CellPhoneCityUtil.getCity(cellphoneNum));
		return result;
		
	}
}
