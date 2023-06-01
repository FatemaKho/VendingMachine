package com.sg.vendingmachine.dto;

import java.math.BigDecimal;


//initialize amounts
public class Change {
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;
    public Change(BigDecimal amount) {
        this.quarters=amount.divide(new BigDecimal ("25")).intValue();
        BigDecimal remainder = new BigDecimal("100").multiply(new BigDecimal(this.quarters));
        amount.subtract(remainder);
        this.dimes = amount.divide(new BigDecimal("10")).intValue();
        remainder = new BigDecimal("10").multiply(new BigDecimal(this.dimes));
        amount.subtract(remainder);
        this.nickels = amount.divide(new BigDecimal("05")).intValue();
        remainder = new BigDecimal("05").multiply(new BigDecimal(this.nickels));
        amount.subtract(remainder);
        this.pennies = amount.divide(new BigDecimal("01")).intValue();
        remainder = new BigDecimal("01").multiply(new BigDecimal(this.pennies));
        amount.subtract(remainder);

//
//        this.quarters=amount.divide(new BigDecimal ("25")).intValue();
//        amount=amount.remainder(new BigDecimal("25"));
//        this.dimes=amount.divide(new BigDecimal("10")).intValue();
//        amount=amount.remainder(new BigDecimal("10"));
//        this.nickels = amount.divide(new BigDecimal("5")).intValue();
//        this.pennies=amount.remainder(new BigDecimal("5")).intValue();

    }
    //don't need setter, its in constructor its initialized

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }
}

