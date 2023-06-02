import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoImpl;
import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;


    public class VendingMachineDaoImplTest {
        VendingMachineDao testDao;

        @BeforeEach
        public void setUp() {
            String testFile = "testproducts.txt";
            testDao = new VendingMachineDaoImpl(testFile);
        }
@org.junit.Test
@Test
public void testLoadProductsFromFile () throws Exception {
    System.out.println("loadProductsFromFile");
    BigDecimal bd = new BigDecimal("2.00");
    Product p1 = new Product("1", "Chips", bd, 1);
    bd = new BigDecimal("2.50");
    Product p2 = new Product("2", "Water", bd, 1);
    // Add products to the file before loading
    testDao.addProduct(Integer.parseInt(p1.getProductId()), p1);
    testDao.addProduct(Integer.parseInt(p2.getProductId()), p2);

    // Result
    Map<Integer, Product> result = testDao.loadProductsFromFile();
    //Expected Result
    Map<Integer, Product> expectedResult = new TreeMap<>();
    expectedResult.put(1, p1);
    expectedResult.put(2, p2);
    //Assert
    assertEquals(expectedResult, result, "Test Products");
}

@org.junit.Test
@Test
public void testAddGetProduct() throws VendingMachinePersistenceException {
    System.out.println("addProduct");
    BigDecimal bd = new BigDecimal("2.00");
    Product p1 = new Product("1", "Chips", bd, 1);
    testDao.addProduct(Integer.parseInt(p1.getProductId()),p1);
    //Result
    Product result = testDao.getProduct(Integer.parseInt(p1.getProductId()));
    //ExpectedResult
    Product expectedResult = new Product("1", "Chips", bd, 1);
    assertEquals(expectedResult.getProductId(), result.getProductId());
    assertEquals(expectedResult.getProductName(), result.getProductName());
    assertEquals(expectedResult.getPrice(), result.getPrice());
    assertEquals(expectedResult.getItemsInStock(), result.getItemsInStock());
}

        @org.junit.Test
        @Test
        public void testGetAllProduct() throws VendingMachinePersistenceException {
            System.out.println("getAllProducts");
            BigDecimal bd = new BigDecimal("2.00");
            Product p1 = new Product("1", "Chips", bd, 1);
            bd = new BigDecimal("2.50");
            Product p2 = new Product("2", "Water", bd, 1);
            testDao.addProduct(Integer.parseInt(p1.getProductId()), p1);
            testDao.addProduct(Integer.parseInt(p2.getProductId()), p2);

            // Result
            List<Product> result = testDao.getAllProducts();

            // Expected Result
            List<Product> expectedResult = new ArrayList<>();
            expectedResult.add(p1);
            expectedResult.add(p2);

            // Assert
            assertNotNull(result, "The list of products must not be null");
            assertEquals(expectedResult, result, "The lists of products must be equal");
            assertTrue(result.contains(p1),"The list of products should contain p1");
            assertTrue(result.contains(p2),"The list of products contain p2");
            assertEquals(expectedResult, result, "2 lists of products must equal");
        }

}


