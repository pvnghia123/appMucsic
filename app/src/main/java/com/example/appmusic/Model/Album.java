package com.example.appmusic.Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idalbum",
        "tenalbum",
        "tencasialbum",
        "hinhalbum"
})
public class Album  implements Serializable {

    @JsonProperty("idalbum")
    private String idalbum;
    @JsonProperty("tenalbum")
    private String tenalbum;
    @JsonProperty("tencasialbum")
    private String tencasialbum;
    @JsonProperty("hinhalbum")
    private String hinhalbum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idalbum")
    public String getIdalbum() {
        return idalbum;
    }

    @JsonProperty("idalbum")
    public void setIdalbum(String idalbum) {
        this.idalbum = idalbum;
    }

    @JsonProperty("tenalbum")
    public String getTenalbum() {
        return tenalbum;
    }

    @JsonProperty("tenalbum")
    public void setTenalbum(String tenalbum) {
        this.tenalbum = tenalbum;
    }

    @JsonProperty("tencasialbum")
    public String getTencasialbum() {
        return tencasialbum;
    }

    @JsonProperty("tencasialbum")
    public void setTencasialbum(String tencasialbum) {
        this.tencasialbum = tencasialbum;
    }

    @JsonProperty("hinhalbum")
    public String getHinhalbum() {
        return hinhalbum;
    }

    @JsonProperty("hinhalbum")
    public void setHinhalbum(String hinhalbum) {
        this.hinhalbum = hinhalbum;
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