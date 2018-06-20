package cwm;

import java.util.Scanner;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Enter Amount");
			int amount = scan.nextInt();
			CashWithdrawalMachine.Withdrawal(amount);
		}
	}
}
