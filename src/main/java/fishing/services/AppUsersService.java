package fishing.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fishing.dao.*;

public class AppUsersService {
	private String connectionString;
	private String login;
	private String password;
	private EntityManager manager;

	public AppUsersService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		manager = emf.createEntityManager();
	}

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public List<Fish> getFishList() {
		try {
			manager.getTransaction().begin();
			List<Fish> listFish = manager.createQuery("from Fish", Fish.class).getResultList();
			manager.getTransaction().commit();
			return listFish;
		} catch (Exception ex) {
			System.out.println("Exception:\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
			manager.getTransaction().rollback();
			return null;
		}
	}

	public Fish getFish(int id) {
		try {
			manager.getTransaction().begin();
			// List<Fish> fishList = (List<Fish>) manager.createQuery("SELECT f
			// from Fish f WHERE f.id = :id")
			// .setParameter("id", id).getResultList();
			// Fish ret = fishList.isEmpty() ? null : fishList.get(0);
			Fish ret = manager.getReference(Fish.class, id);
			manager.getTransaction().commit();
			return ret;
		} catch (Exception ex) {
			System.out.println("Exception:\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
			manager.getTransaction().rollback();
			return null;
		}
	}

	public void addOrUpdateFish(Fish fish) {
		try {
			manager.getTransaction().begin();
			if (fish.getId() == 0)
				manager.persist(fish);
			else
				manager.merge(fish);
			manager.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println("Exception:\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
		}
	}

	public void deleteFish(Fish fish) {

		if (fish.getId() != 0) {
			try {
				manager.getTransaction().begin();
				fish = manager.getReference(Fish.class, fish.getId());
				manager.remove(fish);
				manager.getTransaction().commit();
			} catch (Exception ex) {
				System.out.println("Exception:\n" + ex.getMessage() + "\nStack:\n");
				ex.printStackTrace();
			}
		}

	}

	public boolean addAppUser(AppUser user) {
		try {
			manager.getTransaction().begin();
			if (user.getId() != 0)
				return false;
			List<AppUser> test = (List<AppUser>) manager
					.createQuery("SELECT us from AppUser us  WHERE us.email = :email")
					.setParameter("email", user.getEmail()).getResultList();

			if (test.isEmpty())
				manager.persist(user);
			else
				return false;

			manager.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			System.out.println("Exception:\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
			return false;
		}
	}

	public boolean isAppUser(AppUser user) {
		try {
			manager.getTransaction().begin();
			if (user.getId() != 0)
				return false;
			List<AppUser> test = (List<AppUser>) manager
					.createQuery("SELECT us from AppUser us  WHERE us.email = :email")
					.setParameter("email", user.getEmail()).getResultList();

			manager.getTransaction().commit();
			if (test.isEmpty()||!test.get(0).getPassword().equals(user.getPassword()))
				return false;
			else
				return true;
		} catch (Exception ex) {
			System.out.println("Exception:\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
			return false;
		}
	}

	public void deleteAppUser(AppUser user) {

		if (user.getId() != 0) {
			try {
				manager.getTransaction().begin();
				user = manager.getReference(AppUser.class, user.getId());
				manager.remove(user);
				manager.getTransaction().commit();
			} catch (Exception ex) {
				System.out.println("Exception:\n" + ex.getMessage() + "\nStack:\n");
				ex.printStackTrace();
			}
		}

	}
}
