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
    private final int WIDTH = 1000;
    private final int HEIGHT = 800;
    private int userId = 0;
    private String username = "";
    private Scene loginScene;
    private Scene profileScene;

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
        Label loginSuccessful = new Label("Please give a username to login");

        loginInputPane.getChildren().addAll(usernameLabel, usernameInput, loginSuccessful);

        loginButton = new Button("Log in");

        loginPane.getChildren().addAll(loginInputPane, loginButton);

        loginScene = new Scene(loginPane, WIDTH, HEIGHT);

        loginButton.setOnAction(e -> {
            username = usernameInput.getText();
            if (!username.isEmpty()) {

                primaryStage.setScene(profileScene);
            } else {
                loginSuccessful.setText("Couldn't login, please give a username!");
            }
        });

        // Profile Scene
        VBox layoutProfile = new VBox(20);

        Label welcomeLabel = new Label("Welcome back! See below for all available courses (course code, name, study credits).");
        Label myCoursesLabel = new Label("My courses");

        Label findNewCourse = new Label("Find and add a new course");
        TextField searchInput = new TextField();

        searchInput.setPromptText("Please type in course name or code");

        Button addButton = new Button("Add");

        addButton.setOnAction(e
                -> {
            String courseId = searchInput.getText();

            int usercourseId = 1;
            try {
                functionality.addUserCourse(usercourseId, userId, courseId);

            } catch (SQLException ex) {
                Logger.getLogger(StudyTrackerUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        );

        Button logoutButton = new Button("Log out");
        Button logoutAndCloseButton = new Button("Log out and close");

        // Available courses
        TextArea availableCourses = new TextArea();

        availableCourses.setText(functionality.showAvailableCourses().toString());

        // My courses
        TextArea myCourses = new TextArea();

        myCourses.setText(functionality.showMyCourses(userId).toString());

        if (myCourses.getText().isEmpty()) {
            myCourses.setText("You have not added any courses yet.");
        }

        // Update my courses view
        Button updateMyCourses = new Button("Update your courses");

        updateMyCourses.setOnAction(e
                -> {
            try {
                myCourses.setText(functionality.showMyCourses(userId).toString());
            } catch (SQLException ex) {
                Logger.getLogger(StudyTrackerUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        );

        // Log hours 
        Label timeSpentLabel = new Label("Time spent:");
        TextField timeSpentInput = new TextField();
        timeSpentInput.setPromptText("Time as hours, e.g. '2.5' ");

        Label courseIdLabel = new Label("Course code:");
        TextField courseIdInput = new TextField();
        courseIdInput.setPromptText("Type in course code, e.g. 'MAT11008'");

        Label noteLabel = new Label("Notes:");
        TextField noteInput = new TextField();
        noteInput.setPromptText("Add an optional short note");

        Button logHours = new Button("Save log");
        
        //Toimii
        logHours.setOnAction(e -> {
            float timespent = Float.parseFloat(timeSpentInput.getText());
            String courseId = timeSpentInput.getText();
            String note = noteInput.getText();

            try {
                functionality.addLog(timespent, courseId, note);
            } catch (SQLException ex) {
                Logger.getLogger(StudyTrackerUI.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        });

        Button logNew = new Button("Log new hours");

        logNew.setOnAction(e -> {
            timeSpentInput.clear();
            courseIdInput.clear();
            noteInput.clear();
        }
        );

        // Profile layout
        layoutProfile.getChildren()
                .addAll(welcomeLabel, availableCourses, findNewCourse, searchInput, addButton, myCoursesLabel, myCourses, updateMyCourses, timeSpentLabel, timeSpentInput, courseIdLabel, courseIdInput, noteLabel, noteInput, logHours, logNew, logoutButton, logoutAndCloseButton);
        logoutButton.setOnAction(e
                -> primaryStage.setScene(loginScene));
        logoutAndCloseButton.setOnAction(e
                -> closeProgram(primaryStage));

        profileScene = new Scene(layoutProfile, WIDTH, HEIGHT);

        primaryStage.setScene(loginScene);

        primaryStage.setTitle(
                "StudyTracker");
        primaryStage.setOnCloseRequest(e
                -> closeProgram(primaryStage));
        primaryStage.show();

    }

    private void closeProgram(Stage primaryStage) {

        primaryStage.close();
    }

    public static void main(String[] args) {
        launch(StudyTrackerUI.class
        );
    }

}
