package com.inti.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.inti.model.Magasin;
import com.inti.util.HibernateUtil;

@Service
public class MagasinServiceImpl implements IMagasinService{
	public static Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public List<Magasin> getMagasins() {
List<Magasin> listeMagasins = null;
		
		try
		{
			session.beginTransaction();
			
			listeMagasins = session.createQuery("from Magasin", Magasin.class).list();
			
			session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return listeMagasins;
	}

	@Override
	public void saveMagasin(Magasin m) {
		try
		{
			session.beginTransaction();
			
			
			session.save(m);
			
			session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	@Override
	public Magasin getMagasin(int id) {
		Magasin mag = null;
		try
		{
			session.beginTransaction();
			
			mag = session.get(Magasin.class, id);
			
			session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return mag;
	}

	@Override
	public void deleteMagasin(int id) {
		try
		{
			session.beginTransaction();
			
			session.delete(session.get(Magasin.class, id));
			
			session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
	}

	@Override
	public Magasin updateMagasin(Magasin m) {
		try
		{
			session.beginTransaction();
			
			session.update(m);
			
			session.getTransaction().commit();			
		}
		catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return m;
		
	}
	
}
