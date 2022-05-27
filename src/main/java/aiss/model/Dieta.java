
package aiss.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "platos",
    "tipo"
})
@Generated("jsonschema2pojo")
public class Dieta {

	@JsonProperty("platos")
    private List<Plato> platos = null;
    @JsonProperty("tipo")
    private String tipo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("id")
    public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

    @JsonProperty("platos")
    public List<Plato> getPlatos() {
        return platos;
    }

    @JsonProperty("platos")
    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }

    @JsonProperty("tipo")
    public String getTipo() {
        return tipo;
    }

    @JsonProperty("tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
