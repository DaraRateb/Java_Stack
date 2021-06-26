package com.assignments.dojo.and.ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignments.dojo.and.ninjas.models.Dojo;
import com.assignments.dojo.and.ninjas.models.Ninja;
import com.assignments.dojo.and.ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}

	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}

	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}

	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}

	public List<Ninja> findDojoNinjas(Dojo dojo) {
		return ninjaRepository.findByDojo(dojo);
	}

}
