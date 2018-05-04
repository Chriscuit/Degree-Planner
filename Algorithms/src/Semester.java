import java.util.ArrayList;
import java.util.List;

public class Semester {

    private static int numSemesters = 0;

    private int name;
    private List<Course> list;
    private int totalDifficulty;
    private int totalHours;

    Semester() {
        list = new ArrayList<>();
        name = numSemesters;
        totalDifficulty = 0;
        totalHours = 0;
        numSemesters++;
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

    public int getScore() { return totalDifficulty+totalHours; }

    public List<Course> getList() {
        return this.list;
    }

    public int getName() {
        return name;
    }
}
