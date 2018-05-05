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

    private CourseList fullCourseList = new CourseList();

    JsonReader() throws ParseException, CourseList.InvalidCoursesJsonException, IOException {
        readInFullCourseList();
    }

    public void readInFullCourseList() throws IOException, ParseException, CourseList.InvalidCoursesJsonException {

        Object obj = new JSONParser().parse(new FileReader("/Users/christophergill/Downloads/Degree-Planner/courseInfo.json"));

        JSONObject jsonObject = (JSONObject) obj;

        JSONArray courses = (JSONArray) jsonObject.get("courses");
        Iterator i = courses.iterator();

        while (i.hasNext()) {
            System.out.println(i.next() + "\n\n");
        }

        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<JsonCourseData>> mapType = new TypeReference<List<JsonCourseData>>() {};
        List<JsonCourseData> jsonToJSONCourseList = objectMapper.readValue(String.valueOf(courses), mapType);

        for (JsonCourseData jcourse : jsonToJSONCourseList) {
            fullCourseList.add(new Course(jcourse));
        }
        fullCourseList.finishedList();

    }

    public User readInUserInput(String path) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonUserData jsonUserData = objectMapper.readValue(new File(path), JsonUserData.class);

        User user = new User(jsonUserData, fullCourseList);

        return user;
    }
}
