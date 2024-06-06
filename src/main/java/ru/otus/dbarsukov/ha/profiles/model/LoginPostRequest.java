package ru.otus.dbarsukov.ha.profiles.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * LoginPostRequest
 */

@JsonTypeName("_login_post_request")
public class LoginPostRequest {

  private String id;

  private String password;

  public LoginPostRequest id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Идентификатор пользователя
   * @return id
  */
  
  @Schema(name = "id", description = "Идентификатор пользователя", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LoginPostRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  
  @Schema(name = "password", example = "Секретная строка", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginPostRequest loginPostRequest = (LoginPostRequest) o;
    return Objects.equals(this.id, loginPostRequest.id) &&
        Objects.equals(this.password, loginPostRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, password);
  }

  @Override
  public String toString() {
      return "class LoginPostRequest {\n" +
            "    id: " + toIndentedString(id) + "\n" +
            "    password: " + toIndentedString(password) + "\n" +
            "}";
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

