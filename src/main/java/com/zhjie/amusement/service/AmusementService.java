package com.zhjie.amusement.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface AmusementService {

	/**
	 * 发红包
	 * @param money 红包总金额
	 * @param num 人数
	 * @return
	 */
	public Map<String,Object> doSendHb(BigDecimal money, int num, List<String> personArr);
}
