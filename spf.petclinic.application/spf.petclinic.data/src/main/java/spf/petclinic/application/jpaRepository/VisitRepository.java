package spf.petclinic.application.jpaRepository;

import org.springframework.data.repository.CrudRepository;

import spf.petclinic.application.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
