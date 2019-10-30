package portal;

public class Test8 {
	public static void main(String[] args) {
		for (long i = 0; i < 10; i++) {
			randomPackage(10, 4, 0.1, 5);
		}

	}

	public static void randomPackage(long total_money, int total_people, double lowerLimit, double upperLimit) {
		double avgMoney = total_money / (double) total_people;
		long min_money = (long) ((avgMoney * lowerLimit) < 1 ? 1 : (avgMoney * lowerLimit)); // 计算出最小金额
		long max_money = (long) ((avgMoney * upperLimit) < 1 ? 1 : (avgMoney * upperLimit)); // 计算出最大金额
		if (upperLimit >= total_people) {// 上浮比例超过人数,最大金额就是一人拿最大剩下的人拿最小的
			max_money = total_money - ((total_people - 1) * min_money);
		}
		long allresult = 0;
		for (long i = 0; i < total_people; i++) {
			// 保护值
			long procte = (total_people - i - 1) * min_money;
			// 可支配金额
			long zpje = total_money - procte;
			if (zpje < max_money) {
				max_money = zpje;
			}
			long result = restRound(min_money, max_money, i, zpje, total_people - 1);
			total_money = total_money - result;
			allresult += result;
			System.out.format("红包  %.2f,余额  %.2f \n", result / 100.0, total_money / 100.0);
		}
		System.out.format("总金额%.2f \n", allresult / 100.0);
	}

	/**
	 * 
	 * <p>
	 * Title: restRound
	 * </p>
	 * <p>
	 * Description:随机金额位于最大和最小金额之间
	 * </p>
	 * 
	 * @param min
	 * @param max
	 * @param i
	 * @param money
	 * @param count
	 * @return
	 */
	public static long restRound(long min, long max, long i, long money, long count) {
		long redpac = 0;
		if (i == count) {// 最后一个人取剩下的金额
			redpac = money;
		} else {
			redpac = (long) (Math.random() * (max - min) + min);
		}
		return redpac;
	}
}
