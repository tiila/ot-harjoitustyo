/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import studytracker.db.DatabaseConnection;
import studytracker.db.UserCourseDao;
import studytracker.domain.StudyTrackerFunctionality;
import studytracker.domain.UserCourse;

/**
 *
 * @author dell
 */
public class StudyTrackerFunctionalityTest {

    DatabaseConnection dbconnection;
    StudyTrackerFunctionality functionality;

    UserCourseDao dao = new UserCourseDao();
    List<UserCourse> myCourses;
    int id = 1;
    int userId = 1;
    String courseId = "";

    public StudyTrackerFunctionalityTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {
        dbconnection = new DatabaseConnection("test.db");
        dao = new UserCourseDao();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllCoursesWorks() {
        assertEquals(
                "[MAT11008	Advanced Calculus	5\n"
                + ", MAT11006	Calculus IA: Limits and differentiation	5\n"
                + ", MAT11007	Calculus IB: Integration	5\n"
                + ", MAT12005	Data-analyysin projekti	5\n"
                + ", MAT11004	Differentiaalilaskenta	5\n"
                + ", MAT11005	Integraalilaskenta	5\n"
                + ", TKT10001	Johdatus tietojenkäsittelytieteeseen	5\n"
                + ", MAT11001	Johdatus yliopistomatematiikkaan	5\n"
                + ", MAT11002	Lineaarialgebra ja matriislaskenta 1	5\n"
                + ", TKT10002	Ohjelmoinnin perusteet	5\n"
                + ", TKT10003	Ohjelmoinnin jatkokurssi	5\n"
                + ", TKT10004	Tietokantojen perusteet	5\n"
                + ", TKT10005	Tietokoneen toiminta	5\n"
                + "]", dbconnection.getAllCourses().toString());

    }

    public void showAvailableCoursesWorks() {

    }

    public void showMyCoursesWorks() throws SQLException {
        id = 1;
        userId = 1;
        courseId = "MAT11002";
        functionality.addUserCourse(id, userId, courseId);
        assertEquals("[MAT11002]", functionality.showMyCourses(userId));

    }

    public void addUserCourseWorks() throws SQLException {
        id = 1;
        userId = 1;
        courseId = "TKT10002";
        functionality.addUserCourse(id, userId, courseId);
        assertEquals("[TKT10002]", functionality.showMyCourses(userId));

    }

    public void showACourseWorks() throws SQLException {
        id = 1;
        userId = 1;
        courseId = "TKT10002";
        functionality.addUserCourse(id, userId, courseId);
        assertEquals("TKT10002", functionality.showACourse(id));

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
