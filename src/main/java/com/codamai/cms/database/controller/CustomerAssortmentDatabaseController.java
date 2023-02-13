package com.codamai.cms.database.controller;

import com.codamai.cms.models.CustomerAssortment;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class CustomerAssortmentDatabaseController extends AbstractDatabaseController<CustomerAssortment> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<CustomerAssortment> getModelClass() {
    return CustomerAssortment.class;
  }
}
