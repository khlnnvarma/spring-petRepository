package spf.petclinic.application.jpaRepository;

import org.springframework.data.repository.CrudRepository;

import spf.petclinic.application.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
