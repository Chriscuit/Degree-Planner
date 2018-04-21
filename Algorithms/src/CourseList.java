import java.util.ArrayList;

public class CourseList extends ArrayList<Course> {

    private int totalHours;
    private int totalDifficulty;
    private int numCourses;

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

    public int getTotalDifficulty() {
        return totalDifficulty;
    }

    public void setTotalDifficulty(int totalDifficulty) {
        this.totalDifficulty = totalDifficulty;
    }

    public int getNumCourses() {
        return numCourses;
    }

    public void setNumCourses(int numCourses) {
        this.numCourses = numCourses;
    }

    @Override
    public boolean add(Course course) {
        totalHours += course.getHours();
        totalDifficulty += course.getDifficulty();
        numCourses = this.size() + 1;
        return super.add(course);
    }
}
