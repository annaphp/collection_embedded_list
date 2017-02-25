package anna;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import anna.model.Insole;
import anna.model.Shoe;

public class Main {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		final ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		return new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}
	
	 public static long save(Shoe shoe){
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		long id = (Long) s.save(shoe);
		s.getTransaction().commit();
		s.close();	
		return id;
	 }
	
	
	  public static void update(Shoe shoe) {
	        Session session = sessionFactory.openSession();
	        session.beginTransaction();
	        session.update(shoe);
	        session.getTransaction().commit();
	        session.close();
	 }
	
     public static Shoe findShoeById(long id) {
        Session session = sessionFactory.openSession();
        Shoe shoe = session.get(Shoe.class,id);  
        session.close();
        return shoe;
    }
	
	public static void main(String[] args) {
	
		Shoe shoe = new Shoe("Left Shoe", 45);
		long id = (long)save(shoe);
		shoe = findShoeById(id);

		Insole insoleone = new Insole(45, "sport insole");
		Insole insoletwo = new Insole(45, "gell insole");
		
		shoe.getInsole().add(insoleone);
		shoe.getInsole().add(insoletwo);
		
		update(shoe);
		shoe = findShoeById(id);
		for(Insole i : shoe.getInsole()){
	       System.out.println("**" + i);
	    }
	}

}
