import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

public class JSON_Reader {

    public static void main(String[] args) throws Exception {

        Object obj = new JSONParser().parse(new FileReader("courseInfo.json"));

        JSONObject jsonObject = (JSONObject) obj;

        JSONArray courses = (JSONArray) jsonObject.get("courses");
        Iterator i = courses.iterator();

        while (i.hasNext()) {
            System.out.println(i.next() + "\n\n");
        }

        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<JSONcourse>> mapType = new TypeReference<List<JSONcourse>>() {};
        List<JSONcourse> jsonToJSONCourseList = objectMapper.readValue(String.valueOf(courses), mapType);


        /*
         * Now this is where this class begins to act as the driver program
         */
        CourseList courseList = new CourseList();

        for (JSONcourse jcourse : jsonToJSONCourseList) {
            courseList.add(new Course(jcourse));
        }
        courseList.finishedList();

        User user = new User(8);

        ScheduleOps so = new ScheduleOps(courseList, user);

        int j = 1;
    }
}
