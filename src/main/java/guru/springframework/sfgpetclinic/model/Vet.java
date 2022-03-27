package guru.springframework.sfgpetclinic.model;

import java.util.Set;
import java.util.HashSet;

public class Vet extends  Person{
    private Set<Speciality> specialities =  new HashSet<>();

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	} 
	
	
}
