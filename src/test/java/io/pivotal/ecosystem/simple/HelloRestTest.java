package io.pivotal.ecosystem.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@WebIntegrationTest(value = "server.port=9876")
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class HelloRestTest {

    private static final String BASE_URI = "http://localhost:9876";

    @Autowired
    private HelloController helloController;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testMarketSummary() {
        ResponseEntity<String> re = restTemplate.exchange(BASE_URI
                        + "/", HttpMethod.GET, null,
                new ParameterizedTypeReference<String>() {
                });

        assertNotNull("Should find a result.", re);
    }
}
