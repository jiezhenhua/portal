package com.zhjie.amusement.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zhjie.amusement.service.AmusementService;
import com.zhjie.common.util.RedPacket;

@Service
public class AmusementServiceImpl implements AmusementService{

	@Override
	public Map<String, Object> doSendHb(BigDecimal money, int num, List<String> personArr) {
		Map<String, Object> map = new HashMap<>();
		BigDecimal[] arr = RedPacket.red(money, num);
		for (int i = 0; i < personArr.size(); i++) {
			map.put(personArr.get(i), arr[i]);
		}
		return map;
	}

}
