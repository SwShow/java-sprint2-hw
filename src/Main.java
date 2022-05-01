import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        String[] january = null;
        String[] february = null;
        String[] march = null;
        String[] year = null;

        while (true) {
            printMenue();
            int command = scanner.nextInt();
            if (command == 1) {
                january = monthlyReport.readFileContents("resources/m.202101.csv");
                february = monthlyReport.readFileContents("resources/m.202102.csv");
                march = monthlyReport.readFileContents("resources/m.202103.csv");
            } else if (command == 2) {
                year = monthlyReport.readFileContents("resources/y.2021.csv");
            } else if (command == 3) {
                YearlyReport.compareMonthAndYear(year, january, february, march);
            } else if (command == 4) {
                monthlyReport.infoMonth(january, "Январь");
                monthlyReport.infoMonth(february, "Февраль");
                monthlyReport.infoMonth(march, "Март");
            } else if (command == 5) {
                yearlyReport.infoYear(year);
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
