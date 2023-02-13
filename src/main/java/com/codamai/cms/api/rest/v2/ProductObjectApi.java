package com.codamai.cms.api.rest.v2;

import com.codamai.cms.api.rest.v2.templates.DefaultDataModelRestApi;
import com.codamai.cms.models.ProductObject;
import java.lang.Class;
import java.lang.Override;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple extended controller with a data model.
 */
@RestController
@RequestMapping(
    path = "v2/ProductObject/",
    consumes = "application/json",
    produces = "application/json"
)
public class ProductObjectApi extends DefaultDataModelRestApi<ProductObject> {
  /**
   * Returns your current model class.
   */
  @Override
  public Class<ProductObject> getModelClass() {
    return ProductObject.class;
  }
}
