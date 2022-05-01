import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MonthlyReport {

    String[] january;
    String[] february;
    String[] march;

    public MonthlyReport() {

        this.january = january;
        this.february = february;
        this.march = march;

    }

    static String[] readFileContents(String filename) {
        Path filePath = Paths.get(filename);
        try {
            String yearlyTable = Files.readString(filePath);
            String[] globalReport = yearlyTable.split(System.lineSeparator());

            return globalReport;
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    void infoMonth(String[] month, String nameMonth) {
        if (month != null) {
            System.out.println("Самые большие расходы и доходы за " + nameMonth);

            int largePrice = 0;
            int largeExpense = 0;
            String profitName = "";
            String expenseName = "";
            for (int i = 1; i < month.length; i++) {
                String[] lines = month[i].split(",");
                int amount;
                int price;
                int totalPrice;

                if (lines[1].equals("FALSE")) {
                    amount = Integer.parseInt(lines[2]);
                    price = Integer.parseInt(lines[3]);
                    totalPrice = amount * price;
                    if (totalPrice > largePrice) {
                        largePrice = totalPrice;
                        profitName = lines[0];
                    }
                } else {
                    amount = Integer.parseInt(lines[2]);
                    price = Integer.parseInt(lines[3]);
                    totalPrice = amount * price;
                    if (totalPrice > largeExpense) {
                        largeExpense = totalPrice;
                        expenseName = lines[0];
                    }
                }
            }
            System.out.println("Самые большие расходы: " + expenseName + " - " + largeExpense);
            System.out.println("Самый прибыльный товар: " + profitName + " - " + largePrice + "\n");

        } else {
            System.out.println("Считайте месячный отчет.");
        }
    }
}