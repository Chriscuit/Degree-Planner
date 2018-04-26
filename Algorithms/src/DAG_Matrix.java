import java.util.*;

public class DAG_Matrix {

    private final int vertices;
    private HashMap<String, List<String>> graph;
    private HashMap<String, List<String>> rGraph;
    private List<Course> courseList;

    DAG_Matrix() {
        this.courseList = Course.getCourseList();
        this.vertices = courseList.size();
        setGraph();
        setReverseGraph();
    }

    private void setGraph() {

        HashMap<String, List<String>> map = new HashMap<>();

        for (Course course : courseList) {
            graph.put(course.getName(), course.getPrereqs());
        }

        this.graph = map;
    }

    private void setReverseGraph() {

        HashMap<String, List<String>> map = new HashMap<>();

        for (Course course : courseList) {
            rGraph.put(course.getName(), course.getPostCourses());
        }

        this.rGraph = map;
    }
}
