import java.util.ArrayList;

public class YearlyReport {

    String[] year;

    public YearlyReport() {

        this.year = year;
    }

    public void infoYear(String[] year) {
        if (year != null) {
            System.out.println("Информация по 2021 году");
            int diffExp = 0;   //средний расход
            int diffInc = 0;   // средний доход
            int profit;  // прибыль
            int exp = 0;
            int inc = 0;
            if (year != null) {
                for (int i = 1; i < 3; i++) {
                    String[] report = year[i].split(",");
                    if (report[2].equals("true")) {
                        exp = Integer.parseInt(report[1]);
                    } else {
                        inc = Integer.parseInt(report[1]);
                    }
                }
                profit = inc - exp;
                System.out.println("Прибыль за январь месяц составила: " + profit + " рублей");
            }
            diffExp += exp;
            diffInc += inc;
            for (int i = 3; i < 5; i++) {
                String[] report = year[i].split(",");
                if (report[2].equals("true")) {
                    exp = Integer.parseInt(report[1]);
                } else {
                    inc = Integer.parseInt(report[1]);
                }
            }
            profit = inc - exp;
            System.out.println("Прибыль за февраль месяц составила: " + profit + " рублей");
            diffExp += exp;
            diffInc += inc;
            for (int i = 5; i < 7; i++) {
                String[] report = year[i].split(",");
                if (report[2].equals("true")) {
                    exp = Integer.parseInt(report[1]);

                } else {
                    inc = Integer.parseInt(report[1]);
                }
            }
            profit = inc - exp;
            System.out.println("Прибыль за март месяц составила: " + profit + " рублей");
            diffExp += exp;
            diffInc += inc;
            diffExp /= 3;
            diffInc /= 3;
            System.out.println("Средний расход за все месяцы в году: " + diffExp + " рублей");
            System.out.println("Средний доход за все месяцы в году: " + diffInc + " рублей");
        } else {
            System.out.println("Считайте годовой отчет");
        }
    }

    public static void compareMonthAndYear(String[] year, String[] jan, String[] feb, String[] mar) {

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

        ArrayList<Integer> listExpenseyear = getlistExpense(year);
        ArrayList<Integer> listIncome = getlistIncome(year);

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

    public static ArrayList<Integer> getlistExpense(String[] globalReport) {
        ArrayList<Integer> listExpense = new ArrayList<>();
        for (int i = 1; i < globalReport.length; i++) {
            String[] report = globalReport[i].split(",");
            if (report[2].equals("true")) {
                listExpense.add(Integer.parseInt(report[1]));
            }
        }
        return listExpense;
    }

    public static ArrayList<Integer> getlistIncome(String[] globalReport) {
        ArrayList<Integer> listIncome = new ArrayList<>();
        for (int i = 1; i < globalReport.length; i++) {
            String[] report = globalReport[i].split(",");
            if (report[2].equals("false")) {
                listIncome.add(Integer.parseInt(report[1]));
            }
        }
        return listIncome;
    }
}