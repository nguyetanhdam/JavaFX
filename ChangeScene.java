package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChangeScene extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        Label label = new Label("Welcome");

        // scene 1
        Button button1 = new Button("Java FX huhu :(");
        button1.setOnAction(actionEvent -> {
            window.setScene(scene2);
        });
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(label, button1);
        scene1 = new Scene(layout1, 500., 500);

        // scene 2
        Button button2 = new Button("Hmm scene 2 á");
        button2.setOnAction(actionEvent -> {
            window.setScene(scene1);
        });
        VBox layout2 = new VBox();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 300, 300);

        window.setScene(scene1);
        window.show();
//        window.setScene(scene2);
    }
}