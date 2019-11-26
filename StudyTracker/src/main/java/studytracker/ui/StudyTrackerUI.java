/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.ui;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import studytracker.domain.*;

/**
 * Sovelluksen graafinen käyttöliittymä ja sovelluksen käynnistys
 *
 * @author dell
 */
public class StudyTrackerUI extends Application {

    private StudyTrackerFunctionality functionality;

    Button loginButton, newProfileButton;
    Scene loginScene, profileScene, newProfileScene;

    @Override
    public void init() throws SQLException {
        this.functionality = new StudyTrackerFunctionality(); //ei saa luotua tietokantaa

    }

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
        Label welcomeLabel = new Label("Welcome back! See below for all available courses (course code, name, study credits).");
        Label myCoursesLabel = new Label("My courses");

        Label findNewCourse = new Label("Find and add a new course");
        TextField searchInput = new TextField();
        searchInput.setPromptText("Please type in course name or code"); //Tulee nyt vasta kun klikkaa jotain

        Button addButton = new Button("Add");
        //   addButton.setOnAction(e -> isInDB(searchInput, searchInput.getText()));

        Button logoutButton = new Button("Log out");
        Button logoutAndCloseButton = new Button("Log out and close");
        Button settingsButton = new Button("Change Settings");

        TextArea availableCourses = new TextArea();
        availableCourses.setText(functionality.showAvailableCourses().toString());

        TextArea myCourses = new TextArea();
        myCourses.setText("You have not added any courses yet.");

        layoutProfile.getChildren().addAll(welcomeLabel, availableCourses, findNewCourse, searchInput, addButton, myCoursesLabel, myCourses, settingsButton, logoutButton, logoutAndCloseButton);
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

    private boolean isInDB(TextField searchInput) {

        int found = 0;

        return false;
        //löytyyko tietokannasta, try?
    }
}
