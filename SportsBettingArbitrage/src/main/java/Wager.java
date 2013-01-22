
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Wager {
	private static final BigDecimal one = new BigDecimal(1);
	public static BigDecimal roiInPercent(BigDecimal odds1, BigDecimal odds2) {
		odds1 = odds1.setScale(4,BigDecimal.ROUND_HALF_DOWN);
		odds2 = odds2.setScale(4,BigDecimal.ROUND_HALF_DOWN);
		return roi(sumOfWagers(odds1,odds2)).multiply(new BigDecimal(100)).setScale(2);
	}
	
	private static BigDecimal sumOfWagers(BigDecimal odds1, BigDecimal odds2) {
		return one.divide(odds1, 4, RoundingMode.HALF_DOWN).add(one.divide(odds2, 4, RoundingMode.HALF_DOWN));
	}
	
	private static BigDecimal roi(BigDecimal sumOfWagers) {
		return profit(sumOfWagers).divide(sumOfWagers,4,BigDecimal.ROUND_HALF_DOWN);
	}
	
	private static BigDecimal profit(BigDecimal sumOfWagers) {
		return one.subtract(sumOfWagers);
	}
}
