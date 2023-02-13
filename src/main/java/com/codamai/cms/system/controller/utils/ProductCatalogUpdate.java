package com.codamai.cms.system.controller.utils;

import com.codamai.cms.models.ProductCatalog;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class ProductCatalogUpdate extends AbstractUpdateModelController<ProductCatalog> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<ProductCatalog> getModelClass() {
    return ProductCatalog.class;
  }
}
