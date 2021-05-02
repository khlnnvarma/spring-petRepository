package spf.petclinic.application.services;

import java.util.Set;

import spf.petclinic.application.model.owner;

public interface CurdServices <T,ID>{
	
	T findby(ID id);
	
	Set<T> findAll();
	
	T Save(T obj);
	
	void deleteById(ID id);
	
	void delete(T obj);

}
