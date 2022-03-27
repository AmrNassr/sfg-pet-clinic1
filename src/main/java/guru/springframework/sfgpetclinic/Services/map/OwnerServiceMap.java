package guru.springframework.sfgpetclinic.Services.map;

import guru.springframework.sfgpetclinic.Services.CrudService;
import guru.springframework.sfgpetclinic.Services.OwnerService;
import guru.springframework.sfgpetclinic.Services.PetService;
import guru.springframework.sfgpetclinic.Services.PetTypeService;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;

import java.util.Set;

import org.springframework.stereotype.Service;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
	 private final PetTypeService petTypeService;
	    private final PetService petService;

	    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
	        this.petTypeService = petTypeService;
	        this.petService = petService;
	    }

	@Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByID(Long aLong) {
        return super.findById(aLong);
    } 

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {

                    // save pet type
                    PetType petType = pet.getPetType();
                    if (petType != null) {
                        if (petType.getId() == null) {
                            pet.setPetType(petTypeService.save(petType));
                        }
                    }
                    else {
                       throw new RuntimeException("Pet Type is required");
                    }

                    // save pet
                    if (pet.getId() == null) {
                    	Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            // save owner
            return super.save(object);
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteByID(Long aLong) {
        super.findById(aLong);
    }

	@Override
	public Owner findByLastName(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}
}
