package tui;

import java.sql.SQLException;
import java.util.Scanner;
import control.*;

public class OrderMenu {

	private ControlSaleOrder controlSaleOrder;

	
	public void start() throws SQLException {
	boolean running = true;
		
	Scanner keyboard = new Scanner(System.in);
	
	System.out.println(" *****Order Menu***** ");
	System.out.println(" (1) Place an Order ");
	System.out.println(" (0) Exit ");
	
	 while (!keyboard.hasNextInt()) {
         System.out.println("Input must be a number, try again");
         keyboard.nextLine();
     }
	 short choice = keyboard.nextShort();
	 switch (choice) {
     case 1:
       placeOrder();
       break;
     case 0:
       running = false;
       break;
     default:
       System.out.println("Wrong command");
       break;
	 }
	 }

	private void productAdd() throws SQLException {
		Scanner scanner = new Scanner(System.in);
	
		  System.out.println("Please state the product ID"); 
	      String productID = scanner.nextLine();
	      System.out.println("Please enter the amount of product you want");
	      int quantity = scanner.nextInt();
	      
	      ControlSaleOrder cso = new ControlSaleOrder();
	      cso.addProduct(productID, quantity);
	}

 


	private void placeOrder() throws SQLException {
		      Scanner keyboard = new Scanner(System.in);
			  Scanner scanner1 = new Scanner(System.in);
			 
		       System.out.println("Please enter your email ");
		       String customerEmail = scanner1.nextLine();
		          
		       ControlSaleOrder cso = new ControlSaleOrder();
		       cso.createSaleOrder(customerEmail);
		  boolean ordering = true;     
		  while (ordering) {
			  short choice = keyboard.nextShort();
			  switch (choice) {
	          case 1:
			  productAdd();
			  	  break;
	          case 0:
	        	  return;
	          default:
	              System.out.println("Wrong command");
	              break;
	}
		  }
   }
}