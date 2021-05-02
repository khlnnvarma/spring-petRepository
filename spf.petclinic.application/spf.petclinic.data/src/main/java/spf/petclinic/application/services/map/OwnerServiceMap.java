package spf.petclinic.application.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spf.petclinic.application.model.Pet;
import spf.petclinic.application.model.owner;
import spf.petclinic.application.services.CurdServices;
import spf.petclinic.application.services.PetServices;
import spf.petclinic.application.services.PettypeService;
import spf.petclinic.application.services.ownerservices;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<owner, Long> implements ownerservices{

	private final PetServices ps;
	private final PettypeService pts; 
	
	public OwnerServiceMap(spf.petclinic.application.services.PettypeService pts, PetServices ps) {
		super();
		this.ps = ps;
		this.pts = pts;
	}

	@Override
	public owner findby(Long id) {
	
		return super.findby(id);
	}
	
	@Override
	public Set<owner> findAll() {
	
		return super.findAll();
	}

	@Override
	public owner Save(owner obj) {
		
		if(obj != null) {
			
			if(obj.getPets().size() > 0)
			{
				obj.getPets().forEach(pet -> {
					if(pet.getPettype()!=null) {
						if(pet.getPettype().getId() == null)
							pet.setPettype(pts.Save(pet.getPettype()));
					}
					else						
					{
						throw new RuntimeException("pet type is required.");
					}
					if(pet.getId() == null)
					{
						Pet savedpet = ps.Save(pet);
						pet.setId(savedpet.getId());
					}
				});
			}
			
			
			return super.save(obj);
		}
		else
		{
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
		
	}
	
	@Override
	public void delete(owner obj) {
		super.delete(obj);
		
	}

	@Override
	public owner findbylastName(String lastName) {
		// 
		return null;
	}


}
