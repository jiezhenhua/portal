package com.zhjie.common.util;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 发红包
 * 
 * @author 70975
 *
 */
public class RedPacket {

	public static void main(String[] args) {
		double money = 1.00;
		int num = 3;
		BigDecimal[] arr =  red(new BigDecimal(money), num);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("第一个人的红包数是：" + arr[i].doubleValue());
		}
	}

	/**
	 * 
	 * @param money
	 *            发红包金额
	 * @param num
	 *            人数
	 * @return
	 * @throws RuntimeException
	 */
	public static BigDecimal[] red(BigDecimal money, int num) throws RuntimeException {
		if (money.doubleValue() < num * 0.01) {
			throw new RuntimeException("金额不对....");
		}
		Random random = new Random(); // 使用分 进行计算金额
		int allMoney = money.multiply(BigDecimal.valueOf(100)).intValue();//发红包金额乘与100
		int count = 0; // 存储所有人的随机点数和
		double[] perCount = new double[num];// 存储每一个人的随机点数
		BigDecimal[] perMoney = new BigDecimal[num]; // 存储每一个人的红包金额
		// 给每一个人分配一个随机数
		for (int i = 0; i < perCount.length; i++) {
			int r = random.nextInt((num) * 99) + 1;
			count += r;
			perCount[i] = r;
		}
		int c = 0; // 分配红包金额
		for (int i = 0; i < perCount.length; i++) {
			Double x = new Double(perCount[i] / count);
			int m = (int) Math.floor(x * allMoney);
			if (m == 0) {
				m = 1;
			}
			c += m;
			if (i < perCount.length - 1) {
				perMoney[i] = (new BigDecimal(m).divide(new BigDecimal(100)));
			} else {
				perMoney[i] = (new BigDecimal(allMoney - c + m).divide(new BigDecimal(100)));
			}
		}
		return perMoney;
	}
}
