package com.codamai.cms;

import java.lang.String;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Start the CMS.
 */
@SpringBootApplication(
    exclude = { DataSourceAutoConfiguration.class }
)
@ComponentScan(
    basePackages = "com.codamai.cms"
)
public class Start {
  /**
   * This is your start class. See required environments in documentation to start CMS.
   */
  public static void main(String[] args) {
    SpringApplication.run(Start.class, args);
  }
}
