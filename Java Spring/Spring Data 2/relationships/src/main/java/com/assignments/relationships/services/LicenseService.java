package com.assignments.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignments.relationships.models.License;
import com.assignments.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {

	private final LicenseRepository licenseRepository;

	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}

	public List<License> allLicense() {
		return licenseRepository.findAll();
	}

	public License createLicense(License license) {

		Integer val = 1;

		String str = String.format("%05d", val);

		license.setNumber(str);
		return licenseRepository.save(license);
	}

	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
}
