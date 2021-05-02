package spf.petclinic.application.jpaRepository;

import org.springframework.data.repository.CrudRepository;

import spf.petclinic.application.model.owner;

public interface ownerRepository extends CrudRepository<owner, Long> {

}
