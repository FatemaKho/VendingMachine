package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class VendingMachineDaoImpl implements VendingMachineDao {

    private Map<String, Product> products= new HashMap<>();

    @Override
    public Product addProduct(String productName, Product product) {
        Product newProduct = products.put(productName, product);
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return new ArrayList<Product>(products.values());
    }

    @Override
    public ArrayList<String> getAllProductNames()  {
        ArrayList<String> keyList = new ArrayList<>();
        keyList.addAll(products.keySet());

        return keyList;
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
