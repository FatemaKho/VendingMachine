package com.sg.vendingmachine;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoImpl;
import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.List;

public class VendingMachineDaoImplTest {
    VendingMachineDao testDao;

public VendingMachineDaoImplTest() {

}
    @org.junit.jupiter.api.BeforeEach
    public void setUp () throws Exception {
        String testFile = "testproducts.txt";
        //blank file
        new FileWriter(testFile);
        testDao = new VendingMachineDaoImpl(testFile);
    }

    @Test
    public void testRemoveProduct () throws VendingMachinePersistenceException {
        System.out.println("Remove product");
        BigDecimal bd = new BigDecimal("5.00");
        Product prod1 = new Product("1", "Chips", new BigDecimal("5.00"), 10);
        Product prod2 = new Product("2", "Lays", new BigDecimal("2.50"), 10);
        testDao.addProduct(Integer.parseInt(prod1.getProductId()), prod1);
        testDao.addProduct(Integer.parseInt(prod2.getProductId()), prod2);
        //test removed product
        Product removedProduct = testDao.removeProduct(Integer.parseInt(prod1.getProductId()));
        assertEquals(removedProduct, prod1, "The product is removed");
        //result
        List<Product> result = testDao.getAllProducts();
        //test result
        assertNotNull(result, "The List of Products are not null");
        assertEquals(1, result.size(), "List of products return 1");
        //test removed product 2
        removedProduct=testDao.removeProduct(Integer.parseInt(prod2.getProductId()));
        assertEquals(removedProduct, prod2, "The product 2 was removed.");


    }
public void testAddGetAllProductIds(){

}

}