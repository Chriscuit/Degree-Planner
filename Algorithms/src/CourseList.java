import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseList {

    private List<Course> list;
    private int totalDifficulty;
    private int totalHours;

    CourseList() {
        this.list = new ArrayList<>();
        totalDifficulty = 0;
        totalHours = 0;
    }

    public void add(Course course) {
        this.list.add(course);
        totalDifficulty += course.getDifficulty();
        totalHours += course.getHours();
    }

    public int size() {
        return list.size();
    }

    public int getTotalDifficulty() {
        return totalDifficulty;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public List<Course> getList() {
        return this.list;
    }

//    public void calculatePostCourses() {
//
//        HashMap<String, List<String>> map = new HashMap<>();
//
//        for (Course course : getList()) {
//            populateMap(map, course, course.getPrereqs());
//            populateMap(map, course, course.getCoreqs());
//            map.put(course.getName(), map.get(course.getName()) == null ? new ArrayList<String>() : map.get(course.getName()));
//        }
//
//        for (Course course : getList()) {
//            course.setPostCourses(map.get(course.getName()));
//        }
//    }

    public void calculateReversePreCo() {

        HashMap<String, List<String>> preMap = new HashMap<>();
        HashMap<String, List<String>> coMap = new HashMap<>();

        for (Course course : getList()) {
            populateMap(preMap, course, course.getPrereqs());
            populateMap(coMap, course, course.getCoreqs());
            preMap.put(course.getName(), preMap.get(course.getName()) == null ? new ArrayList<String>() : preMap.get(course.getName()));
            coMap.put(course.getName(), coMap.get(course.getName()) == null ? new ArrayList<String>() : coMap.get(course.getName()));
        }

        for (Course course : getList()) {
            course.setrPrereqs(preMap.get(course.getName()));
            course.setrCoreq(coMap.get(course.getName()));
        }
    }

    private void populateMap(HashMap<String, List<String>> map,  Course course, List<String> courseReqs) {
        for (String req : courseReqs) {

            List<String> postCourseStrings = new ArrayList<>();
            if (map.containsKey(req)) {
                postCourseStrings = map.get(req);
                postCourseStrings.add(course.getName());
                map.put(req, postCourseStrings);
            } else {
                postCourseStrings.add(course.getName());
                map.put(req, postCourseStrings);
            }
        }
    }

    public Boolean contains(String courseName) {

        for (Course c : list) {
            if (c.getName().equals(courseName)) return true;
        }

        return false;
    }

    public void errorCheck() throws InvalidCoursesJsonException {
        for (Course c : list) {
            for (String str : c.getPrereqs()) {
                if (!contains(str)) {
                    throw new InvalidCoursesJsonException(str);
                }
            }
        }
    }

    public void finishedList() throws InvalidCoursesJsonException {
        calculateReversePreCo();
        errorCheck();
    }

    public class InvalidCoursesJsonException extends Exception {

        public InvalidCoursesJsonException(String message){
            super(message);
        }
    }
}
