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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
    name = "ProductCatalog"
)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.EXISTING_PROPERTY,
    property = "@type",
    defaultImpl = ProductCatalog.class
)
public class ProductCatalog extends TenantDataModel {
  /**
   * No description for name.
   */
  @Column(
      name = "name"
  )
  private String name;

  /**
   * reference to parent in null
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "[{id: xxx}]",
      notes = "This is a reference to a list of parent"
  )
  @OneToMany(
      mappedBy = "parent",
      cascade = {CascadeType.REMOVE}
  )
  private Collection<ProductCatalog> children;

  /**
   * No description for parent.
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "{id: xxx}",
      notes = "This is a reference to children"
  )
  @ManyToOne
  private ProductCatalog parent;

  /**
   * reference to catalog in null
   */
  @ApiModelProperty(
      dataType = "java.lang.String",
      example = "[{id: xxx}]",
      notes = "This is a reference to a list of catalog"
  )
  @OneToMany(
      mappedBy = "catalog",
      cascade = {CascadeType.REMOVE}
  )
  private Collection<ProductObject> items;

  /**
   * Add a ProductCatalog to n:1 collection.
   */
  public boolean childrenAdd(ProductCatalog item) {
    if (item == null) {
      return false;
    }
    if(this.children == null) {
      this.children = new ArrayList<ProductCatalog>();
    }
    if(this.children.contains(item)) {
      return false;
    }
    if(this.equals(item.getParent())) {
      return false;
    }
    item.setParent(this);
    this.children.add(item);
    this.set_processed(true);
    item.set_processed(true);
    return true;
  }

  /**
   * Remove a ProductCatalog from n:1 collection.
   */
  public boolean childrenRemove(ProductCatalog item) {
    if (item == null) {
      return false;
    }
    if(!this.children.contains(item)) {
      return false;
    }
    item.setParent(null);
    this.children.remove(item);
    return true;
  }

  /**
   * Add a ProductObject to n:1 collection.
   */
  public boolean itemsAdd(ProductObject item) {
    if (item == null) {
      return false;
    }
    if(this.items == null) {
      this.items = new ArrayList<ProductObject>();
    }
    if(this.items.contains(item)) {
      return false;
    }
    if(this.equals(item.getCatalog())) {
      return false;
    }
    item.setCatalog(this);
    this.items.add(item);
    this.set_processed(true);
    item.set_processed(true);
    return true;
  }

  /**
   * Remove a ProductObject from n:1 collection.
   */
  public boolean itemsRemove(ProductObject item) {
    if (item == null) {
      return false;
    }
    if(!this.items.contains(item)) {
      return false;
    }
    item.setCatalog(null);
    this.items.remove(item);
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
