package com.sg.vendingmachine.dao;

public interface VendingMachineDao {
  Product addProduct(String productId, Product product);
    List<Product> getAllProducts();
    List<String> getAllProductIds();
    Product getProduct(String productId);
    Product updateProduct(String productID, Product product);
    Product removeProduct(String productId);
    Map<String, Product> loadProductsFromFile() throws VendingMachinePersistenceException;
    void writeProductsToFile() throws VendingMachinePersistenceException;

}
