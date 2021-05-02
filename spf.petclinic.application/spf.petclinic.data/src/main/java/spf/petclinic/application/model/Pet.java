package spf.petclinic.application.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="Pet")
public class Pet extends BaseEntity{

	@ManyToOne
	@JoinColumn(name="type_id")
	private PetType pettype;
	@ManyToOne
	@JoinColumn(name= "owner_id")
	private owner Owner;
	@Column(name="birth_Date")
	private LocalDate birthDate;
	@Column(name="name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
	private Set<Visit> visits = new HashSet<>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PetType getPettype() {
		return pettype;
	}
	public void setPettype(PetType pettype) {
		this.pettype = pettype;
	}
	public owner getOwner() {
		return Owner;
	}
	public void setOwner(owner owner) {
		Owner = owner;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Set<Visit> getVisits() {
		return visits;
	}
	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
	

}
