package com.codamai.cms.system.controller.utils;

import com.codamai.cms.models.ProductObject;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class ProductObjectDelete extends AbstractDeleteModelController<ProductObject> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<ProductObject> getModelClass() {
    return ProductObject.class;
  }
}
