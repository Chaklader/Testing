package junittesttimeout;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TestTimeoutGlobal {

	private static Bank bank;
	
	@Rule
    public Timeout globalTimeout = Timeout.seconds(2);

	@BeforeClass
	public static void init() {
		bank = new Bank(500000,100);
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
