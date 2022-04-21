import java.util.ArrayList;
import java.util.Arrays;

public class MonthlyReport {

    static void readMonthlyReport(String monthlyTable, String month) {
        System.out.println("Отчет за " + month);
        String[] bigLines = monthlyTable.split(System.lineSeparator());
        for (int i = 1; i < bigLines.length; i++) {
            String[] lines = bigLines[i].split(",");
            String isExpense;
            String itemName = lines[0];
            if (lines[1].equals("TRUE")) {
                isExpense = "Расходы - ";
            } else {
                isExpense = "Доходы - ";
            }
            String quantity = lines[2];
            String sumOne = lines[3];

            System.out.println(itemName + ": " + isExpense + quantity + " шт. по цене: " + sumOne + " рублей");
        }
    }


    static void getMonthlyReport(String monthlyTable, String month) {
        System.out.println("Самые большие расходы и доходы за " + month);
        String[] bigLines = monthlyTable.split(System.lineSeparator());
        int largePrice = 0;
        int largeExpense = 0;
        String profitName = "";
        String expenseName = "";
        for (int i = 1; i < bigLines.length; i++) {
            String[] lines = bigLines[i].split(",");
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
    }
    public static void compareMonthAndYear(String yearlyTable, String jan, String feb, String mar) {
        String[] globalReport = yearlyTable.split(System.lineSeparator());
        String[] report = jan.split(System.lineSeparator());
        ArrayList<Integer> ExpensesMonths = new ArrayList<>();
        ArrayList<Integer> IncomeMonths = new ArrayList<>();
        ArrayList<Integer> ExpensesMonthsf = new ArrayList<>();
        ArrayList<Integer> IncomeMonthsf = new ArrayList<>();
        ArrayList<Integer> ExpensesMonthsm = new ArrayList<>();
        ArrayList<Integer> IncomeMonthsm = new ArrayList<>();

        for (int i = 1; i < report.length; i++) {
            String[] lines = report[i].split(",");
            if (lines[1].equals("TRUE")) {
                int val1 = Integer.parseInt(lines[2]);
                int val2 = Integer.parseInt(lines[3]);
                int val = val1 * val2;
                ExpensesMonths.add(val);
            } else {
                int amount1 = Integer.parseInt(lines[2]);
                int amount2 = Integer.parseInt(lines[3]);
                int amount = amount1 * amount2;
                IncomeMonths.add(amount);
            }
        }

        int janExpTot = 0;
        for (int j = 0; j < ExpensesMonths.size(); j++) {
            janExpTot += ExpensesMonths.get(j);
        }
        int janIncTot = 0;
        for (int j = 0; j < IncomeMonths.size(); j++) {
            janIncTot += IncomeMonths.get(j);
        }

        String[] report1 = feb.split(System.lineSeparator());
        for (int i = 1; i < report1.length; i++) {
            String[] lines = report1[i].split(",");
            if (lines[1].equals("TRUE")) {
                int val1 = Integer.parseInt(lines[2]);
                int val2 = Integer.parseInt(lines[3]);
                int val = val1 * val2;
                ExpensesMonthsf.add(val);

            } else {
                int amount1 = Integer.parseInt(lines[2]);
                int amount2 = Integer.parseInt(lines[3]);
                int amount = amount1 * amount2;
                IncomeMonthsf.add(amount);
            }
        }

        int febExpTot = 0;
        for (int j = 0; j < ExpensesMonthsf.size(); j++) {
            febExpTot += ExpensesMonthsf.get(j);
        }
        int febIncTot = 0;
        for (int j = 0; j < IncomeMonthsf.size(); j++) {
            febIncTot += IncomeMonthsf.get(j);
        }

        String[] report2 = mar.split(System.lineSeparator());
        for (int i = 1; i < report2.length; i++) {
            String[] lines = report2[i].split(",");
            if (lines[1].equals("TRUE")) {
                int val1 = Integer.parseInt(lines[2]);
                int val2 = Integer.parseInt(lines[3]);
                int val = val1 * val2;
                ExpensesMonthsm.add(val);

            } else {
                int amount1 = Integer.parseInt(lines[2]);
                int amount2 = Integer.parseInt(lines[3]);
                int amount = amount1 * amount2;
                IncomeMonthsm.add(amount);
            }
        }

        int marExpTot = 0;
        for (int j = 0; j < ExpensesMonthsm.size(); j++) {
            marExpTot += ExpensesMonthsm.get(j);
        }
        int marIncTot = 0;
        for (int j = 0; j < IncomeMonthsm.size(); j++) {
            marIncTot += IncomeMonthsm.get(j);
        }

        ArrayList<Integer> listExpenseyear = YearlyReport.getlistExpense(globalReport);
        ArrayList<Integer> listIncome = YearlyReport.getlistIncome(globalReport);

        if (janExpTot != listExpenseyear.get(0)) {
            System.out.println("Расходы в январе не совпадают.");
        } if (febExpTot != listExpenseyear.get(1)) {
            System.out.println("Расходы в феврале не совпадают.");
        } if (marExpTot != listExpenseyear.get(2)) {
            System.out.println("Расходы в марте не совпадают.");
        } if (janIncTot != listIncome.get(0)) {
            System.out.println("Доходы в январе не совпадают.");
        } if (febIncTot != listIncome.get(1)) {
            System.out.println("Доходы в феврале не совпадают.");
        } if (marIncTot != listIncome.get(2)) {
            System.out.println("Доходы в марте не совпадают.");
        } System.out.println("Операция успешно завершена.");

    }
}
