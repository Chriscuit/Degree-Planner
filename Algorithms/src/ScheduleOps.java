import java.util.*;

public class ScheduleOps {

    // TODO: implement depthBFS on reverse Graph to get max depth for each course. Do it for each leaf node (root in reverse) and set course depth to frontier level
    // TODO: handle coreqs and post-co-reqs

    private final int vertices;
    private CourseList fullCourseList;
    private CourseList userCourseList;
    private List<Course> sortedList;
    private HashMap<String, Course> strToCourse;
    private User user;
    private FullPlan fullPlan;

    ScheduleOps(User user) {
        this.fullCourseList = user.getFullCourseList();
        this.userCourseList = user.getUserCourseList();
        this.vertices = userCourseList.size();
        this.user = user;
        this.fullPlan = new FullPlan(user.getNumSemesters());
        setStrToCourse();
        setAllMaxDepths();
        setSortedList();
        setInitBounds();
        initFullPlan();
        optimizeFullPlan();
        filler();
    }

    public User getUser() {
        return this.user;
    }
    public CourseList getFullCourseList() {
        return this.fullCourseList;
    }

    private void setAllMaxDepths() {

        for (Course course : userCourseList.getList()) {
            List<String> rPrereq = course.getrPrereqs();

            if (rPrereq.isEmpty()) {
                course.setMaxDepth(0);
                depthBFS(course);
            }
        }
    }

    private void depthBFS(Course course) {

        int baseDepth = course.getMaxDepth();

        for (String coreq : course.getCoreqs()) {
            Course cCoreq = C(coreq);
            cCoreq.setMaxDepth(baseDepth);
        }
        for (String prereq : course.getPrereqs()) {
            Course cPrereq = C(prereq);
            cPrereq.setMaxDepth(baseDepth + 1);
            depthBFS(cPrereq);
        }
    }

    private Course C(String course) {
        return strToCourse.get(course);
    }

    private void setInitBounds() {

        for (Course c : userCourseList.getList()) {
            c.setLowerBound(0);
        }
        for (Course c : userCourseList.getList()) {
            c.setUpperBound(user.getNumSemesters() - c.getMaxDepth() - 1);
        }
    }

    private void setSortedList() {
        this.sortedList = new ArrayList<>(userCourseList.getList());
        sortedList.sort(Comparator.comparingInt(Course::getMaxDepth));
        Collections.reverse(sortedList);
    }

    private void setStrToCourse() {

        strToCourse = new HashMap<>();

        for (Course c : fullCourseList.getList()) {
            strToCourse.put(c.getName(), c);
        }
    }

    // TODO: write notify functon for when I assign courses to semsters
    private void initFullPlan() {

        int lastSem = fullPlan.getSize() - 1;

        hardcodeCourse("RHE306", C("RHE306").getLowerBound());
        hardcodeCourse("E316K", C("E316K").getLowerBound());
        hardcodeCourse("M408C", 0);
        hardcodeCourse("M408D",C("M408D").getLowerBound());
        hardcodeCourse("EE302", 0);
        hardcodeCourse("EE306", 0);
        hardcodeCourse("EE319K", 1);
        hardcodeCourse("EE364D", lastSem-1);
        hardcodeCourse("EE364E", lastSem-1);
        hardcodeCourse("EE464K", lastSem);
        hardcodeCourse("EE464R", lastSem);
        hardcodeCourse("EE464S", lastSem);
        hardcodeCourse("EE464H", lastSem);
        hardcodeCourse("PHY303K", C("PHY303K").getLowerBound());
        hardcodeCourse("PHY103M", C("PHY103M").getLowerBound());
        hardcodeCourse("PHY303L", C("PHY303L").getLowerBound());
        hardcodeCourse("PHY103N", C("PHY103N").getLowerBound());
        hardcodeCourse("UGS", C("UGS").getLowerBound());
    }

    private void hardcodeCourse(String courseName, int targetSem) {
        if (userCourseList.contains(courseName)) {
            Course course = C(courseName);
            fullPlan.getSem(targetSem).add(course);
            sortedList.remove(course);
            course.setSemesterPlacement(targetSem);
            updateConnections(course);
        }
    }

    private void updateConnections(Course c) {

        int sem = c.getSemesterPlacement();

        for (String prereq : c.getPrereqs()) {
            C(prereq).setUpperBound(sem - 1);
        }
        for (String coreq : c.getCoreqs()) {
            C(coreq).setUpperBound(sem);
        }
        for (String rPrereq : c.getrPrereqs()) {
            C(rPrereq).setLowerBound(sem + 1);
        }
        for (String rCoreq : c.getrCoreqs()) {
            C(rCoreq).setLowerBound(sem);
        }
    }

    private void optimizeFullPlan() {

        int optSem;

        while (!sortedList.isEmpty()) {

            Course course = sortedList.get(0);
            optSem = findLowestDiffSem(course.getLowerBound(), course.getUpperBound(), course);
            fullPlan.getSem(optSem).add(course);
            sortedList.remove(course);
            course.setSemesterPlacement(optSem);
            updateConnections(course);
        }
    }

    private int findLowestDiffSem(int lowerBound, int upperBound, Course course) {

        // TODO: find bug in dis bich

        if (lowerBound > upperBound) {
            System.out.println("fuck me");
        }

        List<Semester> possibleSems = new ArrayList<>();

        for (int i = lowerBound; i <= upperBound; i++) {
            possibleSems.add(fullPlan.getSem(i));
        }

        possibleSems.sort(Comparator.comparingInt(Semester::getTotalDifficulty));

        int optDiff = possibleSems.get(0).getTotalDifficulty();

        Collections.reverse(possibleSems);

        for (int j = 0; j < possibleSems.size(); j++) {
            if (possibleSems.get(j).getTotalDifficulty() > optDiff) {
                possibleSems.remove(j);
            }
        }

        possibleSems.sort(Comparator.comparingInt(Semester::getName));

        return possibleSems.get(0).getName();
    }

    private void filler() {

        for (Semester sem : fullPlan.getSemList()) {
            if (sem.getTotalHours() < 12) {
                sem.add(new Course("FILL", 3, 1, new ArrayList<>(), new ArrayList<>()));
            }
        }
        for (Semester sem : fullPlan.getSemList()) {
            if (sem.getTotalHours() < 12) {
                filler();
            }
        }
    }
}