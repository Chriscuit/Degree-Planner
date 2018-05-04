import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "hours",
        "difficulty",
        "size",
        "courses"
})
public class JsonSemester {

    @JsonProperty("name")
    private Integer name;
    @JsonProperty("hours")
    private Integer hours;
    @JsonProperty("difficulty")
    private Integer difficulty;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("courses")
    private List<String> courses = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    JsonSemester(Semester sem) {
        setName(sem.getName());
        setCourses(new ArrayList<>());
        for (Course c : sem.getList()) {
            courses.add(c.getName());
        }
        setDifficulty(sem.getTotalDifficulty());
        setHours(sem.getTotalHours());
        setSize(sem.getList().size());
    }

    @JsonProperty("name")
    public Integer getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Integer name) {
        this.name = name;
    }

    @JsonProperty("hours")
    public Integer getHours() {
        return hours;
    }

    @JsonProperty("hours")
    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @JsonProperty("difficulty")
    public Integer getDifficulty() {
        return difficulty;
    }

    @JsonProperty("difficulty")
    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty("courses")
    public List<String> getCourses() {
        return courses;
    }

    @JsonProperty("courses")
    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

