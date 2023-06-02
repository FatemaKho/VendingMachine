package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dto.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineServiceLayerImplTest {

    private VendingMachineServiceLayer service;

    public VendingMachineServiceLayerImplTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();

        service = new VendingMachineServiceLayerImpl(dao, auditDao);
    }


    @Test
    void loadProductsInStock() throws VendingMachinePersistenceException {
        Product p1 = new Product("1", "Cake", new BigDecimal("2.50"), 2);
        Product p2 = new Product("2", "Water", new BigDecimal("1.05"), 2);

        Map<String, Product> result = service.loadProductsInStock();
        Map<String, Product> expResult = new TreeMap<>();
        expResult.put("1", p1);
        expResult.put("2", p2);

        assertEquals(result, expResult);
    }

    @Test
    void remainingChange() {
    }

    @Test
    void addProduct() {
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void getAllProductIds() {
    }

    @Test
    void getProduct() throws VendingMachineNoKeyException, VendingMachinePersistenceException, VendingMachineDuplicateIdException, VendingMachineDataValidationException {
        Product p1 = new Product("1", "Chips", new BigDecimal("4.50"), 10);
        Product p2 = new Product("2", "Apple", new BigDecimal("5.00"), 10);
        Product p3 = new Product("3", "Pretzels", new BigDecimal("2.50"), 10);

        service.addProduct(1, p1);
        service.addProduct(2, p2);
        service.addProduct(3, p3);

        Product testP1 = service.getProduct(Integer.parseInt(p1.getProductId()));
        Product testP2 = service.getProduct(Integer.parseInt(p2.getProductId()));
        Product testP3 = service.getProduct(Integer.parseInt(p3.getProductId()));

        assertTrue(p1.equals(testP1));
        assertTrue(p2.equals(testP2));
        assertTrue(p3.equals(testP3));

    }

    @Test
    void updateProduct() throws VendingMachinePersistenceException, VendingMachineDataValidationException, VendingMachineDuplicateIdException {
        Product p1 = new Product("1", "Chips", new BigDecimal("4.50"), 10);
        Product p2 = new Product("2", "Apple", new BigDecimal("5.00"), 10);
        Product p3 = new Product("3", "Pretzels", new BigDecimal("2.50"), 10);

        service.addProduct(1, p1);
        service.addProduct(2, p2);
        service.addProduct(3, p3);

        service.updateProduct(1, new Product("1", "Candy", new BigDecimal("4.50"), 10));
        service.updateProduct(2, new Product("2", "Apple", new BigDecimal("6.00"), 10));
        service.updateProduct(3, new Product("3", "Pretzels", new BigDecimal("2.50"), 5));

        assertTrue(p1.getProductName().equals("Candy"));
        assertTrue(p2.getPrice().equals(new BigDecimal("6.00")));
        assertEquals(p3.getItemsInStock(), 5);
    }

    @Test
    void removeProduct() throws VendingMachineDuplicateIdException, VendingMachinePersistenceException, VendingMachineDataValidationException, VendingMachineNoKeyException {
        Product p1 = new Product("1", "Chips", new BigDecimal("4.50"), 10);
        Product p2 = new Product("2", "Apple", new BigDecimal("5.00"), 10);
        Product p3 = new Product("3", "Pretzels", new BigDecimal("2.50"), 10);

        service.addProduct(1, p1);
        service.addProduct(2, p2);
        service.addProduct(3, p3);

        service.removeProduct(1);
        assertEquals(service.getAllProducts().size(), 2);
        service.removeProduct(2);
        assertEquals(service.getAllProducts().size(), 1);
        service.removeProduct(3);
        assertEquals(service.getAllProducts().size(), 0);
    }

    @Test
    void decreaseStockItem() throws VendingMachineDuplicateIdException, VendingMachinePersistenceException, VendingMachineDataValidationException {
        Product p1 = new Product("1", "Chips", new BigDecimal("4.50"), 10);
        Product p2 = new Product("2", "Apple", new BigDecimal("5.00"), 10);
        Product p3 = new Product("3", "Pretzels", new BigDecimal("2.50"), 10);

        service.addProduct(1, p1);
        service.addProduct(2, p2);
        service.addProduct(3, p3);

        service.decreaseStockItem(p1);
        service.decreaseStockItem(p2);
        service.decreaseStockItem(p2);
        service.decreaseStockItem(p2);
        service.decreaseStockItem(p3);
        service.decreaseStockItem(p3);

        assertEquals(p1.getItemsInStock(), 9);
        assertEquals(p2.getItemsInStock(), 7);
        assertEquals(p3.getItemsInStock(), 8);
    }
}