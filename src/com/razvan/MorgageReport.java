package com.razvan;

import java.text.NumberFormat;

public class MorgageReport {

    private final MortgageCalculator calculator;

    public MorgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printMortgage (int principal, float anualInterest) {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatter = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mountly payments" + mortgageFormatter);
    }

    public void printPaymentSchedule () {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");


       for (double balance : calculator.getRemainingBalances())
           System.out.println(NumberFormat.getCurrencyInstance().format(balance));
    }

}
