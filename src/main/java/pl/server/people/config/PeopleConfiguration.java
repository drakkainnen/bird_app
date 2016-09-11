package pl.server.people.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.server.people.config.proxy.BirdsProxy;

@Configuration
public class PeopleConfiguration {

	@Bean
	public BirdsProxy getBirdProxy() {
		return new BirdsProxy();
	}
}
