package spf.petclinic.application.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spf.petclinic.application.model.Pet;
import spf.petclinic.application.model.Speciality;
import spf.petclinic.application.model.Vet;
import spf.petclinic.application.model.Visit;
import spf.petclinic.application.services.VisitService;

@Service
@Profile({"default","map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Visit findby(Long id) {
	
		return super.findby(id);
	}
	
	@Override
	public Set<Visit> findAll() {
	
		return super.findAll();
	}

	@Override
	public Visit Save(Visit obj) {
		
		if(obj.getPet() == null && obj.getPet().getOwner() == null && obj.getId() == null && obj.getPet().getId() == null )
		{
			throw new RuntimeException("Inavalid visit");
		}
		
		return super.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
		
	}
	
	@Override
	public void delete(Visit obj) {
		super.delete(obj);
		
	}

}
