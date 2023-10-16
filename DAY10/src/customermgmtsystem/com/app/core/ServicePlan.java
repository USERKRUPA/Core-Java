package customermgmtsystem.com.app.core;

public enum ServicePlan {
	// ServicePlan charges :
	SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000);

	private int charge;

	private ServicePlan(int charge) {
		this.charge = charge;
	}

	public String toString() {
		return name() + " has charge amount: "+ charge;
		
	}

	public int getCharge() {
		return charge;
	}
	
}
