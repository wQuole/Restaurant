package Restaurantoppgave;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Restaurant {
	
	private double income;
	private Menu foodMenu;
	private Menu drinkMenu;
	private List<Collection<Guest>> queue;	
	private Collection<Table> availableTables;
	private Collection<Table> occupiedTables;
	private List<Waiter> waiters;
	private int pos = 0;
	
		
	public Restaurant(){
		income = 0;
		this.availableTables = new ArrayList<>();
		this.occupiedTables = new ArrayList<>();
		this.waiters = new ArrayList<>();
		foodMenu = new Menu();
		drinkMenu = new Menu();
		
	}
	
	public void addtoQueue(Collection<Guest> guests){
		int seated = 0;
		for (Table table : availableTables){
			if(table.getSize() >= guests.size()){
				table.addGuest(guests);
				this.changeTableState(table);
				this.addTableToWaiter(table);
				seated++;
				break;
			}
		}
		if (seated == 0){
			queue.add(guests);			
		}
	}
	
	public void changeTableState(Table table){
		if (availableTables.contains(table)){
			availableTables.remove(table);
			occupiedTables.add(table);
		}
		else if (occupiedTables.contains(table)){
			occupiedTables.remove(table);
			availableTables.add(table);
		}
		
	}
	
	public double getIncome() {
		return this.income;
	}
	
	
	public void takePayment(int payment, Table table){
		income +=payment;
		changeTableState(table);
		addGuests();
	}

	private void addGuests() {
		for (Collection<Guest> guests : queue){
			for (Table table : availableTables){
				if(table.getSize() >= guests.size()){
					table.addGuest(guests);
					this.changeTableState(table);
					this.addTableToWaiter(table);
					break;
				}				
			}
		}
	}

	public Menu getFoodMenu() {
		return this.foodMenu;
	}

	public Menu getDrinkMenu() {
		return this.drinkMenu;
	}
	
	public void addTableToWaiter(Table table){
		Waiter waiter = waiters.get(pos);
		waiter.addTable(table);
		this.pos++;
		
		if(pos == waiters.size()){
			this.pos = 0;
		}
	}
}
