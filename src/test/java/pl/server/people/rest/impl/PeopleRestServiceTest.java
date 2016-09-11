package pl.server.people.rest.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import pl.server.people.PeopleApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PeopleApp.class, //
		webEnvironment = WebEnvironment.DEFINED_PORT, //
		properties = "server.port=5555")
public class PeopleRestServiceTest {

	private static final String BASE_SERVICE_URL = "http://localhost:5555/services/rest";

	@Before
	public void setup() {
		RestAssured.baseURI = BASE_SERVICE_URL;
	}

	@Test
	public void shouldReturnAllPeople() {

		@SuppressWarnings("unchecked")
		List<String> results = RestAssured.expect().statusCode(javax.ws.rs.core.Response.Status.OK.getStatusCode())
				.when().get("/people").andReturn().as(List.class);

		assertThat(results).isNotEmpty();

	}

}
