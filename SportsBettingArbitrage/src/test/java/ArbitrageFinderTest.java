import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class ArbitrageFinderTest {

	ArbitrageFinder tested;
	String betFairLocation = "http://www.betfair.com/partner/marketData_loader.asp?fa=ss&id=998919&SportName=Bandy&Type=B";
	List<String> bettingCompany = new ArrayList<String>();
	List<String> xmlLocation = new ArrayList<String>();
	String resourcePath = "resources/bettingCompanies/";

	@Test
	public void getBettingCompanyXmlLocation() {
		tested = new ArbitrageFinder();
		xmlLocation.add(betFairLocation);
		List<String> fetchedLocation = tested.getLocation(resourcePath
				+ "BetFair.txt");
		assertThat(fetchedLocation.get(0), is(xmlLocation.get(0)));
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
			assertThat(tested.getLocation(resourcePath + companyName + ".txt")
					.get(0), is(betFairLocation));
		}
	}

	@Test
	public void parseXmlDocument() throws DocumentException, IOException {
		tested = new ArbitrageFinder();
		SAXReader reader = new SAXReader();
		reader.setEncoding("UTF-16");
		URL url = null;
		// try {
		// tested.getLocation(betFairLocation);
		// url = new URL(betFairLocation);
		// } catch (MalformedURLException e) {
		// e.printStackTrace();
		// }
		URL betfairUrl = new URL(betFairLocation);
		URLConnection yc = betfairUrl.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
		Document document = reader.read(url);
		System.out.println(document.getStringValue());

	}
}
