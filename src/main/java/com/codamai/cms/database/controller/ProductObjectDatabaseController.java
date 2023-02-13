package com.codamai.cms.database.controller;

import com.codamai.cms.models.ProductObject;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class ProductObjectDatabaseController extends AbstractDatabaseController<ProductObject> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<ProductObject> getModelClass() {
    return ProductObject.class;
  }
}
