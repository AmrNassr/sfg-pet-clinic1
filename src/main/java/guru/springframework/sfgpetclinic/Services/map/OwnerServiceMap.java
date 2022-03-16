package guru.springframework.sfgpetclinic.Services.map;

import guru.springframework.sfgpetclinic.Services.CrudService;
import guru.springframework.sfgpetclinic.Services.OwnerService;
import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

import org.springframework.stereotype.Service;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
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
        return super.save(object.getId(),object);
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
