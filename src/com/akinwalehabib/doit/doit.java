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
        // Add one child node to group
         group.getChildren().add(new Button("First Button"));
        
        // Add many child nodes to group
        // All children are added at coordinate 0 , 0
        // So they stack on top of each other 
        // Except we instruct our application to do otherwise
        // using layouts or coordinates
        // Advised to use layouts, because coordinate is relative
        // to other nodes placement
        // group.getChildren().addAll(new Button("First Button"),
        //                            new Button("Second Button"));
        
        Integer width = new Integer(300);
        Integer height = new Integer(400);
         Scene scene = new Scene(group, width, height);
        /**
         * A few customizations for stage object
         */
        primaryStage.setScene(scene);
        primaryStage.setTitle("Do-It!!!");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
