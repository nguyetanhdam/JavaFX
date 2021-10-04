package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Optional;

public class NotiAlert extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Alert Example");
        Button button = new Button();
        button.setText("Close");
        button.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirms");
            alert.setHeaderText("Alert Information");
            alert.setContentText("Choose your option");

            ButtonType buttonTypeYES = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNO = new ButtonType("No", ButtonBar.ButtonData.NO);
            ButtonType buttonTypeYCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeYES, buttonTypeNO, buttonTypeYCancel);

            Optional<ButtonType> res = alert.showAndWait();

            // kiểm tra
            if (res.get() == buttonTypeYES) {
                System.out.println("Code for yes");
            }
            else if (res.get().getButtonData() == ButtonBar.ButtonData.NO) {
                System.out.println("Code for no");
            }
            else {
                System.out.println("Code for cancel");
            }

            String message = res.get().getText();
            Alert alert_info = new Alert(Alert.AlertType.INFORMATION);
            alert_info.setTitle("Information");
            alert_info.setHeaderText("Notification");
            alert_info.setContentText(message);
            alert_info.show();
        });
        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
