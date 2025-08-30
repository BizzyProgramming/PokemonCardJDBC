package bbrown2022;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class dataBase {

	private static String URL = "jdbc:mysql://localhost:3306/pokemoncards";
	private static String USER = "root";
	private static String PASS = "";
	public ArrayList<Card> card = new ArrayList<>();
	private static Connection conn;
	private static dataBase instance;
	public static Scanner sc = new Scanner(System.in);

	private dataBase() {
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
		}
	}

	// Singleton accessor
	public static dataBase getInstance() {
		if (instance == null) {
			instance = new dataBase();
		}
		return instance;
	}

	public Connection getConnection() {
		return conn;
	}

	public void viewAllCards() {

		String sql = "SELECT * FROM card";

		try {
			
			// Clear list to avoid duplication
			card.clear();
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String idCard = rs.getString("idCard");
				String type = rs.getString("type");
				String name = rs.getString("name");
				String rarity = rs.getString("rarity");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				double retailPrice = rs.getDouble("retailPrice");
				int health = rs.getInt("health");
				String element = rs.getString("element");
				int quantity = rs.getInt("quantity");

				card.add(new Card(idCard, type, name, rarity, description, price, retailPrice, health, element,
						quantity));
			}

			for (Card c : card) {
				System.out.println(c);
				System.out.println();
			}
			
			System.out.println("Total number of cards in inventory: " + card.size());
			System.out.println();
			Start.login();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addCard() throws Exception {

		System.out.println("ID Number");
		String idCard = sc.nextLine();

		System.out.println("Type");
		String type = sc.nextLine();

		System.out.println("Name");
		String name = sc.nextLine();

		System.out.println("Rarity");
		String rarity = sc.nextLine();

		System.out.println("Description");
		String description = sc.nextLine();

		System.out.println("My Price");
		double price = sc.nextDouble();
		sc.nextLine();

		System.out.println("Retail Price");
		double retailPrice = sc.nextDouble();
		sc.nextLine();

		System.out.println("Health");
		int health = sc.nextInt();
		sc.nextLine();

		System.out.println("Element");
		String element = sc.nextLine();

		System.out.println("Quantity");
		int quantity = sc.nextInt();
		sc.nextLine();

		String sql = "INSERT into Card(idCard,type,name,rarity,description,price,retailPrice,health,element,quantity) values (?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, idCard);
			ps.setString(2, type);
			ps.setString(3, name);
			ps.setString(4, rarity);
			ps.setString(5, description);
			ps.setDouble(6, price);
			ps.setDouble(7, retailPrice);
			ps.setInt(8, health);
			ps.setString(9, element);
			ps.setInt(10, quantity);

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Card added successfully to the Pokemon Card Collection!");
			} else {
				System.out.println("Failed to add card to the list.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// Return to the main menu
		Start.login();
	}

	public void deleteCard() throws Exception {

		System.out.println("Which card would you like to delete?");
		viewAllCards();
		System.out.println("Choose by ID Card #");
		String id_Card = sc.nextLine();
		sc.nextLine();

		String sql2 = "DELETE FROM pokemoncards.card WHERE idCard = ?";

		try (PreparedStatement initiate = getConnection().prepareStatement(sql2)) {
			initiate.setString(1, id_Card);
			initiate.executeUpdate();
			System.out.println(initiate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Start.login();
	}

	public void updateCard() throws Exception {
		viewAllCards();
		System.out.println("Which card would you like to update?");
		System.out.println("Choose by Card ID #");

		String idCard = sc.nextLine();

		String sql1 = "SELECT idCard, type, name, rarity, description, price, retailPrice, health, element, quantity FROM card WHERE idCard = ?";

		try (PreparedStatement initiate1 = getConnection().prepareStatement(sql1)) {

			initiate1.setString(1, idCard);
			ResultSet results = initiate1.executeQuery();
			if (!results.next()) {
				System.out.println("Card not found.");
				Start.login();
				return;
			}

			System.out.println("Update your ID Card # : [" + results.getString("idCard") + "] ? : ");
			String idNumber = sc.nextLine();

			System.out.println("Update type : [ " + results.getString("type") + "] ? : ");
			String cardType = sc.nextLine();

			System.out.println("Update card name : [" + results.getString("name") + "] ? : ");
			String cardName = sc.nextLine();

			System.out.println("Update card rarity : [ " + results.getString("rarity") + "] ? : ");
			String cardRarity = sc.nextLine();

			System.out.println("Description of card : [ " + results.getString("description") + "] ? : ");
			String cardDescription = sc.nextLine();

			System.out.println("Update my card price : [" + results.getDouble("price") + "] ? : ");
			double cardPrice = sc.nextDouble();
			sc.nextLine(); // Consume the newline character

			System.out.println("Update retail card price : [" + results.getDouble("retailPrice") + "] ? : ");
			double retailPrice = sc.nextDouble();
			sc.nextLine();

			System.out.println("Update the card health : [" + results.getInt("health") + "] ? : ");
			int cardHealth = sc.nextInt();
			sc.nextLine(); // Consume the newline character

			System.out.println("Update card element : [" + results.getString("element") + "] ? : ");
			String cardElement = sc.nextLine();

			System.out.println("Update stock amount of card : [" + results.getInt("quantity") + "] ? : ");
			int stockNumber = sc.nextInt();
			sc.nextLine(); // Consume the newline character

			String sql2 = "UPDATE card SET idCard = ?, type = ?, name = ?, rarity = ?, description = ?, price = ?, retailPrice = ?, health = ?, element = ?, quantity = ? WHERE idCard = ?";

			try (PreparedStatement initiate2 = getConnection().prepareStatement(sql2)) {
				initiate2.setString(1, idNumber);
				initiate2.setString(2, cardType);
				initiate2.setString(3, cardName);
				initiate2.setString(4, cardRarity);
				initiate2.setString(5, cardDescription);
				initiate2.setDouble(6, cardPrice);
				initiate2.setDouble(7, retailPrice);
				initiate2.setInt(8, cardHealth);
				initiate2.setString(9, cardElement);
				initiate2.setInt(10, stockNumber);
				initiate2.setString(11, idCard); // Use the original idCard for the WHERE clause

				int rowsUpdated = initiate2.executeUpdate();
				if (rowsUpdated > 0) {
					System.out.println("Card updated successfully!");
				} else {
					System.out.println("Card update failed.");
				}

				Start.login();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchForCard() {
		System.out.println("Search for card by name");
		System.out.println("=============");
		System.out.println("Name: ");
		String name1 = sc.nextLine();

		String sql4 = "SELECT * FROM card WHERE name LIKE ?";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql4);

			ps.setString(1, name1);
//				System.out.println(ps.toString());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("ID #: " + rs.getString("idCard") + " Special : " + rs.getString("type")
						+ " | Name : " + rs.getString("name") + " | $" + rs.getDouble("price") + " | Qnty : "
						+ rs.getInt("quantity"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void orderByName() {
		String sql5 = "SELECT * FROM card ORDER BY type";

		try {
			PreparedStatement ps = getConnection().prepareStatement(sql5);
			ResultSet rs = ps.executeQuery(sql5);

			while (rs.next()) {
				String id = rs.getString("idCard");
				String type = rs.getString("type");
				String name = rs.getString("name");
				String rarity = rs.getString("rarity");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				double retailPrice = rs.getDouble("retailPrice");
				int health = rs.getInt("health");
				String element = rs.getString("element");
				int quantity = rs.getInt("quantity");
				System.out.println("ID          | #" + id + "\nType        | " + type + "\n" + "Name        | " + name
						+ "\nRarity      | " + rarity + "\nDescription | " + description + "\n" + "My Price    | $"
						+ price + "\n" + "Store Price | $" + retailPrice + "\nHealth      | " + health + "\n"
						+ "Element     | " + element + "\nQuantity    | " + quantity + "\n");

			}
			
			Start.login();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
