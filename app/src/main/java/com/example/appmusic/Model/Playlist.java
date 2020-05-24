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
        "idplaylist",
        "ten",
        "hinh",
        "icon"
})
public class Playlist  implements Serializable {

    @JsonProperty("idplaylist")
    private String idplaylist;
    @JsonProperty("ten")
    private String ten;
    @JsonProperty("hinh")
    private String hinh;
    @JsonProperty("icon")
    private String icon;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idplaylist")
    public String getIdplaylist() {
        return idplaylist;
    }

    @JsonProperty("idplaylist")
    public void setIdplaylist(String idplaylist) {
        this.idplaylist = idplaylist;
    }

    @JsonProperty("ten")
    public String getTen() {
        return ten;
    }

    @JsonProperty("ten")
    public void setTen(String ten) {
        this.ten = ten;
    }

    @JsonProperty("hinh")
    public String getHinh() {
        return hinh;
    }

    @JsonProperty("hinh")
    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
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