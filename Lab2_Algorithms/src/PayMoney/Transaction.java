package PayMoney;

import java.util.Scanner;
//import java.util.Arrays;

public class Transaction {
	long[] transactions = null;

	int noOfTransactions = 0, targetToAchieve = 0;

	Scanner scanner = null;

	public Transaction() {
		scanner = new Scanner(System.in);
	}

	private void insertValues() {
		System.out.print("Enter the size of transaction array: ");
		noOfTransactions = scanner.nextInt();

		transactions = new long[noOfTransactions];

		System.out.println("\nEnter the values of array");
		for (int i = 0; i < noOfTransactions; i++) {
			System.out.print("Enter the " + (i + 1) + "th transcation: ");
			transactions[i] = scanner.nextLong();
		}

		System.out.print("\nEnter the total no of targets that needs to be achieved: ");
		targetToAchieve = scanner.nextInt();

	}

	private int getTransactionsRequiredToSecureTarget(long target) {
		int transRequired = 0;
		long sum = 0;
		while ((sum < target) && (transRequired < noOfTransactions)) {
			sum += transactions[transRequired++];
		}
		return sum >= target ? transRequired : -1;
	}

	public void checkTargetAchievements() {
		insertValues();
		while (targetToAchieve-- > 0) {
			System.out.print("\nEnter the value of target: ");
			long target = scanner.nextLong();
			int transReqToSecureTarget = getTransactionsRequiredToSecureTarget(target); // returns -1 if target is not
																						// achieved
			if (transReqToSecureTarget > 0) {
				System.out.println("Target achieved after " + transReqToSecureTarget + " transactions ");
			} else {
				System.out.println("Given target is not achieved");
			}
		}
	}

}
