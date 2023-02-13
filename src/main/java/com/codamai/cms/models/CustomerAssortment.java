package com.codamai.cms.models;

import com.codamai.cms.database.models.database.TenantDataModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import io.swagger.annotations.ApiModelProperty;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Customer individual assortments, what they can buy.
 */
@Getter
@Setter
@Entity
@Table(
    name = "CustomerAssortment"
)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.EXISTING_PROPERTY,
    property = "@type",
    defaultImpl = CustomerAssortment.class
)
public class CustomerAssortment extends TenantDataModel {
  /**
   * No description for products.
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "[{id: xxx}]",
      notes = "This is a reference to a list of assortments"
  )
  @ManyToMany(
      mappedBy = "assortments"
  )
  private Collection<ProductObject> products;

  /**
   * No description for name.
   */
  @Column(
      name = "name"
  )
  private String name;

  /**
   * Add a ProductObject to n:m collection.
   */
  public boolean productsAdd(ProductObject item) {
    if (item == null) {
      return false;
    }
    if(this.products == null) {
      this.products = new ArrayList<ProductObject>();
    }
    if(this.products.contains(item)) {
      return false;
    }
    if(item.getAssortments() == null) {
      item.setAssortments(new ArrayList<CustomerAssortment>());
    }
    item.getAssortments().add(this);
    this.products.add(item);
    this.set_processed(true);
    item.set_processed(true);
    return true;
  }

  /**
   * Remove a ProductObject from n:m collection.
   */
  public boolean productsRemove(ProductObject item) {
    if (item == null) {
      return false;
    }
    if(!this.products.contains(item)) {
      return false;
    }
    item.getAssortments().remove(this);
    this.products.remove(item);
    return true;
  }

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
