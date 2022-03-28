package guru.springframework.sfgpetclinic.Services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.Services.PetService;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.PetRepository;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {
	
	PetRepository petRepository;
	
	public PetSDJpaService(PetRepository petRepository) {
		
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public Pet findByID(Long id) {
		Optional<Pet> optionalPet=petRepository.findById(id);
		if(optionalPet.isPresent())
		{
			return optionalPet.get();
		}
		else{
		return optionalPet.orElse(null);
		}
	}

	@Override
	public Pet save(Pet object) {
		
		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
		
	}

	@Override
	public void deleteByID(Long id) {
		petRepository.deleteById(id);
		
	}

}
