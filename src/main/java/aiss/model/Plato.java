
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
    "id",
    "nombre",
    "alimentos",
    "listaAlergenos",
    "calorias",
    "provinciaOrigen",
    "temporada",
    "caorigen"
})
@Generated("jsonschema2pojo")
public class Plato {

    @JsonProperty("id")
    private String id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("alimentos")
    private List<Alimento> alimentos = null;
    @JsonProperty("listaAlergenos")
    private List<String> listaAlergenos = null;
    @JsonProperty("calorias")
    private Double calorias;
    @JsonProperty("provinciaOrigen")
    private String provinciaOrigen;
    @JsonProperty("temporada")
    private String temporada;
    @JsonProperty("caorigen")
    private String caorigen;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("nombre")
    public String getNombre() {
        return nombre;
    }

    @JsonProperty("nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @JsonProperty("alimentos")
    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    @JsonProperty("alimentos")
    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    @JsonProperty("listaAlergenos")
    public List<String> getListaAlergenos() {
        return listaAlergenos;
    }

    @JsonProperty("listaAlergenos")
    public void setListaAlergenos(List<String> listaAlergenos) {
        this.listaAlergenos = listaAlergenos;
    }

    @JsonProperty("calorias")
    public Double getCalorias() {
        return calorias;
    }

    @JsonProperty("calorias")
    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    @JsonProperty("provinciaOrigen")
    public String getProvinciaOrigen() {
        return provinciaOrigen;
    }

    @JsonProperty("provinciaOrigen")
    public void setProvinciaOrigen(String provinciaOrigen) {
        this.provinciaOrigen = provinciaOrigen;
    }

    @JsonProperty("temporada")
    public String getTemporada() {
        return temporada;
    }

    @JsonProperty("temporada")
    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    @JsonProperty("caorigen")
    public String getCaorigen() {
        return caorigen;
    }

    @JsonProperty("caorigen")
    public void setCaorigen(String caorigen) {
        this.caorigen = caorigen;
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
