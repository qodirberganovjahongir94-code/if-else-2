public class IfElseAdvanced {

    static String getShippingMethod(double weight, double distance, boolean express) {
        if (weight > 30)           return "Freight shipping required";
        if (express && weight < 5) return "Express air delivery (2-3 days)";
        if (distance > 1000)       return "International shipping (7-14 days)";
        if (weight < 1)            return "Standard mail (3-5 days)";
        return "Standard ground shipping (5-7 days)";
    }

    static double calculateTax(double income) {
        if      (income <= 10_000)  return income * 0.0;
        else if (income <= 40_000)  return income * 0.12;
        else if (income <= 85_000)  return income * 0.22;
        else if (income <= 163_000) return income * 0.24;
        else                        return income * 0.32;
    }

    static String classify(int n) {
        if (n < 0)         return "Negative";
        if (n == 0)        return "Zero";
        if (n % 2 == 0)    return "Positive Even";
        if (isPrime(n))    return "Prime";
        return "Positive Odd (composite)";
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== Shipping Method Selector ===");
        System.out.println(getShippingMethod(0.5, 200, false));
        System.out.println(getShippingMethod(2.0, 500, true));
        System.out.println(getShippingMethod(35, 100, false));
        System.out.println(getShippingMethod(5.0, 1500, false));

        System.out.println("\n=== Tax Calculator ===");
        double[] incomes = {8_000, 25_000, 60_000, 120_000, 200_000};
        for (double income : incomes)
            System.out.printf("Income: $%,8.0f → Tax: $%,.0f (%.0f%%)%n",
                income, calculateTax(income), calculateTax(income)/income*100);

        System.out.println("\n=== Number Classifier ===");
        int[] nums = {-5, 0, 2, 7, 9, 12, 13, 100};
        for (int n : nums)
            System.out.printf("%4d → %s%n", n, classify(n));
    }
}
