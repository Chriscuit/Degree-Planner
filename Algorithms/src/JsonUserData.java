import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "numSemesters",
        "courses"
})
public class JsonUserData {

    @JsonProperty("numSemesters")
    private Integer numSemesters;
    @JsonProperty("courses")
    private List<String> courses = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("numSemesters")
    public Integer getNumSemesters() {
        return numSemesters;
    }

    @JsonProperty("numSemesters")
    public void setNumSemesters(Integer numSemesters) {
        this.numSemesters = numSemesters;
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