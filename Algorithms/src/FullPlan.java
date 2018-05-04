import java.util.ArrayList;
import java.util.List;

public class FullPlan {

    private List<Semester> semList;

    public FullPlan(int numSemester) {
        semList = new ArrayList<>();
        for(int i = 0; i < numSemester; i++) {
            semList.add(new Semester(this));
        }
    }

    public Semester getSem(int i) {
        return semList.get(i);
    }

    public int getSize() {
        return semList.size();
    }

    public int getNumSem() { return semList.size()-1; }

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
}
