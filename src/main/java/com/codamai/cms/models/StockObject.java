package com.codamai.cms.models;

import com.codamai.cms.database.models.database.TenantDataModel;
import com.codamai.cms.enums.STOCKTYPE;
import com.codamai.cms.system.access.annotations.ClassAccessValidatorCreate;
import com.codamai.cms.system.access.annotations.ClassAccessValidatorDelete;
import com.codamai.cms.system.access.annotations.ClassAccessValidatorUpdate;
import com.codamai.cms.system.access.enums.RoleConfigurationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import io.swagger.annotations.ApiModelProperty;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
    name = "StockObject"
)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.EXISTING_PROPERTY,
    property = "@type",
    defaultImpl = StockObject.class
)
@ClassAccessValidatorUpdate(
    roles = { "stockobject-modelendpoint" },
    type = RoleConfigurationType.AND
)
@ClassAccessValidatorDelete(
    roles = { "stockobject-modelendpoint" },
    type = RoleConfigurationType.AND
)
@ClassAccessValidatorCreate(
    roles = { "stockobject-modelendpoint" },
    type = RoleConfigurationType.AND
)
public class StockObject extends TenantDataModel {
  /**
   * No description for amount.
   */
  @Column(
      name = "amount"
  )
  private Integer amount;

  /**
   * No description for reduceAmountOnBuy.
   */
  @Column(
      name = "reduceamountonbuy"
  )
  private Boolean reduceAmountOnBuy;

  /**
   * No description for infiniteAmount.
   */
  @Column(
      name = "infiniteamount"
  )
  private Boolean infiniteAmount;

  /**
   * reference to stock in null
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "{id: xxx}",
      notes = "This is a reference to stock"
  )
  @ManyToOne
  private ProductObject product;

  /**
   * No description for type.
   */
  @Enumerated(EnumType.STRING)
  private STOCKTYPE type;

  /**
   * Initialize all default values to the model.
   */
  @Override
  public void init() {
    // initial data for new objects;
    this.amount = Integer.valueOf("0");
    this.reduceAmountOnBuy = Boolean.valueOf("true");
    this.infiniteAmount = Boolean.valueOf("false");
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
