package junittesttimeout;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TestTimeoutGlobalClass {

	private static Bank bank;

	/*
		We can use the @ClassRule annotation on class. It will see that all 
		methods in a class execute in a specific time. So, here we want all 
		the test cases collectively to be passed within a specific time of 
		10 seconds.
	*/
	@ClassRule
	public static Timeout globalTimeout = Timeout.seconds(10);

	@BeforeClass
	public static void init() {
		bank = new Bank(500000, 100);
	}

	@Test
	public void totalCashTest() throws InterruptedException {
		assertThat(10.0, is(bank.getTotalCash()));
	}

	@Test
	public void totalAccountsTest() throws InterruptedException {
		assertThat(100, is(bank.getTotalAccounts()));
	}

}
