package Restaurantoppgave;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Waiter {
	
	private Restaurant restaurant;
	private List<Table> tables;
	private Menu foodMenu;
	private Menu drinkMenu;
	
	
	public Waiter(Restaurant restaurant){
		this.restaurant = restaurant;
		this.foodMenu = restaurant.getFoodMenu();
		this.drinkMenu = restaurant.getDrinkMenu();
		this.tables = new ArrayList<>();

	}
	
	public void addTable(Table table){
		if (!tables.contains(table)){
			tables.add(table);
		}
	}
	
	public void addtoQueue(Collection<Guest> guests){
		restaurant.addtoQueue(guests);
	}
	
	public void takePayment(Table table){
		int total = 0;
		for (Guest guest : table.getGuests()){
			total+= guest.getCheck();
		}
		table.removeGuests();
		tables.remove(table);
		restaurant.takePayment(total, table);
	}
	
	public void takeOrder(Guest guest, Item...items){
		for (Item i : Arrays.asList(items)){
			guest.addToCheck(i.getPrice());
		}
	}
	
	

}
