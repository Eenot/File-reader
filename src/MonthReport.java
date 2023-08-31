import java.util.ArrayList;
import java.util.HashMap;

public class MonthReport {
    boolean isChecked = false; //Проверка на то, считан ли был отчёт
    HashMap<Integer,ArrayList<MonthLine>> monthStatistic = new HashMap<>();
    MonthConverter monthConverter = new MonthConverter();

    void checkReport() { //метод считывания отчётов из файлов
        for (int i = 1; i <=3; i++) {
            String fileName = "m.20210" + i + ".csv";
            MonthReader monthReader = new MonthReader(fileName);
            monthStatistic.put(i,monthReader.month);
        }
        isChecked = true;
    }

    void printMonthsStatistic() {
        for (Integer month : monthStatistic.keySet()) {
            double maxIncome = 0.0;
            String bestItem = "";
            double bestItemSum = 0.0;
            double maxExpense = 0.0;
            String maxExpenseItem = "";
            double maxExpenseSummary = 0.0;
            System.out.println("Месяц: " + monthConverter.numToMonth(month));

            for (MonthLine line : monthStatistic.get(month)) {
                if (!(line.isExpense)) {
                    if (maxIncome < line.quantity * line.sumOne) {
                        maxIncome = line.quantity * line.sumOne;
                        bestItem = line.itemName;
                        bestItemSum = line.sumOne;
                    }
                } else {
                    if (maxExpense < line.quantity * line.sumOne) {
                        maxExpense = line.quantity * line.sumOne;
                        maxExpenseItem = line.itemName;
                        maxExpenseSummary = line.sumOne;
                    }
                }
            }
            System.out.println("Самый прибыльный товар месяца " + bestItem + " стоимостью " + bestItemSum);
            System.out.println("Самая большая трата в месяце " + maxExpenseItem + " стоимостью " + maxExpenseSummary);
        }
    }
}
