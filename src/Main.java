import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int earnings = 0;
        int spendings = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            int operation = Integer.parseInt(input);

            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String earningsStr = scanner.nextLine();
                    int earningsInt = Integer.parseInt(earningsStr);
                    earnings += earningsInt;
                    break;

                case 2:
                    System.out.println("Введите сумму расхода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    spendings += money;
                    break;

                case 3:
                    if (TaxCalculatorService.isEqualTaxes(earnings, spendings)) {
                        System.out.println("Можете выбрать любую систему налогообложения");
                        break;
                    }

                    int earningsOnly = TaxCalculatorService.taxEarningsOnly(earnings);
                    int earningsMinusSpendings = TaxCalculatorService.taxEarningsMinusSpendings(
                            earnings,
                            spendings
                    );

                    String result = (earningsOnly < earningsMinusSpendings) ? "УСН доходы" : "УСН доходы минус расходы";
                    int resultTax = Math.min(earningsOnly, earningsMinusSpendings);
                    int anotherTax = Math.max(earningsOnly, earningsMinusSpendings);

                    System.out.println("Мы советуем вам " + result);
                    System.out.println("Ваш налог составит: " + resultTax);
                    System.out.println("Налог на другой системе: " + anotherTax);
                    System.out.println("Экономия: " + (anotherTax - resultTax));
                    break;

                default:
                    System.out.println("Такой операции нет");
            }
        }

        System.out.println("Программа завершена");
    }
}