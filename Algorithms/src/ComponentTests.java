import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ComponentTests {

    Driver driver;
    int varianceBound = 5;

    /*
    * between the 6 developed tests, we are covering every conditional in the code
    */

    String basePath = "/Users/christophergill/Downloads/Degree-Planner/";
    String test1Path = "TEST1_Software_Comm_NoCredit_8sem.json";
    String test2Path = "TEST2_Software_Comm_SomeCredit_8sem.json";
    String test3Path = "TEST3_Software_Comm_Year1.5_5sem.json";
    String test4Path = "TEST4_Power_Comm_NoCredit_8sem.json";
    String test5Path = "TEST5_Power_Comm_SomeCredit_7sem.json";
    String test6Path = "TEST6_EmptySchedule.json";

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

    @Test
    public void test6DifficultyBalanceTest() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {

        FullPlan fp = driver.run(basePath + test6Path);

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

    @Test
    public void test6HoursInvariant() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        FullPlan fp = driver.run(basePath + test6Path);

        int desiredHours = fp.getUser().getUserCourseList().getTotalHours();

        int scheduledHours = fp.getTotalHours() - fp.getNumFillerHours();

        assertEquals(desiredHours, scheduledHours);
    }

    /*
     * Makes sure that every course scheduled comes after its prereqs, after or with its coreqs,
     * before its reversePrereqs, and before or with is reverseCoreqs
     */

    @Test
    public void test1OrderInvariant() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        FullPlan fp = driver.run(basePath + test1Path);

        List<Course> scheduledCourses = fp.getUser().getUserCourseList().getList();

        HashMap<String, Course> strToCourse = setStrToCourseMap(scheduledCourses);

        verifyLocalOrder(scheduledCourses, strToCourse);
    }

    @Test
    public void test2OrderInvariant() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        FullPlan fp = driver.run(basePath + test2Path);

        List<Course> scheduledCourses = fp.getUser().getUserCourseList().getList();

        HashMap<String, Course> strToCourse = setStrToCourseMap(scheduledCourses);

        verifyLocalOrder(scheduledCourses, strToCourse);
    }

    @Test
    public void test3OrderInvariant() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        FullPlan fp = driver.run(basePath + test3Path);

        List<Course> scheduledCourses = fp.getUser().getUserCourseList().getList();

        HashMap<String, Course> strToCourse = setStrToCourseMap(scheduledCourses);

        verifyLocalOrder(scheduledCourses, strToCourse);
    }

    @Test
    public void test4OrderInvariant() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        FullPlan fp = driver.run(basePath + test4Path);

        List<Course> scheduledCourses = fp.getUser().getUserCourseList().getList();

        HashMap<String, Course> strToCourse = setStrToCourseMap(scheduledCourses);

        verifyLocalOrder(scheduledCourses, strToCourse);
    }

    @Test
    public void test5OrderInvariant() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        FullPlan fp = driver.run(basePath + test5Path);

        List<Course> scheduledCourses = fp.getUser().getUserCourseList().getList();

        HashMap<String, Course> strToCourse = setStrToCourseMap(scheduledCourses);

        verifyLocalOrder(scheduledCourses, strToCourse);
    }

    @Test
    public void test6OrderInvariant() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        FullPlan fp = driver.run(basePath + test6Path);

        List<Course> scheduledCourses = fp.getUser().getUserCourseList().getList();

        HashMap<String, Course> strToCourse = setStrToCourseMap(scheduledCourses);

        verifyLocalOrder(scheduledCourses, strToCourse);
    }


    private HashMap<String, Course> setStrToCourseMap(List<Course> cL) {
        HashMap<String, Course> strToCourse = new HashMap<>();

        for (Course c : cL) {
            strToCourse.put(c.getName(), c);
        }
        return strToCourse;
    }

    private void verifyLocalOrder(List<Course> scheduledCourses, HashMap<String, Course> strToCourse) {
        for (Course course : scheduledCourses) {
            for (String prereq : course.getPrereqs()) {
                Course cPrereq = strToCourse.get(prereq);
                if (scheduledCourses.contains(cPrereq))
                    assertTrue(course.getSemesterPlacement() > cPrereq.getSemesterPlacement());
            }
            for (String coreq : course.getCoreqs()) {
                Course cCoreq = strToCourse.get(coreq);
                if (scheduledCourses.contains(cCoreq))
                    assertTrue(course.getSemesterPlacement() >= cCoreq.getSemesterPlacement());
            }
            for (String rPrereq : course.getrPrereqs()) {
                Course crPrereq = strToCourse.get(rPrereq);
                if (scheduledCourses.contains(crPrereq))
                    assertTrue(course.getSemesterPlacement() < crPrereq.getSemesterPlacement());
            }
            for (String rCoreq : course.getrCoreqs()) {
                Course crCoreq = strToCourse.get(rCoreq);
                if (scheduledCourses.contains(crCoreq))
                    assertTrue(course.getSemesterPlacement() <= crCoreq.getSemesterPlacement());
            }
        }
    }
}
