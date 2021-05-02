package spf.petclinic.application.services;

import java.util.Set;

import spf.petclinic.application.model.*;

public interface ownerservices extends CurdServices<owner, Long>{
	
	owner findbylastName(String lastName);

}
