package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.VendingMachineController;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.sg.vendingmachine.ui.VendingMachineView;

public class App {
    public static void main(String[] args) {
        VendingMachineView myView = new VendingMachineView();
        VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl();
        VendingMachineController controller = new VendingMachineController(myView, service);
        controller.run();
    }
}