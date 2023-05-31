package main.java.com.sg.vendingmachine.dto;

import java.math.BigDecimal;


//initialize amounts
public class Change {
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;
    public Change(BigDecimal amount) {
this.quarters=amount.divide(new BigDecimal ("25")).intValue();
amount=amount.remainder(new BigDecimal("25"));
this.nickels=amount.divide(new BigDecimal(5)).intValue();
amount=amount.remainder((new BigDecimal("10")));
this.nickels = amount.divide(new BigDecimal("5")).intValue();
this.pennies=amount.remainder(new BigDecimal("5")).intValue();

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

