package edu.eci.cvds.model;

import java.util.Optional;

/**
 * Model class specifying if the reservation is possible and the total cost
 */
public class BookingOutput {

	/** The booking result enum. */
	private BookingResult result;
	/** An optional total cost (only if result is success). */
	private Optional<Float> cost;

	/**
	 * Class constructor using fields
	 */
	public BookingOutput(BookingResult result, Optional<Float> cost) {
		this.result = result;
		this.cost = cost;
	}

	/**
	 * @return the cost
	 */
	public Optional<Float> getCost() {
		return cost;
	}

	/**
	 * @return the result
	 */
	public BookingResult getResult() {
		return result;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Optional<Float> cost) {
		this.cost = cost;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(BookingResult result) {
		this.result = result;
	}

}
