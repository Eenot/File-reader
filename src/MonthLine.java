public class MonthLine {
    String itemName;
    Boolean isExpense;
    Integer quantity;
    Double sumOne;

    public MonthLine(String itemName, Boolean isExpense, Integer quantity, Double sumOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOne = sumOne;
    }
}
