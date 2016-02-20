package fishing.services;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fishing.dao.*;

public class FishingDatabaseFillService {
	private String connectionString;
	private String login;
	private String password;
	private EntityManager manager;
	public FishingDatabaseFillService()
	{
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
	public void fill(){
		createCaters();
		createFishers();
		createFishs();
	}
	public void createCaterTypes()
	{
		try{
			manager.getTransaction().begin();
			CaterType big = new CaterType();
			big.setType("Big");
			CaterType middle = new CaterType();
			middle.setType("Middle");
			CaterType small = new CaterType();
			small.setType("Small");
			manager.persist(big);
			manager.persist(middle);
			manager.persist(small);
			manager.getTransaction().commit();
		}
		catch(Exception ex)
		{
			System.out.println("Exception:\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
		}
	}
	public void createCaters()
	{
		try{
			createCaterTypes();
			manager.getTransaction().begin();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
			
			List<CaterType> caterTypes = manager.createQuery( "from CaterType", CaterType.class ).getResultList();
			
			Cater c1 = new Cater();
			c1.setName("First Cater");
			c1.setBuildingDate(dateFormat.parse("12-05-1999"));
			c1.setWeight(1500);
			
			Cater c2 = new Cater();
			c2.setName("Second Cater");
			c2.setBuildingDate(dateFormat.parse("22-12-2001"));
			c2.setWeight(1600);
			
			Cater c3 = new Cater();
			c3.setName("Third Cater");
			c3.setBuildingDate(dateFormat.parse("1-08-2005"));
			c3.setWeight(1550);
			
			if(!caterTypes.isEmpty()){
				c1.setType(caterTypes.get(0));
				c2.setType(caterTypes.get(0));
				c3.setType(caterTypes.get(0));
			}
			
			manager.persist(c1);
			manager.persist(c2);
			manager.persist(c3);
			manager.getTransaction().commit();
		}
		catch(Exception ex)
		{
			System.out.println("Exception:\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
		}
	}

	public void createFishers()
	{
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
			manager.getTransaction().begin();
			Fisher a = new Fisher();
			a.setName("Petrov V. V.");
			a.setBirthDate(dateFormat.parse("12-05-1990"));
			a.setPhoneNumber("+375298745600");
			manager.persist(a);

			Fisher b = new Fisher();
			b.setName("Ivanov S. V.");
			b.setBirthDate(dateFormat.parse("01-06-1980"));
			b.setPhoneNumber("+375297745864");
			manager.persist(b);
			

			Fisher c = new Fisher();
			c.setName("Banin I. G.");
			c.setBirthDate(dateFormat.parse("30-11-1960"));
			c.setPhoneNumber("+375445664509");
			manager.persist(c);
			

			Fisher d = new Fisher();
			d.setName("Kukov L. B.");
			d.setBirthDate(dateFormat.parse("12-05-1979"));
			d.setPhoneNumber("+375338745600");
			manager.persist(d);
			

			Fisher e = new Fisher();
			e.setName("Pud G. K.");
			e.setBirthDate(dateFormat.parse("12-05-1967"));
			e.setPhoneNumber("+375294562379");
			manager.persist(e);
			manager.getTransaction().commit();
		}
		catch(Exception ex)
		{
			System.out.println("Exception:\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
		}
	}
	public void createFishs()
	{
		try{
			manager.getTransaction().begin();

			Fish a = new Fish();
			a.setName("Yaz\'");
			a.setDescription("Lalalala");
			a.setPrice(9.85);
			manager.persist(a);

			Fish b = new Fish();
			b.setName("Karas\'");
			b.setDescription("Lalalala");
			b.setPrice(5.5);
			manager.persist(b);

			Fish c = new Fish();
			c.setName("Karp\'");
			c.setDescription("Lalalala");
			c.setPrice(13.0);
			manager.persist(c);


		
			manager.getTransaction().commit();
		}
		catch(Exception ex)
		{
			System.out.println("Exception:\n" + ex.getMessage() + "\nStack:\n");
			ex.printStackTrace();
		}
	}
}
