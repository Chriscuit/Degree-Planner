import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "JSONcourses"
})
public class JSONcourses {

    @JsonProperty("JSONcourses")
    private List<JSONcourse> jSONcourses = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("JSONcourses")
    public List<JSONcourse> getJSONcourses() {
        return jSONcourses;
    }

    @JsonProperty("JSONcourses")
    public void setJSONcourses(List<JSONcourse> jSONcourses) {
        this.jSONcourses = jSONcourses;
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
