package service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.service.VendingMachinePersistenceException;

public class VendingMachineAuditDaoStubImpl implements VendingMachineAuditDao {
    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException {
        //do nothing . . .
    }
}
