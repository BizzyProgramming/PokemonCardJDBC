package bbrown2022;

public class Holographic extends Card {

	public String type;

	Holographic(String name, String id, String rarity, String description, int health, double price, int quantity) {
		super(name, id, id, rarity, description, health, price, quantity, id, quantity);
	}

	Holographic(String type, String name, String id, String rarity, String description, int health, double price,
			int quantity) {
		super(name, id, id, rarity, description, health, price, quantity, id, quantity);
		this.type = type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	@Override
	public String toString() {
		return "Type: " + type + super.toString();
	}

}
