import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

public class JSON_Reader {

    // TODO: figure out how tf we gonna read this fucker

//    private String path;

    public static void main(String[] args) throws Exception {

        Object obj = new JSONParser().parse(new FileReader("/Users/christophergill/Downloads/Degree-Planner/courseInfo.json"));

        JSONObject jsonObject = (JSONObject) obj;

        JSONArray courses = (JSONArray) jsonObject.get("courses");
        Iterator i = courses.iterator();

        while (i.hasNext()) {
            System.out.println(i.next() + "\n\n");
        }

        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<JSONcourse>> mapType = new TypeReference<List<JSONcourse>() {};
        List<JSONcourse> jsonToPersonList = objectMapper.readValue(courses, mapType);
    }
}
