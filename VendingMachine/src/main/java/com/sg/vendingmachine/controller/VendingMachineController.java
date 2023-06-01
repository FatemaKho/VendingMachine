package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineDuplicateIdException;
import com.sg.vendingmachine.service.VendingMachineNoKeyException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class VendingMachineController {
    private VendingMachineView view;
    private UserIO io = new UserIOConsoleImpl();
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer service) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        addProducts();
        int cont = 0;
        while (cont == 0) {
            cont = view.displayProducts(service.getAllProductIds(), service.getAllProducts());
            if (cont == 1) break;
            BigDecimal money = view.promptDepositAmount();
            int selection = view.promptProductSelection();
            Product product = getProductFromId(selection);
            getChange(money, product);
        }
    }

    private Product getProductFromId(int id)  {
        try {
            Product product = service.getProduct(id);
            return product;
        } catch (VendingMachineNoKeyException e) {
            e.getMessage();
            return null;
        }
    }

    private void decreaseStockItem(Product product) {
        try {
            if (product.getItemsInStock() == 0) {
                view.displayNoProductInventoryMessage();
            } else {
                service.decreaseStockItem(product);
            }
        } catch (VendingMachineDataValidationException e) {
            e.getMessage();
        }
    }

    private void getChange(BigDecimal money, Product product) {
        Change change = service.remainingChange(money, product);
        if (change == null) {
            view.displayInsufficientFundsMessage();
        } else {
            decreaseStockItem(product);
            view.displayDepositedAmount(money);
            view.displayItem(product);
            if (product.getItemsInStock() != 0) {
                view.displayChangeReturned(change);
            } else {
                view.displayChangeReturned(new Change(money));
            }
        }
    }

    private void addProducts() {
        try {
            service.addProduct(1, new Product("1", "Chips", new BigDecimal("5.00"), 10));
            service.addProduct(2, new Product("2", "Lays", new BigDecimal("2.50"), 10));
            service.addProduct(3, new Product("3", "Apple", new BigDecimal("4.00"), 1));
        } catch (VendingMachineDataValidationException | VendingMachineDuplicateIdException e) {
            e.getMessage();
        }
    }


}