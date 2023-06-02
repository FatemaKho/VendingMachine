package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;


import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class VendingMachineDaoImpl implements VendingMachineDao {

    public final String PRODUCTS_FILE;
    public static final String DELIMITER = "::";
    private TreeMap<Integer, Product> products= new TreeMap<>();

    public VendingMachineDaoImpl() {
        PRODUCTS_FILE = "products.txt";
    }

    public VendingMachineDaoImpl (String productsTextFile) {
        PRODUCTS_FILE = productsTextFile;
    }
    @Override
    public Product addProduct(int productId, Product product) throws VendingMachinePersistenceException {
        loadProductsFromFile();
        Product newProduct = products.put(productId, product);
        writeProductsToFile();
        return newProduct;
    }

    @Override
    public ArrayList<Product> getAllProducts() throws VendingMachinePersistenceException  {
        loadProductsFromFile();
        return new ArrayList<Product>(products.values());
    }

    @Override
    public ArrayList<Integer> getAllProductIds() throws VendingMachinePersistenceException  {
        loadProductsFromFile();
        return products.keySet().stream()
                .collect(Collectors.toCollection(ArrayList::new));
    }
    @Override
    public Product getProduct(int productId) throws VendingMachinePersistenceException  {
        loadProductsFromFile();
        return products.get(productId);
    }

    @Override
    public Product updateProduct(int productId, Product product) throws VendingMachinePersistenceException  {
        loadProductsFromFile();
        Product updatedProduct = products.replace(productId, product);
        writeProductsToFile();
        return updatedProduct;
    }

    @Override
    public Product removeProduct(int productId) throws VendingMachinePersistenceException {
        loadProductsFromFile();
        Product removedProduct= products.remove(productId);
        writeProductsToFile();
        return removedProduct;
    }

    @Override
    public TreeMap<Integer, Product> loadProductsFromFile() throws VendingMachinePersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(PRODUCTS_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;
        Product currentProduct;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentProduct = new Product(currentLine);
            products.put(Integer.parseInt(currentProduct.getProductId()), currentProduct);
        }
        scanner.close();
        return products;
        }

        public void decreaseStockItem (Product product) throws VendingMachinePersistenceException {
            loadProductsFromFile();
            int numItems = product.getItemsInStock();
            numItems--;
            product.setItemsInStock(numItems);
            writeProductsToFile();
        }

        @Override
        public void writeProductsToFile () throws VendingMachinePersistenceException {
            PrintWriter out;
            try {
                out = new PrintWriter(new FileWriter(PRODUCTS_FILE));
            } catch (IOException ex) {
                throw new VendingMachinePersistenceException(
                        "Could not save product data", ex);
            }
            String productAsText;
            List<Product> productList = this.getAllProducts();
            for (Product currentProduct : productList) {
                productAsText = currentProduct.marshallProductAsText();
                out.println(productAsText);
                out.flush();
            }
            out.close();
        }
    }
