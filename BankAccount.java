import java.util.*;

public class BankAccount {
    private static double balance = 5000.0;
    private static int pin = 1234;

    public static boolean validatePin(int inputPin) {
        return pin == inputPin;
    }

    public static void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public static void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        
        try {
            int enteredPin = sc.nextInt();
            
            if (!validatePin(enteredPin)) {
                System.out.println("Invalid PIN. Exiting...");
                sc.close();
                return;
            }

            int choice = 0;
            do {
                System.out.println("\n=== ATM Menu ===");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        deposit(dep);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double wth = sc.nextDouble();
                        withdraw(wth);
                        break;
                    case 4:
                        System.out.println("Thank you! Visit again.");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice != 4);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}