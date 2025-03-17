package com.vi.corelib.api;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestBody {
  private String name;
  private String value;
  private RequestBody object;
  private List<RequestBody> objectList;
  private String dataType; 
  private Boolean required; 
  private String keyType; 
  private Boolean encrypted;
  private Boolean decrypted;
  private String securitySalt;

  public RequestBody() {
  }

  public RequestBody(String key, String value) {
    this.name = key;
    this.value = value;
  }

  public String getJsonText() {
    if (object != null) {
      return """
          {
            "${name}": ${value}
          }
          """.replace("${name}", name)
          .replace("${value}", object.getJsonText());
    } else {
      return """
          {"${name}": "${value}"}""".replace("${name}", name)
          .replace("${value}", value);
    }
  }
}

