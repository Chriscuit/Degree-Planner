/**
 * Created by Ali Kedwaii on 5/4/2018.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class PreviousCoursesTests {

    public static ChromeDriver driver;

    public static WebElement departmentSelect;
    public static WebElement searchBar;
    public static WebElement searchClear;
    public static WebElement searchList;
    public static WebElement nextButton;

    @BeforeEach
    public void SetUp(){

        //set up driver and get page
        System.setProperty("webdriver.chrome.driver",
                "C:\\workspace\\Selenium\\chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        ops.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        driver = new ChromeDriver(ops);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("file:///C:/workspace/DegreePlanner/Degree-Planner/Frontend/previousCoursesSelection.html");

        //find all web elements
        departmentSelect = driver.findElement(By.id("departmentPicker"));
        searchBar = driver.findElement(By.id("searchBox"));
        searchClear = driver.findElement(By.id("clear"));
        searchList = driver.findElement(By.id("searchTable"));
        nextButton = driver.findElement(By.id("displayTimeDifficulty"));
    }

    @AfterEach
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void EESelect(){
        WebElement course1 = driver.findElement(By.xpath("//*[@id=\"searchTable\"]/div[6]"));
        course1.click();
        WebElement course2 = driver.findElement(By.xpath("//*[@id=\"searchTable\"]/div[7]"));
        course2.click();
        WebElement course3 = driver.findElement(By.xpath("//*[@id=\"searchTable\"]/div[12]"));
        course3.click();
        WebElement course4 = driver.findElement(By.xpath("//*[@id=\"searchTable\"]/div[13]"));
        course4.click();

        WebElement selectedCourse1 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[1]"));
        WebElement selectedCourse2 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[2]"));
        WebElement selectedCourse3 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[3]"));
        WebElement selectedCourse4 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[4]"));

        Assertions.assertTrue(selectedCourse1.getText().equals("EE302"));
        Assertions.assertTrue(selectedCourse2.getText().equals("EE306"));
        Assertions.assertTrue(selectedCourse3.getText().equals("EE319K"));
        Assertions.assertTrue(selectedCourse4.getText().equals("EE411"));
    }

    @Test
    public void multipleDeptSelect(){
        WebElement course1 = driver.findElement(By.xpath("//*[@id=\"searchTable\"]/div[6]")); //EE302
        course1.click();
        WebElement course2 = driver.findElement(By.xpath("//*[@id=\"searchTable\"]/div[7]")); //EE306
        course2.click();

        Select deptSelect = new Select(departmentSelect);
        deptSelect.selectByVisibleText("Mathematics");

        WebElement course3 = driver.findElement(By.xpath("//*[@id=\"searchTable\"]/div[1]"));
        course3.click();

        deptSelect.selectByVisibleText("Physics");
        WebElement course4 = driver.findElement(By.xpath("//*[@id=\"searchTable\"]/div[69]"));
        course4.click();


        WebElement selectedCourse1 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[1]"));
        WebElement selectedCourse2 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[2]"));
        WebElement selectedCourse3 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[3]"));
        WebElement selectedCourse4 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[4]"));

        Assertions.assertTrue(selectedCourse1.getText().equals("M408C"));
        Assertions.assertTrue(selectedCourse2.getText().equals("EE302"));
        Assertions.assertTrue(selectedCourse3.getText().equals("EE306"));
        Assertions.assertTrue(selectedCourse4.getText().equals("PHY303K"));
    }

    @Test
    public void EEDeselect(){
        WebElement course1 = driver.findElement(By.xpath("//*[@id=\"searchTable\"]/div[6]"));
        course1.click();
        WebElement course2 = driver.findElement(By.xpath("//*[@id=\"searchTable\"]/div[7]"));
        course2.click();
        WebElement course3 = driver.findElement(By.xpath("//*[@id=\"searchTable\"]/div[12]"));
        course3.click();
        WebElement course4 = driver.findElement(By.xpath("//*[@id=\"searchTable\"]/div[13]"));
        course4.click();

        WebElement selectedCourse1 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[1]"));
        WebElement selectedCourse2 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[2]"));
        WebElement selectedCourse3 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[3]"));
        WebElement selectedCourse4 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[4]"));

        Assertions.assertTrue(selectedCourse1.getText().equals("EE302"));
        Assertions.assertTrue(selectedCourse2.getText().equals("EE306"));
        Assertions.assertTrue(selectedCourse3.getText().equals("EE319K"));
        Assertions.assertTrue(selectedCourse4.getText().equals("EE411"));

        course1.click();
        course3.click();

        selectedCourse1 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[1]"));
        selectedCourse2 = driver.findElement(By.xpath("//*[@id=\"selectedCourses\"]/div[2]"));

        Assertions.assertTrue(selectedCourse1.getText().equals("EE306"));
        Assertions.assertTrue(selectedCourse2.getText().equals("EE411"));
    }
}
