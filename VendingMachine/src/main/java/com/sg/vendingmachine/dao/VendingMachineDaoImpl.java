package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachineDaoImpl implements VendingMachineDao {

    private TreeMap<Integer, Product> products= new TreeMap<>();

    @Override
    public Product addProduct(int productId, Product product) {
        Product newProduct = products.put(productId, product);
        return newProduct;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return new ArrayList<Product>(products.values());
    }

    @Override
    public ArrayList<Integer> getAllProductIds()  {
        ArrayList<Integer> keyList = new ArrayList<>();
        keyList.addAll(products.keySet());

        return keyList;
    }
    @Override
    public Product getProduct(int productId) {
        return products.get(productId);
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        return products.replace(productId, product);
    }

    @Override
    public Product removeProduct(int productId) {
        Product removedProduct= products.remove(productId);
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
