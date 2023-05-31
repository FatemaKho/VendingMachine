package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.ui.VendingMachineView;

public class App {
    public static void main(String[] args) {
        VendingMachineView myView = new VendingMachineView();
        VendingMachineController controller = new VendingMachineController(myView);
        controller.run();
    }
}