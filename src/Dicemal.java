/**
 * Dice represents a single pair of rollable Die objects, randomly generating
 * sums of their two values
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author eric
 *
 */
public class Dicemal
{
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

	private int the_last_Roll;
	private Die_1 die_number_1;
	private Die_1 die_number_2;

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

	public Dicemal()
	{
		// initialize instance variables die1 and die2 by
		// creating a new instance of each

		dicemailAction();
	}

	private void dicemailAction()
	{
		this.die_number_1 = new Die_1();
		this.die_number_2 = new Die_1();
		this.roll();
	}

	public Dicemal(Die_1 die1, Die_1 die2) // overloaded constructor
	{
		dicemailAction(die1, die2);
	}

	private void dicemailAction(Die_1 die1, Die_1 die2)
	{
		this.die_number_1 = die1;
		this.die_number_2 = die2;
	}

	// Instance methods can also be declared anywhere
	// Convention: after constructors

	public int getThe_last_Roll()
	{
		return this.the_last_Roll;
	}

	public void roll()
	{
		// roll each of die1, die2, sum their last rolls,
		// then set Dice.lastRoll to this value

		die_number_1.roll();
		die_number_2.roll();
		this.the_last_Roll = die_number_1.getLastRoll() + die_number_2.getLastRoll();

	}

	// the following method converts the internals of
	// this Dice object, and returns a descriptive String:
	//
	// Roll of 7 => 4 + 3
	//

	public String toString()
	{
		return "Roll of " + getThe_last_Roll() + ": " + die_number_1.getLastRoll() + " + " + die_number_2.getLastRoll();

	}

	// static methods can go anywhere - but at end is standard

	public static final int NUMber_TRIALS = 360;

	public static void main(String[] args)
	{
		Dicemal dice1 = new Dicemal();
		int snakeEyesCount = 0;

		for (int i = 0; i < NUMber_TRIALS; i++)
		{
			dice1.roll();
			System.out.println(dice1);
			
			if (dice1.getThe_last_Roll() == 2)
				snakeEyesCount++;
		}

		System.out.println("Actual count: " + snakeEyesCount);
		System.out.println("Expected count: " + (NUMber_TRIALS / 36.0));
	}
}
