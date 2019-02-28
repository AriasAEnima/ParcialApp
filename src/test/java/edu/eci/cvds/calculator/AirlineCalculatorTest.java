package edu.eci.cvds.calculator;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.*;
import edu.eci.cvds.calculator.AirlineCalculator;
import edu.eci.cvds.model.SeatCategory;
import edu.eci.cvds.model.BookingResult;
import edu.eci.cvds.model.BookingOutput;
import java.util.Optional;
import org.junit.Test;



/**
 * Test class for {@linkplain AirlineCalculator} class
 */
public class AirlineCalculatorTest {

	/**
	 * The class under test.
	 */
	private AirlineCalculator calculator = new AirlineCalculator();

	/**
	 * Primera Clase 
         * <16 sillas y >15 sillas
	 */
	@Test
	public void calculateTestPC() {
            qt().forAll(integers().between(-100, 100)).check((seats)->{
                boolean ans=false;
                BookingOutput br=calculator.calculate(seats, SeatCategory.FIRST_CLASS);
                if (seats<16 && seats>0){
                    ans=BookingResult.SUCCESS==br.getResult() && br.getCost().equals(descuento(seats,100));                  
                }else if(seats>15){
                    ans=BookingResult.TOO_MANY_SEATS==br.getResult();
                }else{
                   ans=BookingResult.NOT_ENOUGH_SEATS==br.getResult();
                }
                
                return ans;                
            });
		
	}
        /**
	 * Clase Economica Clase 
         * <51 sillas y >50 sillas
	 */
        @Test
        public void calculateTestEC() {
            qt().forAll(integers().between(-100, 100)).check((seats)->{
                boolean ans=false;
                BookingOutput br=calculator.calculate(seats, SeatCategory.ECONOMY_CLASS);
                if (seats<51 && seats>0){
                    ans=BookingResult.SUCCESS==br.getResult() && br.getCost().equals(descuento(seats,50));
                }else if(seats>50){
                    ans=BookingResult.TOO_MANY_SEATS==br.getResult();
                }else{
                   ans=BookingResult.NOT_ENOUGH_SEATS==br.getResult();
                }
               
                return ans;
            });
		
	}
        /**
	 * Clase Emergencia Clase 
         * <9 sillas y >8 sillas
	 */
        @Test
        public void calculateTestEmC() {
            qt().forAll(integers().between(-100, 100)).check((seats)->{
                boolean ans=false;
                BookingOutput br=calculator.calculate(seats, SeatCategory.EMERGENCY_DOOR);
                if (seats<9 && seats>0){
                    ans=BookingResult.SUCCESS==br.getResult() && br.getCost().equals(descuento(seats,40)) ;
                }else if(seats>8){
                    ans=BookingResult.TOO_MANY_SEATS==br.getResult();
                }else{
                   ans=BookingResult.NOT_ENOUGH_SEATS==br.getResult();
                }
                return ans;
            });
		
	}

    private Optional<Float> descuento(Integer seats, int precio) {
        Optional<Float> ans;
        if(seats>=15){
            ans=Optional.ofNullable(seats*precio*0.80f);
        }else if(seats>=10){
            ans=Optional.ofNullable(seats*precio*0.90f);
        }else if(seats>5){
            ans=Optional.ofNullable(seats*precio*0.98f);
        }else{
            ans=Optional.ofNullable((float) seats*precio);
        }
        return ans;
    }
}
