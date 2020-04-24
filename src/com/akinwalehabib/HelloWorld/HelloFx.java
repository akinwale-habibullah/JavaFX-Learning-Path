package com.akinwalehabib.HelloWorld;

import javafx.application.Application;
// stage is the container for the entire application
import javafx.stage.Stage;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class HelloFx extends Application {
    /**
     * JavaFX provides named and unnamed parameters
     * In order to use this feature in JavaFX
     * You have to call Application.launch(args)
     * @param args
     */
    // 
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello JavaFx");
        /**
         * To use JavaFX named parameters, we use getParameters().getNamed().get
         * In the command line terminal, use --width=100 or --height=500
         * 
         * For unnamed parameters, use
         * getParameters.getUnnamed() - Lists parameters without a name
         * getParameters.getRaw() - Lists all parameters
         */
        Integer width = Integer.parseInt(getParameters().getNamed().get("width"));
        Integer height = Integer.parseInt(getParameters().getNamed().get("height"));
        /**
         * Create a new group, which will contain our controls
         * To add a Button, we need to create a Group object
         * Whose constructor takes an array of objects or UI Nodes
         */
        Group group = new Group(new Button("Hello World"));

        /**
         * We cannot add group object directly to our stage
         * we have to enclose it in a scene object
         * Scenes takes theee parameters
         *      1. Container object such as Group
         *      2. Width
         *      3. Height
         */
        Scene scene = new Scene(group, width, height);
        // Add scene to our stage
        stage.setScene(scene);
        // display the GUI
        stage.show();
    }
}
