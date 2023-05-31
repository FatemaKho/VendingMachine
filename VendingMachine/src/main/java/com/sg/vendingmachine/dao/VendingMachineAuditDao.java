package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;

import java.util.List;
import java.util.Map;

public interface VendingMachineAuditDao {
    Product addProduct(String productId, Product product);
    List<Product> getAllProducts();
    List<String> getAllProductIds();
    Product getProduct(String productId);
    Product updateProduct(String productID, Product product);
    Product removeProduct(String productId);
    Map<String, Product> loadProductsFromFile() throws VendingMachinePersistenceException;
    void writeProductsToFile() throws VendingMachinePersistenceException;

}

