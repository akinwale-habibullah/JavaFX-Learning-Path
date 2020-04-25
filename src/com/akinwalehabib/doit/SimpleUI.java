/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akinwalehabib.doit;

import java.lang.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import com.akinwalehabib.doit.SimpleUIController;

/**
 *
 * @author Habib
 */
public class SimpleUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Access textfield in our application class
        // we need to get a reference to our controller object
        // for that we need to create a FXMLLoader object
        FXMLLoader loader = new FXMLLoader(SimpleUI.class.getResource("simpleui.fxml"));
        HBox box = loader.load();
        
        SimpleUIController controller = loader.getController();
        
        System.out.println(controller.textfield.getText());
        
        Scene scene = new Scene(box);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        Application.launch(args);
    }
}
