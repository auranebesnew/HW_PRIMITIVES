public class TaxCalculatorService {
    static final private int earningsOnlyPercent = 6;
    static final private int earningMinusSpendingsPercent = 15;

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * earningMinusSpendingsPercent / 100;
        int res = Math.max(tax, 0);

        return res;
    }

    public static int taxEarningsOnly(int earnings) {
        int tax = earnings * earningsOnlyPercent / 100;
        int res = Math.max(tax, 0);

        return res;
    }

    public static boolean isEqualTaxes(int earnings, int spendings) {
        return taxEarningsMinusSpendings(earnings,spendings) == taxEarningsOnly(earnings);
    }
}
