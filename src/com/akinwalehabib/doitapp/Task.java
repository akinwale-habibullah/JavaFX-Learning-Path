/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akinwalehabib.doitapp;

import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
/**
 *
 * @author Habib
 */
public class Task {
    
    public static void main(String[] args) {
        SimpleIntegerProperty intProp = new SimpleIntegerProperty();
        intProp.set(15);
        System.out.println(intProp.get());
        
        SimpleStringProperty stringProp = new SimpleStringProperty("InitialValue");
        System.out.println(stringProp.get());
        stringProp.set("New Value");
        System.out.println(stringProp.get());
        
        ReadOnlyBooleanWrapper readOnlyBooleanWrapper = new ReadOnlyBooleanWrapper(true);
        ReadOnlyBooleanProperty readOnlyBoolProp = readOnlyBooleanWrapper.getReadOnlyProperty();
        
        System.out.println(readOnlyBoolProp.get());
        readOnlyBooleanWrapper.set(false);
        System.out.println(readOnlyBoolProp.get());
        
        intProp.addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            System.out.println("Integer Property is changed to " + newValue);
        });
        
        intProp.addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            System.out.println("Listender 2: Integer Property is changed to " + newValue);
        });
        
        intProp.addListener((Observable observable) -> {
            System.out.println("Int property changed");
        });
        
        intProp.set(10);
        intProp.set(30);
    }
    
}
