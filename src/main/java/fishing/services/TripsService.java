package fishing.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fishing.dao.Trip;

public class TripsService {

	private EntityManager manager;
	public TripsService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		manager = emf.createEntityManager();
	}
	public List<Trip> getTripsList() {
		try {
			manager.getTransaction().begin();
			List<Trip> listTrips = manager.createQuery("from Trip", Trip.class).getResultList();
			manager.getTransaction().commit();
			return listTrips;
		} catch (Exception ex) {
			System.out.println("Exception while processing TripsService (list of trips):\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
			manager.getTransaction().rollback();
			return null;
		}
	}

	public Trip getTrip(int id) {
		try {
			manager.getTransaction().begin();
			Trip  ret = manager.getReference(Trip.class, id);
			manager.getTransaction().commit();
			return ret;
		} catch (Exception ex) {
			System.out.println("Exception while processing TripsService (concrete trip):\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
			manager.getTransaction().rollback();
			return null;
		}
	}

	public void addOrUpdateTrip(Trip trip) {
		try {
			manager.getTransaction().begin();
			if (trip.getId() == 0)
				manager.persist(trip);
			else
				manager.merge(trip);
			manager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Exception while processing TripsService (editing trip):\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
		}
	}
	public void deleteTrip(Trip trip) {

		if (trip.getId() != 0) {
			try {
				manager.getTransaction().begin();
				trip = manager.getReference(Trip.class, trip.getId());
				manager.remove(trip);
				manager.getTransaction().commit();
			} catch (Exception ex) {
				System.out.println("Exception while processing TripsService (deleting trip):\n" + ex.getMessage() + "\nStack:\n");
				ex.printStackTrace();
			}
		}

	}
}
