/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.domain;

import java.sql.SQLException;
import java.util.List;
import javafx.scene.control.TextField;
import studytracker.db.DatabaseConnection;
import studytracker.db.LogDao;
import studytracker.db.UserCourseDao;

/**
 *
 * @author dell
 */
public class StudyTrackerFunctionality {

    private DatabaseConnection dbconnection;

    // @throws SQLException if database cannot be created
    public StudyTrackerFunctionality() throws SQLException {

        this.dbconnection = new DatabaseConnection("studytracker.db");

    }

    public String showAvailableCourses() {
        List<Course> availableCourses = dbconnection.getAllCourses();

        StringBuilder sb = new StringBuilder();

        for (Course course : availableCourses) {
            sb.append(course.toString());
            sb.append(" ");
        }

        return sb.toString();
    }

    public List<UserCourse> showMyCourses(int userId) throws SQLException {

        UserCourseDao dao = new UserCourseDao();
        List<UserCourse> myCourses = dao.list(userId);
        return myCourses;
    }

    public UserCourse showACourse(int id) throws SQLException {
        UserCourseDao dao = new UserCourseDao();
        return dao.read(id);

    }

    public void addUserCourse(int id, int userId, String courseId) throws SQLException {
        UserCourse userCourse = new UserCourse(id, userId, courseId);
        UserCourseDao dao = new UserCourseDao();
        dao.create(userCourse);

    }

    public void addLog(String courseId, float timespent, String note) throws SQLException {
        Log log = new Log(courseId, timespent, note);
        LogDao dao = new LogDao();
        dao.create(log);
    }

    // Find if course is in DB, try, add to functionality
    private boolean isInDB(TextField searchInput) {

        int found = 0;

        return false;

    }

    public String showLoggedHours() {
        LogDao dao = new LogDao();
        List<Log> allLogs = dao.getAllLogs();

        StringBuilder sb = new StringBuilder();

        for (Log log : allLogs) {
            sb.append(log.toString());
            sb.append(" ");
        }

        return sb.toString();

    }
}
