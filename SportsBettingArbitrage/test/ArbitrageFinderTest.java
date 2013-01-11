import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;


public class ArbitrageFinderTest {

	ArbitrageFinder tested;
	
	@Test
	public void getBettingCompanyXmlLocation() {
		tested=new ArbitrageFinder();
		String betFairLocation = "http://www.betfair.com/partner/marketData_loader.asp?fa=ss&id=1&SportName=Soccer&Type=B";
		String fetchedLocation=tested.getLocation("resources/bettingCompanies/BetFair.txt");
		assertThat(fetchedLocation, is(betFairLocation));
				
	}

}
