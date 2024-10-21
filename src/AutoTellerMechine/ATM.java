package AutoTellerMechine;

import java.util.Scanner;

public class ATM {
	private double balance;
	private final int PIN;
	public ATM(double initialBalance,int pin) {
		this.balance=initialBalance;
		this.PIN=pin;
	}
	public void checkbalance() {
		System.out.println("Your current Balance is:$"+balance);
	}
	public void deposit(double amount) {
		if(amount>0) {
			balance=balance+amount;
			System.out.println("Successfully deposited:$"+amount);
			System.out.println("Updated balance:$"+balance);
		}
		else {
			System.out.println("Invalid deposit amount:");
		}
	}
	public void withdraw(double amount) {
		if(amount>0&&amount<=balance) {
			balance-=amount;
			System.out.println("Successfully withdraw:$"+amount);
			System.out.println("Update balance:$"+balance);
		}
		else if(amount>balance) {
			System.out.println("Insufficient balance.");
		}
		else {
			System.out.println("Invaild withdraw amount.");
		}
	}
	public boolean authenticate(int pinInput) {
		return pinInput==this.PIN;	
	}

	         // main method will be started
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATM atm=new ATM(500.00,1234);
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the ATM!");
		System.out.print("Please enter your 4-digit PIN");
		int pinInput=scan.nextInt();
		if(atm.authenticate(pinInput)) {
			int option=-1;
			while(option!=4) {
				System.out.println("\nATM Menu:");
				System.out.println("1.check Balance:");
				System.out.println("2.Deposit");
				System.out.println("3.Withdraw");
				System.out.println("4.Exit");
				System.out.println("Please choose an option:");
				option=scan.nextInt();
				switch(option) {
				case 1:
				atm.checkbalance();
				break;
				case 2:
					System.out.print("Enter the amount to deposit:");
					double depositAmount=scan.nextDouble();
					atm.deposit(depositAmount);
					break;
				case 3:
					System.out.print("Enter the amount to withdraw:");
					double withdrawAmount=scan.nextDouble();
					atm.withdraw(withdrawAmount);
					break;
				case 4:
					System.out.print("Thank you for using the ATM.Goodbye!");
					break;
					default:
						System.out.println("Invaild option.Please try again.");
				}
			}
			
			}
		else {
			System.out.println("Incorrect PIN.Access Denied");
		}	

	}

}
