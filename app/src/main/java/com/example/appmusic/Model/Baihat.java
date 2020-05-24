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
"idbaihat",
"tenbaihat",
"hinhbaihat",
"casi",
"linkbaihat"
})
public class Baihat implements Serializable {

    @JsonProperty("idbaihat")
    private String idbaihat;
    @JsonProperty("tenbaihat")
    private String tenbaihat;
    @JsonProperty("hinhbaihat")
    private String hinhbaihat;
    @JsonProperty("casi")
    private String casi;
    @JsonProperty("linkbaihat")
    private String linkbaihat;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("idbaihat")
    public String getIdbaihat() {
        return idbaihat;
    }

    @JsonProperty("idbaihat")
    public void setIdbaihat(String idbaihat) {
        this.idbaihat = idbaihat;
    }

    @JsonProperty("tenbaihat")
    public String getTenbaihat() {
        return tenbaihat;
    }

    @JsonProperty("tenbaihat")
    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    @JsonProperty("hinhbaihat")
    public String getHinhbaihat() {
        return hinhbaihat;
    }

    @JsonProperty("hinhbaihat")
    public void setHinhbaihat(String hinhbaihat) {
        this.hinhbaihat = hinhbaihat;
    }

    @JsonProperty("casi")
    public String getCasi() {
        return casi;
    }

    @JsonProperty("casi")
    public void setCasi(String casi) {
        this.casi = casi;
    }

    @JsonProperty("linkbaihat")
    public String getLinkbaihat() {
        return linkbaihat;
    }

    @JsonProperty("linkbaihat")
    public void setLinkbaihat(String linkbaihat) {
        this.linkbaihat = linkbaihat;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Baihat(String idbaihat, String tenbaihat, String hinhbaihat, String casi, String linkbaihat) {
        this.idbaihat = idbaihat;
        this.tenbaihat = tenbaihat;
        this.hinhbaihat = hinhbaihat;
        this.casi = casi;
        this.linkbaihat = linkbaihat;
    }
}
