import java.util.*;

public class DAG_Matrix {

    // TODO: implement BFS on reverse Graph to get max depth for each course. Do it for each leaf node (root in reverse) and set course depth to frontier level
    // TODO: handle coreqs and post-co-reqs

    private final int vertices;
    private HashMap<String, List<String>> graph = new HashMap<>();
    private HashMap<String, List<String>> rGraph = new HashMap<>();
    private CourseList courseList;
    private List<Course> sortList;
    private User user;
    private FullPlan fullPlan;

    DAG_Matrix(CourseList courseList, User user) {
        this.courseList = courseList;
        this.vertices = courseList.size();
        this.user = user;
        this.fullPlan = new FullPlan(user.getNumSemesters());
        setGraph();
        setReverseGraph();
        setAllMaxDepths();
        setAllUpperBounds();
        setSortList();
    }

    private void setGraph() {

        for (Course course : courseList.getList()) {
            graph.put(course.getName(), course.getPrereqs());
        }
    }

    private void setReverseGraph() {

        for (Course course : courseList.getList()) {
            rGraph.put(course.getName(), course.getPostCourses());
        }
    }

    public User getUser() {
        return this.user;
    }
    public CourseList getCourseList() {
        return this.courseList;
    }

    private void setAllMaxDepths() {

        for (String course : graph.keySet()) {
            List<String> pCourses = C(course).getPostCourses();
            if (pCourses.isEmpty()) {
                C(course).setMaxDepth(0);
                BFS(course);
            }
        }
    }

    private void BFS(String course) {

        Course currCourse = C(course);
        int baseDepth = currCourse.getMaxDepth();

        for (String prereq : C(course).getPrereqs()) {
            C(prereq).setMaxDepth(baseDepth + 1);
            BFS(prereq);
        }
    }

    private Course C(String course) {
        for (Course c : this.courseList.getList()) {
            if (c.getName().equals(course)) return c;
        }
        return null;
    }

    private void setAllUpperBounds() {

        for (Course c : courseList.getList()) {
            c.setLowerBound(user.getNumSemesters() - c.getMaxDepth());
        }
    }

    private void setSortList() {
        this.sortList = courseList.getList();
        sortList.sort(Comparator.comparingInt(Course::getMaxDepth));
        Collections.reverse(sortList);
    }


    // TODO: write notify functon for when I assign courses to semsters
    private void initFullPlan() {
        if (courseList.contains("EE302")) {
            Course EE302 = C("EE302");
            fullPlan.getSem(0).add(EE302);
            sortList.remove(EE302);
//            EE302.
        }
        if (courseList.contains("EE306")) {
            Course EE306 = C("EE302");
            fullPlan.getSem(0).add(EE306);
            sortList.remove(EE306);
        }
        if (courseList.contains("EE319K")) {
            Course EE319K = C("EE319K");
            fullPlan.getSem(1).add(EE319K);
            sortList.remove(EE319K);
        }
        if (courseList.contains("EE364D")) {
            Course EE364D = C("EE364D");
            fullPlan.getSem(fullPlan.getSize()-1).add(EE364D);
            sortList.remove(EE364D);
        }
        if (courseList.contains("EE364E")) {
            Course EE364E = C("EE364E");
            fullPlan.getSem(fullPlan.getSize()-1).add(EE364E);
            sortList.remove(EE364E);
        }
        if (courseList.contains("EE464K")) {
            Course EE464K = C("EE464K");
            fullPlan.getSem(fullPlan.getSize()).add(EE464K);
            sortList.remove(EE464K);
        }
        if (courseList.contains("EE464R")) {
            Course EE464R = C("EE464R");
            fullPlan.getSem(fullPlan.getSize()).add(EE464R);
            sortList.remove(EE464R);
        }
        if (courseList.contains("EE464S")) {
            Course EE464S = C("EE464S");
            fullPlan.getSem(fullPlan.getSize()).add(EE464S);
            sortList.remove(EE464S);
        }
        if (courseList.contains("EE464S")) {
            Course EE464H = C("EE464H");
            fullPlan.getSem(fullPlan.getSize()).add(EE464H);
            sortList.remove(EE464H);
        }
    }


}