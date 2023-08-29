import java.util.ArrayList;
import java.util.HashMap;


public class CheckReports {
    HashMap<Integer ,ArrayList<MonthToLine>> monthsStatistic;
    ArrayList<YearToLine> yearStatistic;
    MonthConverter monthConverter = new MonthConverter();

    public CheckReports(HashMap<Integer, ArrayList<MonthToLine>> monthsStatistic, ArrayList<YearToLine> yearStatistic) {
        this.monthsStatistic = monthsStatistic;
        this.yearStatistic = yearStatistic;
    }




    void getCheckedReports() {

        if (!MonthReport.isChecked && !YearReport.isChecked) {
            System.out.println("Перед сверкой отчётов, необходимо их считать!");
        } else {
            ArrayList<Integer> errors = new ArrayList<>();
            for (Integer month : monthsStatistic.keySet()) {
                double expenseSum = 0.0;
                double incomeSum = 0.0;
                for (MonthToLine line : monthsStatistic.get(month)) {
                    if (line.isExpense) {
                        expenseSum += (line.quantity * line.sumOne);
                    } else {
                        incomeSum += (line.quantity * line.sumOne);
                    }
                }
                String strMonth = "0" + month;

                for (YearToLine line : yearStatistic) {
                    if (line.month.equals(strMonth) && line.isExpense) {
                        if (line.amount != expenseSum) {
                            errors.add(month);
                        }
                    }
                    if (line.month.equals(strMonth) && !line.isExpense){
                        if (line.amount != incomeSum) {
                            errors.add(month);
                        }
                    }
                }
            }
            if (errors.isEmpty()) {
                System.out.println("Все отчёты успешно прошли проверку!");
            } else {
                for (Integer error : errors) {
                    System.out.println("Обнаружено несоответствие в отчёте за месяц " + monthConverter.numToMonth(error));
                }
            }
        }
    }
}
