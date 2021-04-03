package com.tqg.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.PrintStream;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.tqg.dao.LizenzDAO;
import com.tqg.model.Lizenz;
import com.tqg.service.LizenzService;

import junit.framework.Assert;



public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
//	private static LizenzDAO lizenzDAO ;
//
//	 @Autowired
//	private Lizenz lizenz;
//	
//	
//	@BeforeClass
//	public static void init() {
//		context = new AnnotationConfigApplicationContext();
//		context.scan("com.tqg.*");
//		context.refresh();
//		lizenzDAO = (LizenzDAO)context.getBean("LizenzDAO");
//	}
//
//	@Test
//	public  void testAddProduct() {
//		
//		lizenz = new Lizenz();
//		lizenz.setId(100);
//		lizenz.setLizenzName("JUnitName");
//		lizenz.setLizenzKey("JUnitKey");
//		
//		assertEquals("Successfully added product to the table!", true , lizenz);
//		
//	}
	
//	@Test
//	public  void testGetProduct() {
//		lizenz = lizenzDAO.get(2);
//		assertEquals("Successfully fatch product from the table!", "LCM BPM" , lizenz.getLizenzName());
//	}
	

//@Test
//	public void testGetProduct() {
//		
//	 Lizenz alex = new Lizenz(3 , "", "");
//	    EntityManager entityManager = null;
//	    
//		entityManager.persist(alex);
//	    entityManager.flush();
//	 
//	    // when
//	    Lizenz found = lizenzDAO.getLizenzById(3);
//	 
//	   
//		
//		
//		assertEquals("Successfully fetched product from the table!","Television",lizenz);
//		
//		
//	}
	
//	
//	@Test
//	public void testUpdateProduct() {
//		
//		
//		lizenz = lizenzDAO.updateLizenz(lizenz);
//		
//		lizenz.setLizenzName("JUnit Update Name");
//		
//		assertEquals("Successfully updated a single product in the table!",true,lizenzDAO.updateLizenz(lizenz));
//		
//		
//	}
	

//	@Test
//	public void testDeleteProduct() {
//		
//	
//		assertEquals("Successfully deleted a single product in the table!",lizenzDAO.getAllLizenzs());
//		
//		
//	}
	
		
}
