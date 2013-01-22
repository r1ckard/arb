
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class WagerTest {
	@Test
	public void testWager() {
		BigDecimal expected = new BigDecimal("4.35");
		assertEquals(expected,Wager.roiInPercent(new BigDecimal(8.0),new BigDecimal(1.2)));
	}
	@Test
	public void testWagerReversedOdds() {
		BigDecimal expected = new BigDecimal("4.35");
		assertEquals(expected,Wager.roiInPercent(new BigDecimal(1.2),new BigDecimal(8.0)));
	}
}
