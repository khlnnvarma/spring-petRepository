package spf.petclinic.application.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spf.petclinic.application.model.Pet;
import spf.petclinic.application.model.PetType;
import spf.petclinic.application.model.Vet;
import spf.petclinic.application.services.PettypeService;
@Service
@Profile({"default","map"})
public class PettypeMap extends AbstractMapService<PetType, Long> implements PettypeService{

	@Override
	public PetType findby(Long id) {
		return super.findby(id);
	}

	@Override
	public PetType Save(PetType obj) {
		return super.save(obj);
	}

	@Override
	public void delete(PetType obj) {
		super.delete(obj);
		
	}
	@Override
	public Set<PetType> findAll() {
	
		return super.findAll();
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
		
	}

}
