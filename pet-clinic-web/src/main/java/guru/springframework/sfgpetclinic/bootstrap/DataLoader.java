package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();

        owner1.setFirstName("Eliza");
        owner1.setLastName("Sarkozi");

        ownerService.save(owner1);
        System.out.println("L-am bagat pe primu: " + owner1.getFirstName());

        Owner owner2 = new Owner();

        owner2.setFirstName("Potato");
        owner2.setLastName("Patata");

        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet();

        vet1.setFirstName("Doc");
        vet1.setLastName("Toru");

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Doctor");
        vet2.setLastName("Vet");

        vetService.save(vet2);

        System.out.println("Loaded vets...");



    }
}
