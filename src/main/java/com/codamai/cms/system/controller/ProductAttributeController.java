package com.codamai.cms.system.controller;

import com.codamai.cms.models.ProductAttribute;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class ProductAttributeController extends TenantDataModelController<ProductAttribute> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<ProductAttribute> getModelClass() {
    return ProductAttribute.class;
  }
}
