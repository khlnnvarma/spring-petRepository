package spf.petclinic.application.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spf.petclinic.application.model.Speciality;
import spf.petclinic.application.model.Vet;
import spf.petclinic.application.services.SpecialityService;
@Service
@Profile({"default","map"})
public class SpecialityServicemap extends AbstractMapService<Speciality, Long> implements SpecialityService {

	@Override
	public Speciality findby(Long id) {
	
		return super.findby(id);
	}
	
	@Override
	public Set<Speciality> findAll() {
	
		return super.findAll();
	}

	@Override
	public Speciality Save(Speciality obj) {
		return super.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
		
	}
	
	@Override
	public void delete(Speciality obj) {
		super.delete(obj);
		
	}
}
