package spf.petclinic.application.jpaservices;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spf.petclinic.application.jpaRepository.PetRepository;
import spf.petclinic.application.model.Pet;
import spf.petclinic.application.services.PetServices;

@Service
@Profile("springdatajpa")
public class PetjpaService implements PetServices{
	
	private final PetRepository  petrepository;
	
	public PetjpaService(PetRepository petrepository) {
		super();
		this.petrepository = petrepository;
	}

	@Override
	public Pet findby(Long id) {
		return petrepository.findById(id).orElse(null);
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> petset =new HashSet<>();
		petrepository.findAll().forEach(petset::add);
		return petset;
	}

	@Override
	public Pet Save(Pet obj) {
		
		return petrepository.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		petrepository.deleteById(id);
		
	}

	@Override
	public void delete(Pet obj) {
		petrepository.delete(obj);
		
	}

}
