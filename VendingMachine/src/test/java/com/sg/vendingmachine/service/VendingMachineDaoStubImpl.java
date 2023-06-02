package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VendingMachineDaoStubImpl implements VendingMachineDao {
    private TreeMap<Integer, Product> products= new TreeMap<>();
    private Product testOne, testTwo;

    public VendingMachineDaoStubImpl(){
        testOne = new Product("1", "Cake", BigDecimal.valueOf(2.50), 5);
        testTwo = new Product("2", "Brownie", BigDecimal.valueOf(3.50), 5);
    }
    @Override
    public Product addProduct(int productId, Product product) throws VendingMachinePersistenceException {
        Product newProduct = products.put(productId, product);
        return newProduct;
    }

    @Override
    public ArrayList<Product> getAllProducts() throws VendingMachinePersistenceException {
        return new ArrayList<Product>(products.values());
    }

    @Override
    public ArrayList<Integer> getAllProductIds() throws VendingMachinePersistenceException {
        return products.keySet().stream()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Product getProduct(int productId) throws VendingMachinePersistenceException {
        return products.get(productId);
    }

    @Override
    public Product updateProduct(int productId, Product product) throws VendingMachinePersistenceException {
        Product updatedProduct = products.replace(productId, product);
        return updatedProduct;
    }

    @Override
    public Product removeProduct(int productId) throws VendingMachinePersistenceException {
        Product removedProduct= products.remove(productId);
        return removedProduct;
    }

    @Override
    public TreeMap<Integer, Product> loadProductsFromFile() throws VendingMachinePersistenceException {
        products.put(1, testOne);
        products.put(2, testOne);
        return products;
    }

    @Override
    public void writeProductsToFile() throws VendingMachinePersistenceException {

    }

    @Override
    public void decreaseStockItem(Product product) throws VendingMachinePersistenceException {
        int numItems = product.getItemsInStock();
        numItems--;
        product.setItemsInStock(numItems);
    }
}
