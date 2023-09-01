public class YearLine {
    String month;
    Double amount;
    Boolean isExpense;

    public YearLine(String month, Double amount, Boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }

    public Boolean getExpense() {
        return isExpense;
    }
}
