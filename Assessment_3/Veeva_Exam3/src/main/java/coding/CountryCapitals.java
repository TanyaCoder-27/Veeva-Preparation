package coding;

import java.util.*;

class Country {
	String name;
	List<Capital> capitals = new ArrayList<>();

	public Country(String name) {
		this.name = name;
	}

	void addCapital(String capital_name, String season) {
		capitals.add(new Capital(capital_name, season));
	}
}

class Capital {
	String name;
	String season;

	public Capital(String name, String season) {
		this.name = name;
		this.season = season;
	}
}

public class CountryCapitals {
	static Map<String, Country> countries = new HashMap<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("enter no of countries: ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {

			System.out.println("country name: ");
			String cname = sc.nextLine();

			Country c = new Country(cname);

			System.out.println("no of capitals: ");
			int k = sc.nextInt();
			sc.nextLine();

			for (int j = 0; j < k; j++) {

				System.out.println("capital name: ");
				String cap = sc.nextLine();

				System.out.println("season: ");
				String season = sc.nextLine();

				c.addCapital(cap, season);
			}

			countries.put(cname, c);
		}

		displayAll();
		System.out.println();
		printCountry("veeva");
		System.out.println();
		printCountriesWithTwoCapitals();
		System.out.println();
		printCountriesWithThreeCapitals();
		System.out.println();
		printCountriesWithoutSummerCapital();
		System.out.println();
		printCapitalsOfCountriesStartingWithVowels();
		System.out.println();
		printSummerCapitalsOfCountriesStartingWithVowels();

	}

	// 1.
	static void displayAll() {
		for (Country c : countries.values()) {
			System.out.println("	country name: " + c.name +" "+ "no of capitals " + c.capitals.size());
			for (Capital cap : c.capitals) {
				System.out.print(" capital name:" +" "+ cap.name + " season:" + cap.season);
			}
		}
	}

	// 2.Given a country name, print capitals of that country along with season and
	// no of capitals for that country.
	static void printCountry(String name) {
		Country c = countries.get(name);
		if (c == null) {
			System.out.println("Not found");
			return;
		}

		System.out.println(c.name + " (" + c.capitals.size() + ")");
		for (Capital cap : c.capitals) {
			System.out.println(cap.name + " - " + cap.season);
		}
	}

	// 3. PRINT ALL COUTNRIES HAVING 2 CAPITALS
	static void printCountriesWithTwoCapitals() {
		for (Country c : countries.values()) {
			if (c.capitals.size() == 2) {
				System.out.println(c.name);
			}
		}
	}

	// 4. Print all the countries having 3 capitals.
	static void printCountriesWithThreeCapitals() {
		for (Country c : countries.values()) {
			if (c.capitals.size() == 3) {
				System.out.println(c.name);
			}
		}
	}

	// 5.Find countries that doesn’t contain summer capital
	static void printCountriesWithoutSummerCapital() {
		for (Country c : countries.values()) {
			boolean hasSummerCapital = false;
			for (Capital cap : c.capitals) {
				if (cap.season.equalsIgnoreCase("summer")) {
					hasSummerCapital = true;
					break;
				}
			}
			if (!hasSummerCapital) {
				System.out.println(c.name);
			}
		}
	}

	// 6.Find and return the capitals of the countries which start with vowels
	static void printCapitalsOfCountriesStartingWithVowels() {
		for (Country c : countries.values()) {
			char first = c.name.toLowerCase().charAt(0);

			if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') {
				System.out.println("Country: " + c.name);

				for (Capital cap : c.capitals) {
					System.out.println("Capital: " + cap.name + " - Season: " + cap.season);
				}
			}
		}
	}

	// 7Print summer capitals of the country that starts with vowel.
	static void printSummerCapitalsOfCountriesStartingWithVowels() {
		for (Country c : countries.values()) {
			char first = c.name.toLowerCase().charAt(0);

			if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') {
				System.out.println("Country: " + c.name);

				for (Capital cap : c.capitals) {
					if (cap.season.equalsIgnoreCase("summer")) {
						System.out.println("Summer Capital: " + cap.name);
					}
				}
			}
		}
	}

}

/*
enter no of countries: 3
country name: 
api
no of capitals: 
2
capital name: 
cap1
season: 
rainy
capital name: 
cap2
season: 
winter
country name: 
veeva
no of capitals: 
3
capital name: 
abc
season: 
winter
capital name: 
xyz
season: 
summer
capital name: 
pqr
season: 
rainy
country name: 
vasavi
no of capitals: 
1
capital name: 
clg
season: 
summer
	country name: vasavi no of capitals 1
 capital name: clg season:summer	country name: api no of capitals 2
 capital name: cap1 season:rainy capital name: cap2 season:winter	country name: veeva no of capitals 3
 capital name: abc season:winter capital name: xyz season:summer capital name: pqr season:rainy
veeva (3)
abc - winter
xyz - summer
pqr - rainy

api

veeva

api

Country: api
Capital: cap1 - Season: rainy
Capital: cap2 - Season: winter

Country: api

 */