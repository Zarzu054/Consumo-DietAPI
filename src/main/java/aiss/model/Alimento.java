
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
@JsonPropertyOrder({"id", "nombre", "calorias", "categoria",
	"tipo", "alergeno", "temporada"})
@Generated("jsonschema2pojo")
public class Alimento {

    @JsonProperty("id")
    private String id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("calorias")
    private Integer calorias;
    @JsonProperty("categoria")
    private String categoria;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("alergeno")
    private String alergeno;
    @JsonProperty("temporada")
    private String temporada;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
    public Alimento() {
    	super();
    }
    
    public Alimento(String id, String nombre, Integer calorias, String categoria,
    		String tipo, String alergeno, String temporada) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.calorias = calorias;
		this.categoria = categoria;
		this.tipo = tipo;
		this.alergeno = alergeno;
		this.temporada = temporada;
	}

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

    @JsonProperty("calorias")
	public Integer getCalorias() {
		return calorias;
	}
    
    @JsonProperty("calorias")
	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}

    @JsonProperty("categoria")
	public String getCategoria() {
		return categoria;
	}

    @JsonProperty("categoria")
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

    @JsonProperty("tipo")
	public String getTipo() {
		return tipo;
	}
    
    @JsonProperty("tipo")
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    @JsonProperty("alergeno")
	public String getAlergeno() {
		return alergeno;
	}

    @JsonProperty("alergeno")
	public void setAlergeno(String alergeno) {
		this.alergeno = alergeno;
	}

    @JsonProperty("temporada")
	public String getTemporada() {
		return temporada;
	}

    @JsonProperty("temporada")
	public void setTemporada(String temporada) {
		this.temporada = temporada;
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
