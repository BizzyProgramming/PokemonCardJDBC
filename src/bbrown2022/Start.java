package bbrown2022;

import java.util.Scanner;

public class Start {

	static Scanner sc = new Scanner(System.in);

	private static dataBase db;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Welcome to Bizzy's Pokemon Card Collection!");
		System.out.println("================");

		db = dataBase.getInstance();

		login();
	
		
	}

	public static void login() throws Exception {

		System.out.println("Main Menu:");
		System.out.println("===============");
		System.out.println("1) View All Cards");
		System.out.println("2) Add a Card");
		System.out.println("3) Update a card");
		System.out.println("4) Delete a card");
		System.out.println("5) Search for card by Name");
		System.out.println("Choose an option please...");
		System.out.println("==============");
		
		
		String name = sc.nextLine();
		if (name.equals("1")) {
			 db.viewAllCards();
		//	db.orderByName();
			
			
		} else if (name.equals("2")) {
			db.addCard();
		} else if (name.equals("3")) {
			db.updateCard();

		} else if (name.equals("4")) {
			db.deleteCard();

		} else if (name.equals("5")) {
			db.searchForCard();
			System.out.println();
			login();
		} else {
			login();
		}
		
	}
}
