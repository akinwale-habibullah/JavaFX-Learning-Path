/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akinwalehabib.doit;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.*;

/**
 *
 * @author Habib
 */
public class doit extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        group.getChildren().add(new Button("First Button"));
        
        Integer width = new Integer(300);
        Integer height = new Integer(400);
        Scene scene = new Scene(group, width, height);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
