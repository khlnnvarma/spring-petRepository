package spf.petclinic.application.jpaservices;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spf.petclinic.application.jpaRepository.PetTypeRepository;
import spf.petclinic.application.model.PetType;
import spf.petclinic.application.services.PetServices;
import spf.petclinic.application.services.PettypeService;

@Service
@Profile("springdatajpa")
public class PetTypejpaService implements PettypeService{

	private final PetTypeRepository pettyperepository;
	
	public PetTypejpaService(PetTypeRepository pettyperepository) {
		super();
		this.pettyperepository = pettyperepository;
	}

	@Override
	public PetType findby(Long id) {
		return pettyperepository.findById(id).orElse(null);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> pettypeset=new HashSet<>();
		 pettyperepository.findAll().forEach(pettypeset::add);
		 return pettypeset;
	}

	@Override
	public PetType Save(PetType obj) {
		return pettyperepository.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		pettyperepository.deleteById(id);
		
	}

	@Override
	public void delete(PetType obj) {
		pettyperepository.delete(obj);
		
	}

}
