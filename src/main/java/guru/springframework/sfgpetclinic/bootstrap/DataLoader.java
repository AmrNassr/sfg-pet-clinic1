package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.Services.OwnerService;
import guru.springframework.sfgpetclinic.Services.PetService;
import guru.springframework.sfgpetclinic.Services.PetTypeService;
import guru.springframework.sfgpetclinic.Services.SpecialityService;
import guru.springframework.sfgpetclinic.Services.VetService;
import guru.springframework.sfgpetclinic.Services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.Services.map.PetServiceMap;
import guru.springframework.sfgpetclinic.Services.map.VetServiceMap;
import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Speciality;

@Component
public class DataLoader implements CommandLineRunner {
	  private final OwnerService ownerService;
	    private final VetService vetService;
	    private final PetTypeService petTypeService;
	    private final SpecialityService specialityService;

		public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService ,SpecialityService specialityService) {
	        this.ownerService = ownerService;
	        this.vetService = vetService;
	        this.petTypeService = petTypeService;
	        this.specialityService = specialityService;
	    }

	    @Override
	    public void run(String... args) throws Exception {

	    	int count=petTypeService.findAll().size();
	    	if(count == 0 )
	    	{
	    		LoadData();
	    	}
	    }

		private void LoadData() {
			PetType dog = new PetType();
	        dog.setName("Dog");
	        PetType savedDogPetType = petTypeService.save(dog);

	        PetType cat = new PetType();
	        dog.setName("Cat");
	        PetType savedCatPetType = petTypeService.save(cat);
	        Speciality radiology = new Speciality();
	        radiology.setDescription("Radiology");
	       Speciality saveRadiology=specialityService.save(radiology);
	       
	        Speciality surgery = new Speciality();
	        surgery.setDescription("Surgery");
	        Speciality saveSurgery=specialityService.save(surgery);
	        
	        Speciality dentistry = new Speciality();
	        dentistry.setDescription("Dentistry");
	        Speciality saveDentistry=specialityService.save(dentistry);

	        Owner owner1 = new Owner();
	        owner1.setFirstName("Michael");
	        owner1.setLastName("Weston");
	        owner1.setAddress("Bounty 4");
	        owner1.setCity("Bremen");
	        owner1.setTelephone("1234567890");

	        Pet mikesPet = new Pet();
	        mikesPet.setPetType(savedDogPetType);
	        mikesPet.setOwner(owner1);
	        mikesPet.setBirthDate(LocalDate.now());
	        mikesPet.setName("Mikes pet");
	        owner1.getPets().add(mikesPet);
	        ownerService.save(owner1);


	        Owner owner2 = new Owner();
	        owner2.setFirstName("Fiona");
	        owner2.setLastName("Glenanne");
	        owner2.setAddress("Beauty 5");
	        owner2.setCity("Hamburg");
	        owner2.setTelephone("6664567890");

	        Pet fionasPet = new Pet();
	        fionasPet.setPetType(savedCatPetType);
	        fionasPet.setOwner(owner1);
	        fionasPet.setBirthDate(LocalDate.now());
	        fionasPet.setName("Fionas pet");
	        owner2.getPets().add(fionasPet);
	        ownerService.save(owner2);

	        System.out.println("Loaded Owners....");
	        System.out.println("Loaded Owners");

	        Vet vet1 = new Vet();
	        vet1.setFirstName("Sam");
	        vet1.setLastName("Axe");
	        vet1.getSpecialities().add(saveDentistry);
            vetService.save(vet1);

	        Vet vet2 = new Vet();
	        vet2.setFirstName("Jessie");
	        vet2.setLastName("Porter");
	        vet2.getSpecialities().add(saveSurgery);

	        vetService.save(vet2);

	        System.out.println("Loaded Vets....");
		}
	}