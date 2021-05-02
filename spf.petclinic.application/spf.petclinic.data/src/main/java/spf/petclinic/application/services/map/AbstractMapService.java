package spf.petclinic.application.services.map;

import java.util.*;

import spf.petclinic.application.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
	
	protected Map<Long,T> map = new HashMap<>();
	
	Set<T> findAll()
	{
		return new HashSet<>(map.values());
	}
	T findby(ID id)
	{
		return map.get(id);
	}
	
	T save(T object)
	{
		if(object != null)
		{
			if(object.getId() == null)
			{
				object.setId(getNextid());
			}
			map.put(object.getId(), object);
		}	else {
			throw new RuntimeException("Object cannot be null");
		}
		
		return object;
	}
	
	void deleteById(ID id)
	{
		map.remove(id);
	}
	
	void delete(T obj)
	{
		map.entrySet().removeIf(entry -> entry.getValue().equals(obj));
	}
	
	public Long getNextid() {
		Long nextid= null;
		try {
		nextid = Collections.max(map.keySet()) + 1;
		}
		catch(NoSuchElementException e)
		{
			nextid=1L;
		}
		
		return nextid;
	}

}
