package com.sg.vendingmachine.ui;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class VendingMachineView {
    private UserIO io = new UserIOConsoleImpl();

    private Map<String, Double> products = new HashMap<>();
    List<String> productNames = new ArrayList<>();

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    public Map getAndSeedProducts() {
        products.put("cake", 2.50);
        products.put("water", 1.05);
        products.put("coke", 2.05);
        products.put("pepsi", 1.95);
        products.put("sprite", 1.85);
        products.put("perrier", 4.50);

        return products;
    }

    public List<String> printMenuAndGetProductNames(){
        io.print("\nWELCOME TO THE BEST VENDING MACHINE\n");
        System.out.println(String.format("%-5s %-13s %-10s ", "No", "Product", "Price($)"));
        System.out.println(String.format("%s", "---------------------------"));
        int number = 1;
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue();
            productNames.add(key);

            System.out.printf("%-5s %-13s %7.2f%n", number, key, value);

            number++;
        }

        return productNames;
    }

    public BigDecimal getMoney(){
        String moneyInput = io.readString("\nPlease put in money:");
        BigDecimal money = new BigDecimal(moneyInput).setScale(2, RoundingMode.HALF_UP);
        return money;
    }

    public int getProductSelection() {
        int productSelection = io.readInt("Please choose the product you want to buy (Enter a No)", 1, 7);
        return productSelection;
    }

    public boolean printCasesAndCheckFunds(int index, BigDecimal money){
        io.print("You have chosen "+productNames.get(index)+".");
        System.out.printf("You have deposited $%.2f.",money);
        BigDecimal productPrice = new BigDecimal(products.get(productNames.get(index)));
        int comparisonResult = productPrice.compareTo(money);

        if (comparisonResult > 0) {
            io.print("\nInsufficient funds.");
            return false;
        } else {
            io.print("\nSufficient funds.");
        }
        return true;
    }
}
