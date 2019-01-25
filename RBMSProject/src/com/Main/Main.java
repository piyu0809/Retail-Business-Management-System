

package com.Main;


import java.util.Scanner;


import com.PLSql.QueryFunc;


class Main{
	private static Scanner in;
	public static String procedure;
	
	public static void main(String[] args) {
		int choice;
		try {
			
	do { 
	     
	     System.out.println("Press 1 for seeing particular table value)");
	     System.out.println("Press 2 for checking savings in particular purchase");
	     System.out.println("Press 3 for monthly sale activity information of an employee");
	     System.out.println("Press 4 for inserting customers data");
	     System.out.println("Press 5 for adding purchases");
	     System.out.println("Press 6 for deleting any purchase");
	     System.out.println("Press 7 for Exit");
	     System.out.println("Please enter your choice");
	     System.out.println("Enter your choice : ");
	     in = new Scanner(System.in);
	     String input=in.nextLine();
	     choice=Integer.parseInt(input);
	     QueryFunc a=new QueryFunc();
	     switch(choice) {
		
	     case 1:  a.procedureTables();
	     		  break;
		
	     case 2:  a.showSavings();   
	    	      break;
			
	     case 3:  a.monthlySales();
	    	 	  break;
			
	     case 4:  a.insertCustomers();
	    	 	  break;
			
	     case 5:  a.addingPurchases();
	     		  break;
		
	     case 6:  a.deletePurchase();
	    	 	  break;
			
	     case 7:  System.exit(0);
	     		  break;
			
	    
	     default: System.out.println("Please choose correct Information"); 
				
		}
	}while(choice!=7);
		

		}catch(Exception e) {
			
			System.out.println("Please enter a choice and try again!!!");
			e.printStackTrace();
		}
	
	}
}
