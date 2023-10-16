package enumeration;

public enum Fuel {
	PETROL(105), DIESEL(95), CNG(50), LPG(1100);
	private int cost;
	private Fuel(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return name() + " Cost: " + cost;
	}
}
