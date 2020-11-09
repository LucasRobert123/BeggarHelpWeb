package beggarHelp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import beggarHelp.model.Donor;

public class DonorDao implements Dao<Donor>{

	private EntityManager em;

	public DonorDao() {
		em = JPAUtil.getEntityManagerFactory().createEntityManager();
	}

	@Override
	public Donor get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Donor> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Donor t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Donor t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Donor t) {
		// TODO Auto-generated method stub
		
	}

		
	
}