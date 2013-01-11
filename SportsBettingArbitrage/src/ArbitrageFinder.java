import java.util.List;

import util.FileReader;

public class ArbitrageFinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArbitrageFinder arbFinder = new ArbitrageFinder();
		// Fetch bettingcompany file
		// Fetch xml from company 1
		arbFinder.getLocation("");
		// Fetch xml from company 2

	}

	public String getLocation(String fileLocation) {
		return new FileReader().getXmlLocation(fileLocation);
	}

	public List<String> getBettingCompaniesToFindArbitragesFrom(
			String bettingCompanyFileLocation) {

		return new FileReader().getBettingCompanies(bettingCompanyFileLocation);
	}

}
