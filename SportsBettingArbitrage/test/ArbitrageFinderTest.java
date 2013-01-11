import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArbitrageFinderTest {

	ArbitrageFinder tested;
	String betFairLocation = "http://www.betfair.com/partner/marketData_loader.asp?fa=ss&id=1&SportName=Soccer&Type=B";
	List<String> bettingCompany = new ArrayList<String>();
	String resourcePath = "resources/bettingCompanies/";

	@Test
	public void getBettingCompanyXmlLocation() {
		tested = new ArbitrageFinder();
		String fetchedLocation = tested.getLocation(resourcePath
				+ "BetFair.txt");
		assertThat(fetchedLocation, is(betFairLocation));
	}

	@Test
	public void getBettingCompaniesToFetchLocationsFor() {
		tested = new ArbitrageFinder();
		bettingCompany.add("BetFair");

		List<String> fetchedCompanies = tested
				.getBettingCompaniesToFindArbitragesFrom(resourcePath
						+ "BettingCompanies.txt");
		assertThat(fetchedCompanies.get(0), is(bettingCompany.get(0)));
	}

	@Test
	public void getXmlFlowFromBettingCompanyFile() {
		tested = new ArbitrageFinder();
		List<String> fetchedCompanies = tested
				.getBettingCompaniesToFindArbitragesFrom("resources/bettingCompanies/BettingCompanies.txt");
		for (String companyName : fetchedCompanies) {
			assertThat(tested.getLocation(resourcePath + companyName + ".txt"),
					is(betFairLocation));
		}

	}
}
