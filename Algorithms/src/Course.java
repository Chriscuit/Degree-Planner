import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Course {

    private static List<Course> courseList = new ArrayList<Course>();
    private static int totalDifficulty;
    private static int totalHours;
    private static int numCourses;

    private String name;
    private int hours;
    private int difficulty;
    private List<String> prereqs;
    private List<String> postCourses;
    private Boolean isLeaf;

    Course(String name, int hours, int difficulty, List<String> prereqs) {
        setName(name);
        setHours(hours);
        setDifficulty(difficulty);
        setPrereqs(prereqs);
        setIsLeaf();
        updateCourseList();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    private void setHours(int hours) {
        this.hours = hours;
    }

    public int getDifficulty() {
        return difficulty;
    }
    private void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public List<String> getPrereqs() {
        return prereqs;
    }

    public List<String> getPostCourses() {
        return postCourses;
    }

    private void setPrereqs(List<String> prereqs) {
        this.prereqs = prereqs;
    }

    public void updateCourseList() {
        this.courseList.add(this);
        totalDifficulty += this.difficulty;
        totalHours += this.hours;
    }

    public int getNumCourses() {
        return courseList.size();
    }

    public static List<Course> getCourseList() {
        return courseList;
    }

    private void setIsLeaf() {
        this.isLeaf = this.prereqs.isEmpty();
    }

    public Boolean isLeaf() {
        return isLeaf;
    }

    public void caclulatePostCourses() {

        HashMap<String, List<String>> map = new HashMap<>();

        for (Course course : courseList) {
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

        for (Course course : courseList) {
            course.postCourses = map.get(course.getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hours, difficulty, prereqs);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", difficulty=" + difficulty +
                ", prereqs=" + prereqs +
                '}';
    }
}
