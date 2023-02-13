package com.codamai.cms.models;

import com.codamai.cms.database.models.database.TenantDataModel;
import com.codamai.cms.system.access.annotations.ClassAccessValidatorCreate;
import com.codamai.cms.system.access.annotations.ClassAccessValidatorDelete;
import com.codamai.cms.system.access.annotations.ClassAccessValidatorUpdate;
import com.codamai.cms.system.access.enums.RoleConfigurationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import io.swagger.annotations.ApiModelProperty;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Supplier of products.
 */
@Getter
@Setter
@Entity
@Table(
    name = "SupplierObject"
)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.EXISTING_PROPERTY,
    property = "@type",
    defaultImpl = SupplierObject.class
)
@ClassAccessValidatorUpdate(
    roles = { "supplierobject-modelendpoint" },
    type = RoleConfigurationType.AND
)
@ClassAccessValidatorDelete(
    roles = { "supplierobject-modelendpoint" },
    type = RoleConfigurationType.AND
)
@ClassAccessValidatorCreate(
    roles = { "supplierobject-modelendpoint" },
    type = RoleConfigurationType.AND
)
public class SupplierObject extends TenantDataModel {
  /**
   * No description for name.
   */
  @Column(
      name = "name"
  )
  private String name;

  /**
   * reference to supplier in null
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "[{id: xxx}]",
      notes = "This is a reference to a list of supplier"
  )
  @OneToMany(
      mappedBy = "supplier",
      cascade = {CascadeType.REMOVE}
  )
  private Collection<ProductObject> products;

  /**
   * No description for description.
   */
  @Column(
      name = "description"
  )
  private String description;

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
    if(this.equals(item.getSupplier())) {
      return false;
    }
    item.setSupplier(this);
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
    item.setSupplier(null);
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
