package spf.petclinic.application.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import spf.petclinic.application.model.Speciality;
import spf.petclinic.application.model.Vet;
import spf.petclinic.application.services.CurdServices;
import spf.petclinic.application.services.VetServices;

@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetServices{
	
	private SpecialityServicemap ssm;



	@Override
	public Vet findby(Long id) {
	
		return super.findby(id);
	}
	
	@Override
	public Set<Vet> findAll() {
	
		return super.findAll();
	}

	@Override
	public Vet Save(Vet obj) {
		
		if(obj != null)
		{
			if(obj.getSpecialities().size() > 0)
			{
				obj.getSpecialities().forEach(special -> {
					if(special.getDescription() == null)
					{
						if(special.getId() == null)
						{
							Speciality sp= ssm.Save(special);
							special.setId(sp.getId());
						}
					}
				});
			}
		}
		
		return super.save(obj);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
		
	}
	
	@Override
	public void delete(Vet obj) {
		super.delete(obj);
		
	}

	
	public SpecialityServicemap getSsm() {
		return ssm;
	}

	public void setSsm(SpecialityServicemap ssm) {
		this.ssm = ssm;
	}

}
