package junittesttimeout;

import java.util.concurrent.TimeUnit;

public class Bank {

	private double totalCash;
	private int totalAccounts;

	public Bank(double cash, int accounts) {
		this.totalCash = cash;
		this.totalAccounts = accounts;
	}

	public double getTotalCash() throws InterruptedException {
		double cash = 0.0;
		for (int index = 0; index < 5; index++) {
			cash += index;
			TimeUnit.SECONDS.sleep(1);
		}
		return cash;
	}

	public int getTotalAccounts() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(500);
		return totalAccounts;
	}

	@Override
	public String toString() {
		return "Bank [cash=" + totalCash + ", accounts=" + totalAccounts + "]";
	}
}
