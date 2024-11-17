import java.util.ArrayList;
import java.util.Scanner;

class ATM {
    private static double balance = 0.0;
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Predefined user credentials
        String userId = "admin";
        String userPin = "1234";

        System.out.println("Welcome to the ATM System");
        System.out.print("Enter User ID: ");
        String enteredId = scanner.nextLine();
        System.out.print("Enter User PIN: ");
        String enteredPin = scanner.nextLine();

        if (userId.equals(enteredId) && userPin.equals(enteredPin)) {
            System.out.println("\nLogin successful!");
            showMenu(scanner);
        } else {
            System.out.println("Invalid credentials. Exiting...");
        }

        scanner.close();
    }

    private static void showMenu(Scanner scanner) {
        while (true) {
            
            System.out.println("\nATM Menu:");
            System.out.println("1. Balance Enquiry");
            System.out.println("2. Transaction History");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("5. Transfer");
            System.out.println("6. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    check_balance();
                    break;
                case 2:
                    showTransactionHistory();
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    deposit(scanner);
                    break;
                case 5:
                    transfer(scanner);
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void check_balance() {
        System.out.println("Your curreny baance is: ");
        System.out.println("$ "+balance);
    }
    private static void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("\nEnter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
            transactionHistory.add("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("\nEnter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
            transactionHistory.add("Deposited: $" + amount);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    private static void transfer(Scanner scanner) {
        System.out.print("\nEnter the recipient's account number: ");
        String recipient = scanner.next();
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Transfer to account " + recipient + " successful. New balance: $" + balance);
            transactionHistory.add("Transferred $" + amount + " to account: " + recipient);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}
