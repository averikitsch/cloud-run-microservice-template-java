
package com.cloudrun.microservicetemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

/** Example REST controller to demonstrate structured logging. */
@RestController
public class MicroserviceController {
  // 'spring-cloud-gcp-starter-logging' module provides support for
  // associating a web request trace ID with the corresponding log entries.
  // https://cloud.spring.io/spring-cloud-gcp/multi/multi__stackdriver_logging.html
  private static final Logger logger = LoggerFactory.getLogger(MicroserviceController.class);

  /** Example endpoint handler. */
  @GetMapping("/")
  public @ResponseBody String indexHTTP() {
    String FIELD = "test";
    // Example of structured logging - add custom fields
    MDC.put("logField", "custom-entry");
    MDC.put("arbitraryField", 
    "custom-entry");
    // Use logger with log correlation
    // https://cloud.google.com/run/docs/logging#correlate-logs this line goes on and on and on and one and one and one and on.
    logger.info("Structured logging example.");
    return "Hello World!";
  }
}
