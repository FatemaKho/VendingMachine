package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineNoKeyException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class VendingMachineView {
    private Scanner scanner;
    private UserIO io;
    
    public VendingMachineView() {
        scanner = new Scanner(System.in);
    }
    
    public void displayProducts(List<Integer> ids, List<Product> products)  {
        io.print("Vending Machine Products:");
        for (int i = 0; i < ids.size(); i++) {
            io.print(ids.get(i)
                    + products.get(i).getProductName()
                    +  " - $" + products.get(i).getPrice()
                    + " (Inventory: " + products.get(i).getItemsInStock() + ")");
        }
    }
    
    public void displayDepositedAmount(BigDecimal depositedAmount) {
        io.print("Deposited amount: $" + depositedAmount);
    }
    
    public void displayInsufficientFundsMessage() {
        io.print("Insufficient funds. Please deposit more money.");
    }
    
    public void displayNoProductInventoryMessage() {
        io.print("Selected product is out of stock. Please choose another product.");
    }
    
    public void displayChangeReturned(Change change) {
        io.print("Change returned: ");
        io.print("Quarters: " + change.getQuarters());
        io.print("Dimes: " + change.getDimes());
        io.print("Nickels: " + change.getNickels());
        io.print("Pennies: " + change.getPennies());
    }
    
    public int promptProductSelection() {
        return io.readInt("Please select a product");
    }
    
    public BigDecimal promptDepositAmount() {
        BigDecimal amount = io.readBigDecimal("Enter the deposit amount: $");
        return amount;
    }
}
