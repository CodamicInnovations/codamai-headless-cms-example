package com.codamai.cms.models;

import com.codamai.cms.database.models.database.TenantDataModel;
import com.codamai.cms.enums.PRODUCTTYPE;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * A product in the store
 */
@Getter
@Setter
@Entity
@Table(
    name = "ProductObject"
)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.EXISTING_PROPERTY,
    property = "@type",
    defaultImpl = ProductObject.class
)
@ClassAccessValidatorCreate(
    roles = { "productobject-modelendpoint" },
    type = RoleConfigurationType.AND
)
@ClassAccessValidatorDelete(
    roles = { "productobject-modelendpoint" },
    type = RoleConfigurationType.AND
)
@ClassAccessValidatorUpdate(
    roles = { "productobject-modelendpoint" },
    type = RoleConfigurationType.AND
)
public class ProductObject extends TenantDataModel {
  /**
   * No description for name.
   */
  @Column(
      name = "name"
  )
  private String name;

  /**
   * No description for supplier.
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "{id: xxx}",
      notes = "This is a reference to products"
  )
  @ManyToOne
  private SupplierObject supplier;

  /**
   * No description for endSell.
   */
  @Column(
      name = "endsell"
  )
  private LocalDateTime endSell;

  /**
   * No description for group.
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "{id: xxx}",
      notes = "This is a reference to products"
  )
  @ManyToOne
  private ProductGroup group;

  /**
   * reference to products in null
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "[{id: xxx}]",
      notes = "This is a reference to a list of products"
  )
  @ManyToMany
  private Collection<CustomerAssortment> assortments;

  /**
   * No description for catalog.
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "{id: xxx}",
      notes = "This is a reference to items"
  )
  @ManyToOne
  private ProductCatalog catalog;

  /**
   * No description for description.
   */
  @Column(
      name = "description"
  )
  private String description;

  /**
   * No description for type.
   */
  @Enumerated(EnumType.STRING)
  private PRODUCTTYPE type;

  /**
   * No description for startSell.
   */
  @Column(
      name = "startsell"
  )
  private LocalDateTime startSell;

  /**
   * No description for stock.
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "[{id: xxx}]",
      notes = "This is a reference to a list of product"
  )
  @OneToMany(
      mappedBy = "product"
  )
  private Collection<StockObject> stock;

  /**
   * No description for attributes.
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "[{id: xxx}]",
      notes = "This is a reference to a list of product"
  )
  @OneToMany(
      mappedBy = "product"
  )
  private Collection<ProductAttribute> attributes;

  /**
   * Add a CustomerAssortment to n:m collection.
   */
  public boolean assortmentsAdd(CustomerAssortment item) {
    if (item == null) {
      return false;
    }
    if(this.assortments == null) {
      this.assortments = new ArrayList<CustomerAssortment>();
    }
    if(this.assortments.contains(item)) {
      return false;
    }
    if(item.getProducts() == null) {
      item.setProducts(new ArrayList<ProductObject>());
    }
    item.getProducts().add(this);
    this.assortments.add(item);
    this.set_processed(true);
    item.set_processed(true);
    return true;
  }

  /**
   * Remove a CustomerAssortment from n:m collection.
   */
  public boolean assortmentsRemove(CustomerAssortment item) {
    if (item == null) {
      return false;
    }
    if(!this.assortments.contains(item)) {
      return false;
    }
    item.getProducts().remove(this);
    this.assortments.remove(item);
    return true;
  }

  /**
   * Add a StockObject to n:1 collection.
   */
  public boolean stockAdd(StockObject item) {
    if (item == null) {
      return false;
    }
    if(this.stock == null) {
      this.stock = new ArrayList<StockObject>();
    }
    if(this.stock.contains(item)) {
      return false;
    }
    if(this.equals(item.getProduct())) {
      return false;
    }
    item.setProduct(this);
    this.stock.add(item);
    this.set_processed(true);
    item.set_processed(true);
    return true;
  }

  /**
   * Remove a StockObject from n:1 collection.
   */
  public boolean stockRemove(StockObject item) {
    if (item == null) {
      return false;
    }
    if(!this.stock.contains(item)) {
      return false;
    }
    item.setProduct(null);
    this.stock.remove(item);
    return true;
  }

  /**
   * Add a ProductAttribute to n:1 collection.
   */
  public boolean attributesAdd(ProductAttribute item) {
    if (item == null) {
      return false;
    }
    if(this.attributes == null) {
      this.attributes = new ArrayList<ProductAttribute>();
    }
    if(this.attributes.contains(item)) {
      return false;
    }
    if(this.equals(item.getProduct())) {
      return false;
    }
    item.setProduct(this);
    this.attributes.add(item);
    this.set_processed(true);
    item.set_processed(true);
    return true;
  }

  /**
   * Remove a ProductAttribute from n:1 collection.
   */
  public boolean attributesRemove(ProductAttribute item) {
    if (item == null) {
      return false;
    }
    if(!this.attributes.contains(item)) {
      return false;
    }
    item.setProduct(null);
    this.attributes.remove(item);
    return true;
  }

  /**
   * Initialize all default values to the model.
   */
  @Override
  public void init() {
    // initial data for new objects;
    this.type = PRODUCTTYPE.PRODUCT;
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
