package pl.server.people.config.proxy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class BirdsProxy {

	private static final Logger LOG = LoggerFactory.getLogger(BirdsProxy.class);

	@Value("${birds.url}")
	private String url;

	@Autowired
	private JacksonJsonProvider jacksonJsonProvider;

	public <T> T createProxy(Class<T> service) {
		LOG.debug("Creating proxy for {service}. Base address {url}", service, url);

		List<Object> providers = Stream.of(this.jacksonJsonProvider, new CustomResponseMapper())
				.collect(Collectors.toList());
		T restProxy = JAXRSClientFactory.create(this.url, service, providers);
		ClientConfiguration config = WebClient.getConfig(restProxy);
		return restProxy;
	}
}
