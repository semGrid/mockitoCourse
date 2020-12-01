package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * BankInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-01T14:58:07.832Z")




public class BankInformation   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("commissionPercentage")
  private BigDecimal commissionPercentage = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("name")
  private String name = null;

  public BankInformation code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Bank code
   * @return code
  **/
  @ApiModelProperty(example = "CB", value = "Bank code")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public BankInformation commissionPercentage(BigDecimal commissionPercentage) {
    this.commissionPercentage = commissionPercentage;
    return this;
  }

  /**
   * Bank commission percentage
   * @return commissionPercentage
  **/
  @ApiModelProperty(example = "0.0", value = "Bank commission percentage")

  @Valid

  public BigDecimal getCommissionPercentage() {
    return commissionPercentage;
  }

  public void setCommissionPercentage(BigDecimal commissionPercentage) {
    this.commissionPercentage = commissionPercentage;
  }

  public BankInformation currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Bank currency code
   * @return currency
  **/
  @ApiModelProperty(example = "USD", value = "Bank currency code")


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BankInformation name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Bank name
   * @return name
  **/
  @ApiModelProperty(example = "City Bank", value = "Bank name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankInformation bankInformation = (BankInformation) o;
    return Objects.equals(this.code, bankInformation.code) &&
        Objects.equals(this.commissionPercentage, bankInformation.commissionPercentage) &&
        Objects.equals(this.currency, bankInformation.currency) &&
        Objects.equals(this.name, bankInformation.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, commissionPercentage, currency, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankInformation {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    commissionPercentage: ").append(toIndentedString(commissionPercentage)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

