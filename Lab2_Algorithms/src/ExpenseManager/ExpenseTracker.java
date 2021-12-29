package ExpenseManager;

import java.util.Scanner;

public class ExpenseTracker {

	int curDenominationSize = 0;
	int[] currencyDenominations = null, denominations = null;
	Scanner scanner = null;
	SortHelper sortHelper = null;

	public ExpenseTracker() {
		scanner = new Scanner(System.in);
		sortHelper = new SortHelper();
	}

	private void insertValues() {
		System.out.print("Enter the size of currency denominations: ");
		curDenominationSize = scanner.nextInt();

		currencyDenominations = new int[curDenominationSize];
		denominations = new int[curDenominationSize];

		System.out.println("Enter the currency denominations value");
		for (int i = 0; i < curDenominationSize; i++) {
			System.out.print("Enter the " + (i + 1) + "th currency denomination: ");
			currencyDenominations[i] = scanner.nextInt();
		}

		sortHelper.mergeSort(currencyDenominations, 0, curDenominationSize - 1);
	}

	public void calculateExpenseDenominations() {
		this.insertValues();
		System.out.print("Enter the amount you want to pay: ");
		long amount = scanner.nextLong();
		// long tAmount = amount;
		if (amount > 0) {
			while (amount > 0) {
				boolean isAmtUpdated = false;

				for (int i = 0; i < curDenominationSize; i++) {
					int curDenom = currencyDenominations[i];
					if (curDenom > 0 && amount >= curDenom) {
						denominations[i] = (int) amount / curDenom;
						amount %= curDenom;
						isAmtUpdated = true;
					}
				}
				if (!isAmtUpdated) {
					System.out.println("Unable to complete the payment");
					return;
				}
			}

			// sortHelper.printArray(denominations, curDenominationSize);

			if (amount == 0) {
				System.out.println("Your payment approach in order to give min no of notes will be");
				for (int i = 0; i < curDenominationSize; i++) {
					if (denominations[i] > 0) {
						System.out.println(currencyDenominations[i] + ":" + denominations[i]);
					}
				}
			}
		} else {
			System.out.println("Amount is zero");
		}
	}

	public static void main(String[] args) {

		ExpenseTracker expenseTracker = new ExpenseTracker();
		expenseTracker.calculateExpenseDenominations();
		expenseTracker.scanner.close();

	}

}
