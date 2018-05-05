import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class UnitTests {

    Driver driver;

    String basePath = "/Users/christophergill/Downloads/Degree-Planner/";
    String test1Path = "TEST1_Software_Comm_NoCredit_8sem.json";

    @Before
    public void reinitDriver() {
        driver = new Driver();
    }

    /*
     * Tests various methods of CourseList
     */

    @Test
    public void testCourseListContains() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {

        FullPlan fp = driver.run(basePath + test1Path);

        CourseList courseList = fp.getUser().getUserCourseList();
        assertTrue(courseList.contains("EE364D"));
    }

    @Test
    public void testCourseListAdd() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {

        FullPlan fp = driver.run(basePath + test1Path);

        CourseList courseList = fp.getUser().getUserCourseList();
        courseList.add(new Course("test", 1, 1, null, null));
        assertTrue(courseList.contains("test"));
    }

    @Test
    public void testCourseListCalculateRerversePreCo() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {

        FullPlan fp = driver.run(basePath + test1Path);

        List<String> test1PR = new ArrayList<>();
        test1PR.add("test2");

        List<String> test2CR = new ArrayList<>();
        test2CR.add("test3");

        Course test1 = new Course("test1", 1, 1, test1PR, new ArrayList<String>());
        Course test2 = new Course("test2", 1, 1, new ArrayList<String>(), test2CR);
        Course test3 = new Course("test3", 1, 1, new ArrayList<String>(), new ArrayList<String>());

        CourseList courseList = fp.getUser().getUserCourseList();

        courseList.addPassCourse(test1);
        courseList.addPassCourse(test2);
        courseList.addPassCourse(test3);

        courseList.calculateReversePreCo();

        assertTrue(test2.getrPrereqs().contains("test1"));
        assertTrue(test3.getrCoreqs().contains("test2"));
    }

    /*
    * Tests various methods of Semester
    */

    @Test
    public void testSemesterContains() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {

        FullPlan fp = driver.run(basePath + test1Path);

        assertTrue(fp.getSem(0).contains("EE302"));
    }

    @Test
    public void testSemesterAddAndGetDiff() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {

        FullPlan fp = driver.run(basePath + test1Path);


        Semester sem = new Semester(0);
        Course test = new Course("test", 1, 11, new ArrayList<String>(), new ArrayList<String>());

        sem.add(test);

        assertTrue(sem.contains("test"));
        assertEquals(sem.getTotalDifficulty(), 11);
    }

    /*
     * Tests various methods of FullPlan
     */



    private HashMap<String, Course> setStrToCourseMap(List<Course> cL) {
        HashMap<String, Course> strToCourse = new HashMap<>();

        for (Course c : cL) {
            strToCourse.put(c.getName(), c);
        }
        return strToCourse;
    }
}
