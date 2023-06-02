package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import org.junit.jupiter.api.Test;

class VendingMachineServiceLayerImplTest {

    private VendingMachineServiceLayer service;

    public VendingMachineServiceLayerImplTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        VendingMachineAuditDao auditDao= new VendingMachineAuditDaoStubImpl();
        service = new VendingMachineServiceLayerImpl(dao, auditDao);
    }

    @Test
    void loadProductsInStock() {
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
    void getProduct() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void removeProduct() {
    }

    @Test
    void decreaseStockItem() {
    }
}