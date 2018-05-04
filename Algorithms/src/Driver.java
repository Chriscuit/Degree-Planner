public class Driver {
    public static void main(String[] args) throws Exception {

        JsonReader jsonReader = new JsonReader();

        User user = jsonReader.readInUserInput();

        ScheduleOps so = new ScheduleOps(user);
    }
}
