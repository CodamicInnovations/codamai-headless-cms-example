package com.codamai.cms.system.controller.utils;

import com.codamai.cms.models.ProductAttribute;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class ProductAttributeUpdate extends AbstractUpdateModelController<ProductAttribute> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<ProductAttribute> getModelClass() {
    return ProductAttribute.class;
  }
}
