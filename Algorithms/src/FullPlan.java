import java.util.ArrayList;
import java.util.List;

public class FullPlan {

    private List<Semester> semList;

    public FullPlan(int numSemester) {
        semList = new ArrayList<>();
        for(int i = 0; i < numSemester; i++) {
            semList.add(new Semester());
        }
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
}
