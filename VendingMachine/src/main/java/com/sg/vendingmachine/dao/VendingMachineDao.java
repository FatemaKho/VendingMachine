package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;

import java.util.List;
import java.util.Map;

public interface VendingMachineDao {
    Product addProduct(String productName, Product product);
    List<Product> getAllProducts();
    List<String> getAllProductNames();

    Product getProduct(String productName);
    Product updateProduct(String productName, Product product);
    Product removeProduct(String productName);
    Map<String, Product> loadProductsFromFile() throws VendingMachinePersistenceException;
    void writeProductsToFile() throws VendingMachinePersistenceException;

}
