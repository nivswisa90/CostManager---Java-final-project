package costManager.model;

public class CostItem {

//    private String description;
//    private double sum;
//    private Currency currency;
//    private int id;

    private int id;
    private Category category;
    private double amount;
    private Currency currency;
    private String description;
    private String date;

    public CostItem(int id, Category category, double amount, Currency currency, String description, String date) {
        setId(id);
        setCategory(category);
        setAmount(amount);
        setCurrency(currency);
        setDescription(description);
        setDate(date);
    }
    public void setId(int id) {this.id = id; }

    public int getId() { return this.id; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Category getCategory() {return category;}

    public void setCategory(Category category) { this.category = category; }

    public String getDate() { return date; }

    public void setDate(String data) { this.date = date; }


}
