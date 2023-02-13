package com.codamai.cms.system.controller;

import com.codamai.cms.models.CustomerAssortment;
import java.lang.Class;
import java.lang.Override;
import org.springframework.stereotype.Service;

/**
 * Simple extended controller with a data model.
 */
@Service
public class CustomerAssortmentController extends TenantDataModelController<CustomerAssortment> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<CustomerAssortment> getModelClass() {
    return CustomerAssortment.class;
  }
}
