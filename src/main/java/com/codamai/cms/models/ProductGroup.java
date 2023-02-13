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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
    name = "ProductGroup"
)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.EXISTING_PROPERTY,
    property = "@type",
    defaultImpl = ProductGroup.class
)
public class ProductGroup extends TenantDataModel {
  /**
   * reference to group in null
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "[{id: xxx}]",
      notes = "This is a reference to a list of group"
  )
  @OneToMany(
      mappedBy = "group",
      cascade = {CascadeType.REMOVE}
  )
  private Collection<ProductObject> products;

  /**
   * Add a ProductObject to n:1 collection.
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
    if(this.equals(item.getGroup())) {
      return false;
    }
    item.setGroup(this);
    this.products.add(item);
    this.set_processed(true);
    item.set_processed(true);
    return true;
  }

  /**
   * Remove a ProductObject from n:1 collection.
   */
  public boolean productsRemove(ProductObject item) {
    if (item == null) {
      return false;
    }
    if(!this.products.contains(item)) {
      return false;
    }
    item.setGroup(null);
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
