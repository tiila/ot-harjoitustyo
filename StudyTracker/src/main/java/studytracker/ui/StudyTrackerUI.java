/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author dell
 */


public class StudyTrackerUI extends Application {

    Button loginButton, newProfileButton;
    Scene loginScene, profileScene, newProfileScene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        loginButton = new Button("Log in");
        newProfileButton = new Button("Create a new profile");

        StackPane layout = new StackPane();
        layout.getChildren().addAll(loginButton, newProfileButton);

        VBox layoutLogin = new VBox(20);
        layoutLogin.getChildren().addAll(loginButton, newProfileButton);

        loginScene = new Scene(layoutLogin, 1200, 700);

        VBox layoutProfile = new VBox(20);
        Label tervetuloaLabel = new Label("Welcome back!");
        Button logoutButton = new Button("Log out");
        Button logoutAndCloseButton = new Button("Log out and close");
        Button settingsButton = new Button("Change Settings");

        layoutProfile.getChildren().addAll(tervetuloaLabel, settingsButton, logoutButton, logoutAndCloseButton);
        logoutButton.setOnAction(e -> primaryStage.setScene(loginScene)); //+ kirjaudu ulos
        logoutAndCloseButton.setOnAction(e -> closeProgram(primaryStage));
        settingsButton.setOnAction(e -> SettingsBox.display("Settings", "Change settings or delete your account here"));

        profileScene = new Scene(layoutProfile, 1200, 700);

        loginButton.setOnAction(e -> primaryStage.setScene(profileScene));
        newProfileButton.setOnAction(e -> primaryStage.setScene(newProfileScene));

        primaryStage.setScene(loginScene);
        primaryStage.setTitle("StudyTracker");
        primaryStage.setOnCloseRequest(e -> closeProgram(primaryStage));
        primaryStage.show();

    }

    private void closeProgram(Stage primaryStage) {
        //Kirjaudu ulos
        //Jos esim tallennettavaa ennen sulkemista, esim kirjautumistiedot tm?
        System.out.println("Moikka");
        primaryStage.close();
    }

    public static void main(String[] args) {
        launch(StudyTrackerUI.class); // launch(args); 
    }

}
