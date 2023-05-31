package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class VendingMachineController {
    private VendingMachineView view;
    private UserIO io = new UserIOConsoleImpl();
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer service) {
        this.service = service;
        this.view = view;
    }


    public void run() {
        boolean keepGoing = true;
        int selection = view.promptItemSelection();

        while (keepGoing) {
            switch (selection) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:

                case 7:
                    keepGoing = false;
                    break;

            }
        }


    }

}