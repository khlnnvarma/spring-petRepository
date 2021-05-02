package spf.petclinic.application.jpaRepository;

import org.springframework.data.repository.CrudRepository;

import spf.petclinic.application.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
