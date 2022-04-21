import java.util.ArrayList;
import java.util.Arrays;

public class MonthlyReport {

    static void readMonthlyReport(String[] monthlyTable, String month) {
        System.out.println("Отчет за " + month);

        for (int i = 1; i < monthlyTable.length; i++) {
            String[] lines = monthlyTable[i].split(",");
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


    static void getMonthlyReport(String[] monthlyTable, String month) {
        System.out.println("Самые большие расходы и доходы за " + month);

        int largePrice = 0;
        int largeExpense = 0;
        String profitName = "";
        String expenseName = "";
        for (int i = 1; i < monthlyTable.length; i++) {
            String[] lines = monthlyTable[i].split(",");
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

    public static void compareMonthAndYear(String[] yearlyTable, String[] jan, String[] feb, String[] mar) {


        ArrayList<Integer> ExpensesMonths = new ArrayList<>();
        ArrayList<Integer> IncomeMonths = new ArrayList<>();
        ArrayList<Integer> ExpensesMonthsf = new ArrayList<>();
        ArrayList<Integer> IncomeMonthsf = new ArrayList<>();
        ArrayList<Integer> ExpensesMonthsm = new ArrayList<>();
        ArrayList<Integer> IncomeMonthsm = new ArrayList<>();

        for (int i = 1; i < jan.length; i++) {
            String[] lines = jan[i].split(",");
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


        for (int i = 1; i < feb.length; i++) {
            String[] lines = feb[i].split(",");
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


        for (int i = 1; i < mar.length; i++) {
            String[] lines = mar[i].split(",");
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

        ArrayList<Integer> listExpenseyear = YearlyReport.getlistExpense(yearlyTable);
        ArrayList<Integer> listIncome = YearlyReport.getlistIncome(yearlyTable);

        if (janExpTot != listExpenseyear.get(0)) {
            System.out.println("Расходы в январе не совпадают.");
        }
        if (febExpTot != listExpenseyear.get(1)) {
            System.out.println("Расходы в феврале не совпадают.");
        }
        if (marExpTot != listExpenseyear.get(2)) {
            System.out.println("Расходы в марте не совпадают.");
        }
        if (janIncTot != listIncome.get(0)) {
            System.out.println("Доходы в январе не совпадают.");
        }
        if (febIncTot != listIncome.get(1)) {
            System.out.println("Доходы в феврале не совпадают.");
        }
        if (marIncTot != listIncome.get(2)) {
            System.out.println("Доходы в марте не совпадают.");
        }
        System.out.println("Операция успешно завершена.");

    }
}
