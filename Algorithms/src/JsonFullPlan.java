import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "JsonSemester",
        "totalHours",
        "numSemesters"
})
public class JsonFullPlan {

    @JsonProperty("JsonSemester")
    private List<JsonSemester> jsonSemesterList = null;
    @JsonProperty("totalHours")
    private Integer totalHours;
    @JsonProperty("numSemesters")
    private Integer numSemesters;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    JsonFullPlan(FullPlan fullPlan) {
        setJsonSemesterList(new ArrayList<>());
        for (Semester sem : fullPlan.getSemList()) {
            jsonSemesterList.add(new JsonSemester(sem));
        }
        setTotalHours(fullPlan.getTotalHours());
        setNumSemesters(fullPlan.getSize());
    }

    @JsonProperty("JsonSemester")
    public List<JsonSemester> getJsonSemesterList() {
        return jsonSemesterList;
    }

    @JsonProperty("JsonSemester")
    public void setJsonSemesterList(List<JsonSemester> jsonSemesterList) {
        this.jsonSemesterList = jsonSemesterList;
    }

    @JsonProperty("totalHours")
    public Integer getTotalHours() {
        return totalHours;
    }

    @JsonProperty("totalHours")
    public void setTotalHours(Integer totalHours) {
        this.totalHours = totalHours;
    }

    @JsonProperty("numSemesters")
    public Integer getNumSemesters() {
        return numSemesters;
    }

    @JsonProperty("numSemesters")
    public void setNumSemesters(Integer numSemesters) {
        this.numSemesters = numSemesters;
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