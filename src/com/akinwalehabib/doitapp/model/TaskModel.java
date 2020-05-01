/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akinwalehabib.doitapp.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Habib
 */
public class TaskModel {
    // We create all this properties so we can listen to changes
    StringProperty priorityProperty = new SimpleStringProperty();
    StringProperty descriptionProperty = new SimpleStringProperty();
    ObjectProperty<Integer> progressProperty = new SimpleObjectProperty<>(0);    

    public String getPriorityProperty() {
        return priorityProperty.get();
    }
    public void setPriorityProperty(String priorityProperty) {
        this.priorityProperty.set(priorityProperty);
    }
    // In JavaFX we add an additional method
    // that returns the property
    public StringProperty priorityProperty() {
        return priorityProperty;
    }

    public String getDescriptionProperty() {
        return descriptionProperty.get();
    }
    public void setDescriptionProperty(String descriptionProperty) {
        this.descriptionProperty.set(descriptionProperty);
    }
    // In JavaFX we add an additional method
    // that returns the property
    public StringProperty descriptionProperty() {
        return descriptionProperty;
    }

    public Integer getProgressProperty() {
        return progressProperty.getValue();
    }
    public void setProgressProperty(Integer progressProperty) {
        this.progressProperty.set(progressProperty);
    }
    // In JavaFX we add an additional method
    // that returns the property
    public ObjectProperty<Integer> progressProperty() {
        return progressProperty;
    }
    
}
