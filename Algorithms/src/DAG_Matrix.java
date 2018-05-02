import java.util.*;

public class DAG_Matrix {

    // TODO: implement BFS on reverse Graph to get max depth for each course. Do it for each leaf node (root in reverse) and set course depth to frontier level
    // TODO: handle coreqs and post-co-reqs

    private final int vertices;
    private HashMap<String, List<String>> graph = new HashMap<>();
    private HashMap<String, List<String>> rGraph = new HashMap<>();
    private CourseList courseList;

    DAG_Matrix(CourseList courseList) {
        this.courseList = courseList;
        this.vertices = courseList.size();
        setGraph();
        setReverseGraph();
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
}
