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
        io = new UserIOConsoleImpl();
    }
    
    public int displayProducts(List<Integer> ids, List<Product> products)  {
        io.print("Vending Machine Products:");
        for (int i = 0; i < ids.size(); i++) {
            io.print("#" + ids.get(i)
                    + " "
                    + products.get(i).getProductName()
                    +  " - $" + products.get(i).getPrice()
                    + " (Inventory: " + products.get(i).getItemsInStock() + ")");
        }
        return io.readInt("0: Continue \n1: Exit");
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
       String num = io.readString("Enter the deposit amount: $");
       return io.readBigDecimal(num);
    }
 
    public void displayItem(Product product) {
        io.print("Product Details:");
        io.print("Name: " + product.getProductName());
        io.print("Price: $" + product.getPrice());
        io.print("Inventory: " + product.getItemsInStock());
    }
}