package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;

import java.math.BigDecimal;

public class VendingMachineServiceLayerImpl {
    Change remainingChange(BigDecimal amount, Product product) {
        if (amount.compareTo(product.getPrice()) < 0) {
            return null;
        } else {
            return new Change(amount);
        }
    }
}
