package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Doctor11;
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
	
	public Staff fetchStaff(long phone)
	{
		List<Staff> lst=EM.createQuery("select m from Staff m where phone=?1").setParameter(1, phone).getResultList();
		if(lst.isEmpty())
		{
			return null;
		}else{
			return lst.get(0);
		}
	}
	

	
	public Staff fetchStaff(String email)
	{
		List<Staff> lst2=EM.createQuery("select m from Staff m where email=?1").setParameter(1, email).getResultList();
		if(lst2.isEmpty())
		{
			return null;
		}else{
			return lst2.get(0);
		}
	}
	public void savedoctor(Doctor11 dao)
	{
		ET.begin();
		EM.persist(dao);
		ET.commit();
	}
	public Doctor11 fetchDoctor(long phone)
	{
		List<Doctor11> lst=EM.createQuery("select m from Doctor11  m where phone=?1").setParameter(1, phone).getResultList();
		if(lst.isEmpty())
		{
			return null;
		}else{
			return lst.get(0);
		}
	}
	

	
	public Doctor11 fetchDoctor(String email)
	{
		List<Doctor11> lst2=EM.createQuery("select m from Doctor11 m where email=?1").setParameter(1, email).getResultList();
		if(lst2.isEmpty())
		{
			return null;
		}else{
			return lst2.get(0);
		}
	}
	public  Doctor11 fetchDoctor(int id)
	{
		return EM.find(Doctor11.class,id);
	}

	public Staff fetchStaff(int id)
	{
		return EM.find(Staff.class,id);
	}
	public void updateStaff(Staff s)
	{
		ET.begin();
		EM.merge(s);
		ET.commit();
		
	}
	public void updateDoctor(Doctor11 d)
	{
		ET.begin();
		EM.merge(d);
		ET.commit();
		
	}
	public List<Staff> fetchstaffaprovel(){
		return EM.createQuery("select s from Staff s").getResultList();
	}
	
	public List<Doctor11> fetchdoctoraprovel(){
		return EM.createQuery("select s from Doctor11 s").getResultList();
	}
	} 
