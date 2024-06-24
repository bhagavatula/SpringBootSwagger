package com.applications.own.dataservices.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class SoupmenuData   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("price")
  private Long  price = null;

  public SoupmenuData id(Integer id) {
    this.id = id;
    return this;
  }



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SoupmenuData soupmenuData = (SoupmenuData) o;
    return Objects.equals(this.id, soupmenuData.id) &&
        Objects.equals(this.name, soupmenuData.name) &&
        Objects.equals(this.type, soupmenuData.type) &&
        Objects.equals(this.price, soupmenuData.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, type, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SoupmenuData {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
