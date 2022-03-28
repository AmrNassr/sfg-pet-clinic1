package guru.springframework.sfgpetclinic.Services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.Services.OwnerService;
import guru.springframework.sfgpetclinic.Services.PetService;
import guru.springframework.sfgpetclinic.Services.PetTypeService;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
	 private final PetTypeService petTypeService;
	 private final PetService petService;
	 private final OwnerRepository ownerRepository;
	 
	public OwnerSDJpaService(PetTypeService petTypeService, PetService petService, OwnerRepository ownerRepository) {
		this.petTypeService = petTypeService;
		this.petService = petService;
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners :: add );
		return owners;
	}

	@Override
	public Owner findByID(Long id) {
		Optional<Owner> optionalOwner=ownerRepository.findById(id);
		if(optionalOwner.isPresent())
		{
			return optionalOwner.get();
		}
		else
		{
			return optionalOwner.orElse(null);
		}
	}

	@Override
	public Owner save(Owner object) {
		
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		 ownerRepository.delete(object);
		
	}

	@Override
	public void deleteByID(Long id) {
		ownerRepository.deleteById(id);
		
	}

	@Override
	public Owner findByLastName(String lastname) {
		
		return ownerRepository.findByLastName(lastname);
	}

}
