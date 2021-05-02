package spf.petclinic.application.jpaRepository;

import org.springframework.data.repository.CrudRepository;

import spf.petclinic.application.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
