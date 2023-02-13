package com.codamai.cms.system.controller.utils;

import com.codamai.cms.models.ProductGroup;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class ProductGroupRead extends AbstractReadModelController<ProductGroup> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<ProductGroup> getModelClass() {
    return ProductGroup.class;
  }
}
