package edu.eci.cvds.model;

/**
 * Enum class to represent the seat accommodation types
 */
public enum SeatCategory {
	FIRST_CLASS(100),
	ECONOMY_CLASS(50),
	EMERGENCY_DOOR(40);

	/** The category price */
	private float price;

	/**
	 * Class constructor with fields
	 */
	private SeatCategory(float price) {
		this.price = price;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

}
