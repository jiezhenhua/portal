package com.zhjie.cellphone.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zhjie.cellphone.service.CellPhoneService;
import com.zhjie.common.util.Constant;
import com.zhjie.common.util.Solution;
@Service
public class CellPhoneServiceImp implements CellPhoneService {

		@Override
		public List<Map<String,List<String>>> generateCellPhoneNum(String cellphonestr) {
			List<Map<String,List<String>>> listMap = new ArrayList<>();
			//获取前三位
			char[] ch = cellphonestr.toCharArray();
			System.out.println("-------开始生成号码----------");
			permutationCellPhone(listMap, ch, "yd");
			permutationCellPhone(listMap, ch, "lt");
			permutationCellPhone(listMap, ch, "dx");
			System.out.println("-------开始生成结束----------");
			return listMap;
		}
		
		/**
		 * 组装电话号码
		 * @param list
		 * @param cellPhoneStr
		 */
		public void permutationCellPhone(List<Map<String,List<String>>> listMap, char[] ch, String type){
			String[] topThree;
			if("yd".equals(type)){
				topThree = Constant.YD_TOP_THREE;
			}else if("lt".equals(type)){
				topThree = Constant.LT_TOP_THREE;
			}else{
				topThree = Constant.DX_TOP_THREE;
			}
			Map<String,List<String>> map = new HashMap<>();
			List<String> list = new ArrayList<String>();
			for (String str : topThree) {//前三位种类
				char[] ydch = str.toCharArray();
				StringBuffer topthree = new StringBuffer();
				StringBuffer afterEight = new StringBuffer();
				List<Integer> listIndex = new ArrayList<>(); 
				for (char c : ydch) {
					for (int i = 0; i < ch.length; i++) {
						if(c == ch[i] && !listIndex.contains(i)){
							if(topthree.length()<4){
								topthree.append(ch[i]);
								listIndex.add(i);
								if(topthree.length()<3)
									break;
							}
						}
						//循环结束判断是否找到符合情况的前三位号码
						if(topthree.length() == 3){
							//提取后八位
							for (int j = 0; j < ch.length; j++) {
								if(!listIndex.contains(j)){
									afterEight.append(ch[j]);
								}
							}
							List<String> l= Solution.Permutation(afterEight.toString());
							List<String> ll = new ArrayList<>();
							for (String cellphone : l) {
								ll.add(str+cellphone);
							}
							list.addAll(ll);
							break;
						}
					}
				}
			}
			map.put(type, list);
			listMap.add(map);
		}
}
