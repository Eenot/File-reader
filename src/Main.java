import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MonthReport monthReport = new MonthReport();
        YearReport yearReport = new YearReport();


        while(true) {
            printMenu();
            int command = sc.nextInt();

            switch (command) {
                case 1:
                    monthReport.checkReport();
                    System.out.println("Все отчёты успешно считаны!");
                    break;
                case 2:
                    yearReport.checkReport();
                    System.out.println("Все отчёты успешно считаны!");
                    break;
                case 3:
                    CheckReports checkReports = new CheckReports(MonthReport.monthStatistic, YearReport.years);
                    checkReports.getCheckedReports();
                    break;
                case 4:
                    if (MonthReport.isChecked) {
                        monthReport.printMonthsStatistic();
                    } else {
                        System.out.println("Перед выводом информации об отчётах по месяцам необходимо их считать!");
                    }
                    break;
                case 5:
                    if (YearReport.isChecked) {
                        yearReport.printYearStatistic();
                    } else {
                        System.out.println("Перед выводом информации об отчёте за год необходимо его считать!");
                    }
                    break;
                case 0:
                    System.out.println("Спасибо за использование нашей программы! Всего хорошего!");
                    return;
                default:
                    System.out.println("Неизвестная команда!");
                    break;

            }
        }
    }

    public static void printMenu() {
        System.out.println("---------------Меню----------------");
        System.out.println("1 - Считать все месячные отчёты.");
        System.out.println("2 - Считать годовой отчёт.");
        System.out.println("3 - Сверить отчёты.");
        System.out.println("4 - Вывести информацию о всех месячных отчётах.");
        System.out.println("5 - Вывести информацию о годовом отчёте.");
        System.out.println("0 - Выйти из программы.");
    }
}


