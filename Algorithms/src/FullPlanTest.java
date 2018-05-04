import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class FullPlanTest {

    Driver driver;
    int varianceBound = 5;

    String basePath = "/Users/christophergill/Downloads/Degree-Planner/";
    String test1Path = "TEST1_Software_Comm_NoCredit_8sem.json";
    String test2Path = "TEST2_Software_Comm_SomeCredit_8sem.json";
    String test3Path = "TEST3_Software_Comm_Year1.5_5sem.json";
    String test4Path = "TEST4_Power_Comm_NoCredit_8sem.json";
    String test5Path = "TEST5_Power_Comm_SomeCredit_7sem.json";


    @Before
    public void reinitDriver() {
        driver = new Driver();
    }

    /*
     * Makes sure that the difficulties assigned to each semester vary within a predefined bound we
     * consider to be sensible
     */

    @Test
    public void test1DifficultyBalanceTest() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {

        FullPlan fp = driver.run(basePath + test1Path);

        assertTrue(fp.getDiffVariance() <= varianceBound);
    }

    @Test
    public void test2DifficultyBalanceTest() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {

        FullPlan fp = driver.run(basePath + test2Path);

        assertTrue(fp.getDiffVariance() <= varianceBound);
    }

    @Test
    public void test3DifficultyBalanceTest() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {

        FullPlan fp = driver.run(basePath + test3Path);

        assertTrue(fp.getDiffVariance() <= varianceBound);
    }

    @Test
    public void test4DifficultyBalanceTest() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {

        FullPlan fp = driver.run(basePath + test4Path);

        assertTrue(fp.getDiffVariance() <= varianceBound);
    }


    @Test
    public void test5DifficultyBalanceTest() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {

        FullPlan fp = driver.run(basePath + test5Path);

        assertTrue(fp.getDiffVariance() <= varianceBound);
    }


    /*
    * Makes sure that the number of our requested is the same as the number of hours scheduled, with the exception
    * of filler classes that were needed to reach a base of 12 hours
    */

    @Test
    public void test1HoursInvariant() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        FullPlan fp = driver.run(basePath + test1Path);

        int desiredHours = fp.getUser().getUserCourseList().getTotalHours();

        int scheduledHours = fp.getTotalHours() - fp.getNumFillerHours();

        assertEquals(desiredHours, scheduledHours);
    }

    @Test
    public void test2HoursInvariant() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        FullPlan fp = driver.run(basePath + test2Path);

        int desiredHours = fp.getUser().getUserCourseList().getTotalHours();

        int scheduledHours = fp.getTotalHours() - fp.getNumFillerHours();

        assertEquals(desiredHours, scheduledHours);
    }

    @Test
    public void test3HoursInvariant() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        FullPlan fp = driver.run(basePath + test3Path);

        int desiredHours = fp.getUser().getUserCourseList().getTotalHours();

        int scheduledHours = fp.getTotalHours() - fp.getNumFillerHours();

        assertEquals(desiredHours, scheduledHours);
    }

    @Test
    public void test4HoursInvariant() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        FullPlan fp = driver.run(basePath + test4Path);

        int desiredHours = fp.getUser().getUserCourseList().getTotalHours();

        int scheduledHours = fp.getTotalHours() - fp.getNumFillerHours();

        assertEquals(desiredHours, scheduledHours);
    }

    @Test
    public void test5HoursInvariant() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        FullPlan fp = driver.run(basePath + test5Path);

        int desiredHours = fp.getUser().getUserCourseList().getTotalHours();

        int scheduledHours = fp.getTotalHours() - fp.getNumFillerHours();

        assertEquals(desiredHours, scheduledHours);
    }
}
