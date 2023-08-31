import java.util.ArrayList;
import java.util.HashMap;

public class ReportChecker {
    HashMap<Integer ,ArrayList<MonthLine>> monthStatistic;
    ArrayList<YearLine> yearStatistic = new ArrayList<>();
    MonthConverter monthConverter = new MonthConverter();
    MonthReport monthReport = new MonthReport();
    YearReport yearReport = new YearReport();

    public ReportChecker(HashMap<Integer, ArrayList<MonthLine>> monthStatistic, ArrayList<YearLine> yearStatistic) {
        this.monthStatistic = monthStatistic;
        this.yearStatistic = yearStatistic;
    }

    void getCheckedReports() {
        if (!monthReport.isChecked && !yearReport.isChecked) {
            System.out.println("Перед сверкой отчётов, необходимо их считать!");
        } else {
            ArrayList<Integer> errors = new ArrayList<>();
            for (Integer month : monthStatistic.keySet()) {
                double expenseSum = 0.0;
                double incomeSum = 0.0;
                for (MonthLine line : monthStatistic.get(month)) {
                    if (line.isExpense) {
                        expenseSum += (line.quantity * line.sumOne);
                    } else {
                        incomeSum += (line.quantity * line.sumOne);
                    }
                }
                String strMonth = "0" + month;

                for (YearLine line : yearStatistic) {
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
