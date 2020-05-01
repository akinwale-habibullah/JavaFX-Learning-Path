/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akinwalehabib.doitapp;

import com.akinwalehabib.doitapp.model.TaskModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;

/**
 * FXML Controller class
 *
 * @author Habib
 */
public class UiController implements Initializable {
    private TaskModel currentTask = new  TaskModel();
    
    @FXML
    private TableView<?> tasksTable;

    @FXML
    private ComboBox<String> priority;

    @FXML
    private Spinner<Integer> progressSpinner;

    @FXML
    private CheckBox completedCheckbox;

    @FXML
    private TextField taskDescription;
    
    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button add;

    @FXML
    private Button cancel;

    /**
     * Initialises the controller class.
     * @param url URL
     * @param rb ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       priority.getItems().addAll("High", "Medium", "Low");
       progressSpinner.setValueFactory(
               new SpinnerValueFactory
                       .IntegerSpinnerValueFactory(0, 100, 0));
       
       progressSpinner.valueProperty().addListener((ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) -> {
           if (newValue == 100) {
               completedCheckbox.setSelected(true);
           } else {
               completedCheckbox.setSelected(false);
           }
           
           // System.out.println(currentTask.getDescriptionProperty());
           // System.out.println(currentTask.getPriorityProperty());
           // System.out.println(currentTask.getProgressProperty());
           
           // currentTask.setDescriptionProperty(newValue.toString());
       });
       
        ReadOnlyIntegerProperty intProgress = ReadOnlyIntegerProperty.readOnlyIntegerProperty(progressSpinner.valueProperty());
        progressBar.progressProperty().bind(intProgress.divide(100.0));
        
        priority.valueProperty().bindBidirectional(currentTask.priorityProperty());
        taskDescription.textProperty().bindBidirectional(currentTask.descriptionProperty());
        progressSpinner.getValueFactory().valueProperty().bindBidirectional(currentTask.progressProperty());
    }    
    
}
