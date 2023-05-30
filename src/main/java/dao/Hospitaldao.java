package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Staff;

public class Hospitaldao {
	EntityManagerFactory EMF=Persistence.createEntityManagerFactory("dev1");
	EntityManager EM=EMF.createEntityManager();
	EntityTransaction ET=EM.getTransaction();
	
	public void savestaff(Staff staff)
	{
		ET.begin();
		EM.persist(staff);
		ET.commit();
	}
	

}