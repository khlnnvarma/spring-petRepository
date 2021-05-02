package spf.petclinic.application.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vets")
public class Vet extends person{
	
	@ManyToMany
	@JoinTable(name="vet_specialities", joinColumns = @JoinColumn(name="vet_id"),
	inverseJoinColumns =@JoinColumn(name="speciality_id"))
	private Set<Speciality> specialities= new HashSet<>();

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}

}
