package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.boot.test.web.client.TestRestTemplate;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
		"classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
		"classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
		config = @SqlConfig(encoding = "utf-8"))


class FetchJeepTest extends FetchJeepTestSupport {
	@Test
	void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
	
	//Given: a valid model, trim and URI
		
		JeepModel model = JeepModel.WRANGLER;
		String trim = "Sport";
		String uri = String.format("%s?model=%s&trim=%s", getBaseUriForJeeps(), model, trim);
				
				//("http://localhost:%d/jeeps?model=%s&trim=%s", serverPort, model, trim);
				
	//When: a connection is made to the URI
		
		ResponseEntity<List<Jeep>> response = 
			
		getRestTemplate().exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Jeep>>(){});
				
	//Then: a success (OK - 200) status code is returned
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	//And: the actual list returned is the same as the expected list
		List<Jeep> expected = buildExpected();
		assertThat(response.getBody()).isEqualTo(expected);
		}
	}
	
	