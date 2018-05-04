import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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
    public void reinitDriver() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        driver = new Driver();
    }

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



}
