import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double balance = 2500.75;
        int transactions = 0;
        int attempts = 0;
        boolean loggedIn = false;

        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            int pin = input.nextInt();
            attempts++;
            if (pin == 1234) {
                loggedIn = true;
                break;
            }
        }

        if (!loggedIn) {
            System.out.println("Your account has been locked.");
        } else {
            int choice;

            do {
                System.out.print("\n========= ATM =========\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Show Account Status\n5. Exit\n=======================\nChoose: ");
                choice = input.nextInt();

                if (choice == 5) {
                    System.out.println("Transactions: " + transactions + "\nThank you for using our ATM.");
                    break;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Balance: " + balance);
                        break;
                    case 2:
                        System.out.print("Amount: ");
                        double deposit = input.nextDouble();
                        if (deposit > 0) {
                            balance += deposit;
                            transactions++;
                            System.out.println("Balance: " + balance);
                        } else {
                            System.out.println("Invalid amount.");
                        }
                        break;
                    case 3:
                        System.out.print("Amount: ");
                        double withdraw = input.nextDouble();
                        if (withdraw == 0) {
                            System.out.println("Transaction cancelled.");
                        } else if (withdraw < 0 || withdraw > balance) {
                            System.out.println("Insufficient balance.");
                        } else {
                            balance -= withdraw;
                            transactions++;
                            System.out.println("Balance: " + balance);
                            if (balance == 0) {
                                System.out.println("Warning: Your account is empty.");
                            }
                        }
                        break;
                    case 4:
                        if (balance >= 5000) {
                            System.out.println("VIP Customer");
                        } else if (balance >= 1000) {
                            System.out.println("Regular Customer");
                        } else {
                            System.out.println("Low Balance");
                        }
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } while (true);
        }
    }
}