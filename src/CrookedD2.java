
public class CrookedD2 extends Die_1 // subclassing
{
	public CrookedD2()
	{
		Crap.println("  CrookedDie2's constructor called.");
	}

	public void roll() // can you see what this computes?
	{
		// call the inherited method to get lastRoll from parent Die parts

		rollAction3();
	}

	private void rollAction3()
	{
		int MaketestRoll = getLastRoll();

		if (MaketestRoll == 6)
			this.setLastRoll(1);
		else
			this.setLastRoll(MaketestRoll + 1);
	}

	public String toString()
	{
		return "A CrookedDie2 rolling 1,2,3,4,5,6 in sequence, and... ";
	}

}
