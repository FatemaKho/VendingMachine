package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VendingMachineDaoImpl implements VendingMachineDao {

    private ArrayList<Product> products;

    @Override
    public Product addProduct(String productId, Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public List<String> getAllProductIds() {
        return null;
    }

    @Override
    public Product getProduct(String productId) {
        return null;
    }

    @Override
    public Product updateProduct(String productID, Product product) {
        return null;
    }

    @Override
    public Product removeProduct(String productId) {
        return null;
    }

    @Override
    public Map<String, Product> loadProductsFromFile() throws VendingMachinePersistenceException {
        return null;
    }

    @Override
    public void writeProductsToFile() throws VendingMachinePersistenceException {

    }
}
