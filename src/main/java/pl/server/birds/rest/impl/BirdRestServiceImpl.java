package pl.server.birds.rest.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import pl.server.birds.exceptions.CustomException;
import pl.server.birds.rest.api.BirdRestService;

@Service
public class BirdRestServiceImpl implements BirdRestService {

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(BirdRestService.class);

	private Map<String, String> birds = createBirds();

	private static Map<String, String> createBirds() {
		HashMap<String, String> map = new HashMap<>();
		map.put("Adam", "123");
		return map;
	}

	@Override
	public String getBrocken() {
		throw new CustomException("dupadupa");
	}

	@Override
	public List<String> getAllBirds() {
		return new ArrayList<>(birds.values());
	}

	@Override
	public String getBirdByPeronName(String name) {

		LOG.info(name);
		if (name != null) {
			throw new CustomException("omfg");
		}
		return birds.getOrDefault(name, "");
	}

}
