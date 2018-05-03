import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "hours",
        "difficulty",
        "prerequisites",
        "corequisites"
})
public class JsonCourseData {

    @JsonProperty("title")
    private String title;
    @JsonProperty("hours")
    private int hours;
    @JsonProperty("difficulty")
    private int difficulty;
    @JsonProperty("prerequisites")
    private List<String> prerequisites = null;
    @JsonProperty("corequisites")
    private List<String> corequisites = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("prerequisites")
    public List<String> getPrerequisites() {
        return prerequisites;
    }

    @JsonProperty("prerequisites")
    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    @JsonProperty("corequisites")
    public List<String> getCorequisites() {
        return corequisites;
    }

    @JsonProperty("corequisites")
    public void setCorequisites(List<String> corequisites) {
        this.corequisites = corequisites;
    }

    @JsonProperty("hours")
    public void setHours() {
        this.hours = hours;
    }

    @JsonProperty("hours")
    public int getHours() {
        return hours;
    }

    @JsonProperty("difficulty")
    public void setDifficulty() {
        this.difficulty = difficulty;
    }

    @JsonProperty("difficulty")
    public int getDifficulty() {
        return difficulty;
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