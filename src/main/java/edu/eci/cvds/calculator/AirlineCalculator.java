package edu.eci.cvds.calculator;

import java.util.Optional;

import edu.eci.cvds.model.SeatCategory;
import edu.eci.cvds.model.BookingOutput;
import edu.eci.cvds.model.BookingResult;

/**
 * Utility class to validate an airline's booking
 */
public class AirlineCalculator implements BookingCalculator {
        private final float FIVE_SEATS_DISCONT=0.98f;
        private final float TEN_SEATS_DISCONT=0.90f;
        private final float FIFTEEN_SEATS_DISCONT=0.80f;
	/**
	 * {@inheritDoc}}
	 */
	@Override
	public BookingOutput calculate(Integer seatsNumber, SeatCategory category) {                
                BookingResult br=BookingResult.NOT_ENOUGH_SEATS;
                BookingOutput bo=new BookingOutput(br, Optional.empty());
		// TODO: Add required validations and calculate total price if applies
                if(seatsNumber>0){
                    if (SeatCategory.FIRST_CLASS.equals(category) && seatsNumber<=15 
                            || SeatCategory.ECONOMY_CLASS.equals(category) && seatsNumber<=50                      
                     || SeatCategory.EMERGENCY_DOOR.equals(category) && seatsNumber<=8){                      
                        br=BookingResult.SUCCESS;                       
                    }else {
                        br=BookingResult.TOO_MANY_SEATS;
                        bo=new BookingOutput(br, Optional.empty());                       
                    }
                }
                if(br==BookingResult.SUCCESS){
                    if (seatsNumber>=15){
                        bo=new BookingOutput(br, Optional.of(seatsNumber * category.getPrice()*FIFTEEN_SEATS_DISCONT));
                    }else if(seatsNumber>=10){
                        bo=new BookingOutput(br, Optional.of(seatsNumber * category.getPrice()*TEN_SEATS_DISCONT));
                    }else if(seatsNumber>5){
                        bo=new BookingOutput(br, Optional.of(seatsNumber * category.getPrice()*FIVE_SEATS_DISCONT));
                    }else{
                        bo=new BookingOutput(br, Optional.of(seatsNumber * category.getPrice()));
                    }
                 }
                    
                return bo;
	}
}
