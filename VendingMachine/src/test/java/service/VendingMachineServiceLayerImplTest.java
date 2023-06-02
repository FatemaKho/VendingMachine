package service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.*;
import service.VendingMachineAuditDaoStubImpl;
import service.VendingMachineDaoStubImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class VendingMachineServiceLayerImplTest {

    private VendingMachineServiceLayer service;

    public VendingMachineServiceLayerImplTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        VendingMachineAuditDao auditDao= new VendingMachineAuditDaoStubImpl();
        service = new VendingMachineServiceLayerImpl(dao, auditDao);
    }


    @Test
    void loadProductsInStock() throws VendingMachinePersistenceException {
        Product p1 = new Product("1", "Cake", new BigDecimal("2.5"), 5);

        Map<String, Product> result = service.loadProductsInStock();
        Map<String, Product> expResult = new TreeMap<>();
        expResult.put("Cake", p1);

        assertEquals(result, expResult);
    }

    @Test
    void remainingChange() throws VendingMachineNoKeyException, VendingMachinePersistenceException {
        Product cakeTest = new Product("1", "Cake", BigDecimal.valueOf(2.50), 5);
        Product brownieTest = new Product("2", "Brownie", BigDecimal.valueOf(3.50), 5);
        BigDecimal moneyDeposited = new BigDecimal("5.00");

        Change cakeChange = service.remainingChange(moneyDeposited, cakeTest);
        Change brownieChange = service.remainingChange(moneyDeposited, brownieTest);

        assertEquals(10, cakeChange.getQuarters(), "Change should return 10 quarters");
        assertEquals(0, cakeChange.getDimes(), "Change should return 0 dimes");
        assertEquals(0, cakeChange.getNickels(), "Change should return 0 nickels");
        assertEquals(0, cakeChange.getPennies(), "Change should return 0 pennies");

        assertEquals(6, brownieChange.getQuarters(), "Change should return 6 quarters");
        assertEquals(0, brownieChange.getDimes(), "Change should return 0 dimes");
        assertEquals(0, brownieChange.getNickels(), "Change should return 0 nickels");
        assertEquals(0, brownieChange.getPennies(), "Change should return 0 pennies");
    }

    @Test
void addProduct() throws VendingMachinePersistenceException, VendingMachineDataValidationException, VendingMachineDuplicateIdException {

    int productId = 1;
    Product product = new Product("1", "Chips", new BigDecimal("5.00"), 10);

    Product addedProduct = service.addProduct(productId, product);

    assertNotNull(addedProduct);
    assertEquals(productId, addedProduct.getProductId().intValue());
    assertEquals(product.getProductName(), addedProduct.getProductName());
    assertEquals(product.getPrice(), addedProduct.getPrice());
    assertEquals(product.getItemsInStock(), addedProduct.getItemsInStock());
}

    @Test
    void getAllProductIds() throws VendingMachinePersistenceException, VendingMachineDuplicateIdException, VendingMachineDataValidationException {
        // Arrange
        service.addProduct(1, new Product("1", "Chips", new BigDecimal("4.50"), 10));
        service.addProduct(2, new Product("2", "Apple", new BigDecimal("5.00"), 10));
        service.addProduct(3, new Product("3", "Pretzels", new BigDecimal("2.50"), 10));
        // Act
        List<Integer> productIdList = service.getAllProductIds();
        // Assert
        assertNotNull(productIdList);
        assertEquals(3, productIdList.size());
        assertTrue(productIdList.contains(1));
        assertTrue(productIdList.contains(2));
        assertTrue(productIdList.contains(3));
    }
    @Test
    void getAllProducts() throws VendingMachinePersistenceException, VendingMachineDuplicateIdException, VendingMachineDataValidationException {
        // Arrange
        Product p1 = new Product("1", "Chips", new BigDecimal("4.50"), 10);
        Product p2 = new Product("2", "Apple", new BigDecimal("5.00"), 10);
        Product p3 = new Product("3", "Pretzels", new BigDecimal("2.50"), 10);
        service.addProduct(1, p1);
        service.addProduct(2, p2);
        service.addProduct(3, p3);
        // Act
        List<Product> productList = service.getAllProducts();
        // Assert
        assertNotNull(productList);
        assertEquals(3, productList.size());
        assertTrue(productList.contains(p1));
        assertTrue(productList.contains(p2));
        assertTrue(productList.contains(p3));


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
    void updateProduct() throws VendingMachinePersistenceException, VendingMachineDataValidationException, VendingMachineDuplicateIdException, VendingMachineNoKeyException {
        Product p1 = new Product("1", "Chips", new BigDecimal("4.50"), 10);
        Product p2 = new Product("2", "Apple", new BigDecimal("5.00"), 10);
        Product p3 = new Product("3", "Pretzels", new BigDecimal("2.50"), 10);

        service.addProduct(1, p1);
        service.addProduct(2, p2);
        service.addProduct(3, p3);

        Product testP1 = service.updateProduct(1, new Product("1", "Candy", new BigDecimal("4.50"), 10));
        Product testP2 = service.updateProduct(2, new Product("2", "Apple", new BigDecimal("6.00"), 10));
        Product testP3 =  service.updateProduct(3, new Product("3", "Pretzels", new BigDecimal("2.50"), 5));

        assertTrue(service.getProduct(1).getProductName().equals(testP1.getProductName()));
        assertTrue(service.getProduct(2).getPrice().equals(new BigDecimal("6.00")));
        assertEquals(service.getProduct(3).getItemsInStock(), testP3.getItemsInStock());
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