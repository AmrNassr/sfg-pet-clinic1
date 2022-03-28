 package guru.springframework.sfgpetclinic.Services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.Services.SpecialityService;
import guru.springframework.sfgpetclinic.Services.VetService;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.repositories.VetRepository;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService{
	private final SpecialityService specialityService;
	private final VetRepository vetRepository;
	
	public VetSDJpaService(SpecialityService specialityService, VetRepository vetRepository) {
		this.specialityService = specialityService;
		this.vetRepository = vetRepository;
	}
	@Override
	public Set<Vet> findAll() {
		
		Set<Vet> vets=new HashSet<>();
		vetRepository.findAll().forEach(vets::add );
		return vets;
	}
	@Override
	public Vet findByID(Long id) {
		Optional<Vet> optionalVet=vetRepository.findById(id);
		if(optionalVet.isPresent())
		{
			return optionalVet.get();
			
		}
		else
		{
			return optionalVet.orElse(null);
		}
		
	}
	@Override
	public Vet save(Vet object) {
		
		return vetRepository.save(object);
	}
	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
		
	}
	@Override
	public void deleteByID(Long id) {
		vetRepository.deleteById(id);
		
	}
	
}
