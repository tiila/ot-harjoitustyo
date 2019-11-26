/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import studytracker.db.DatabaseConnection;

/**
 *
 * @author dell
 */
public class StudyTrackerFunctionalityTest {

    DatabaseConnection dbconnection;

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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
