
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       MonthlyReport monthlyReport = new MonthlyReport();

        while (true) {
            printMenue();
            int command = scanner.nextInt();
            if (command == 1) {
                MonthlyReport.readMonthlyReport(monthlyReport.jan, monthlyReport.name1);
                MonthlyReport.readMonthlyReport(monthlyReport.feb, monthlyReport.name2);
                MonthlyReport.readMonthlyReport(monthlyReport.mar, monthlyReport.name3);
            } else if (command == 2) {
                YearlyReport.readYearlyReport(monthlyReport.year);
            } else if (command == 3) {
                MonthlyReport.compareMonthAndYear(monthlyReport.year, monthlyReport.jan, monthlyReport.feb, monthlyReport.mar);
            } else if (command == 4) {
                MonthlyReport.getMonthlyReport(monthlyReport.jan, monthlyReport.name1);
                MonthlyReport.getMonthlyReport(monthlyReport.feb, monthlyReport.name2);
                MonthlyReport.getMonthlyReport(monthlyReport.mar, monthlyReport.name3);
            } else if (command == 5) {
                YearlyReport.infoYear(monthlyReport.year);
            } else if (command == 100) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    static void printMenue() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 -  Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 -  Вывести информацию о годовом отчёте");
        System.out.println("100 -  Завершить программу");
    }


}
