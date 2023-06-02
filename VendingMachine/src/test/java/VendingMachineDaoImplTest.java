import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoImpl;
import com.sg.vendingmachine.dto.Product;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;
import org.junit.Test;

import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineDaoImplTest {
    VendingMachineDao testDao;

public VendingMachineDaoImplTest(){
    String testFile = "testproducts.txt";
    VendingMachineDao testDao = new VendingMachineDaoImpl("testproducts.txt");
}
    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }
@Test
public void testLoadProductsFromFile () throws Exception {
    System.out.println("loadProductsFromFile");
    BigDecimal bd = new BigDecimal("2.00");
    Product p1 = new Product("1", "Chips", bd, 1);
    bd = new BigDecimal("2.50");
    Product p2 = new Product("2", "Water", bd, 1);
    //Result
    Map<Integer, Product> result = testDao.loadProductsFromFile();
    //Expected Result
    Map<Integer, Product> expectedResult = new TreeMap<>();
    expectedResult.put(1, p1);
    expectedResult.put(2, p2);
    //Assert
    assertEquals(expectedResult, result, "Test Products");
}

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

@Test
public void testGetAllProduct() throws VendingMachinePersistenceException {
    System.out.println("getAllProducts");
    BigDecimal bd = new BigDecimal("2.00");
    Product p1 = new Product("1", "Chips", bd, 1);
    bd = new BigDecimal ("2.50");
    Product p2 = new Product("2", "Water", bd, 1);
    testDao.addProduct(Integer.parseInt(p1.getProductId()),p1);
    testDao.addProduct(Integer.parseInt(p2.getProductId()),p2);

    //Result
    List<Product> result = testDao.getAllProducts();
    //ExpectedResult
    List<Product> expectedResult = new ArrayList<>();
    expectedResult.add(p1);
    expectedResult.add(p2);

    //Assert
    assertNotNull(result, "The list of products must not be null");
    assertEquals(result.contains(p1), "List of products must equal");
    assertTrue(result.contains(p1),"The list of products should contain p1");
    assertTrue(result.contains(p2),"The list of products contain p2");
    assertEquals(expectedResult, result, "2 lists of products must equal");
}

}
