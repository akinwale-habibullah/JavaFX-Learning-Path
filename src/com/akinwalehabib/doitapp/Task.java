/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akinwalehabib.doitapp;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Habib
 */
public class Task {
    // We create all this properties so we can listen to changes
    private final StringProperty priorityProperty = new SimpleStringProperty();
    private final StringProperty descriptionProperty = new SimpleStringProperty();
    private final ObjectProperty<Integer> progressProperty = new SimpleObjectProperty<>(0); 
    private final ObjectProperty<Integer> idProperty = new SimpleObjectProperty<>(null);

    public Task() {}
    public Task(Integer id, String priority, String description, Integer progress){
        this.idProperty.set(id);
        this.priorityProperty.set(priority);
        this.descriptionProperty.set(description);
        this.progressProperty.set(progress);
    }
    
    public String getPriorityProperty() {
        return this.priorityProperty.get();
    }
    public void setPriorityProperty(String value) {
        this.priorityProperty.set(value);
    }
    // In JavaFX we add an additional method
    // that returns the property
    public StringProperty priorityProperty() {
        return priorityProperty;
    }

    public String getDescriptionProperty() {
        return this.descriptionProperty.get();
    }
    public void setDescriptionProperty(String value) {
        this.descriptionProperty.set(value);
    }
    // In JavaFX we add an additional method
    // that returns the property
    public StringProperty descriptionProperty() {
        return descriptionProperty;
    }

    public Integer getProgressProperty() {
        return this.progressProperty.getValue();
    }
    public void setProgressProperty(Integer value) {
        this.progressProperty.set(value);
    }
    // In JavaFX we add an additional method
    // that returns the property
    public ObjectProperty<Integer> progressProperty() {
        return progressProperty;
    }
    
    public Integer getIdProperty() {
        return this.idProperty.getValue();
    }
    public void setIdProperty(Integer value) {
        this.idProperty.set(value);
    }
    // In JavaFX we add an additional method
    // that returns the property
    public ObjectProperty<Integer> IdProperty() {
        return idProperty;
    }
    
}
