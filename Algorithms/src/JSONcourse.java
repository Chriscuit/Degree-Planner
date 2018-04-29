import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "prerequisites",
        "corequisites"
})
public class JSONcourse {

    @JsonProperty("title")
    private String title;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public int getHours() {
        char[] titleCharArr = this.title.toCharArray();
        int x = Integer.valueOf(String.valueOf(titleCharArr[2]));
        return x;
    }

    public int getDiff() {
        Random ran = new Random();
        int x = ran.nextInt(6);
        return x;
    }
}