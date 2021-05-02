package spf.petclinic.application.jpaservices;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spf.petclinic.application.jpaRepository.VisitRepository;
import spf.petclinic.application.model.Visit;
import spf.petclinic.application.services.VisitService;

@Service
@Profile("springdatajpa")
public class VisitjpaService implements VisitService{
	
	private final VisitRepository visitrepository;

	public VisitjpaService(VisitRepository visitrepository) {
		super();
		this.visitrepository = visitrepository;
	}

	@Override
	public Visit findby(Long id) {
		
		return visitrepository.findById(id).orElse(null) ;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visitset=new HashSet<>();
		visitrepository.findAll().forEach(visitset::add);
		return visitset;
	}

	@Override
	public Visit Save(Visit obj) {
		return visitrepository.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		visitrepository.deleteById(id);
		
	}

	@Override
	public void delete(Visit obj) {
		visitrepository.delete(obj);
		
	}

}
