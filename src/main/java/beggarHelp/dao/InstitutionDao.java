package beggarHelp.dao;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import beggarHelp.model.Institution;


public class InstitutionDao implements Dao<Institution> {

private EntityManager em;
	
	public InstitutionDao() {
		em = JPAUtil.getEntityManagerFactory().createEntityManager();
	}

	@Override
	public Institution get(int id) {
		return em.find(Institution.class,id);
	}

	@Override
	public List<Institution> getAll() {
		return em.createQuery("FROM Institution",Institution.class ).getResultList();
	}

	@Override
	public void save(Institution instance) {
		 executeInsideTransaction(em -> em.persist(instance));	
	}

	@Override
	public void update(Institution instance) {
		 executeInsideTransaction(em -> em.merge(instance));	
	}

	@Override
	public void delete(Institution instance) {
		 executeInsideTransaction(em -> em.remove(instance));	
	}

	private void executeInsideTransaction(Consumer<EntityManager> action ) {
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			action.accept(em);
			tx.commit();
		}
		catch(RuntimeException e){
			tx.rollback();
			throw e;
		}
	}
	
	

	public List<Institution> logar(String email, String password) {
		
		Query q = em.createQuery("SELECT i FROM Institution i WHERE i.email = :email AND i.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);
		
		return q.getResultList();
	}
	
	public List<Institution> filterInstitution(String uf, String city) {

		Query q = em.createQuery("SELECT i FROM Institution i WHERE i.uf = :uf AND i.city = :city");
		q.setParameter("uf", uf);
		q.setParameter("city", city);

		return q.getResultList();
	}
}
