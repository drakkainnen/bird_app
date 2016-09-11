package pl.server.birds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "pl.server.birds", "pl.server.both" })
public class BirdApp {

	private static final Logger log = LoggerFactory.getLogger(BirdApp.class);

	public static void main(String[] args) {
		log.debug("Starting application");
		SpringApplication.run(BirdApp.class);
	}
}
