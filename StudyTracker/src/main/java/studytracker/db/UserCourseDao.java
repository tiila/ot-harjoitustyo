/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.db;

import java.sql.*;
import java.util.*;
import studytracker.domain.UserCourse;

/**
 *
 * @author dell
 */
public class UserCourseDao implements Dao<UserCourse, Integer> {

    private int id;
    private int userId;
    private String courseId;
    private DatabaseConnection dbconnection;
    private String dbName = "studytracker.db";
    private List<UserCourse> userCourses = new ArrayList<>();

    public UserCourseDao() {
        this.id = 0;
        this.userId = 0;
        this.courseId = "";

    }

    @Override
    public void create(UserCourse userCourse) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);

        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Usercourse"
                + " (user_id, course_id) "
                + " VALUES (?, ?)");
        stmt.setInt(1, userCourse.getUserId());
        stmt.setString(2, userCourse.getCourseId());

        stmt.executeUpdate();
        connection.close();
        System.out.println("Onnistui");
    }

    @Override
    public UserCourse read(Integer id) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Usercourse WHERE id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {
            return null;
        }

        UserCourse uc = new UserCourse(rs.getInt("id"), rs.getInt("user_id"), rs.getString("course_id"));

        stmt.close();
        rs.close();
        connection.close();

        return uc;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<UserCourse> list(Integer userId) throws SQLException { // UserId as parameter
        this.userId = userId;

        List<UserCourse> myCourses = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbName)) {
            PreparedStatement stmt = connection.prepareStatement("SELECT course_id FROM Usercourse WHERE user_id = ?");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                UserCourse course = new UserCourse();
                course.setCourseId(rs.getString("course_id"));
                myCourses.add(course);
            }
            
            stmt.close();
            rs.close();
        }

        return myCourses;

    }
}
