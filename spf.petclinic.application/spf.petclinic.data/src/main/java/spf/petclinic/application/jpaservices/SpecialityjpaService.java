package spf.petclinic.application.jpaservices;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spf.petclinic.application.jpaRepository.SpecialityRepository;
import spf.petclinic.application.model.Speciality;
import spf.petclinic.application.services.SpecialityService;

@Service
@Profile("springdatajpa")
public class SpecialityjpaService implements SpecialityService {
	
	private final SpecialityRepository specialityrepository;

	public SpecialityjpaService(SpecialityRepository specialityrepository) {
		super();
		this.specialityrepository = specialityrepository;
	}

	@Override
	public Speciality findby(Long id) {
		
		return specialityrepository.findById(id).orElse(null);
	}

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> spset=new HashSet<>();
		specialityrepository.findAll().forEach(spset::add);
		return spset;
	}

	@Override
	public Speciality Save(Speciality obj) {
		return specialityrepository.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		specialityrepository.deleteById(id);
	}

	@Override
	public void delete(Speciality obj) {
		specialityrepository.delete(obj);
	}

}
