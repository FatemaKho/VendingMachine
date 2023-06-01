package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

public interface VendingMachineServiceLayer {
    Map<String, Product> loadProductsInStock() throws VendingMachinePersistenceException;
    Change remainingChange(BigDecimal amount, Product product);
    void addProduct(int productId, Product product) throws VendingMachineDataValidationException, VendingMachineDuplicateIdException, VendingMachinePersistenceException;
    ArrayList<Product> getAllProducts() throws VendingMachinePersistenceException;
    ArrayList<Integer> getAllProductIds() throws VendingMachinePersistenceException;

    Product getProduct(int productId) throws VendingMachineNoKeyException, VendingMachinePersistenceException;
    Product updateProduct(int productId, Product product) throws VendingMachineDataValidationException, VendingMachinePersistenceException;
    Product removeProduct(int productId) throws VendingMachineNoKeyException, VendingMachinePersistenceException;

    void decreaseStockItem(Product product) throws VendingMachineDataValidationException, VendingMachinePersistenceException;

}
