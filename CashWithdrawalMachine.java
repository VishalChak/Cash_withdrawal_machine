package cwm;

import java.util.Vector;

public class CashWithdrawalMachine {

	private static int getBalance() {
		int sum = 0;
		for (int i = 0; i < currencyCount.size(); i++) {
			sum = sum + currency[i] * currencyCount.get(i);
		}
		return sum;
	}

	private static int getcurrencyCount(int amount, int currency, int count) {
		if (amount >= currency) {
			if (count >= amount / currency) {
				return amount / currency;
			} else
				return count;
		}
		return 0;
	}

	public static void Withdrawal(int amount) {
		if (currencyCount == null)
			setcurrency();
		System.out.println("--------------------------------");
		if (amount > 15000) {
			System.out.println("Cash Withdrawal Limit exceeds");
		} else if (amount % 10 != 0) {
			System.out.println("Please enter valid amount");
		} else if (amount > CashWithdrawalMachine.getBalance()) {
			System.out.println("Insufficient Fund");
		} else {
			int WithdrawalcurrencyCount[] = new int[6];
			int i = 0, temp_count = 0;
			while (amount > 0 && i < 6) {
				temp_count = getcurrencyCount(amount, currency[i], currencyCount.get(i));
				WithdrawalcurrencyCount[i] = temp_count;
				amount = amount - currency[i] * temp_count;
				currencyCount.setElementAt((currencyCount.get(i) - temp_count), i);
				i++;
			}
			if (amount == 0) {
				System.out.println("Withdrawal Cash");
				for (i = 0; i < WithdrawalcurrencyCount.length; i++) {
					if (WithdrawalcurrencyCount[i] != 0)
						System.out.println(WithdrawalcurrencyCount[i] + " X " + currency[i]);
				}

				System.out.println("Remaining Cash");
				for (i = 0; i < currencyCount.size(); i++) {
					System.out.println(currencyCount.get(i) + " X " + currency[i]);
				}
			} else {
				String remaningcurrency = "";
				for (i = 0; i < currencyCount.size(); i++) {
					if (currencyCount.get(i) != 0) {
						if (remaningcurrency == "")
							remaningcurrency += currency[i];
						else
							remaningcurrency = remaningcurrency + " or " + currency[i];
					}
				}
				System.out.println("Please enter the amount multiple of " + remaningcurrency);
			}
		}
		System.out.println("--------------------------------\n");
	}

	// currencyCount is a synchronized shared resource
	private static Vector<Integer> currencyCount = null;

	private static final int currency[] = { 1000, 500, 200, 100, 50, 10 };

	private static void setcurrency() {
		currencyCount = new Vector<Integer>(6);
		currencyCount.add(10);
		currencyCount.add(10);
		currencyCount.add(10);
		currencyCount.add(12);
		currencyCount.add(5);
		currencyCount.add(5);
	}
}