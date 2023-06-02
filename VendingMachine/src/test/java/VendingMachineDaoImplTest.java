import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoImpl;
import org.junit.Test;

import java.io.FileWriter;

public class VendingMachineDaoImplTest {
    VendingMachineDao testDao;

public VendingMachineDaoImplTest(){

}
    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception{
        String testFile = "testproducts.txt";
        //blank file
        new FileWriter(testFile);
        testDao=new VendingMachineDaoImpl(testFile);
    }

public void testLoadProductsFromFile () throws Exception {

}
}