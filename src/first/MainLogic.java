package first;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class MainLogic {

	public static void main(String[] args) {
	
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.xml").build();  
    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
      
    SessionFactory factory = meta.getSessionFactoryBuilder().build();  
    Session se = factory.openSession(); 

	Transaction tx = se.beginTransaction();
	
		Student obj = new Student();
		obj.setId(665);
		obj.setName("Amrutha");
		obj.setMarks(480);
		
		se.save(obj);
		//se.persist(obj);
		//se.saveOrUpdate(obj);
		tx.commit();
		se.close();
	}

}
