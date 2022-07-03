package ai.faire.challenge.airport.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationTest")
public class ApiDocumentationControllerIntegrationTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @LocalServerPort
  private int randomServerPort;

  private URI baseUri;

  @BeforeEach
  void setUp() {
    UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance().scheme("http")
      .host("localhost")
      .port(randomServerPort)
      .path("/");

    baseUri = uriBuilder.build().toUri();
  }

  @Test
  void getOpenApiDocumentationShouldReturnJsonOpenApi() {
    // when
    var response = restTemplate.getForEntity(baseUri + "/api-docs", String.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }
}
