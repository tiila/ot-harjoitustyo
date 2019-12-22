/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import studytracker.domain.Log;

/**
 *
 * @author dell
 */
public class LogDao implements Dao<Log, Integer> {

    private float timespent;
    private String courseId;
    private String note;
    private int userId;
    private DatabaseConnection dbconnection;
    private String dbName = "studytracker.db";

    public LogDao() {
        this.timespent = 0;
        this.courseId = "";
        this.note = "";
        this.userId = 1;
        this.courseId = "";

    }

    @Override
    public void create(Log log) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);

        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Log"
                + " (timespent, course_id, note) "
                + " VALUES (?, ?, ?)");

        stmt.setFloat(1, log.getTimeSpent());
        stmt.setString(2, log.getCourseId());
        stmt.setString(3, log.getNote());

        stmt.executeUpdate();
        connection.close();
    }

    @Override
    public Log read(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
