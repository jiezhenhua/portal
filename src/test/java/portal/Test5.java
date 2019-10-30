package portal;

import java.math.BigDecimal;
import java.util.Random;

public class Test5 {
	/**
	 *
	 * @param randomMax
	 *            随机数期间最大值
	 * @param randomMin
	 *            随机数期间最小值
	 * @return double
	 */
	public static double randomNum(double randomMax, double randomMin) {
		Random random = new Random();
		double randomMoney = Math.floor(random.nextDouble() * 100 * randomMax) / 100;
		BigDecimal randomMoneyBigDeximal = BigDecimal.valueOf(randomMoney);
		return randomMoneyBigDeximal.compareTo(BigDecimal.valueOf(randomMin)) > 0 ? randomMoney : randomMin;
	}

	/**
	 * 按照平均数*2的随机算法生成红包
	 * 
	 * @param vagXTwo
	 * @return
	 */
	public static double randomByVagXTwo(double vagXTwo, double rdMin) {
		double rdMoney = Math.floor(new Random().nextDouble() * 100 * vagXTwo) / 100;
		return BigDecimal.valueOf(rdMoney).compareTo(BigDecimal.valueOf(rdMin)) > 0 ? rdMoney : rdMin;
	}

	/**
	 * 如果 rdNum>subMax 按照限制上下限来随机生成红包，否则按照平均数*2的随机算法生成红包 （1-subMax） 为有上下限的概率
	 * 
	 * @return
	 */
	public static boolean randomNumConf() {
		double subMax = 0.5;
		double rdNum = Math.floor(Math.random() * 100) / 100;
		return BigDecimal.valueOf(rdNum).compareTo(BigDecimal.valueOf(subMax)) > 0 ? true : false;
	}

	/**
	 * @param totalBonus
	 *            总金额
	 * @param totalNum
	 *            总数
	 * @param randomMax
	 *            随机最大
	 * @param randomMin
	 *            随机最小
	 * @return double
	 */
	public static double bonus(double totalBonus, int totalNum, double randomMax, double randomMin) {
		double bonusVAG = BigDecimal.valueOf(totalBonus).divide(BigDecimal.valueOf(totalNum), 2, BigDecimal.ROUND_DOWN)
				.doubleValue(); // 剩余金额平均值
		double rdMoney;
		// 最大值大于总金额
		boolean isDo = BigDecimal.valueOf(randomMax).compareTo(BigDecimal.valueOf(totalBonus)) > 0;
		if (isDo) {
			randomMax = totalBonus;
		}
		if (randomNumConf() && totalNum > 100 && !isDo) {
			rdMoney = randomNum(randomMax, randomMin);
		} else {
			randomMin = 0.01;
			if (totalNum == 1) {
				return (double) Math.round(totalBonus * 100) / 100;
			}
			rdMoney = randomByVagXTwo(BigDecimal.valueOf(bonusVAG).multiply(BigDecimal.valueOf(2)).doubleValue(),
					randomMin);
		}
		totalBonus = BigDecimal.valueOf(totalBonus).subtract(BigDecimal.valueOf(rdMoney)).doubleValue();
		return rdMoney;
	}

	public static void test(double totalBonus, int totalNum, double randomMax, double randomMin) {
		BigDecimal b = BigDecimal.ZERO;
		int c = totalNum;
		for (int i = 0; i < c; i++) {
			double n = bonus(totalBonus, totalNum, randomMax, randomMin);
			totalBonus = BigDecimal.valueOf(totalBonus).subtract(BigDecimal.valueOf(n)).doubleValue();
			totalNum--;
			b = b.add(BigDecimal.valueOf(n));
			System.out.print(n + "   ");
		}
		System.out.println();
		System.out.println("红包总数：" + b);
	}

	public static void main(String[] args){
       for (int i = 0; i <100 ; i++) {
			test(10, 5, 5, 0.5);
       }
}
}
