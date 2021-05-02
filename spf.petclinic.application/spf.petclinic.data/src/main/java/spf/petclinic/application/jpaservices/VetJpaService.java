package spf.petclinic.application.jpaservices;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spf.petclinic.application.jpaRepository.VetRepository;
import spf.petclinic.application.model.Vet;
import spf.petclinic.application.services.VetServices;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetServices{
	
	private final VetRepository vetrepository;
	
	public VetJpaService(VetRepository vetrepository) {
		super();
		this.vetrepository = vetrepository;
	}

	@Override
	public Vet findby(Long id) {
		
		return vetrepository.findById(id).orElse(null);
	}

	@Override
	public Set<Vet> findAll() {
		
		Set<Vet> vetset=new HashSet<>();
		 vetrepository.findAll().forEach(vetset::add);
		 return vetset;
	}

	@Override
	public Vet Save(Vet obj) {
		return vetrepository.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		vetrepository.deleteById(id);
		
	}

	@Override
	public void delete(Vet obj) {
		vetrepository.delete(obj);
		
	}

}
