package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Product;

import java.math.BigDecimal;

public interface VendingMachineServiceLayer {
    Change remainingChange(BigDecimal amount, Product product);
}
