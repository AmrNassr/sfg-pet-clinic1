package guru.springframework.sfgpetclinic.Services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.Services.PetTypeService;
import guru.springframework.sfgpetclinic.model.PetType;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }
    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

	@Override
	public PetType findByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByID(Long id) {
		// TODO Auto-generated method stub
		
	}
}
