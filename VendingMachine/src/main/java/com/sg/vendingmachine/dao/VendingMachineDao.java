package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;

import java.util.ArrayList;
import java.util.TreeMap;

public interface VendingMachineDao {
    Product addProduct(int productId, Product product);
    ArrayList<Product> getAllProducts();
    ArrayList<Integer> getAllProductIds();

    Product getProduct(int productId);
    Product updateProduct(int productId, Product product);
    Product removeProduct(int productId);
    TreeMap<Integer, Product> loadProductsFromFile() throws VendingMachinePersistenceException;
    void writeProductsToFile() throws VendingMachinePersistenceException;
    void decreaseStockItem(Product product);

}
