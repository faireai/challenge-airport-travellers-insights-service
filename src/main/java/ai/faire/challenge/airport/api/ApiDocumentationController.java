package ai.faire.challenge.airport.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ApiDocumentationController {

  private final Resource resourceFile;
  private final ObjectMapper yamlReader;
  private final ObjectMapper jsonWriter;

  public ApiDocumentationController(@Value("classpath:openapi/api-documentation.yaml") Resource resourceFile,
                                    @Qualifier("yamlReader") ObjectMapper yamlReader,
                                    ObjectMapper objectMapper) {
    this.resourceFile = resourceFile;
    this.yamlReader = yamlReader;
    this.jsonWriter = objectMapper;
  }

  @GetMapping(value = "/api-docs", produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<String> getOpenApiDocumentation() throws IOException {
    var openApiDocumentationYaml = yamlReader.readValue(resourceFile.getInputStream(), Object.class);
    var openApiDocumentationJson = jsonWriter.writeValueAsString(openApiDocumentationYaml);
    return ResponseEntity.status(HttpStatus.OK).body(openApiDocumentationJson);
  }
}
