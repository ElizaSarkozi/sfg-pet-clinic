package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {


    ///added comments so i can do a push
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
