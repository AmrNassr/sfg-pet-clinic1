package guru.springframework.sfgpetclinic.Services.map;

import guru.springframework.sfgpetclinic.Services.CrudService;
import guru.springframework.sfgpetclinic.Services.SpecialityService;
import guru.springframework.sfgpetclinic.Services.VetService;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

import org.springframework.stereotype.Service;
@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
	private final SpecialityService specialityService;
    public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	@Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet findByID(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Vet save(Vet object) {
    	if(object.getSpecialities().size()>0)
    	{
    		object.getSpecialities().forEach(speciality ->{
    			if(speciality.getId()==null)
    			{
    				Speciality saveSpeciality = specialityService.save(speciality);
    				speciality.setId(saveSpeciality.getId());
    			}
    		});
    	}
        return super.save(object);
    }

    @Override
    public void deleteByID(Long aLong) {
        super.deleteById(aLong);
    }
}
