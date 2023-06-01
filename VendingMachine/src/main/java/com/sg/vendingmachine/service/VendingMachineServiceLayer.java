package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface VendingMachineServiceLayer {
    Change remainingChange(BigDecimal amount, Product product);
    Product addProduct(String productName, Product product);
    ArrayList<Product> getAllProducts();
    ArrayList<String> getAllProductNames();

    Product getProduct(String productName);
    Product updateProduct(String productName, Product product);
    Product removeProduct(String productName);
}
