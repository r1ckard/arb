import java.util.List;

import util.FileReader;

public class ArbitrageFinder {
	private final static String resourcePath = "resources/bettingCompanies/";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArbitrageFinder arbFinder = new ArbitrageFinder();
		// Fetch bettingcompany file
		List<String> fetchedCompanies = arbFinder
				.getBettingCompaniesToFindArbitragesFrom("resources/bettingCompanies/BettingCompanies.txt");
		// Fetch xml from companies
		for (String companyName : fetchedCompanies) {
			arbFinder.getLocation(resourcePath + companyName + ".txt").get(0);
		}

	}

	public List<String> getLocation(String fileLocation) {
		return new FileReader().getRowsFromFile(fileLocation);
	}

	public List<String> getBettingCompaniesToFindArbitragesFrom(
			String bettingCompanyFileLocation) {
		return new FileReader().getRowsFromFile(bettingCompanyFileLocation);
	}

}
