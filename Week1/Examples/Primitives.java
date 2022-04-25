class Primitives {

	public static void main(String args[]){
	
		//Lets look at some primitives
		//boolean, a 1 or a 0
		//datatype varName assignOpperator valueOfVar
		boolean ourFirstBool = true;

		//System class has utility methods to do things like printing to the console
		//We can print out the value stored in the ourFirstBool variable
		System.out.println(ourFirstBool);

		byte littleByte = 120;

		System.out.println(littleByte);

		short littleBitBigger = 30_000;

		//We can also use casting and widening
		
		//Since the max value of short > 30k, we have no issue storing a byte which only goes up to 127
		short widening = littleByte;

		System.out.println(widening);

		int thirtyTwoBits = 32768;

		//Narrowing can be dangerous
		short narrowing = (short) thirtyTwoBits;

		System.out.println(narrowing);

		//If you want to explcitly pass a long into a method, you need to use the l character at the end
		long sixtyFourBits = 1234567890l;

		//If you want to explicitly pass a float you will need to use a f character at the end
		float iAmFloating = 2.34145f;

		double iAmDoubleAFloat = 56.232456436;

		char payRespect = 'f';

		System.out.println(payRespect);

	}

}
