package gamePackage;
import java.util.Random;

/**
 * Stochastic logic implementation for artificial intelligence
 * applications. Basically comparison functions that are wrong sometimes.
 * 
 * @author Indelisio
 *
 * 
 */
public class SMLogic {

	private static Random rand = new Random(); //Prevent unnessicary initializations
	
	/**
	 * Convenience function for stochastic inverts for intelligence modeling
	 * @param in Input value
	 * @param uncertanty Value from 0 to 0.5, although the value should fall exclusively between these values
	 * @return Possibly flipped in value
	 */
	public static boolean maybeInvert(boolean in, double uncertanty){
		if(uncertanty != Math.min(Math.max(uncertanty, 0.0),0.5)){
			throw new IllegalArgumentException("Uncertanty value not between 0 and .5, got " + uncertanty);
			
		}
		
		return (rand.nextDouble() <  uncertanty) ? !in : in;
	}

}
