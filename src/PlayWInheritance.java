/**
 * Just some Java code to allow you to explore inheritance, constructor
 * chaining, and polymorphism ("dynamic method lookup")
 * 
 */

public class PlayWInheritance
{
	public static int R_EXAMPLE = 1; // change this to try different behaviors
										// below

	public static void main(String[] args)
	{
		System.out.println();

		// common to all examples...

		// which constructors are called in the following?

		Die_1 die1 = new Die_1();
		CrookedDi crooked_1 = new CrookedDi();
		CrookedD2 crooked_2 = new CrookedD2();

		System.out.println();

		// change RUN_EXAMPLE above to run any one of the following 6 examples

		if (R_EXAMPLE == 1)
		{
			System.out.println("Note the output: constructor chaining.");
		}
		else if (R_EXAMPLE == 2)
		{
			// When a reference is treated like a String
			// => toString() is automatically invoked, and its returned value
			// used instead!

			System.out.println(die1.toString());

			System.out.print("toString() automatically called when reference treated as String: ");
			System.out.println(die1.toString());
			System.out.println("Concatenating a string to a reference: " + die1.toString());
		}
		else if (R_EXAMPLE == 3)
		{
			// concatenate " " + super.toString() to end of toString() code
			// inside each of 3 classes, then watch the result when run again.

			System.out.println("die1's toString(): '" + die1 + "'");
			System.out.println("crooked1's toString(): '" + crooked_1 + "'");
			System.out.println("crooked2's toString(): '" + crooked_2 + "'");
		}
		else if (R_EXAMPLE == 4)
		{
			// Die alias = die1; // try replacing this line with either below
			Die_1 alias = crooked_1; // upcasting!
			// Die alias = crooked2; // ditto

			System.out.println("alias's toString(): '" + alias.toString() + "'");
			System.out.println();
		}
		else if (R_EXAMPLE == 5)
		{
			Die_1 alias;

			double toss = Math.random(); // [0.0..1.0)

			if (toss < 0.333)
				alias = die1;
			else if (toss < 0.666)
				alias = crooked_1;
			else
				alias = crooked_2;

			// Can the compiler figure out the actual type
			// of alias in the following call?
			// No => dynamic runtime lookup happens

			describe("Which toString() is called? Answer is: ", alias);
		}
		else if (R_EXAMPLE == 6)
		{
			Die_1 another = new Die_1();

			Dicemal dice = new Dicemal(die1, crooked_1); // we'll try substituting here

			dice.roll();

			int result = dice.getThe_last_Roll();

			System.out.printf("Roll of '%s' and '%s' is: %d.\n", die1, crooked_1, result);
		}

		System.out.println();
	}

	/**
	 * Shows polymorphism via passing either Die ref as toDescribe, or
	 * CrookedDie1 or CrookedDie2 ref instead
	 * 
	 * @param msg
	 * @param toDescribe
	 */

	public static void describe(String msg, Die_1 toDescribe)
	{
		System.out.printf("%s '%s' \n", msg, toDescribe.toString());
	}

}
