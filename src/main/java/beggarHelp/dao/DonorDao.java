package beggarHelp.dao;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import beggarHelp.model.Donor;
import beggarHelp.model.Institution;

public class DonorDao implements Dao<Donor> {

	private EntityManager em;

	public DonorDao() {
		em = JPAUtil.getEntityManagerFactory().createEntityManager();
	}

	@Override
	public Donor get(int id) {
		return em.find(Donor.class, id);
	}

	@Override
	public List<Donor> getAll() {
		return em.createQuery("FROM Donor", Donor.class).getResultList();
	}

	@Override
	public void save(Donor instance) {
		executeInsideTransaction(em -> em.persist(instance));
	}

	@Override
	public void update(Donor instance) {
		executeInsideTransaction(em -> em.merge(instance));
	}

	@Override
	public void delete(Donor instance) {
		executeInsideTransaction(em -> em.remove(instance));
	}
	
	
	public void deleteAux(Donor instance){
       
		InstitutionDao iDao = new InstitutionDao();
		Institution inst = iDao.get(1);
		
        em.getTransaction().begin();
        inst.getDoadores().remove(instance);
        em.remove(inst);
        em.getTransaction().commit();
	}

	
	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			action.accept(em);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}

	public List<Donor> logar(String email, String password) {

		Query q = em.createQuery("SELECT i FROM Donor i WHERE i.email = :email AND i.password = :password");
		q.setParameter("email", email);
		q.setParameter("password", password);

		System.out.println(q.getResultList());
		return q.getResultList();
	}
	
	

}