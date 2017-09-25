package Restaurantoppgave;

import java.util.Arrays;
import java.util.List;

public class Item {
	
	private List<String> allergies;
	private int price;
	private String name;
	
	
	public Item(String name, int price, String...strings){
		allergies = Arrays.asList(strings);
		this.price = price;
		this.name = name;	
	}
	

	public List<String> getAllergies() {
		return allergies;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

}
