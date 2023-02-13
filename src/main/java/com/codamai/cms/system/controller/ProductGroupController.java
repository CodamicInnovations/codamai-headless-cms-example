package com.codamai.cms.system.controller;

import com.codamai.cms.models.ProductGroup;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class ProductGroupController extends TenantDataModelController<ProductGroup> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<ProductGroup> getModelClass() {
    return ProductGroup.class;
  }
}
