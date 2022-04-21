import java.util.ArrayList;

public class YearlyReport {


    static void infoYear(String yearlyTable) {
        System.out.println("Информация по 2021 году");

        String[] globalReport = yearlyTable.split(System.lineSeparator());// линия

        String[] reports1 = globalReport[1].split(",");
        int expense1 = getBalance(reports1);
        System.out.println("Доход/расход за январь: " + expense1);
        String[] reports2 = globalReport[2].split(",");
        int expense2 = getBalance(reports2);
        int balance1 = expense1 + expense2;
        System.out.println("Доход/расход за январь: " + expense2 + "\n" + "Прибыль января: " + balance1 + " рублей");


        String[] reports3 = globalReport[3].split(",");
        int expense3 = getBalance(reports3);
        System.out.println("Доход/расход за февраль: " + expense3);
        String[] reports4 = globalReport[4].split(",");
        int expense4 = getBalance(reports4);
        int balance2 = expense3 + expense4;
        System.out.println("Доход/расход за февраль: " + expense4 + "\n" + "Прибыль февраля: " + balance2 + " рублей");

        String[] reports5 = globalReport[5].split(",");
        int expense5 = getBalance(reports5);
        System.out.println("Доход/расход за март: " + expense5);
        String[] reports6 = globalReport[6].split(",");
        int expense6 = getBalance(reports6);
        int balance3 = expense5 + expense6;
        System.out.println("Доход/расход за март: " + expense6 + "\n" + "Прибыль марта: " + balance3 + " рублей");

        ArrayList<Integer> ExpensesYear = getlistExpense(globalReport);
        ArrayList<Integer> IncomeYear = getlistIncome(globalReport);

        int middleExpense = (ExpensesYear.get(0) +  ExpensesYear.get(1) + ExpensesYear.get(2)) / 3;
        int middleIncome = (IncomeYear.get(0) + IncomeYear.get(1) + IncomeYear.get(2)) / 3;
        System.out.println("Средний доход за 2021 год: " + middleIncome + " рублей");
        System.out.println("Средний расход за 2021 год: " + middleExpense + " рублей");

    }

    public static int getBalance(String[] report) {
        int income;
        if (report[2].equals("true")) {
            income = -Integer.parseInt(report[1]);
        } else {
            income = Integer.parseInt(report[1]);
        }
        return income;
    }

    public static ArrayList<Integer> getlistExpense(String[] globalReport) {
        ArrayList<Integer> listExpense = new ArrayList<>();
        for (int i = 1; i < globalReport.length; i ++) {
            String[] report = globalReport[i].split(",");
            if (report[2].equals("true")) {
                listExpense.add(Integer.parseInt(report[1]));
            }
        }
        return listExpense;
    }

    public static ArrayList<Integer> getlistIncome(String[] globalReport) {
        ArrayList<Integer> listIncome = new ArrayList<>();
        for (int i = 1; i < globalReport.length; i ++) {
            String[] report = globalReport[i].split(",");
            if (report[2].equals("false")) {
                listIncome.add(Integer.parseInt(report[1]));
            }
        }
        return listIncome;
    }

    public static void readYearlyReport(String yearlyTable) {
        System.out.println("Информация по 2021 году");
        String[] globalReport = yearlyTable.split(System.lineSeparator());
        for (int i = 1; i < globalReport.length; i++) {
            String[] report = globalReport[i].split(",");
            String isExpense;
            String itemName = report[0];
            if (report[2].equals("true")) {
                isExpense = "Расходы - ";
            } else {
                isExpense = "Доходы - ";
            }
            String value = report[1];


            System.out.println(itemName + ": " + isExpense + value);
        }
    }
}

