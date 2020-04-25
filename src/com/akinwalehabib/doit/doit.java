/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akinwalehabib.doit;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;

/**
 *
 * @author Habib
 */
public class doit extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);
        
        Button b1 = new Button("First Button");
        Button b2 = new Button("Long Second Button");
        Button b3 = new Button("Third Button");
        Button b4 = new Button("Fourth Button");
        
        GridPane.setConstraints(b1, 1, 1);
        GridPane.setConstraints(b2, 2, 1);
        GridPane.setConstraints(b3, 1, 2);
        GridPane.setConstraints(b4, 2, 2);
        
        BorderPane borderpane = new BorderPane();
        borderpane.setTop(new Button("top"));
        borderpane.setBottom(new Button("bottom"));
        borderpane.setLeft(new Button("left"));
        borderpane.setCenter(new Button("Center"));
        borderpane.setRight(new Button("left"));
        GridPane.setConstraints(borderpane, 1, 3, 4, 2);
        
        grid.getChildren().addAll(b1, b2, b3, b4, borderpane);
        
        Integer width = new Integer(300);
        Integer height = new Integer(400);
        Scene scene = new Scene(grid, width, height);
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
