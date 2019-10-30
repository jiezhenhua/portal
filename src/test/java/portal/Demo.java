package portal;

public class Demo {
	public static void main(String[] args) {
		randomPackage();
	}

	public static void randomPackage() {
		double total_money = 2;
		int total_people = 5;
		double min_money = 0.04; // 每个人最少能收到0.05元、
		double max_money = 1; // 每个人最少能收到0.05元、
		double lingjiezhi = (total_money / total_people) * 100;
		double allresult = 0;
		for (int i = 0; i < total_people; i++) {
			// 保护值
			double procte = (total_people - i - 1) * min_money / 100;
			;
			// 可支配金额
			double zpje = total_money - procte;
			if (zpje * 100 < max_money) {
				max_money = zpje * 100;
			}
			double result = restRound(min_money, max_money, i, zpje, total_people - 1);
			total_money = total_money - result;
			allresult += result;
			System.out.format("红包  %.2f,余额  %.2f \n", result, total_money);
		}
		System.out.format("总金额%.2f", allresult);
	}

	public static double restRound(double min, double max, int i, double money, int count) {
		double redpac = 0;
		if (i == 4) {
			redpac = money;
		} else {
			redpac = (Math.random() * (max - min) + min) / 100;
		}
		return redpac;
	}
}