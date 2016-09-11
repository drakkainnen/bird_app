package pl.server.birds.rest.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

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
import pl.server.birds.exceptions.CustomException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BirdApp.class, //
		webEnvironment = WebEnvironment.DEFINED_PORT, //
		properties = "server.port=5555")
public class BirdRestServiceTest {

	private static final String BASE_SERVICE_URL = "http://localhost:5555/services/rest";

	@Before
	public void setup() {
		RestAssured.baseURI = BASE_SERVICE_URL;
	}

	@Test
	public void shouldReturnAllBirds() {

		// given when
		@SuppressWarnings("unchecked")
		List<String> response = RestAssured.expect() //
				.statusCode(Status.OK.getStatusCode()) //
				.when() //
				.get("/bird") //
				.thenReturn().as(List.class);

		// then
		assertThat(response).isEqualTo(Arrays.asList("123"));
	}

	@Test
	public void shouldReturnBirdByPersonName() {
		// given when
		String bird = RestAssured.given().request().body("Adam").contentType(ContentType.JSON) //
				.expect().statusCode(Status.OK.getStatusCode()) //
				.when().post("/bird/by-person-name") //
				.andReturn().asString();

		// then
		assertThat(bird).isEqualTo("123");
	}

	@Test
	public void shouldNotServePeople() {
		// when then
		RestAssured.expect().statusCode(Status.NOT_FOUND.getStatusCode()) //
				.when().get("/people"); //

	}

	@Test
	public void shouldRecieveServerFault() {

		// given when
		CustomException exception = RestAssured.expect() //
				.statusCode(Status.INTERNAL_SERVER_ERROR.getStatusCode()).log().body() //
				.when().get("/bird/brocken").as(CustomException.class);

		// then
		assertThat(exception.getMessage()).isEqualTo("dupadupa");

	}

}
