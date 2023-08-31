import java.util.ArrayList;
import java.util.HashMap;

public class YearReport {
    boolean isChecked = false; //проверка на то считан ли был отчёт
    ArrayList<YearLine> years;
    MonthConverter monthConverter = new MonthConverter();

    void checkReport() {
        YearReader yearReader = new YearReader("y.2021.csv");
        years = yearReader.years;
        isChecked = true;
    }

    void printYearStatistic() {
        System.out.println("Отчётный год - 2021.");
        HashMap<String,Double> profits = new HashMap<>();
        double allIncomes = 0.0;
        double allOutcomes = 0.0;

        for (YearLine year : years) {
            if (!profits.containsKey(year.month)) {
                profits.put(year.month,0.0);
            }
            if (!year.isExpense) {
                profits.put(year.month, profits.get(year.month)+year.amount);
                allIncomes += year.amount;
            } else {
                profits.put(year.month, profits.get(year.month)-year.amount);
                allOutcomes += year.amount;
            }
        }



        for (String month : profits.keySet()) {
            double amount = profits.get(month);
            System.out.println("Прибыль за " + monthConverter.numToMonth(month) + ": " + amount);
        }

        System.out.println("Средний расход за все имеющиеся операции в году: " + allOutcomes / (years.size() / 2.0));
        System.out.println("Средний доход за все имеющиеся операции в году: " + allIncomes / (years.size() / 2.0));
    }


}
