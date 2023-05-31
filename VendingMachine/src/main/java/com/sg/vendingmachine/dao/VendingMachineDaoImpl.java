package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class VendingMachineDaoImpl implements VendingMachineDao {

    private Map<String, Product> products= new HashMap<>();

    @Override
    public Product addProduct(String productName, Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<String> getAllProductNames() {
        return null;
    }

    @Override
    public Product getProduct(String productName) {
        return products.get(productName);
    }

    @Override
    public Product updateProduct(String productName, Product product) {
        return products.replace(productName, product);
    }

    @Override
    public Product removeProduct(String productName) {
        Product removedProduct= products.remove(productName);
        return removedProduct;
    }

    @Override
    public Map<String, Product> loadProductsFromFile() throws VendingMachinePersistenceException {
        return null;
    }

    @Override
    public void writeProductsToFile() throws VendingMachinePersistenceException {

    }
}
