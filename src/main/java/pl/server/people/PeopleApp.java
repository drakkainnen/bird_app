package pl.server.people;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "pl.server.people", "pl.server.birds.config" })
public class PeopleApp {

	private static final Logger LOG = LoggerFactory.getLogger(PeopleApp.class);

	public static void main(String[] args) {
		LOG.debug("Starting application");
		SpringApplication.run(PeopleApp.class);
	}
}
