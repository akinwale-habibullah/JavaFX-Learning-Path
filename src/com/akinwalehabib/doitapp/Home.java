/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akinwalehabib.doitapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;

/**
 *
 * @author Habib
 */
public class Home extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Home.class.getResource("ui.fxml"));
        GridPane grid = loader.load();
        Scene scene = new Scene(grid, 600, 400);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Do-It!!!");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    
    public static void main(String[] args) {
        System.out.println("Hello World");
        
        Application.launch(args);
    }
}
