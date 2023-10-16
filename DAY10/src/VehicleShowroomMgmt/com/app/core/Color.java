package VehicleShowroomMgmt.com.app.core;

public enum Color {
	BLACK(5000), BLUE(4000), GREY(6000), RED(7000);
	private int cost;
	
	private Color(int cost) {
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String toString() {
		return name() + " with cost " + cost;
	}
}
