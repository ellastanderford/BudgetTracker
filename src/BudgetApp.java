import java.util.ArrayList;
import java.util.Scanner;

public class BudgetApp {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        BudgetManager manager = new BudgetManager();

        System.out.println("Welcome to Ella's Budget Tracker!");
        int choice = 0;
        while (choice != 6) {
            //Display menu
            System.out.println("\nPlease choose an option:");
            System.out.println("1) Add a transaction");
            System.out.println("2) View all transactions");
            System.out.println("3) View balance");
            System.out.println("4) Filter by category");
            System.out.println("5) Remove a transaction");
            System.out.println("6) Exit");
            //Get user choice
            System.out.println("Enter your choice (1-6): ");
            if (in.hasNextInt()) {
                choice = in.nextInt();
                in.nextLine();
            }
            else {
                System.out.println("Invalid input. Please enter a number 1-6.");
                in.nextLine();
                continue;
            }
            //Responding to their choice using a switch
            switch (choice) {
                case 1: //Adding a transaction
                    System.out.print("Enter type (income/expense): ");
                    String type = in.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = in.nextDouble();
                    in.nextLine(); //Consume next line of empty space

                    System.out.print("Enter category: ");
                    String category = in.nextLine();

                    System.out.print("Enter description: ");
                    String description = in.nextLine();

                    System.out.print("Enter date (e.g., 2025-10-30): ");
                    String date = in.nextLine();

                    Transaction t = new Transaction(type, amount, category, description, date);
                    manager.addTransaction(t);
                    break;

                case 2: //View all transactions
                    ArrayList<Transaction> all = manager.getAllTransactions();
                    if (all.isEmpty()) {
                        System.out.println("No transactions recorded yet.");
                    }
                    else {
                        System.out.println("\n---All Transactions---");
                        for (int i = 0; i < all.size(); i++) {
                            System.out.println((i + 1) + ") " + all.get(i));
                        }
                    }
                    break;

                case 3: //View balance
                    double balance = manager.getBalance();
                    System.out.printf("Current balance: $%.2f\n", balance); 
                    break;
                
                case 4: //Filter by category
                    System.out.print("Enter category to filter by: ");
                    String cat = in.nextLine();
                    ArrayList<Transaction> filtered = manager.filterByCategory(cat);
                    if (filtered.isEmpty()) {
                        System.out.println("No transactions found for that category.");
                    }
                    else {
                        System.out.println("\n--- Transactions in category: " + cat + " ---");
                        for (Transaction ft : filtered) {
                            System.out.println(ft);
                        }
                    }
                    break;

                case 5: //Remove a transaction
                    ArrayList<Transaction> current = manager.getAllTransactions();
                    if (current.isEmpty()) {
                        System.out.println("No transactions to remove.");
                    }
                    else {
                        System.out.println("\n--- Current Transactions ---");
                        for (int i = 0; i < current.size(); i++) {
                            System.out.println((i + 1) + ") " + current.get(i));
                        }
                        System.out.print("Enter the number of the transaction to remove: ");
                        int index = in.nextInt() - 1;
                        in.nextLine(); //consume new line
                        manager.removeTransaction(index);
                    }
                    break;

                case 6: //Exit
                    System.out.println("Thanks for using Ella's Budget Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number 1-6.");
                    break;
            }
        }
        in.close();
    }
}