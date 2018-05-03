import java.util.*;

public class ScheduleOps {

    // TODO: implement preBFS on reverse Graph to get max depth for each course. Do it for each leaf node (root in reverse) and set course depth to frontier level
    // TODO: handle coreqs and post-co-reqs

    private final int vertices;
    private CourseList courseList;
    private List<Course> sortedList;
    private HashMap<String, Course> strToCourse;
    private User user;
    private FullPlan fullPlan;

    ScheduleOps(CourseList courseList, User user) {
        this.courseList = courseList;
        this.vertices = courseList.size();
        this.user = user;
        this.fullPlan = new FullPlan(user.getNumSemesters());
        setStrToCourse();
        setAllMaxDepths();
        setSortedList();
        setInitBounds();
        initFullPlan();
        optimizeFullPlan();
    }

    public User getUser() {
        return this.user;
    }
    public CourseList getCourseList() {
        return this.courseList;
    }

    private void setAllMaxDepths() {

        for (Course course : courseList.getList()) {
            List<String> rCoreq = course.getrCoreqs();
            List<String> rPrereq = course.getrPrereqs();

            if (rPrereq.isEmpty()) {
                course.setMaxDepth(0);
                preBFS(course);
            }
        }
    }

    private void preBFS(Course course) {

        int baseDepth = course.getMaxDepth();

        for (String coreq : course.getCoreqs()) {
            Course cCoreq = C(coreq);
            cCoreq.setMaxDepth(baseDepth);
        }
        for (String prereq : course.getPrereqs()) {
            Course cPrereq = C(prereq);
            cPrereq.setMaxDepth(baseDepth + 1);
            preBFS(cPrereq);
        }
    }

    private Course C(String course) {
        return strToCourse.get(course);
    }

    private void setInitBounds() {

        for (Course c : courseList.getList()) {
            c.setLowerBound(0);
        }
        for (Course c : courseList.getList()) {
            c.setUpperBound(user.getNumSemesters() - c.getMaxDepth() - 1);
        }
    }

    private void setSortedList() {
        this.sortedList = new ArrayList<>(courseList.getList());
        sortedList.sort(Comparator.comparingInt(Course::getMaxDepth));
        Collections.reverse(sortedList);
    }

    private void setStrToCourse() {

        strToCourse = new HashMap<>();

        for (Course c : courseList.getList()) {
            strToCourse.put(c.getName(), c);
        }
    }

    // TODO: write notify functon for when I assign courses to semsters
    private void initFullPlan() {

        int lastSem = fullPlan.getSize() - 1;

        // basics
        hardcodeCourse("M408C", 0);
        hardcodeCourse("M408D",C("M408C").getSemesterPlacement()+1);
        hardcodeCourse("EE302", 0);
        hardcodeCourse("EE306", 0);
        hardcodeCourse("EE319K", 1);
        hardcodeCourse("EE364D", lastSem-1);
        hardcodeCourse("EE364E", lastSem-1);
        hardcodeCourse("EE464K", lastSem);
        hardcodeCourse("EE464R", lastSem);
        hardcodeCourse("EE464S", lastSem);
        hardcodeCourse("EE464H", lastSem);
    }

    private void hardcodeCourse(String courseName, int targetSem) {
        if (courseList.contains(courseName)) {
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

        if (lowerBound > upperBound) {
            System.out.println("fuck me");
        }

        List<Semester> possibleSems = new ArrayList<>();

        for (int i = lowerBound; i <= upperBound; i++) {
            possibleSems.add(fullPlan.getSem(i));
        }

        possibleSems.sort(Comparator.comparingInt(Semester::getTotalDifficulty));

        return possibleSems.get(0).getName();
    }
}