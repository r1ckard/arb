import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArbitrageFinderTest {

	ArbitrageFinder tested;

	@Test
	public void getBettingCompanyXmlLocation() {
		tested = new ArbitrageFinder();
		String betFairLocation = "http://www.betfair.com/partner/marketData_loader.asp?fa=ss&id=1&SportName=Soccer&Type=B";
		String fetchedLocation = tested
				.getLocation("resources/bettingCompanies/BetFair.txt");
		assertThat(fetchedLocation, is(betFairLocation));
	}

	@Test
	public void getBettingCompaniesToFetchLocationsFor() {
		tested = new ArbitrageFinder();
		List<String> bettingCompany = new ArrayList<String>();
		bettingCompany.add("BetFair");

		List<String> fetchedCompanies = tested
				.getBettingCompaniesToFindArbitragesFrom("resources/bettingCompanies/BettingCompanies.txt");
		assertThat(fetchedCompanies.get(0), is(bettingCompany.get(0)));
	}

}
