package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }


    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology description");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery description");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry description");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();

        owner1.setFirstName("Eliza");
        owner1.setLastName("Sarkozi");
        owner1.setAddress("Address 1");
        owner1.setCity("Miami");
        owner1.setTelephone("12345");

        Pet elisPet = new Pet();
        elisPet.setPetType(savedDogPetType);
        elisPet.setOwner(owner1);
        elisPet.setBirthDate(LocalDate.now());
        elisPet.setName("Yogi the doggie");
        owner1.getPets().add(elisPet);

        ownerService.save(owner1);
        System.out.println("L-am bagat pe primu: " + owner1.getFirstName());

        Owner owner2 = new Owner();

        owner2.setFirstName("Potato");
        owner2.setLastName("Patata");
        owner2.setAddress("Address 2");
        owner2.setCity("New York");
        owner2.setTelephone("23456");

        Pet potatoPet = new Pet();
        potatoPet.setPetType(savedCatPetType);
        potatoPet.setOwner(owner2);
        potatoPet.setBirthDate(LocalDate.now());
        potatoPet.setName("Cats are evil");
        owner2.getPets().add(potatoPet);

        ownerService.save(owner2);
        System.out.println("Loaded owners");

        Vet vet1 = new Vet();

        vet1.setFirstName("Doc");
        vet1.setLastName("Toru");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Doctor");
        vet2.setLastName("Vet");
        vet2.getSpecialties().add(savedDentistry);
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
