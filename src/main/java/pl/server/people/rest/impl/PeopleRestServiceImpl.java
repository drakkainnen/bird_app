package pl.server.people.rest.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.server.birds.exceptions.CustomException;
import pl.server.birds.rest.api.BirdRestService;
import pl.server.people.config.proxy.BirdsProxy;
import pl.server.people.rest.api.PeopleRestService;

@Service
public class PeopleRestServiceImpl implements PeopleRestService {

	private static final Logger LOG = LoggerFactory.getLogger(PeopleRestServiceImpl.class);
	private List<String> people = Stream.of("Adam", "Wojtek").collect(Collectors.toList());

	@Autowired
	private BirdsProxy birdsProxy;

	@Override
	public List<String> people() {
		return people;
	}

	@Override
	public String personWithBirds(int id) {

		try {
			String person = people.get(id);
			BirdRestService proxy = birdsProxy.createProxy(BirdRestService.class);
			String bird = proxy.getBirdByPeronName(person);
			return String.join(" - ", person, bird);
		} catch (CustomException e) {
			LOG.error(e.getMessage());
			throw new CustomException(e.getMessage());
		}
	}

}
