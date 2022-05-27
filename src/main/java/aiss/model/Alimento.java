
package aiss.model;

import java.util.HashMap;
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
    "alimento",
    "cantidad"
})
@Generated("jsonschema2pojo")
public class Alimento {

    @JsonProperty("alimento")
    private Alimento alimento;
    @JsonProperty("cantidad")
    private Integer cantidad;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("alimento")
    public Alimento getAlimento() {
        return alimento;
    }

    @JsonProperty("alimento")
    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    @JsonProperty("cantidad")
    public Integer getCantidad() {
        return cantidad;
    }

    @JsonProperty("cantidad")
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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
