package Restaurantoppgave;

public class Guest {
	
	private int check;
	
	public Guest(){
		check = 0;
		
	}
	

	
	public void addToCheck(int amount){
		if (amount>0){
			check+=amount;
		}
	}
	
	public int getCheck(){
		return this.check;
	}
	
	public void tip(int amount){
		if (amount > 0){
			check+=amount;			
		}
	}
	
}
