package spf.petclinic.application.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import spf.petclinic.application.model.Pet;
import spf.petclinic.application.model.PetType;
import spf.petclinic.application.model.Speciality;
import spf.petclinic.application.model.Vet;
import spf.petclinic.application.model.Visit;
import spf.petclinic.application.model.owner;
import spf.petclinic.application.services.PetServices;
import spf.petclinic.application.services.PettypeService;
import spf.petclinic.application.services.SpecialityService;
import spf.petclinic.application.services.VetServices;
import spf.petclinic.application.services.VisitService;
import spf.petclinic.application.services.ownerservices;
import spf.petclinic.application.services.map.OwnerServiceMap;
import spf.petclinic.application.services.map.VetServiceMap;
import spf.petclinic.application.services.map.VisitMapService;

@Component
public class Dataloader implements CommandLineRunner{

	private final ownerservices ows;
	private final VetServices Vs;
	private final PettypeService pts;
	private final SpecialityService ss;
	private final VisitService vms;


	public Dataloader(ownerservices ows, VetServices vs, PettypeService pts, SpecialityService ss,
			VisitService vms) {
		super();
		this.ows = ows;
		Vs = vs;
		this.pts = pts;
		this.ss = ss;
		this.vms = vms;
	}


	@Override
	public void run(String... args) throws Exception {
	
		int count = pts.findAll().size();
		
		if(count < 1)
		{
			loadData();
		}
		
		
	}
	
	public void loadData() {
		
		PetType dog=new PetType();
		dog.setName("dog");
		
		pts.Save(dog);
		
		PetType cat=new PetType();
		cat.setName("Cat");
		
		pts.Save(cat);
		
		owner ow1 =new owner();
		ow1.setFirstName("khlnn");
		ow1.setLastName("varma");
		ow1.setAddress("southsea");
		ow1.setCity("hyd");
		ow1.setTelephone("9225656135");
		
		Pet pet1=new Pet();
		pet1.setOwner(ow1);
		pet1.setPettype(dog);
		pet1.setBirthDate(LocalDate.now());
		pet1.setName("it i dog");
		ow1.getPets().add(pet1);
		
		ows.Save(ow1);
		
		owner ow2 = new owner();
		ow2.setFirstName("krishna");
		ow2.setLastName("teja");
		ow2.setAddress("nothsea");
		ow2.setCity("kphb");
		ow2.setTelephone("5485874848");
		
		Pet pet2=new Pet();
		pet2.setOwner(ow2);
		pet2.setPettype(cat);
		pet2.setBirthDate(LocalDate.now());
		pet2.setName("it i cat");
		ow2.getPets().add(pet2);
		
		ows.Save(ow2);
		
		Speciality sp1= new Speciality();
		sp1.setDescription("Radioglogy");
		Speciality savedsp1=ss.Save(sp1);
		
		Speciality sp2= new Speciality();
		sp1.setDescription("Surgory");
		Speciality savedsp2=ss.Save(sp2);
		
		Speciality sp3= new Speciality();
		sp1.setDescription("Dentist");
		Speciality savedsp3=ss.Save(sp3);	
		
		
		
		Vet vet1= new Vet();		
		vet1.setFirstName("sam");
		vet1.setLastName("max");
		vet1.getSpecialities().add(savedsp1);
		
		Vs.Save(vet1);
		
		Vet vet2= new Vet();		
		vet2.setFirstName("monkey");
		vet2.setLastName("lufy");
		vet2.getSpecialities().add(savedsp2);
		
		Vs.Save(vet2);
		
		Visit v1=new Visit();
		v1.setDate(LocalDate.now());
		v1.setDescription("For Dog");
		v1.setPet(pet1);
		
		vms.Save(v1);
		
		
	}
	
	

}
