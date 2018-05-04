import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) throws Exception {

        JsonReader jsonReader = new JsonReader();

        User user = jsonReader.readInUserInput("TEST5_Power_Comm_SomeCredit_7sem.json");

        ScheduleOps so = new ScheduleOps(user);

        FullPlan fullPlan = so.getFullPlan();

        JsonFullPlan jsonFullPlan = new JsonFullPlan(fullPlan);

        ObjectMapper mapper = new ObjectMapper();

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("output.json"), jsonFullPlan);
    }
}
