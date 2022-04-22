import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month1 = "январь";
        String month2 = "Февраль";
        String month3 = "Март";
        String[] jan = readFileContents("resources/m.202101.csv");
        String[] feb = readFileContents("resources/m.202102.csv");
        String[] mar = readFileContents("resources/m.202103.csv");
        String[] year = readFileContents("resources/y.2021.csv");

        while (true) {
            printMenue();
            int command = scanner.nextInt();
            if (command == 1) {
                MonthlyReport.readMonthlyReport(jan, month1);
                MonthlyReport.readMonthlyReport(feb, month2);
                MonthlyReport.readMonthlyReport(mar, month3);
            } else if (command == 2) {
                YearlyReport.readYearlyReport(year);
            } else if (command == 3) {
                MonthlyReport.compareMonthAndYear(year, jan, feb, mar);
            } else if (command == 4) {
                MonthlyReport.getMonthlyReport(jan, month1);
                MonthlyReport.getMonthlyReport(feb, month2);
                MonthlyReport.getMonthlyReport(mar, month3);
            } else if (command == 5) {
                YearlyReport.infoYear(year);
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

    private static String[] readFileContents(String filename) {
        Path filePath = Paths.get(filename);
        try {
            String yearlyTable =  Files.readString(filePath);
            String[] globalReport = yearlyTable.split(System.lineSeparator());

            return globalReport;
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}
