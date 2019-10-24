package com.zhjie.cellphone.service;

import java.util.List;
import java.util.Map;


public interface CellPhoneService {

	/**
	 * 组合电话号码
	 * @param cellphonestr
	 * @return
	 */
	public List<Map<String,List<String>>> generateCellPhoneNum(String cellphonestr);
}
