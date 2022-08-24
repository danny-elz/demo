package com.example.demo;


import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class HelloApplication extends Application {

    public void start(Stage window) {
        BorderPane layout = new BorderPane();
        HBox horizontalBox = new HBox();
        horizontalBox.setSpacing(10);
        Label letterLabel = new Label();
        Label wordLabel = new Label();
        Label longestWord = new Label();
        horizontalBox.getChildren().addAll(letterLabel, wordLabel, longestWord);

        TextArea textField = new TextArea("");

        textField.textProperty().addListener((ObservableValue<? extends String> change, String oldValue, String newValue) -> {
            int characterCount = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();

            letterLabel.setText("Letters: " + characterCount);
            wordLabel.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);
        });

        layout.setCenter(textField);
        layout.setBottom(horizontalBox);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();




    }

    public static void main(String[] args) {
        launch(HelloApplication.class);
    }

}