/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akinwalehabib.simpleui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;

/**
 *
 * @author Habib
 */
public class doit extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.setMinWidth(600);
        grid.setMinHeight(400);
        
        grid.setHgap(5);
        grid.setVgap(10);
        grid.setGridLinesVisible(false);
        
        TableColumn column1 = new TableColumn("Priority");
        TableColumn column2 = new TableColumn("Description");
        TableColumn column3 = new TableColumn("Progress");
        
        TableView table = new TableView();
        table.setMinHeight(300);
        table.setMinWidth(550);
        table.getColumns().addAll(column1, column2, column3);
        GridPane.setConstraints(table, 1, 1, 3, 1);
        
        TextField taskName = new TextField();
        taskName.setPromptText("Enter task name");
        taskName.setText("Default text");
        taskName.setMinWidth(300);
        GridPane.setConstraints(taskName, 2, 2);
        
        ComboBox priority = new ComboBox();
        priority.getItems().addAll("High", "Low", "Medium");
        priority.setPromptText("Enter Priority");
        GridPane.setConstraints(priority, 1, 2);
        
        Button addButton = new Button("Add");
        addButton.setMinWidth(100);
        GridPane.setConstraints(addButton, 3, 2);
        
        Button cancelButton = new Button("Cancel");
        cancelButton.setMinWidth(100);
        GridPane.setConstraints(cancelButton, 3, 3);
        
        HBox progressArea = new HBox();
        progressArea.getChildren().addAll(new Label("Progress"),
                                          new Spinner<Integer>(0, 100, 0),
                                          new CheckBox("Completed"));
        progressArea.setAlignment(Pos.CENTER_RIGHT);
        progressArea.setSpacing(10);
        GridPane.setConstraints(progressArea, 1, 3, 2, 1);
        
        grid.getChildren().addAll(table, taskName, priority, addButton, cancelButton, progressArea);
        
        Integer width = new Integer(600);
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
