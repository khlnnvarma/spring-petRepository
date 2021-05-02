package spf.petclinic.application.jpaRepository;

import org.springframework.data.repository.CrudRepository;

import spf.petclinic.application.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
