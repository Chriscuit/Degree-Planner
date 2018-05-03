import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class JsonReader {

    public static void readInFullCourseList(CourseList courseList) throws IOException, ParseException, CourseList.InvalidCoursesJsonException {

        Object obj = new JSONParser().parse(new FileReader("courseInfo.json"));

        JSONObject jsonObject = (JSONObject) obj;

        JSONArray courses = (JSONArray) jsonObject.get("courses");
        Iterator i = courses.iterator();

        while (i.hasNext()) {
            System.out.println(i.next() + "\n\n");
        }

        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<JsonCourseData>> mapType = new TypeReference<List<JsonCourseData>>() {};
        List<JsonCourseData> jsonToJSONCourseList = objectMapper.readValue(String.valueOf(courses), mapType);


        /*
         * Now this is where this class begins to act as the driver program
         */
        for (JsonCourseData jcourse : jsonToJSONCourseList) {
            courseList.add(new Course(jcourse));
        }
        courseList.finishedList();
    }

    public static User readInUserInput(CourseList fullCourseList) throws IOException, ParseException, CourseList.InvalidCoursesJsonException {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonUserData jsonUserData = objectMapper.readValue(new File("testDegreePlan.json"), JsonUserData.class);

        User user = new User(jsonUserData, fullCourseList);

        return user;
    }
}
