package com.codamai.cms.database.controller;

import com.codamai.cms.models.ProductAttribute;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class ProductAttributeDatabaseController extends AbstractDatabaseController<ProductAttribute> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<ProductAttribute> getModelClass() {
    return ProductAttribute.class;
  }
}
