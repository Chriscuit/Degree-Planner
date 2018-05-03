import java.util.HashMap;
import java.util.List;

public class User {

    private int numSemesters;
    private List<String> userCourseStr;
    private CourseList userCourseList;
    private CourseList fullCourseList;
    private HashMap<String, Course> strToCourse;

    User(JsonUserData jsonUserData, CourseList fullCourseList) {
        this.fullCourseList = fullCourseList;
        this.userCourseStr = jsonUserData.getCourses();
        this.numSemesters = jsonUserData.getNumSemesters();
        setStrToCourse();
        initUserCoursesList();
    }

    public int getNumSemesters() {
        return numSemesters;
    }

    private void setStrToCourse() {

        strToCourse = new HashMap<>();

        for (Course c : fullCourseList.getList()) {
            strToCourse.put(c.getName(), c);
        }
    }

    private void initUserCoursesList() {

        userCourseList = new CourseList();
        for (String course : userCourseStr) {
            userCourseList.add(strToCourse.get(course));
        }
    }

    public CourseList getUserCourseList() {
        return userCourseList;
    }

    public CourseList getFullCourseList() {
        return fullCourseList;
    }
}
