package spf.petclinic.application.jpaservices;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spf.petclinic.application.jpaRepository.PetRepository;
import spf.petclinic.application.jpaRepository.PetTypeRepository;
import spf.petclinic.application.jpaRepository.ownerRepository;
import spf.petclinic.application.model.owner;
import spf.petclinic.application.services.ownerservices;

@Service
@Profile("springdatajpa")
public class ownerJpaService implements ownerservices {
	
	private final ownerRepository ownerrepository;
	private final PetRepository petrepository;
	private final PetTypeRepository pettyperepository;
	
	public ownerJpaService(ownerRepository ownerrepository, PetRepository petrepository,
			PetTypeRepository pettyperepository) {
		super();
		this.ownerrepository = ownerrepository;
		this.petrepository = petrepository;
		this.pettyperepository = pettyperepository;
	}

	@Override
	public owner findby(Long id) {
		
		Optional<owner> ownerrep= ownerrepository.findById(id);
		
		return ownerrep.orElse(null);
	}

	@Override
	public Set<owner> findAll() {
		
		Set<owner> owners =new HashSet<>();
		
		 ownerrepository.findAll().forEach(owners::add);
		 
		 return owners;
	}

	@Override
	public owner Save(owner obj) {
		
		return ownerrepository.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		ownerrepository.deleteById(id);
		
	}

	@Override
	public void delete(owner obj) {
		ownerrepository.delete(obj);
		
	}

	@Override
	public owner findbylastName(String lastName) {
		return null;
	}

}
