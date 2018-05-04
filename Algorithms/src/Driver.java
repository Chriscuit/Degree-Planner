import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) throws Exception {

//        String inputPath = args[0];

        String inputPath = "TEST5_Power_Comm_SomeCredit_7sem.json";

        JsonReader jsonReader = new JsonReader();

        User user = jsonReader.readInUserInput(inputPath);

        ScheduleOps so = new ScheduleOps(user);

        FullPlan fullPlan = so.getFullPlan();

        JsonFullPlan jsonFullPlan = new JsonFullPlan(fullPlan);

        ObjectMapper mapper = new ObjectMapper();

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("output.json"), jsonFullPlan);
    }
}
