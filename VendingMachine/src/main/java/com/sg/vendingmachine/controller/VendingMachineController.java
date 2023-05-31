package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class VendingMachineController {
    private VendingMachineView view;
    private UserIO io = new UserIOConsoleImpl();

    public VendingMachineController(VendingMachineView view) {
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        boolean getCaseAndCheckFunds;
        List<String> productNames;
        BigDecimal money;
        Map products;
        int productSelection = 0;

        while (keepGoing) {
            products = getProducts();
            productNames = getProductNames();
            money = getMoney();
            productSelection = getProductSelection();

            switch (productSelection) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    int caseIndex = productSelection - 1;
                    getCaseAndCheckFunds = printCase(caseIndex, money);
                    keepGoing = getCaseAndCheckFunds;
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }

    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private Map getProducts() {
        return view.getAndSeedProducts();
    }

    private List<String> getProductNames(){
        return view.printMenuAndGetProductNames();
    }

    private BigDecimal getMoney(){
        return view.getMoney();
    }

    private int getProductSelection(){
        return view.getProductSelection();
    }

    private boolean printCase(int index, BigDecimal money){
        return view.printCasesAndCheckFunds(index, money);
    }
}