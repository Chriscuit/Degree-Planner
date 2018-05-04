import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {
    public static void main(String[] args) throws Exception {

        JsonReader jsonReader = new JsonReader();

        User user = jsonReader.readInUserInput();

        ScheduleOps so = new ScheduleOps(user);

        FullPlan fullPlan = so.getFullPlan();

        ObjectMapper mapper = new ObjectMapper();

//        mapper.writeValue(new File("output.json"), fullPlan);
    }
}
