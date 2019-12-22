/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import studytracker.domain.Course;
import studytracker.domain.Log;
import studytracker.domain.UserCourse;

/**
 *
 * @author dell
 */
public class LogDao implements Dao<Log, Integer> {

    private int id;
    private String courseId;
    private float timespent;
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
                + " (course_id, timespent, note) "
                + " VALUES (?, ?, ?)");
        stmt.setString(1, log.getCourseId());
        stmt.setFloat(2, log.getTimeSpent());
        stmt.setString(3, log.getNote());

        stmt.executeUpdate();
        connection.close();
    }


    @Override
    public Log read(Integer key) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Usercourse WHERE id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        Log log = new Log(rs.getString("courseId"), rs.getFloat("timespent"), rs.getString("note"));

        stmt.close();
        rs.close();
        connection.close();

        return log;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Log> getAllLogs() {
        List<Log> allLogs = new ArrayList<>();
        try {
            try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbName)) {
                PreparedStatement getLogsQuery = connection.prepareStatement("SELECT * FROM Log;");
                ResultSet resultSet = getLogsQuery.executeQuery();

                while (resultSet.next()) {
                    Log l = new Log();
                    l.setCourseId(resultSet.getString("course_id"));
                    l.setTimeSpent(resultSet.getFloat("timespent"));
                    l.setNote(resultSet.getString("note"));
                    allLogs.add(l);
                    System.out.println(allLogs);
                }

                getLogsQuery.close();
                resultSet.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allLogs;
    }

}
