package spf.petclinic.application.services.map;

import spf.petclinic.application.services.CurdServices;
import spf.petclinic.application.services.PetServices;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spf.petclinic.application.model.Pet;
@Service
@Profile({"default","map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetServices {

	@Override
	public Pet findby(Long id) {
	
		return super.findby(id);
	}
	
	@Override
	public Set<Pet> findAll() {
	
		return super.findAll();
	}

	@Override
	public Pet Save(Pet obj) {
		return super.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
		
	}
	
	@Override
	public void delete(Pet obj) {
		super.delete(obj);
		
	}


}
