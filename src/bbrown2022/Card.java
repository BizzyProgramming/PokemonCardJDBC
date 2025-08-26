package bbrown2022;

public class Card {

	private String name;
	private String description;
	private double price;
	private String rarity;
	private double retailPrice;
	private String idCard;
	private int health;
	private int quantity;
	private String type;
	private String element;

	// Default constructor
	Card() {

	}

	Card(String idCard, String name, String type, String rarity, String description, double price, double retailPrice,
			int health, String element, int quantity) {
		super();
		this.idCard = idCard;
		this.name = name;
		this.type = type;
		this.type = rarity;
		this.health = health;
		this.price = price;
		this.retailPrice = price;
		this.element = element;
		this.quantity = quantity;
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setId(String idCard) {
		this.idCard = idCard;
	}

	public String getId() {
		return this.idCard;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getHealth() {
		return this.health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setAmount(int amount) {
		this.quantity = amount;
	}

	public int getAmount() {
		return this.quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getRarity() {
		return rarity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ID#: " + idCard + "\nTYPE: " + type + "\n" + "NAME: " + name + "\nRarity: " + rarity + "\nDescription: "
				+ description + "\nPRICE: $" + price + "\n" + "RETAIL PRICE: $" + retailPrice + "\n" + "\n" + "HEALTH: "
				+ health + "\nELEMENT: " + element + "\nStock: " + quantity + "\n" + "================";
	}

}
