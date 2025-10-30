import java.util.ArrayList;

public class BudgetManager {
    //Creating an array list for the transactions
    private ArrayList<Transaction> transactions;
    
    //Transaction constructor
    public BudgetManager() {
        transactions = new ArrayList<>(); //initalizes my list
    }

    //Methods to manipulate array list
    //Add a transaction
    public void addTransaction(Transaction t) {
        transactions.add(t);
        System.out.println("Transaction added successfully!");
    }
    //Remove a transaction by index
    public void removeTransaction(int index) {
        if (index >= 0 && index < transactions.size()) {
            transactions.remove(index);
            System.out.println("Transaction removed successfully!");
        }
        else {
            System.out.println("Invalid index. No transaction removed.");
        }
    }
    //View all transactions
    public ArrayList<Transaction> getAllTransactions() {
        return transactions;
    }
    //Calculate current balance
    public double getBalance() {
        double balance = 0.0;

        for (Transaction t : transactions) {
            if (t.getType().equalsIgnoreCase("income")) {
                balance = balance + t.getAmount();
            }
            else if (t.getType().equalsIgnoreCase("expense")) {
                balance = balance - t.getAmount();
            }
        }

        return balance;
    }
    //Filter transactions by category
    public ArrayList<Transaction> filterByCategory(String category) {
        ArrayList<Transaction> filtered = new ArrayList<>();

        for (Transaction t : transactions) {
            if (t.getCategory().equalsIgnoreCase(category)) {
                filtered.add(t);
            }
        }

        return filtered;
    }

}
