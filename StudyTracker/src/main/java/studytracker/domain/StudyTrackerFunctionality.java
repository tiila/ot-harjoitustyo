/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import javafx.scene.control.TextField;
import org.sqlite.util.StringUtils;
import studytracker.db.DatabaseConnection;
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

    public List<UserCourse> showMyCourses(Integer userId) throws SQLException {

        UserCourseDao dao = new UserCourseDao();
        List<UserCourse> myCourses = dao.list(userId);
        System.out.println(myCourses.toString());
        return myCourses;
    }

    public UserCourse showACourse(int id) throws SQLException {

        UserCourseDao dao = new UserCourseDao();
        System.out.println(dao.read(id));
        return dao.read(id);

    }

    public void addUserCourse(int id, int userId, String courseId) throws SQLException {
        System.out.println("metodi addUserCourse");
        UserCourse userCourse = new UserCourse(id, userId, courseId);
        System.out.println(userCourse.getUserId() + userCourse.getCourseId());
        UserCourseDao dao = new UserCourseDao();
        dao.create(userCourse);

        System.out.println("Onnistui");

    }

    public static UserCourse getCourse(String user_id) {
        return null;

    }

    // Find if course is in DB, try, add to functionality
    private boolean isInDB(TextField searchInput) {

        int found = 0;

        return false;

    }

}
