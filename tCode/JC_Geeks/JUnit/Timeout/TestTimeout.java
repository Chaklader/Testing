package junittesttimeout;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestTimeout {

	private static Bank bank;

	@BeforeClass
	public static void init() {
		bank = new Bank(500000, 100);
	}

	@Test(timeout = 2000)
	public void totalCashTest() throws InterruptedException {
		assertThat(10.0, is(bank.getTotalCash()));
	}
	
	@Test(timeout = 1000)
	public void totalAccountsTest() throws InterruptedException {
		assertThat(100, is(bank.getTotalAccounts()));
	}
}
