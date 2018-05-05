import java.util.ArrayList;
import java.util.List;

public class FullPlan {

    private List<Semester> semList;
    private User user;
    private int numFillers = 0;

    public FullPlan(User user) {
        this.user = user;
        int numSemester = user.getNumSemesters();
        semList = new ArrayList<>();
        for(int i = 0; i < numSemester; i++) {
            semList.add(new Semester(this));
        }
    }

    public FullPlan(int numSem) {
        this.user = null;
        int numSemester = numSem;
        semList = new ArrayList<>();
        for(int i = 0; i < numSem; i++) {
            semList.add(new Semester(this));
        }
    }

    public User getUser() {
        return user;
    }

    public Semester getSem(int i) {
        return semList.get(i);
    }

    public int getSize() {
        return semList.size();
    }

    public List<Semester> getSemList() {
        return semList;
    }

    public int getTotalHours() {

        int total = 0;

        for (Semester sem : semList) {
            total += sem.getTotalHours();
        }

        return total;
    }

    public int getDiffVariance() {

        int minDiff = Integer.MAX_VALUE;
        int maxDiff = 0;

        for (Semester sem : semList) {
            minDiff = Integer.min(minDiff, sem.getTotalDifficulty());
            maxDiff = Integer.max(maxDiff, sem.getTotalDifficulty());
        }

        return maxDiff - minDiff;
    }

    public void incremenetFillers() {
        this.numFillers++;
    }

    public int getNumFillers() {
        return numFillers;
    }

    public int getNumFillerHours() {
        return numFillers * 3;
    }

    public int getTotalDifficulty() {

        int total = 0;

        for (Semester sem : semList) {
            total += sem.getTotalDifficulty();
        }

        return total;
    }
}
