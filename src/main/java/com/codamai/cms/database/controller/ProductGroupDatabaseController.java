package com.codamai.cms.database.controller;

import com.codamai.cms.models.ProductGroup;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class ProductGroupDatabaseController extends AbstractDatabaseController<ProductGroup> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<ProductGroup> getModelClass() {
    return ProductGroup.class;
  }
}
