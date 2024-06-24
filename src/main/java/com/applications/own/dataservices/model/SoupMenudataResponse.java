package com.applications.own.dataservices.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class SoupMenudataResponse   {
  @JsonProperty("id")
  private Integer soupId = null;

  public SoupMenudataResponse userId(Integer soupId) {
    this.soupId = soupId;
    return this;
  }

    public Integer getsoupId() {
    return soupId;
  }

  public void setSoupId(Integer soupId) {
    this.soupId = soupId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SoupMenudataResponse soupMenudataResponse = (SoupMenudataResponse) o;
    return Objects.equals(this.soupId, soupMenudataResponse.soupId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(soupId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SoupMenudataResponse {\n");
    
    sb.append("    userId: ").append(toIndentedString(soupId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
