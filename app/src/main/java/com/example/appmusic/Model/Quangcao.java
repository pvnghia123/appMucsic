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
"idquancao",
"hinhanh",
"noidung",
"idbaihat",
"tenbaihat",
"hinhbaihat"
})
public class Quangcao implements Serializable {

@JsonProperty("idquancao")
private String idquancao;
@JsonProperty("hinhanh")
private String hinhanh;
@JsonProperty("noidung")
private String noidung;
@JsonProperty("idbaihat")
private String idbaihat;
@JsonProperty("tenbaihat")
private String tenbaihat;
@JsonProperty("hinhbaihat")
private String hinhbaihat;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("idquancao")
public String getIdquancao() {
return idquancao;
}

@JsonProperty("idquancao")
public void setIdquancao(String idquancao) {
this.idquancao = idquancao;
}

@JsonProperty("hinhanh")
public String getHinhanh() {
return hinhanh;
}

@JsonProperty("hinhanh")
public void setHinhanh(String hinhanh) {
this.hinhanh = hinhanh;
}

@JsonProperty("noidung")
public String getNoidung() {
return noidung;
}

@JsonProperty("noidung")
public void setNoidung(String noidung) {
this.noidung = noidung;
}

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

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}