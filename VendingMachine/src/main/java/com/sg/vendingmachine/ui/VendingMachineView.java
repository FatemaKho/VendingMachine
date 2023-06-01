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
    public String promptItemSelection() {
        // Prompt the user to select an item and return the input
        // ...
    }
    public BigDecimal promptDepositAmount() {
        // Prompt the user to enter the deposit amount and return the input
        // ...
    }
}
