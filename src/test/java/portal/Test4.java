package portal;

import java.util.ArrayList;

public class Test4 {

	static ArrayList<Integer> moneyList = new ArrayList<>();// 最终金额存放的地方
	static int money = 1000;// 总共10块钱,扩大100倍,单位分
	static int count = 10;// 抽10次
	public static int runnum = 0;// 执行有效的次数，初始0，最高9
	public static void main(String[] args) {
		while (runnum < count) {
			int rs = 0;
			for (int as : moneyList) {
				rs += as;
			}
			mt(money - rs);
		}
		for (int as : moneyList) {
			System.out.print(as + "  ");
		}

	}

	public static int mt(int shengxiade) {
		if (runnum == count) {
			/**
			 * 最后一次（count） 循环moneyList，拿到最后剩下的钱
			 */
			int rs = 0;
			for (int as : moneyList) {
				rs += as;
			}
			runnum++;
			moneyList.add(money - rs);
			return runnum;
		}
		int mt = (int) (Math.random() * money);
		// mt = (double)Math.round(mt*100) / 100;
		if (90 < mt && mt < 130) {
			int start = 90 * (count - runnum - 1);
			int end = 130 * (count - runnum - 1);
			if (start < shengxiade - mt && shengxiade - mt < end) {
				moneyList.add(mt);// 会执行9次
				runnum++;
				System.out.println("第" + runnum + "次拿到的红包" + mt + "(自己除以100就是金额小数)");
			} else {
				moneyList.add(900 + (int) (Math.random() * 10));
				runnum++;
				System.out.println("第" + runnum + "次拿到的红包" + mt + "(自己除以100就是金额小数)");
			}
		} else {
			mt(shengxiade);// 10块钱
		}
		return runnum;
	}
}
