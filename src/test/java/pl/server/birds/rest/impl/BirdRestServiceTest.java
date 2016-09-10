package pl.server.birds.rest.impl;

import static org.assertj.core.api.Assertions.assertThat;

import javax.ws.rs.core.Response.Status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pl.server.birds.BirdApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BirdApp.class, webEnvironment = WebEnvironment.DEFINED_PORT, properties = "server.port=5555")
public class BirdRestServiceTest {

	private static final String ADDRESS_URL = "/services/rest";
	private static final String BASE_SERVICE_URL = "http://localhost:5555/services/rest";

	@Before
	public void setup() {
		RestAssured.baseURI = "http://localhost:5555/services/rest";
	}

	@Test
	public void shouldReturnStatusOkForBirds() {

		// given when
		String response = RestAssured.expect() //
				.statusCode(Status.OK.getStatusCode()) //
				.contentType(ContentType.TEXT) //
				.when() //
				.get("/bird") //
				.thenReturn().as(String.class);

		// then
		assertThat(response).isEqualTo("dupa");

	}

	@Test
	public void shouldNotServePeople() {
		// given when then
		RestAssured.expect() //
				.statusCode(Status.NOT_FOUND.getStatusCode()) //
				.when() //
				.get("/people"); //

	}

}
