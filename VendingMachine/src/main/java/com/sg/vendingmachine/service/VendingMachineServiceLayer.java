package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

public interface VendingMachineServiceLayer {
    Change remainingChange(BigDecimal amount, Product product);
    void addProduct(int productId, Product product) throws VendingMachineDataValidationException, VendingMachineDuplicateIdException;
    ArrayList<Product> getAllProducts();
    ArrayList<Integer> getAllProductIds();

    Product getProduct(int productId) throws VendingMachineNoKeyException;
    Product updateProduct(int productId, Product product) throws VendingMachineDataValidationException;
    Product removeProduct(int productId) throws VendingMachineNoKeyException;

}
