package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dto.Change;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class VendingMachineView {
    private Scanner scanner;
    private UserIO io;
    
    public VendingMachineView() {
        scanner = new Scanner(System.in);
    }
    
    public void displayProducts(List<Integer> ids, VendingMachineDao dao) {
        System.out.println("Vending Machine Products:");
        for (Integer id : ids) {
            io.print(id + dao.getProduct(id).getProductName() +  " - $" + dao.getProduct(id).getPrice() + " (Inventory: " + dao.getProduct(id).getItemsInStock() + ")");
        }
        System.out.println();
    }
    
    public void displayDepositedAmount(BigDecimal depositedAmount) {
        System.out.println("Deposited amount: $" + depositedAmount);
        System.out.println();
    }
    
    public void displayInsufficientFundsMessage() {
        System.out.println("Insufficient funds. Please deposit more money.");
        System.out.println();
    }
    
    public void displayNoProductInventoryMessage() {
        System.out.println("Selected product is out of stock. Please choose another product.");
        System.out.println();
    }
    
    public void displayChangeReturned(Change change) {
        System.out.println("Change returned: ");
        System.out.println("Quarters: " + change.getQuarters());
        System.out.println("Dimes: " + change.getDimes());
        System.out.println("Nickels: " + change.getNickels());
        System.out.println("Pennies: " + change.getPennies());
        System.out.println();
    }
    
    public int promptProductSelection() { 
        int i = io.readInt("Please select a product");
        return i;
        
    }
    
    public BigDecimal promptDepositAmount() {
        System.out.print("Enter the deposit amount: $");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine(); // Consume the newline character
        System.out.println();
        return amount;
    }
}
