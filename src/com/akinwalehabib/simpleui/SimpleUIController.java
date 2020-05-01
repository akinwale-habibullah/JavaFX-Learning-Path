/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akinwalehabib.simpleui;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 *
 * @author Habib
 */
public class SimpleUIController {
    
    @FXML
    public TextField textfield;
    
    public void initialize() {
        System.out.println("SimpleUIController is initialized");
        
        textfield.setText("This is the textfield's text set in SimpleUIController");
    }
}
