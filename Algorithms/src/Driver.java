public class Driver {
    public static void main(String[] args) throws Exception {

        CourseList fullCourseList = new CourseList();

        JsonReader.readInFullCourseList(fullCourseList);

        User user = JsonReader.readInUserInput(fullCourseList);

        ScheduleOps so = new ScheduleOps(user);

        int j = 1;
    }
}
