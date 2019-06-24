package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Eliza");
        owner1.setLastName("Sarkozi");

        ownerService.save(owner1);
        System.out.println("L-am bagat pe primu: " + owner1.getFirstName());

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Potato");
        owner2.setLastName("Patata");

        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet();
        vet1.setId(3L);
        vet1.setFirstName("Doc");
        vet1.setLastName("Toru");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(4L);
        vet2.setFirstName("Doctor");
        vet2.setLastName("Vet");

        vetService.save(vet2);

        System.out.println("Loaded vets...");



    }
}
