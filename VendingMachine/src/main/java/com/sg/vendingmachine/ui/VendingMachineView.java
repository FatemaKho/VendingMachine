package com.sg.vendingmachine.ui;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class VendingMachineView {
    private UserIO io = new UserIOConsoleImpl();

    public void displayItems(List<Product> items) {
        // Display the list of items and their prices
        // ...
    }
    public void displayDepositedAmount(BigDecimal depositedAmount) {
        // Display the currently deposited amount
        // ...
    }
    public void displayInsufficientFundsMessage() {
        // Display a message indicating insufficient funds
        // ...
    }
    public void displayNoItemInventoryMessage() {
        // Display a message indicating no inventory for the selected item
        // ...
    }
    public void displayChangeReturned(Change change) {
        // Display the change returned to the user
        // ...
    }
    public int promptItemSelection() {
        // Prompt the user to select an item and return the input
        // ...
    }
    public BigDecimal promptDepositAmount() {
        // Prompt the user to enter the deposit amount and return the input
        // ...
    }
}

//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Scanner;

//public class VendingMachineView {
    //private Scanner scanner;
    
   // public VendingMachineView() {
        //scanner = new Scanner(System.in);
    //}
    
    //public void displayItems(List<Item> items) {
       // System.out.println("Vending Machine Items:");
       // for (Item item : items) {
         //   System.out.println(item.getName() + " - $" + item.getCost() + " (Inventory: " + item.getInventoryCount() + ")");
        //}
        //System.out.println();
    //}
    
    //public void displayDepositedAmount(BigDecimal depositedAmount) {
        //System.out.println("Deposited amount: $" + depositedAmount);
        //System.out.println();
    //}
    
    //public void displayInsufficientFundsMessage() {
       // System.out.println("Insufficient funds. Please deposit more money.");
       // System.out.println();
    //}
    
    //public void displayNoItemInventoryMessage() {
       // System.out.println("Selected item is out of stock. Please choose another item.");
        //System.out.println();
    //}
    
    //public void displayChangeReturned(Change change) {
        //System.out.println("Change returned: ");
        //System.out.println("Quarters: " + change.getQuarters());
       // System.out.println("Dimes: " + change.getDimes());
        //System.out.println("Nickels: " + change.getNickels());
        //System.out.println("Pennies: " + change.getPennies());
        //System.out.println();
    //}
    
   // public String promptItemSelection() {
        //System.out.print("Enter the item name: ");
       // String itemName = scanner.nextLine();
        //System.out.println();
        //return itemName;
    //}
    
    //public BigDecimal promptDepositAmount() {
       // System.out.print("Enter the deposit amount: $");
       // BigDecimal amount = scanner.nextBigDecimal();
        //scanner.nextLine(); // Consume the newline character
        //System.out.println();
        //return amount;
    //}
//}
//