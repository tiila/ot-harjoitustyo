/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.ui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import studytracker.domain.*;

/**
 * Application UI and application start method
 *
 * @author dell
 */
public class StudyTrackerUI extends Application {

    private StudyTrackerFunctionality functionality;
    private int userId = 0;
    private Scene loginScene;
    private Scene profileScene;
    private Scene newProfileScene;

    Button loginButton, newProfileButton;

    @Override
    public void init() throws SQLException {
        this.functionality = new StudyTrackerFunctionality();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Login Scene
        VBox loginPane = new VBox(10);
        HBox loginInputPane = new HBox(10);

        Label usernameLabel = new Label("Username:");
        TextField usernameInput = new TextField();

        loginInputPane.getChildren().addAll(usernameLabel, usernameInput);

        loginButton = new Button("Log in");
        newProfileButton = new Button("Create a new profile");

        newProfileButton.setOnAction(e -> primaryStage.setScene(newProfileScene));

        loginPane.getChildren().addAll(loginInputPane, loginButton, newProfileButton);

        loginScene = new Scene(loginPane, 1000, 600);

        loginButton.setOnAction(e -> primaryStage.setScene(profileScene));

        newProfileButton.setOnAction(e -> primaryStage.setScene(newProfileScene));

        // New Profile Scene
        VBox newProfilePane = new VBox(10);
        HBox newInputPane = new HBox(10);

        Label newUsernameLabel = new Label("New username: ");
        TextField newUsernameInput = new TextField();

        newInputPane.getChildren().addAll(newUsernameLabel, newUsernameInput);

        newProfilePane.getChildren().addAll(newInputPane);

        newProfileScene = new Scene(newProfilePane, 1000, 600);

        // Profile Scene
        VBox layoutProfile = new VBox(20);
        Label welcomeLabel = new Label("Welcome back! See below for all available courses (course code, name, study credits).");
        Label myCoursesLabel = new Label("My courses");

        Label findNewCourse = new Label("Find and add a new course");
        TextField searchInput = new TextField();
        searchInput.setPromptText("Please type in course name or code"); // Huom. ei tuu suoraan

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            String courseId = searchInput.getText();

            int usercourseId = 1;
            try {
                functionality.addUserCourse(usercourseId, userId, courseId);

                System.out.println(courseId);

            } catch (SQLException ex) {
                Logger.getLogger(StudyTrackerUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Button logoutButton = new Button("Log out");
        Button logoutAndCloseButton = new Button("Log out and close");
        Button settingsButton = new Button("Change Settings");

        // Available courses
        TextArea availableCourses = new TextArea();
        availableCourses.setText(functionality.showAvailableCourses().toString());
        
        // My courses
        TextArea myCourses = new TextArea();
        myCourses.setText("You have not added any courses yet."); // If no courses have been added
        myCourses.setText(functionality.showMyCourses(userId).toString());

        // Update my courses view
        Button updateMyCourses = new Button("Update your courses");
        updateMyCourses.setOnAction(e -> {
            try {
                myCourses.setText(functionality.showMyCourses(userId).toString());
            } catch (SQLException ex) {
                Logger.getLogger(StudyTrackerUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // Log hours 
        

        // Profile layout
        layoutProfile.getChildren().addAll(welcomeLabel, availableCourses, findNewCourse, searchInput, addButton, myCoursesLabel, myCourses, updateMyCourses, settingsButton, logoutButton, logoutAndCloseButton);
        logoutButton.setOnAction(e -> primaryStage.setScene(loginScene)); // + log out
        logoutAndCloseButton.setOnAction(e -> closeProgram(primaryStage));
        settingsButton.setOnAction(e -> SettingsBox.display("Settings", "Change settings or delete your account here"));

        profileScene = new Scene(layoutProfile, 1200, 700);

        primaryStage.setScene(loginScene);
        primaryStage.setTitle("StudyTracker");
        primaryStage.setOnCloseRequest(e -> closeProgram(primaryStage));
        primaryStage.show();

    }

    private void closeProgram(Stage primaryStage) {
        // Log out
        // Save 
        System.out.println("Moikka");
        primaryStage.close();
    }

    public static void main(String[] args) {
        launch(StudyTrackerUI.class); // launch(args); 
    }

}
