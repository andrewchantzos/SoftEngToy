package persistence.model;

import model.Family;
import persistence.generic.GenericServiceImpl;

public class FamilyService extends GenericServiceImpl<Family>{
	
	public FamilyService() {
		super(Family.class);
	}
}