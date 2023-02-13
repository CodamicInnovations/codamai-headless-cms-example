package com.codamai.cms.system.controller.utils;

import com.codamai.cms.models.SupplierObject;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class SupplierObjectRead extends AbstractReadModelController<SupplierObject> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<SupplierObject> getModelClass() {
    return SupplierObject.class;
  }
}
