package com.codamai.cms.models;

import com.codamai.cms.database.models.database.TenantDataModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import io.swagger.annotations.ApiModelProperty;
import java.lang.Override;
import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
    name = "ProductAttribute"
)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.EXISTING_PROPERTY,
    property = "@type",
    defaultImpl = ProductAttribute.class
)
public class ProductAttribute extends TenantDataModel {
  /**
   * reference to attributes in null
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "{id: xxx}",
      notes = "This is a reference to attributes"
  )
  @ManyToOne
  private ProductObject product;

  /**
   * No description for key.
   */
  @Column(
      name = "field_key"
  )
  private String key;

  /**
   * No description for value.
   */
  @Column(
      name = "value"
  )
  private String value;

  /**
   * Initialize all default values to the model.
   */
  @Override
  public void init() {
    // initial data for new objects;
  }

  /**
   * return type model for rest calls in @type.
   *
   * @return type of model for abstract.
   */
  @JsonProperty("@type")
  public String get_Type() {
    return this.getClass().getSimpleName();
  }
}
