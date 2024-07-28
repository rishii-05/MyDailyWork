import java.util.Scanner;

class ATM {
	private BankAccount bankAccount;
	public ATM(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	public void displayMenu() {
		System.out.println("\n ********* ATM Menu  ********* ");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Exit");
	}
	public void performTransaction() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			displayMenu();
			System.out.print("\nSelect an option: ");
			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					System.out.println("\nYour current balance: Rs." + bankAccount.getBalance());
					break;
				case 2:
					System.out.print("Enter amount to be deposited: ");
					double depositAmount = scanner.nextDouble();
					bankAccount.deposit(depositAmount);
					System.out.println("\nDeposit successful.\nYour current balance: Rs." + bankAccount.getBalance());
					break;
				case 3:
					System.out.print("Enter amount to withdraw: ");
					double withdrawAmount = scanner.nextDouble();
					if ((withdrawAmount > 0) && (withdrawAmount <= bankAccount.getBalance())) {
						bankAccount.withdraw(withdrawAmount);
						System.out.println("\nWithdrawal successful.\nYour current balance: Rs." + bankAccount.getBalance());
					} else {
						System.out.println("\nInsufficient balance!!");
					}
					break;
				case 4:
					System.out.println("\n ********* Exiting ATM. Thank you!  ********* ");
					scanner.close();
					return;
				default:
					System.out.println("\nInvalid option!! Please select a valid option.");
			}
		}
	}
}

class BankAccount {
	private double balance;
	public BankAccount(double initialBalance) {
		this.balance= initialBalance;
	}
	public double getBalance(){
		return balance;
	}
	public void deposit(double amount) {
		balance += amount;
	}
	public void withdraw(double amount) {
		balance -= amount;
        }
}

public class ATM_Interface {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter initial account balance: Rs.");
		double initialBalance = scanner.nextDouble();
		BankAccount bankAccount = new BankAccount(initialBalance);
		ATM atm  = new ATM(bankAccount);
		atm.performTransaction();
	}
}