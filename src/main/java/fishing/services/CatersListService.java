package fishing.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fishing.dao.Cater;
import fishing.dao.Fish;

public class CatersListService {

	private EntityManager manager;
	public CatersListService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		manager = emf.createEntityManager();
	}
	public List<Cater> getOpenCatersNamesList() {
		try {
			manager.getTransaction().begin();
			Query q = manager.createNativeQuery("Select c.id, c.name, c.buildingDate, c.weight, c.type_id"
					+ " From Cater c"
					+ " left outer join fishing.Trip t"
					+ "  on cater_id=c.id AND t.arrivalDate>CURDATE()"
					+ " Where t.arrivalDate is null ",
					Cater.class);
			List<Cater> listCaters = q.getResultList();
			manager.getTransaction().commit();
			return listCaters;
		} catch (Exception ex) {
			System.out.println("Exception while processing CatersService (list of caters):\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
			manager.getTransaction().rollback();
			return null;
		}
	}
	public List<Cater> getCatersList() {
		try {
			manager.getTransaction().begin();
			List<Cater> listCaters = manager.createQuery("from Cater", Cater.class).getResultList();
			manager.getTransaction().commit();
			return listCaters;
		} catch (Exception ex) {
			System.out.println("Exception while processing CatersService (list of caters):\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
			manager.getTransaction().rollback();
			return null;
		}
	}

	public Cater getCater(int id) {
		try {
			manager.getTransaction().begin();
			Cater  ret = manager.getReference(Cater.class, id);
			manager.getTransaction().commit();
			return ret;
		} catch (Exception ex) {
			System.out.println("Exception while processing CatersService (concrete cater):\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
			manager.getTransaction().rollback();
			return null;
		}
	}

	public void addOrUpdateCater(Cater cater) {
		try {
			manager.getTransaction().begin();
			if (cater.getId() == 0)
				manager.persist(cater);
			else
				manager.merge(cater);
			manager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Exception while processing CatersService (editing cater):\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
		}
	}

	public void deleteCater(Cater cater) {

		if (cater.getId() != 0) {
			try {
				manager.getTransaction().begin();
				cater = manager.getReference(Cater.class, cater.getId());
				manager.remove(cater);
				manager.getTransaction().commit();
			} catch (Exception ex) {
				System.out.println("Exception while processing CatersService (deleting cater):\n" + ex.getMessage() + "\nStack:\n");
				ex.printStackTrace();
			}
		}

	}
}
