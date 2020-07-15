package com.live;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.live.repository.OracleRepository;
import com.live.repository.ProductRepository;

public class App 
{
    public static void main( String[] args )
    {
      performIOC();
    	
    }

	private static void performIOC() {
		//  System.out.println( "Hello World!" );
		//	ProductRepository productRepository = new OracleRepository();
			ProductRepository productRepository = null;
			// Load the spring container
			//the spring contianer would user the applicationcontext.xml to connfigure the spring beans
			
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
			
			//access the spring bean from the applications
			
			productRepository = (ProductRepository) context.getBean("productRepository");
			productRepository.getProducts().forEach(System.out::println);
			
			
		 	ProductRepository mySqlRepository = null;
		 	mySqlRepository = context.getBean("mySqlRepository", ProductRepository.class);
		 	mySqlRepository.getProducts().forEach(System.out::println);
		 	
		 	//Testing SingleTon
		 	System.out.println(productRepository);
	}
	
	private static void testSingleton() {
		ProductRepository productRepository = null;
		// Load the spring container
		//the spring contianer would user the applicationcontext.xml to connfigure the spring beans
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		productRepository = (ProductRepository) context.getBean("productRepository");
		System.out.println(productRepository);
		
		productRepository = (ProductRepository) context.getBean("productRepository");
		System.out.println(productRepository);
	}
}
