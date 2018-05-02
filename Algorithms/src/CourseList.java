import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseList {

    private List<Course> list;
    private int totalDifficulty;
    private int totalHours;

    CourseList() {
        this.list = new ArrayList<>();
        totalDifficulty = 0;
        totalHours = 0;
    }

    public void add(Course course) {
        this.list.add(course);
        totalDifficulty += course.getDifficulty();
        totalHours += course.getHours();
    }

    public int size() {
        return list.size();
    }

    public int getTotalDifficulty() {
        return totalDifficulty;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public List<Course> getList() {
        return this.list;
    }

    public void caclulatePostCourses() {

        HashMap<String, List<String>> map = new HashMap<>();

        for (Course course : getList()) {
            for (String prereq : course.getPrereqs()) {

                List<String> postCourseStrings = new ArrayList<>();
                if (map.containsKey(prereq)) {
                    postCourseStrings = map.get(prereq);
                    postCourseStrings.add(course.getName());
                    map.put(prereq, postCourseStrings);
                } else {
                    postCourseStrings.add(course.getName());
                    map.put(prereq, postCourseStrings);
                }
            }
        }

        for (Course course : getList()) {
            course.setPostCourses(map.get(course.getName()));
        }
    }

    public Boolean contains(String courseName) {

        for (Course c : list) {
            if (c.getName().equals(courseName)) return true;
        }

        return false;
    }

    public void errorCheck() throws InvalidCoursesJsonException {
        for (Course c : list) {
            for (String str : c.getPrereqs()) {
                if (!contains(str)) {
                    throw new InvalidCoursesJsonException(str);
                }
            }
        }
    }

    public void finishedList() throws InvalidCoursesJsonException {
        caclulatePostCourses();
        errorCheck();
    }

    public class InvalidCoursesJsonException extends Exception {

        public InvalidCoursesJsonException(String message){
            super(message);
        }

    }
}
