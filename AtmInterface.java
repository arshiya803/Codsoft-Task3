import java.util.Scanner;

class bankAccount {
 private double balance;

 public bankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     balance += amount;
 }

 public boolean withdraw(double amount) {
     if (amount <= balance) {
         balance -= amount;
         return true; 
     } 
     else {
         return false; 
     }
 }
}

class Atm {
 private bankAccount userAccount;
 private Scanner scanner;

 public Atm(bankAccount userAccount) {
     this.userAccount = userAccount;
     this.scanner = new Scanner(System.in);
 }


 public void displayMenu() {
     System.out.println("ATM Menu:");
     System.out.println("1. Withdraw");
     System.out.println("2. Deposit");
     System.out.println("3. Check Balance");
     System.out.println("4. Exit");
 }

 
 public void handleUserInput() {
     int choice;

     do {
         displayMenu();
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 
                 System.out.print("Enter the amount to withdraw: ");
                 double withdrawAmount = scanner.nextDouble();
                 boolean withdrawSuccess = userAccount.withdraw(withdrawAmount);
                 displayTransactionResult(withdrawSuccess);
                 break;

             case 2:
                 
                 System.out.print("Enter the amount to deposit: ");
                 double depositAmount = scanner.nextDouble();
                 userAccount.deposit(depositAmount);
                 System.out.println("Deposit successful. Current balance: " + userAccount.getBalance());
                 break;

             case 3:
                 
                 System.out.println("Current Balance: " + userAccount.getBalance());
                 break;

             case 4:
                 
                 System.out.println("Goodbye! Have a nice day...");
                 break;

             default:
                 System.out.println("Invalid choice. Please enter a valid option.");
         }
     } while (choice != 4);
 }

 
 private void displayTransactionResult(boolean success) {
     if (success) {
         System.out.println("Withdrawal successful. Current balance: " + userAccount.getBalance());
     } else {
         System.out.println("Insufficient balance. Withdrawal failed.");
     }
 }
}

public class AtmInterface {
 public static void main(String[] args) {
     
     bankAccount userAccount = new bankAccount(5000.0);

     
     Atm atm = new Atm(userAccount);

    
     atm.handleUserInput();
 }
}

