package com.codamai.cms.database.controller;

import com.codamai.cms.models.ProductCatalog;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class ProductCatalogDatabaseController extends AbstractDatabaseController<ProductCatalog> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<ProductCatalog> getModelClass() {
    return ProductCatalog.class;
  }
}
