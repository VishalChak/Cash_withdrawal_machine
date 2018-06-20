package cwm;

import org.junit.Test;

public class CashWithdrawalMachineTest {

	// One time limit is 15k
	@Test
	public void withdrawalLimit() {
		CashWithdrawalMachine.Withdrawal(16000);
	}

	// Withdrawal amount must be multiplication of 10
	@Test
	public void EnterValidAmount() {
		CashWithdrawalMachine.Withdrawal(14001);
	}

	// Out of cash
	@Test
	public void insufficientFund() {
		CashWithdrawalMachine.Withdrawal(15000);
		CashWithdrawalMachine.Withdrawal(15000);
	}

//	Few Currencies are empty
	@Test
	public void checkRemaingCurranciesNote() {
		CashWithdrawalMachine.Withdrawal(40);
		CashWithdrawalMachine.Withdrawal(20);
	}

//	 A valid transaction
	public void successfulWithdrawal() {
		CashWithdrawalMachine.Withdrawal(5000);
	}

}
