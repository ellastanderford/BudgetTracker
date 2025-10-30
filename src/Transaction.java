public class Transaction {
    private String type; //"income" or "expense"
    private double amount; //amount of money being added/removed
    private String category; //i.e. "Food", "Rent", "Gas", "Work"
    private String description; //short note on the expense/income
    private String date; //String or LocalDate

    //Transaction object constructor
    public Transaction(String t, double a, String c, String d, String date) {
        type = t;
        amount = a;
        category = c;
        description = d;
        this.date = date;
    }

    //Grants access to the variables in main -- Getters
    public String getType() {
        return type;
    }
    public double getAmount() {
        return amount;
    }
    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public String getDate() {
        return date;
    }

    //Allows main to edit variables -- Setters
    public void setType(String type) {
        //Adding some validation to this method
        if (type.equalsIgnoreCase("income") || type.equalsIgnoreCase("expense")) {
            this.type = type;
        }
        else {
            System.out.println("Invalid type. Must be 'income' or 'expense'");
        }
    }
    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        }
        else {
            System.out.println("Amount cannot be negative.");
        }
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDate(String date) {
        this.date = date;
    }

    //toString() method to define how object is printed
    @Override
    public String toString() {
        return date + " | " + category + " | " + type + " | " + date + " | $" + amount + " | " +  description;
    }
}
