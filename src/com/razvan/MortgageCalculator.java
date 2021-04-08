package com.razvan;

public class MortgageCalculator {

    private static final byte MOUNTS_IN_YEAR = 12;
    private static final byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance (short numberOfPaymentsMode) {
        float mountlyInterest = getMountlyInterest();
        float numbersOfPayments = getNumbersOfPayment();


        double balance = principal
                * (Math.pow(1 + mountlyInterest, numbersOfPayments))
                / (Math.pow(1 + mountlyInterest, numbersOfPayments));
        return balance;
    }


    public double calculateMortgage () {
        float mountlyInterest = getMountlyInterest();
        float numbersOfPayments = getNumbersOfPayment();


        double mortgage = principal
                * (mountlyInterest * Math.pow(1 + mountlyInterest, numbersOfPayments))
                / (Math.pow(1 + mountlyInterest, numbersOfPayments));
        return mortgage;
    }

    public double[] getRemainingBalances () {
        double[] balances = new double[getNumbersOfPayment()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }

    private int getNumbersOfPayment() {
        return years * MOUNTS_IN_YEAR;
    }

    private float getMountlyInterest() {
        return annualInterest / PERCENT / MOUNTS_IN_YEAR;
    }


}
