package guru.springframework.sfgpetclinic.Services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.Services.PetTypeService;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService{
	private final PetTypeRepository petTypeRepository;
	

	public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
		
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes =new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public PetType findByID(Long id) {
		Optional<PetType> optionalPetType=petTypeRepository.findById(id);
		if(optionalPetType.isPresent())
		{
			return optionalPetType.get();
		}
		else
		{
			return optionalPetType.orElse(null);
		}
	}

	@Override
	public PetType save(PetType object) {
		
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
		
	}

	@Override
	public void deleteByID(Long id) {
		petTypeRepository.deleteById(id);
		
	}

}
