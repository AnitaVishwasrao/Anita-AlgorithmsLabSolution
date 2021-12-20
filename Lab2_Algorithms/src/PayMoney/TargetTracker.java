package PayMoney;

public class TargetTracker {

	public static void main(String[] args)
	{
		Transaction transaction = new Transaction();
		transaction.checkTargetAchievements();
		transaction.scanner.close();
	}
}
