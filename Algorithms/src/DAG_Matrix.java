import java.util.*;

public class DAG_Matrix {

    // TODO: implement BFS on reverse Graph to get max depth for each course. Do it for each leaf node (root in reverse) and set course depth to frontier level
    // TODO: handle coreqs and post-co-reqs

    private final int vertices;
    private HashMap<String, List<String>> graph;
    private HashMap<String, List<String>> rGraph;
    private CourseList courseList;

    DAG_Matrix(CourseList courseList) {
        this.courseList = courseList;
        this.vertices = courseList.size();
        setGraph();
        setReverseGraph();
    }

    private void setGraph() {

        HashMap<String, List<String>> map = new HashMap<>();

        for (Course course : courseList.getList()) {
            graph.put(course.getName(), course.getPrereqs());
        }

        this.graph = map;
    }

    private void setReverseGraph() {

        HashMap<String, List<String>> map = new HashMap<>();

        for (Course course : courseList.getList()) {
            rGraph.put(course.getName(), course.getPostCourses());
        }

        this.rGraph = map;
    }
}
