package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;

import java.util.ArrayList;
import java.util.TreeMap;

public interface VendingMachineDao {
    Product addProduct(int productId, Product product) throws VendingMachinePersistenceException ;
    ArrayList<Product> getAllProducts() throws VendingMachinePersistenceException ;
    ArrayList<Integer> getAllProductIds() throws VendingMachinePersistenceException ;

    Product getProduct(int productId) throws VendingMachinePersistenceException ;
    Product updateProduct(int productId, Product product) throws VendingMachinePersistenceException ;
    Product removeProduct(int productId) throws VendingMachinePersistenceException ;
    TreeMap<Integer, Product> loadProductsFromFile() throws VendingMachinePersistenceException ;
    void writeProductsToFile() throws VendingMachinePersistenceException ;
    void decreaseStockItem(Product product) throws VendingMachinePersistenceException ;

}
