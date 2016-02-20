package fishing.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fishing.dao.Catch;

public class CatchesService {

	private EntityManager manager;
	public CatchesService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		manager = emf.createEntityManager();
	}
	public List<Catch> getCatchesList() {
		try {
			manager.getTransaction().begin();
			List<Catch> listCatches = manager.createQuery("from Catch", Catch.class).getResultList();
			manager.getTransaction().commit();
			return listCatches;
		} catch (Exception ex) {
			System.out.println("Exception while processing CatchesService (list of catches):\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
			manager.getTransaction().rollback();
			return null;
		}
	}

	public Catch getCatch(int id) {
		try {
			manager.getTransaction().begin();
			Catch  ret = manager.getReference(Catch.class, id);
			manager.getTransaction().commit();
			return ret;
		} catch (Exception ex) {
			System.out.println("Exception while processing CatchesService (concrete catch):\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
			manager.getTransaction().rollback();
			return null;
		}
	}

	public void createCatch(Catch catch_) {
		try {
			manager.getTransaction().begin();
			if (catch_.getId() == 0)
				manager.persist(catch_);
			else
				manager.merge(catch_);
			manager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Exception while processing CatchesService (creaing catch):\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
		}
	}
	public void deleteCatch(Catch catch_) {

		if (catch_.getId() != 0) {
			try {
				manager.getTransaction().begin();
				catch_ = manager.getReference(Catch.class, catch_.getId());
				manager.remove(catch_);
				manager.getTransaction().commit();
			} catch (Exception ex) {
				System.out.println("Exception while processing CatchsService (deleting catch):\n" + ex.getMessage() + "\nStack:\n");
				ex.printStackTrace();
			}
		}

	}
}
