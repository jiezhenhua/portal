package portal;

import java.math.BigDecimal;

public class Test7 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			randomPackage(new BigDecimal(5), 6, 0.1, 5);
		}
	}

	/**
	 * 
	 * <p>
	 * Title: randomPackage
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param total_money
	 *            总金额
	 * @param total_people
	 *            人数
	 * @param lowerLimit
	 *            下浮比例 默认0.1（就是total_money*lowerLimit）
	 * @param upperLimit
	 *            上浮比例 默认5（就是total_money*upperLimit））
	 */
	public static void randomPackage(BigDecimal total_money, int total_people, double lowerLimit, double upperLimit) {
		BigDecimal min_money = total_money.multiply(new BigDecimal(lowerLimit));// 计算红包最小值
		BigDecimal max_money = total_money.multiply(new BigDecimal(upperLimit));// 计算红包最大值
		if (upperLimit >= total_people) {// 上浮比例超过人数,最大金额就是一人拿最大剩下的人拿最小的
			max_money = total_money.subtract(min_money.multiply(new BigDecimal(total_people - 1)));
		}
		min_money = min_money.multiply(new BigDecimal(100));
		max_money = max_money.multiply(new BigDecimal(100));
		BigDecimal allresult = BigDecimal.ZERO;
		for (int i = 0; i < total_people; i++) {
			// 保护值
			BigDecimal procte = min_money.multiply(new BigDecimal(total_people - i - 1)).divide(new BigDecimal(100));
			// 可支配金额
			BigDecimal zpje = total_money.subtract(procte);
			if (zpje.multiply(new BigDecimal(100)).compareTo(max_money) == -1) {// 支配金额小于最大金额
				max_money = zpje.multiply(new BigDecimal(100));
			}
			BigDecimal result = restRound(min_money, max_money, i, zpje, total_people - 1);
			total_money = total_money.subtract(result);
			allresult = allresult.add(result);
			System.out.format("红包  %.2f,余额  %.2f \n", result, total_money);
		}
		System.out.format("总金额%.2f \n", allresult);
	}

	public static BigDecimal restRound(BigDecimal min, BigDecimal max, int i, BigDecimal money, int count) {
		BigDecimal redpac = BigDecimal.ZERO;
		if (i == count) {
			redpac = money;
		} else {
			redpac = ((max.subtract(min)).multiply(new BigDecimal((int) (Math.random() * 100) / 100.0)).add(min))
					.divide(new BigDecimal(100));
		}
		return redpac;
	}
}
