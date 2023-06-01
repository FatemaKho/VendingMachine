package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
        return products.keySet().stream()
                .collect(Collectors.toCollection(ArrayList::new));
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
    public void decreaseStockItem(Product product) {
        int numItems = product.getItemsInStock();
        numItems--;
        product.setItemsInStock(numItems);
    }

    @Override
    public Map<String, Product> loadProductsFromFile() throws VendingMachinePersistenceException {
        return null;
    }

    @Override
    public void writeProductsToFile() throws VendingMachinePersistenceException {

    }
}
