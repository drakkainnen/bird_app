package pl.server.birds.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebServiceConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(WebServiceConfiguration.class);
	private static final String ADDRESS_URL = "/rest";

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private Bus bus;

	@Bean
	public Server getJaxRsServer() {
		Collection<Object> restServices = this.applicationContext.getBeansWithAnnotation(Path.class).values();
		if (restServices.isEmpty()) {
			LOG.info("No REST Services have been found. Rest Endpint will not be enabled in CXF");
			return null;
		} else {
			String services = restServices.stream() //
					.map(e -> e.getClass().getSimpleName().toString()) //
					.collect(Collectors.joining(", "));
			LOG.info(services);
		}

		Collection<Object> providers = applicationContext.getBeansWithAnnotation(Provider.class).values();
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		factory.setBus(bus);
		factory.setAddress(ADDRESS_URL);
		factory.setServiceBeans(new ArrayList<>(restServices));
		factory.setProviders(new ArrayList<>(providers));

		LOG.debug(factory.getAddress());
		return factory.create();
	}

}
