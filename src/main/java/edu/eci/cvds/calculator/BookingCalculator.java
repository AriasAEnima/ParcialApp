package edu.eci.cvds.calculator;

import edu.eci.cvds.model.SeatCategory;
import edu.eci.cvds.model.BookingOutput;

/**
 * Basic interface to validate an employee
 */
@FunctionalInterface
public interface BookingCalculator {

	/**
	 * Calculates the total cost of the booking.
	 * 
	 * @param seatsNumber The number of seats to book
	 * @param category The desired category to book
	 * @return A {@linkplain BookingOutput} object with the output to the
	 *         reservation.
	 */
	BookingOutput calculate(Integer seatsNumber, SeatCategory category);

}
