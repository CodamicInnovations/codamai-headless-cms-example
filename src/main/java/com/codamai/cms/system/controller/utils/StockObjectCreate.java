package com.codamai.cms.system.controller.utils;

import com.codamai.cms.models.StockObject;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class StockObjectCreate extends AbstractCreateModelController<StockObject> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<StockObject> getModelClass() {
    return StockObject.class;
  }
}
