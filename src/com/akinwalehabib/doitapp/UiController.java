/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akinwalehabib.doitapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Habib
 */
public class UiController implements Initializable {
    private final Task currentTask = new Task();
    private final ObservableList<Task> tasks = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Task> tasksTable;
    
    @FXML
    private TableColumn<Task, String> priorityColumn;
    
    @FXML
    private TableColumn<Task, String> descriptionColumn;
    
    @FXML
    private TableColumn<Task, String> progressColumn;

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
           
           // tasks.add(new Task(25+newValue, "Medium", "Fix Bug 2343333"+newValue, newValue));
        });
       
        ReadOnlyIntegerProperty intProgress = ReadOnlyIntegerProperty.readOnlyIntegerProperty(progressSpinner.valueProperty());
        progressBar.progressProperty().bind(intProgress.divide(100.0));
        
        priority.valueProperty().bindBidirectional(currentTask.priorityProperty());
        taskDescription.textProperty().bindBidirectional(currentTask.descriptionProperty());
        progressSpinner.getValueFactory().valueProperty().bindBidirectional(currentTask.progressProperty());
        
        tasksTable.setItems(tasks);
        priorityColumn.setCellValueFactory(rowData -> rowData.getValue().priorityProperty());
        descriptionColumn.setCellValueFactory(rowData -> rowData.getValue().descriptionProperty());
        progressColumn.setCellValueFactory(rowData -> Bindings.concat(rowData.getValue().progressProperty(), " %"));
        
        tasks.addAll(new Task(1, "High", "Complete Design Document", 10),
                     new Task(2, "Medium", "Update Class Diagram", 0),
                     new Task(3, "Low", "Fix Run 345232", 0));
        
        StringBinding addButtonTextBinding = new StringBinding() {
            {
                super.bind(currentTask.IdProperty());
            }
            @Override
            protected String computeValue() {
                if(currentTask.getIdProperty() == null) {
                    return "Add";
                } else {
                    return "Update";
                }
            }
        };
        add.textProperty().bind(addButtonTextBinding);
        add.disableProperty().bind(Bindings.greaterThan(3, currentTask.descriptionProperty().length()));
        
        tasksTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Task> ObservableList, Task oldValue, Task newValue) -> {
            setCurrentTask(newValue);
        }) ;
    }

    private void setCurrentTask(Task selectedTask) {
        if(selectedTask != null) {
            currentTask.setIdProperty(selectedTask.getIdProperty());
            currentTask.setDescriptionProperty(selectedTask.getDescriptionProperty());
            currentTask.setPriorityProperty(selectedTask.getPriorityProperty());
            currentTask.setProgressProperty(selectedTask.getProgressProperty());
        } else {
            currentTask.setIdProperty(null);
            currentTask.setDescriptionProperty("");
            currentTask.setPriorityProperty("");
            currentTask.setProgressProperty(0);
        }
    }
    
}
