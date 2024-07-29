package com.motorcyclebg;

import com.motorcyclebg.config.ForexApiConfig;
import com.motorcyclebg.service.impl.ExRateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest
class MotorcycleBGApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	private MockRestServiceServer mockServer;

	@MockBean
	private ForexApiConfig forexApiConfig;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		mockServer = MockRestServiceServer.createServer(restTemplate);

		mockServer.expect(requestTo("http://example.com"))
				.andRespond(withSuccess("{\"base\":\"USD\",\"rates\":{\"EUR\":0.85}}", MediaType.APPLICATION_JSON));
	}

	@Test
	void contextLoads() {
	}

	@Configuration
	static class TestConfig {

		@Bean
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}

		@Bean
		public ExRateServiceImpl exRateServiceImpl(RestTemplate restTemplate, ForexApiConfig forexApiConfig) {
			return new ExRateServiceImpl(null, RestClient.create(restTemplate), forexApiConfig); // Pass other dependencies as needed
		}
	}
}
