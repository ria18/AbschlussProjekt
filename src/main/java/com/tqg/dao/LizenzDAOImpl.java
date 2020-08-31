package com.tqg.dao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.tqg.model.Lizenz;

@Repository
public class LizenzDAOImpl implements LizenzDAO {

	@Autowired
	private SessionFactory sessionFactory;


	public void addLizenz(Lizenz lizenz) {
		sessionFactory.getCurrentSession().saveOrUpdate(lizenz);
		 
	      

	}
	@Override
	public void deleteLizenz(Integer lizenzId) {
		Lizenz lizenz = (Lizenz) sessionFactory.getCurrentSession().load(
				Lizenz.class, lizenzId);
		if (null != lizenz) {
			this.sessionFactory.getCurrentSession().delete(lizenz);
		}

	}
	
	@Override
	public Lizenz updateLizenz(Lizenz lizenz) {
		sessionFactory.getCurrentSession().update(lizenz);
		return lizenz;
	}
	

	@SuppressWarnings("unchecked")
	public List<Lizenz> getAllLizenzs() {

		return sessionFactory.getCurrentSession().createQuery("from Lizenz")
				.list();
	}



	public Lizenz getLizenzById(int lizenzid) {
		return (Lizenz) sessionFactory.getCurrentSession().get(
				Lizenz.class, lizenzid);
	}
	
	
	//  Junit Test getting singel Lizenz based on id
	@Override
	public Lizenz get(int id) {
		
		return  (Lizenz) sessionFactory.getCurrentSession().get(
				Lizenz.class, Integer.valueOf(id));
	}
	


	
}