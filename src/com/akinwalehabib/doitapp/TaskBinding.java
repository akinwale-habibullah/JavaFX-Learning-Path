/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akinwalehabib.doitapp;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Habib
 */
public class TaskBinding {
    
    public static void main(String[] args) {
        StringProperty lastNameProp = new SimpleStringProperty();
        StringProperty surNameProp = new SimpleStringProperty();
        
        // Uni-Directional binding
        // surNameProp.bind(lastNameProp);
        
        // lastNameProp.set("Clarke");
        // System.out.println(surNameProp.get());
        
        // throws an error: java.lang.RuntimeException: A bound value cannot be set
        // surNameProp.set("Habib");
        
        // Bi-Directional Binding
        // surNameProp.bindBidirectional(lastNameProp);
        // surNameProp.set("Habib");
        // System.out.println(surNameProp.get());
        
        // lastNameProp.set("Akinwale");
        // System.out.println(lastNameProp.get());
        
        
        // Using Bindings static method - concat
        // lastNameProp.set("First");
        // surNameProp.set("Surname");
        // System.out.println(lastNameProp.get());
        // System.out.println(surNameProp.get());
        
        
        // StringProperty fullNameProp = new SimpleStringProperty();
        // fullNameProp.bind(Bindings.concat(lastNameProp.get(), " ", surNameProp.get()));
        // System.out.println(fullNameProp.get());
        
        // Declare and initialize a property
        // IntegerProperty lengthIntegerProp = new SimpleIntegerProperty(18);
        // IntegerProperty widthIntegerProp = new SimpleIntegerProperty(13);
        // IntegerProperty areaIntegerProperty = new SimpleIntegerProperty();
        // areaIntegerProperty.bind(widthIntegerProp.multiply(lengthIntegerProp));
        
        // declare and initialize NumberBinding
        // NumberBinding perimeterBinding = lengthIntegerProp.add(widthIntegerProp).multiply(2);
        
        // System.out.println(areaIntegerProperty.get());
        // System.out.println(perimeterBinding.getValue());
        
        // Low level binding created by using a binding class
        DoubleProperty radiusDoubleProp = new SimpleDoubleProperty(1.5);
        DoubleBinding volumeDoubleBinding = new DoubleBinding() {
            {
                super.bind(radiusDoubleProp);
            }
            @Override
            protected double computeValue() {
                return 4 / 3 * Math.PI * Math.pow(radiusDoubleProp.get(), 3);
            }
        };
        
        System.out.println(volumeDoubleBinding.get());
        radiusDoubleProp.set(2.5);
        System.out.println(volumeDoubleBinding.get());
    }
    
}
