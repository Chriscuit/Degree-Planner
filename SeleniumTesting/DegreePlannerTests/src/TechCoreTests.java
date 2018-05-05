/**
 * Created by Ali Kedwaii on 5/3/2018.
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


public class TechCoreTests {

    private static ArrayList<String> consoleOut;
    private static ArrayList<String> courseList;

    public static ChromeDriver driver;

    public static WebElement primaryCoreElement;
    public static WebElement secondaryCoreElement;
    public static WebElement primaryCoreButton;

    public static WebElement primaryChoice1;
    public static WebElement primaryChoice2;
    public static WebElement primaryChoice3;
    public static WebElement electivesButton;

    public static WebElement electives;
    public static WebElement secondaryCoreButton;

    public static WebElement secondaryChoice1;
    public static WebElement secondaryChoice2;
    public static WebElement secondaryChoice3;

    public static WebElement nextButton;

    @BeforeEach
    public void SetUp(){
        consoleOut = new ArrayList<>();
        courseList = new ArrayList<>();

        //set up driver and get page
        System.setProperty("webdriver.chrome.driver",
                "C:\\workspace\\Selenium\\chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        ops.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        driver = new ChromeDriver(ops);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("file:///C:/workspace/DegreePlanner/Degree-Planner/Frontend/techCoreSelection.html");

        //find all web elements
        primaryCoreElement = driver.findElement(By.id("primaryCore"));
        secondaryCoreElement = driver.findElement(By.id("secondaryCore"));
        primaryCoreButton = driver.findElement(By.id("primaryCoreRequirementsButton"));

        primaryChoice1 = driver.findElement(By.id("primaryChoiceSelect1"));
        primaryChoice2 = driver.findElement(By.id("primaryChoiceSelect2"));
        primaryChoice3 = driver.findElement(By.id("primaryChoiceSelect3"));
        electivesButton = driver.findElement(By.id("displayElectivesButton"));

        electives = driver.findElement(By.id("primaryElectives"));
        secondaryCoreButton = driver.findElement(By.id("secondaryCoreRequirementsButton"));

        secondaryChoice1 = driver.findElement(By.id("secondaryChoiceSelect1"));
        secondaryChoice2 = driver.findElement(By.id("secondaryChoiceSelect2"));
        secondaryChoice3 = driver.findElement(By.id("secondaryChoiceSelect3"));

        nextButton = driver.findElement(By.id("nextButton"));
    }

    @AfterEach
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void primarySelectTest(){
        Select primarySelect = new Select(primaryCoreElement);
        primarySelect.selectByVisibleText("Computer Architecture and Embedded Systems");
        Select secondarySelect = new Select(secondaryCoreElement);
        secondarySelect.selectByVisibleText("Software Engineering and Design");
        primaryCoreButton.click();

        Assertions.assertFalse(primaryChoice1.isDisplayed());
        Assertions.assertFalse(primaryChoice2.isDisplayed());
        Assertions.assertFalse(primaryChoice3.isDisplayed());

        primarySelect.selectByVisibleText("Energy Systems and Renewable Energy");
        primaryCoreButton.click();

        Assertions.assertTrue(primaryChoice1.isDisplayed());
        Assertions.assertFalse(primaryChoice2.isDisplayed());
        Assertions.assertFalse(primaryChoice3.isDisplayed());

        primarySelect.selectByVisibleText("Communications, Signal Processing, Networks and Systems");
        primaryCoreButton.click();

        Assertions.assertTrue(primaryChoice1.isDisplayed());
        Assertions.assertTrue(primaryChoice2.isDisplayed());
        Assertions.assertTrue(primaryChoice3.isDisplayed());

        primarySelect.selectByVisibleText("Fields, Waves and Electromagnetic Systems");
        primaryCoreButton.click();

        Assertions.assertTrue(primaryChoice1.isDisplayed());
        Assertions.assertTrue(primaryChoice2.isDisplayed());
        Assertions.assertFalse(primaryChoice3.isDisplayed());
    }

    @Test
    public void techCoreChoiceTest(){
        Select primarySelect = new Select(primaryCoreElement);
        primarySelect.selectByVisibleText("Energy Systems and Renewable Energy");
        Select secondarySelect = new Select(secondaryCoreElement);
        secondarySelect.selectByVisibleText("Computer Architecture and Embedded Systems");
        primaryCoreButton.click();

        //pick primary classes
        Select primaryChoice1Select = new Select(primaryChoice1);
        primaryChoice1Select.selectByVisibleText("EE 369: Power Systems Engineering");

        electivesButton.click();

        //pick primary electives
        Select electiveSelect = new Select(electives);
        electiveSelect.selectByVisibleText("EE 339: Solid-State Electronic Devices");
        electiveSelect.selectByVisibleText("EE 362Q: Power Quality and Harmonics");
        electiveSelect.selectByVisibleText("EE 362G: Smart Grids");
        //secondaryCoreButton.click();

        Assertions.assertTrue(primarySelect.getFirstSelectedOption().getText().equals("Energy Systems and Renewable Energy"));
        Assertions.assertTrue(secondarySelect.getFirstSelectedOption().getText().equals("Computer Architecture and Embedded Systems"));
    }

    @Test
    public void secondarySelectTest(){
        Select primarySelect = new Select(primaryCoreElement);
        primarySelect.selectByVisibleText("Computer Architecture and Embedded Systems");
        Select secondarySelect = new Select(secondaryCoreElement);
        secondarySelect.selectByVisibleText("Software Engineering and Design");
        primaryCoreButton.click();

        //pick primary electives
        Select electiveSelect = new Select(electives);
        electiveSelect.selectByVisibleText("EE 422C: Software Design & Implementation II");
        electiveSelect.selectByVisibleText("EE 445M: Embedded and Real-Time Systems Laboratory");
        electiveSelect.selectByVisibleText("EE 361C: Multicore Computing");

        Assertions.assertTrue(nextButton.isDisplayed());

        secondarySelect.selectByVisibleText("Nanoelectronics and Nanotechnology");
        primaryCoreButton.click();

        Assertions.assertTrue(nextButton.isDisplayed());

        secondarySelect.selectByVisibleText("Electronics and Integrated Circuits");
        primaryCoreButton.click();

        Assertions.assertTrue(nextButton.isDisplayed());

        secondarySelect.selectByVisibleText("Data Science and Information Processing");
        primaryCoreButton.click();

        Assertions.assertTrue(nextButton.isDisplayed());

        secondarySelect.selectByVisibleText("Energy Systems and Renewable Energy");
        primaryCoreButton.click();

//      Assertions.assertFalse(nextButton.isDisplayed());
        Assertions.assertTrue(secondaryCoreButton.isDisplayed());
        secondaryCoreButton.click();

        Assertions.assertTrue(secondaryChoice1.isDisplayed());
        Assertions.assertFalse(secondaryChoice2.isDisplayed());
        Assertions.assertFalse(secondaryChoice3.isDisplayed());

        secondarySelect.selectByVisibleText("Fields, Waves and Electromagnetic Systems");
        primaryCoreButton.click();
        secondaryCoreButton.click();

        Assertions.assertTrue(secondaryChoice1.isDisplayed());
        Assertions.assertTrue(secondaryChoice2.isDisplayed());
        Assertions.assertFalse(secondaryChoice3.isDisplayed());

        secondarySelect.selectByVisibleText("Communications, Signal Processing, Networks and Systems");
        primaryCoreButton.click();
        secondaryCoreButton.click();

        Assertions.assertTrue(secondaryChoice1.isDisplayed());
        Assertions.assertTrue(secondaryChoice2.isDisplayed());
        Assertions.assertTrue(secondaryChoice3.isDisplayed());
    }

    @Test
    public void alertTest(){
        Select primarySelect = new Select(primaryCoreElement);
        primarySelect.selectByVisibleText("Computer Architecture and Embedded Systems");
        Select secondarySelect = new Select(secondaryCoreElement);
        secondarySelect.selectByVisibleText("Software Engineering and Design");
        primaryCoreButton.click();

        Select electiveSelect = new Select(electives);
        electiveSelect.selectByVisibleText("EE 422C: Software Design & Implementation II");
        electiveSelect.selectByVisibleText("EE 445M: Embedded and Real-Time Systems Laboratory");
        electiveSelect.selectByVisibleText("EE 361C: Multicore Computing");
        electiveSelect.selectByVisibleText("EE 445S: Real-Time Digital Signal Processing Laboratory");
        nextButton.click();
        checkAlert();
    }

    public void checkAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }

    @Test
    public void lessElectivesSelected(){
        Select primarySelect = new Select(primaryCoreElement);
        primarySelect.selectByVisibleText("Software Engineering and Design");
        Select secondarySelect = new Select(secondaryCoreElement);
        secondarySelect.selectByVisibleText("Computer Architecture and Embedded Systems");
        primaryCoreButton.click();

        Select electiveSelect = new Select(electives);
        electiveSelect.selectByVisibleText("EE 360P: Concurrent and Distributed Systems");
        electiveSelect.selectByVisibleText("EE 360T: Software Testing");
        nextButton.click();

        //check console output
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            consoleOut.add(entry.getMessage());
        }

        for (String s : consoleOut) {
            if (s.contains("[") || s.contains(" ")) {
                if (s.contains("[")) {
                    s = s.split("\\[")[1];
                    s = s.split("]")[0];
                    String[] list = s.split("\"");
                    for (String t : list) {
                        if (!t.equals("\\")) {
                            t = t.split("\\\\")[0];
                            if (!t.equals(",")) {
                                courseList.add(t);
                            }
                        }
                    }
                } else if (s.contains("\"")) {
                    s = s.split("\"")[1];
                    if (s.contains(":")) {
                        s = s.split(":")[0];
                    }
                    if (s.contains(" ")) {
                        s = s.split(" ")[0].concat(s.split(" ")[1]);
                        courseList.add(s);
                    }
                }
            }
        }

        Assertions.assertTrue(courseList.contains("EE360C"));
        Assertions.assertTrue(courseList.contains("M325K"));
        Assertions.assertTrue(courseList.contains("EE461L"));
        Assertions.assertTrue(courseList.contains("EE422C"));
        Assertions.assertTrue(courseList.contains("EE360P"));
        Assertions.assertTrue(courseList.contains("EE360T"));
        Assertions.assertTrue(courseList.contains("EE316"));
        Assertions.assertTrue(courseList.contains("EE460N"));
        Assertions.assertTrue(courseList.contains("EE445L"));

        Assertions.assertEquals(courseList.size(), 12);
    }

    @Test
    public void techCoreTest1(){
        //pick tech cores
        Select primarySelect = new Select(primaryCoreElement);
        primarySelect.selectByVisibleText("Energy Systems and Renewable Energy");
        Select secondarySelect = new Select(secondaryCoreElement);
        secondarySelect.selectByVisibleText("Computer Architecture and Embedded Systems");
        primaryCoreButton.click();

        //pick primary classes
        Select primaryChoice1Select = new Select(primaryChoice1);
        primaryChoice1Select.selectByVisibleText("EE 369: Power Systems Engineering");

        electivesButton.click();

        //pick primary electives
        Select electiveSelect = new Select(electives);
        electiveSelect.selectByVisibleText("EE 339: Solid-State Electronic Devices");
        electiveSelect.selectByVisibleText("EE 362Q: Power Quality and Harmonics");
        electiveSelect.selectByVisibleText("EE 362G: Smart Grids");
        //secondaryCoreButton.click();

        //pick secondary classes

        //go to next page
        nextButton.click();

        //check console output
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            consoleOut.add(entry.getMessage());
        }

        for (String s : consoleOut) {
            if (s.contains("[") || s.contains(" ")) {
                if (s.contains("[")) {
                    s = s.split("\\[")[1];
                    s = s.split("]")[0];
                    String[] list = s.split("\"");
                    for (String t : list) {
                        if (!t.equals("\\")) {
                            t = t.split("\\\\")[0];
                            if (!t.equals(",")) {
                                courseList.add(t);
                            }
                        }
                    }
                } else if (s.contains("\"")) {
                    s = s.split("\"")[1];
                    if (s.contains(":")) {
                        s = s.split(":")[0];
                    }
                    if (s.contains(" ")) {
                        s = s.split(" ")[0].concat(s.split(" ")[1]);
                        courseList.add(s);
                    }
                }
            }
        }

        Assertions.assertTrue(courseList.contains("EE369"));
        Assertions.assertTrue(courseList.contains("EE339"));
        Assertions.assertTrue(courseList.contains("EE325"));
        Assertions.assertTrue(courseList.contains("EE462L"));
        Assertions.assertTrue(courseList.contains("EE362K"));
        Assertions.assertTrue(courseList.contains("M427L"));
        Assertions.assertTrue(courseList.contains("EE362Q"));
        Assertions.assertTrue(courseList.contains("EE362G"));
        Assertions.assertTrue(courseList.contains("M325K"));
        Assertions.assertTrue(courseList.contains("EE460N"));
        Assertions.assertTrue(courseList.contains("EE316"));
        Assertions.assertTrue(courseList.contains("EE445L"));
    }

    @Test
    public void techCoreTest2(){
        //pick tech cores
        Select primarySelect = new Select(primaryCoreElement);
        primarySelect.selectByVisibleText("Computer Architecture and Embedded Systems");
        Select secondarySelect = new Select(secondaryCoreElement);
        secondarySelect.selectByVisibleText("Energy Systems and Renewable Energy");
        primaryCoreButton.click();

        //pick primary classes

        //pick primary electives
        Select electiveSelect = new Select(electives);
        electiveSelect.selectByVisibleText("EE 422C: Software Design & Implementation II");
        electiveSelect.selectByVisibleText("EE 445M: Embedded and Real-Time Systems Laboratory");
        electiveSelect.selectByVisibleText("EE 361C: Multicore Computing");
        secondaryCoreButton.click();

        //pick secondary classes
        Select secondaryChoice1Select = new Select(secondaryChoice1);
        secondaryChoice1Select.selectByVisibleText("EE 369: Power Systems Engineering");

        //go to next page
        nextButton.click();

        //check console output
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            consoleOut.add(entry.getMessage());
        }

        for (String s : consoleOut) {
            if (s.contains("[") || s.contains(" ")) {
                if (s.contains("[")) {
                    s = s.split("\\[")[1];
                    s = s.split("]")[0];
                    String[] list = s.split("\"");
                    for (String t : list) {
                        if (!t.equals("\\")) {
                            t = t.split("\\\\")[0];
                            if (!t.equals(",")) {
                                courseList.add(t);
                            }
                        }
                    }
                } else if (s.contains("\"")) {
                    s = s.split("\"")[1];
                    if (s.contains(":")) {
                        s = s.split(":")[0];
                    }
                    if (s.contains(" ")) {
                        s = s.split(" ")[0].concat(s.split(" ")[1]);
                        courseList.add(s);
                    }
                }
            }
        }

        Assertions.assertTrue(courseList.contains("EE369"));
        Assertions.assertTrue(courseList.contains("EE445M"));
        Assertions.assertTrue(courseList.contains("EE325"));
        Assertions.assertTrue(courseList.contains("EE462L"));
        Assertions.assertTrue(courseList.contains("M427L"));
        Assertions.assertTrue(courseList.contains("EE361C"));
        Assertions.assertTrue(courseList.contains("EE422C"));
        Assertions.assertTrue(courseList.contains("M325K"));
        Assertions.assertTrue(courseList.contains("EE460N"));
        Assertions.assertTrue(courseList.contains("EE316"));
        Assertions.assertTrue(courseList.contains("EE445L"));
    }
}


