package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoImpl;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{
    private VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public Map<String, Product> loadProductsInStock() throws VendingMachinePersistenceException {
        Map<String, Product> productsInStock = new HashMap<>();
            for (Product p : dao.loadProductsFromFile().values())  {
                if(p.getItemsInStock() < 1) {
                    auditDao.writeAuditEntry("Product Name: " + p.getProductName());
                } else {
                    productsInStock.put(p.getProductName(), p);
                }
        }
    return productsInStock;
    }

    public Change remainingChange(BigDecimal amount, Product product) {
        if (amount.compareTo(product.getPrice()) < 0) {
            return null;
        } else {
            return new Change(amount.subtract(product.getPrice()));
        }
    }

    @Override
    public void addProduct(int productId, Product product) throws VendingMachineDataValidationException, VendingMachineDuplicateIdException{
        if (dao.getProduct(productId) != null) {
            throw new VendingMachineDuplicateIdException("Error: could not add product. Product with ID# " + productId + " already exists.");
        }

        validateProductData(product);
        dao.addProduct(productId, product);

    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return dao.getAllProducts();
    }

    @Override
    public ArrayList<Integer> getAllProductIds() {
        return dao.getAllProductIds();
    }

    @Override
    public Product getProduct(int productId) throws VendingMachineNoKeyException {
        Product product = dao.getProduct(productId);
        if(product == null) throw new VendingMachineNoKeyException("ID not found");
        return product;
    }

    @Override
    public Product updateProduct(int productId, Product product) throws VendingMachineDataValidationException{
        validateProductData(product);
        return dao.updateProduct(productId, product);
    }

    @Override
    public Product removeProduct(int productId) throws VendingMachineNoKeyException {
        Product product =  dao.removeProduct(productId);
        if (product == null) throw new VendingMachineNoKeyException("ID not found");
        return product;
    }

    @Override
    public void decreaseStockItem(Product product) throws VendingMachineDataValidationException {
        validateProductData(product);
        dao.decreaseStockItem(product);
    }

    private void validateProductData(Product product) throws VendingMachineDataValidationException{
        if (product.getPrice().compareTo(new BigDecimal("0")) <= 0
                || product.getProductName().trim().length() == 0
                || product.getProductName() == null
                || product.getItemsInStock() <= 0
                || isNumeric(product.getProductId()) == false) {
            throw new VendingMachineDataValidationException("Error: Missing information or invalid data inputs");
        }
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
