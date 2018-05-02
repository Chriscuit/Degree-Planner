import java.util.List;
import java.util.Objects;

public class Course {

    private String name;
    private int hours;
    private int difficulty;
    private List<String> prereqs;
    private List<String> coreqs;
    private List<String> postCourses;
    private int maxDepth = 0;

    // TODO: implement these puppies for the algo to work
    private int lowerBound;
    private int upperBound;
    private int lastestPrereqPlacement;
    private int semesterPlacement;

    Course(String name, int hours, int difficulty, List<String> prereqs, List<String> coreqs) {
        setName(name);
        setHours(hours);
        setDifficulty(difficulty);
        setPrereqs(prereqs);
        setCoreqs(coreqs);
    }

    Course(JSONcourse jcourse) {
        setName(jcourse.getTitle());
        setHours(jcourse.getHours());
        setDifficulty(jcourse.getDifficulty());
        setPrereqs(jcourse.getPrerequisites());
        setCoreqs(jcourse.getCorequisites());
    }

    public void setMaxDepth(int depth) {
        this.maxDepth = Integer.max(depth, this.maxDepth);
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

    private void setCoreqs(List<String> coreqs) {
        this.coreqs = coreqs;
    }

    public List<String> getCoreqs() {
        return coreqs;
    }

    public void setPostCourses(List<String> list) {
        this.postCourses = list;
    }


    public int getSemesterPlacement() {
        return semesterPlacement;
    }

    public void setSemesterPlacement(int semesterPlacement) {
        this.semesterPlacement = semesterPlacement;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public int getLastestPrereqPlacement() {
        return lastestPrereqPlacement;
    }

    public void setLastestPrereqPlacement(int lastestPrereqPlacement) {
        this.lastestPrereqPlacement = lastestPrereqPlacement;
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
