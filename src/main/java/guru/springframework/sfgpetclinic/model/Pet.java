package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{
	@Column(name = "name")
	private String name;
    @Column(name = "BirthDate")
    private LocalDate BirthDate;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<Visit> visitis= new HashSet<>();

    public Set<Visit> getVisitis() {
		return visitis;
	}

	public void setVisitis(Set<Visit> visitis) {
		this.visitis = visitis;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate BirthDate) {
        this.BirthDate = BirthDate;
    }
}
