package hamsterofdark;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main
{

	public static void main(String[] args)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();

		Employee myE = new Employee();
		myE.setFirstName("Michael");
		myE.setLastName("Landry");
		myE.setId(1);
		
		Transaction tx = null;
		try 
		{
		   tx = session.beginTransaction();
		   session.save(myE);
		   
		   tx.commit();
		}
		catch(Exception e)
		{
			System.out.println("Transaction failed");
			e.printStackTrace();
		}
		
		//now go check your db make sure row is in there
		

	}

}
