import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws Exception {

//        String inputPath = args[0];

        String inputPath = "TEST2_Software_Comm_SomeCredit_8sem.json";

        JsonReader jsonReader = new JsonReader();

        User user = jsonReader.readInUserInput(inputPath);

        ScheduleOps so = new ScheduleOps(user);

        FullPlan fullPlan = so.getFullPlan();

        JsonFullPlan jsonFullPlan = new JsonFullPlan(fullPlan);

        ObjectMapper mapper = new ObjectMapper();

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("output.json"), jsonFullPlan);
    }

    public FullPlan run(String inputPath) throws ParseException, CourseList.InvalidCoursesJsonException, IOException {

        JsonReader jsonReader = new JsonReader();

        User user = jsonReader.readInUserInput(inputPath);

        ScheduleOps so = new ScheduleOps(user);

        FullPlan fullPlan = so.getFullPlan();

        JsonFullPlan jsonFullPlan = new JsonFullPlan(fullPlan);

        ObjectMapper mapper = new ObjectMapper();

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("output.json"), jsonFullPlan);

        return fullPlan;
    }
}
