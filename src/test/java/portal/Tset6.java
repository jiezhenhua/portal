package portal;

import java.util.Map;

public class Tset6 {
	public static void main(String[] args) {
		for (long i = 0; i < 10; i++) {
			randomPackage();
		}

	}

	public static void randomPackage() {
		long total_money = 290000;
		long total_people = 3;
		long min_money = 33; // 每个人最少能收到0.05元、
		long max_money = 934; // 每个人最少能收到0.2元、
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
			System.out.format("红包  %d,余额  %d \n", result, total_money);
		}
		System.out.format("总金额%d \n", allresult);
	}

	public static long restRound(long min, long max, long i, long money, long count) {
		long redpac = 0;
		if (i == count) {
			redpac = money;
		} else {
			redpac = (long) (Math.random() * (max - min) + min);
		}
		return redpac;
		}
}
