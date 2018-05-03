import java.util.*;

public class ScheduleOps {

    // TODO: implement preBFS on reverse Graph to get max depth for each course. Do it for each leaf node (root in reverse) and set course depth to frontier level
    // TODO: handle coreqs and post-co-reqs

    private final int vertices;
    private CourseList courseList;
    private List<Course> sortList;
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
        setSortList();
        setAllUpperBounds();
        initFullPlan();
    }

    public User getUser() {
        return this.user;
    }
    public CourseList getCourseList() {
        return this.courseList;
    }

    private void setAllMaxDepths() {

        for (Course course : courseList.getList()) {
            List<String> rCoreq = course.getrCoreq();
            List<String> rPrereq = course.getrPrereqs();

            if (rPrereq.isEmpty()) {
                course.setMaxDepth(0);
                preBFS(course);
            }
            if (rCoreq.isEmpty()) {
                course.setMaxDepth(0);
                preBFS(course);
            }
        }

    }

    private void preBFS(Course course) {

        Course currCourse = course;
        int baseDepth = currCourse.getMaxDepth();

        for (String prereq : course.getPrereqs()) {
            Course cPrereq = C(prereq);
            cPrereq.setMaxDepth(baseDepth + 1);
            preBFS(cPrereq);
        }
    }

    private void coBFS(Course course) {

        Course currCourse = course;
        int baseDepth = currCourse.getMaxDepth();

        for (String coreq : course.getCoreqs()) {
            Course cCoreq = C(coreq);
            cCoreq.setMaxDepth(baseDepth + 1);
            preBFS(cCoreq);
        }
    }

    private Course C(String course) {
        return strToCourse.get(course);
    }

    private void setAllUpperBounds() {

        for (Course c : courseList.getList()) {
            c.setLowerBound(user.getNumSemesters() - c.getMaxDepth());
        }
    }

    private void setSortList() {
        this.sortList = new ArrayList<>(courseList.getList());
        sortList.sort(Comparator.comparingInt(Course::getMaxDepth));
        Collections.reverse(sortList);
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
            sortList.remove(course);
            course.setSemesterPlacement(targetSem);
        }
    }

    private void optimizeFullPlan() {


    }


}