import java.awt.font.NumericShaper;
import java.util.List;
import java.util.Objects;

public class Course {

    private String name;
    private int hours;
    private int difficulty;
    private List<String> prereqs;
    private List<String> postCourses;
    private Boolean isLeaf;
    private int maxDepth;

    // TODO: implement these puppies for the algo to work
    private int semesterPlacement;
    private int lowerBound;
    private int upperBound;
    private int lastestPrereqPlacement;


    Course(String name, int hours, int difficulty, List<String> prereqs) {
        setName(name);
        setHours(hours);
        setDifficulty(difficulty);
        setPrereqs(prereqs);
        setIsLeaf();
    }

    public void setMaxDepth(int depth) {
        this.maxDepth = depth;
    }

    public int getMaxDepth() {
        return maxDepth;
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

    private void setIsLeaf() {
        this.isLeaf = this.prereqs.isEmpty();
    }

    public void setPostCourses(List<String> list) {
        this.postCourses = list;
    }

    public Boolean isLeaf() {
        return isLeaf;
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
