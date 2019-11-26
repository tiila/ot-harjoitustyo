/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import studytracker.db.DatabaseConnection;

/**
 *
 * @author dell
 */
public class StudyTrackerFunctionality {

    private DatabaseConnection dbconnection;

    // @throws SQLException jos tietokantaa ei voida luoda
    public StudyTrackerFunctionality() throws SQLException {

        this.dbconnection = new DatabaseConnection("studytracker.db");

    }

    //metodit
    public List<Course> showAvailableCourses() {

        return dbconnection.getAllCourses();

    }

}
