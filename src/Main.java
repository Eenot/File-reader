import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthReport monthReport = new MonthReport();
        YearReport yearReport = new YearReport();

        while(true) {
            printMenu();
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    monthReport.checkReport();
                    System.out.println("Все отчёты успешно считаны!");
                    break;
                case 2:
                    yearReport.checkReport();
                    System.out.println("Годовой отчёт успешно считан!");
                    break;
                case 3:
                    if (monthReport.isChecked && yearReport.isChecked) {
                        ReportChecker reportChecker = new ReportChecker(monthReport.monthStatistic, yearReport.years);
                        reportChecker.getCheckedReports();
                    } else {
                        System.out.println("Чтобы сверить отчёты для начала их необходимо считать!");
                    }
                    break;
                case 4:
                    if (monthReport.isChecked) {
                        monthReport.printMonthsStatistic();
                    } else {
                        System.out.println("Перед выводом информации об отчётах по месяцам необходимо их считать!");
                    }
                    break;
                case 5:
                    if (yearReport.isChecked) {
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


