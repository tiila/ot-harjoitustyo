/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import studytracker.domain.Course;

/**
 *
 * @author dell
 */
public class DatabaseConnection {

    private String database;

    List<Course> courses = new ArrayList<Course>();

    Course mat11008 = new Course("MAT11008", "Advanced Calculus", 5);
    Course mat11006 = new Course("MAT11006", "Calculus IA: Limits and differentiation", 5);
    Course mat11007 = new Course("MAT11007", "Calculus IB: Integration", 5);
    Course mat12005 = new Course("MAT12005", "Data-analyysin projekti", 5);
    Course mat11004 = new Course("MAT11004", "Differentiaalilaskenta", 5);
    Course mat11005 = new Course("MAT11005", "Integraalilaskenta", 5);
    Course tkt10001 = new Course("TKT10001", "Johdatus tietojenkäsittelytieteeseen", 5);
    Course mat11001 = new Course("MAT11001", "Johdatus yliopistomatematiikkaan", 5);
    Course mat11002 = new Course("MAT11002", "Lineaarialgebra ja matriislaskenta 1", 5);
    Course tkt10002 = new Course("TKT10002", "Ohjelmoinnin perusteet", 5);
    Course tkt10003 = new Course("TKT10003", "Ohjelmoinnin jatkokurssi", 5);
    Course tkt10004 = new Course("TKT10004", "Tietokantojen perusteet", 5);
    Course tkt10005 = new Course("TKT10005", "Tietokoneen toiminta", 5);

    public DatabaseConnection(String databaseName) throws SQLException {
        this.database = databaseName;
        initDatabase();
    }

    private void initDatabase() {

        try {
            Connection connection = connect();

            PreparedStatement createUserTable = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS user (id INTEGER PRIMARY KEY, name VARCHAR(100), status VARCHAR(10))"
            );
            createUserTable.execute();
            createUserTable.close();

            PreparedStatement createCourse = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS course (id VARCHAR(50), name VARCHAR(100), credits INTEGER)"
            );
            createCourse.execute();
            createCourse.close();

            PreparedStatement createLog = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS log (id INTEGER PRIMARY KEY, timespent FLOAT, date DATE, note VARCHAR(200))" //kurssi, käyttäjä
            );
            createLog.execute();
            createCourse.close();

            insertCourses(courses);
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertCourses(List<Course> courses) throws SQLException {
        Connection connection = connect();
        //    PreparedStatement insertCourses = connection.prepareStatement("INSERT INTO Course (id, name, credits) VALUES (?, ?, ?);");

      //  String SQL_INSERT = "INSERT INTO Course (id, name, credits) VALUES (?, ?, ?)";

        PreparedStatement insertCourses = connection.prepareStatement("INSERT INTO Course (id, name, credits) VALUES (?, ?, ?)");

        courses.add(mat11008);
        courses.add(mat11006);
        courses.add(mat11007);
        courses.add(mat12005);
        courses.add(mat11004);
        courses.add(mat11005);
        courses.add(tkt10001);
        courses.add(mat11001);
        courses.add(mat11002);
        courses.add(tkt10002);
        courses.add(tkt10003);
        courses.add(tkt10004);
        courses.add(tkt10005);

        int i;

        for (Course course : courses) {
            System.out.println(course.getId());
            insertCourses.setString(1, course.getId());
            insertCourses.setString(2, course.getName());
            System.out.println(course.getName());
            insertCourses.setInt(3, course.getCredits());
            System.out.println(course.getCredits());
            i = insertCourses.executeUpdate();
            i++;

        }

        connection.close();
    }


    /*
    Tietokantayhteys
     */
    private Connection connect() {
        Connection connection = null;
        try {
            String url = "jdbc:sqlite:" + database;
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
