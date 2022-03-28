package guru.springframework.sfgpetclinic.Services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.Services.SpecialityService;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService{
	SpecialityRepository specialityRepository;
	

	public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
		
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities=new HashSet<>();
		specialityRepository.findAll().forEach(specialities::add);
		return specialities;
	}

	@Override
	public Speciality findByID(Long id) {
		Optional<Speciality> optionalSpeciality=specialityRepository.findById(id);
		if(optionalSpeciality.isPresent())
		{
			return optionalSpeciality.get();
		}
		else
		{
		return optionalSpeciality.orElse(null);
		}
	}

	@Override
	public Speciality save(Speciality object) {
		
		return specialityRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		specialityRepository.delete(object);
		
	}

	@Override
	public void deleteByID(Long id) {
		specialityRepository.deleteById(id);
		
	}

}
