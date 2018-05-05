import java.util.ArrayList;
import java.util.List;

public class Semester {

//    private static int numSemesters = 0;

    private int name;
    private List<Course> list;
    private int totalDifficulty;
    private int totalHours;

    Semester(int name) {
        this.list = new ArrayList<>();
        this.name = name;
        this.totalDifficulty = 0;
        this.totalHours = 0;
    }

    Semester(FullPlan fp) {
        list = new ArrayList<>();
        name = fp.getSize();
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

    public int getScore() { return totalDifficulty+totalHours; }

    public List<Course> getList() {
        return this.list;
    }

    public int getName() {
        return name;
    }

    public Boolean contains(String name) {
        for (Course c : list) {
            if (c.getName().equals(name)) return true;
        }
        return false;
    }
}
