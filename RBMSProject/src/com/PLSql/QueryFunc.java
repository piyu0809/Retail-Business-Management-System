
package com.PLSql;
import java.sql.*;   
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;
import java.util.Scanner;

public class QueryFunc{
	private static Scanner in=new Scanner(System.in);
	public static String query=null;
	

	/*
	 * This Function is to check and print the data currently present 
	 * in Employees table.
	 */
	
	private void showEmployees() {
		CallableStatement cs = null; // Initializes the object for Callable Statement
		Connection conn=null; // Initializes the object for connection
		try {
	   	 System.out.println("Connecting...");
		 OracleDataSource ds=new oracle.jdbc.pool.OracleDataSource();// declaring the oracleDataSource object
		 ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");// Setting URL to which JDBC connection to be done
	     conn = ds.getConnection("phirema1","Piyu0809");// setting up the username and password for the connection
	     System.out.println("Connected");
		 cs = conn.prepareCall("begin ? := refcursor_jdbc.getemployees(); end;");// Prepare calling of the Function
		 cs.registerOutParameter (1, OracleTypes.CURSOR); 
 		 cs.execute();
 	     ResultSet rs ;// Object is declared for Resultset
         
 		 rs = (ResultSet) cs.getObject(1);// Copying object of callablestatement to Reslut set object
          
              while (rs.next()) {
                  System.out.println("EID       : " + rs.getString(1)); //Employee ID
                  System.out.println("NAME      : " + rs.getString(2));
                  System.out.println("TELEPHONE : " + rs.getString(3));
                  System.out.println("EMAIL     : " + rs.getString(4));
                  System.out.println("==============================");
                  System.out.println("");
          }
          
	}catch(Exception e) {
		
		e.printStackTrace();
	} finally {
		try { if(cs!=null)
			cs.close();
         if(conn!=null)	 
         conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
	
	
	
	/*
	 * This Function is to check and print the data currently present 
	 * in Supplies table. While the connection is same as for @showEmployees()
	 */	
		private void showSupplies() {
			CallableStatement cs = null;
			Connection conn=null;
			try {
		   	 System.out.println("Connecting...");
			 OracleDataSource ds=new oracle.jdbc.pool.OracleDataSource();
			 ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
		     conn = ds.getConnection("phirema1","Piyu0809");
		     System.out.println("Connected");
		     cs = conn.prepareCall("begin ? := refcursor_jdbc4.getsupplies(); end;");
			 cs.registerOutParameter (1, OracleTypes.CURSOR); 
	 		 cs.execute();
	 		 ResultSet rs ;
	        
	 		 rs = (ResultSet) cs.getObject(1);
	          
	              while (rs.next()) {
	                  System.out.println("SUP#     : " + rs.getString(1)); // Supply Number
	                  System.out.println("PID      : " + rs.getString(2)); // Product ID
	                  System.out.println("SID      : " + rs.getString(3)); // Supplier ID
	                  System.out.println("SDATE    : " + rs.getString(4)); // Supply Date
	                  System.out.println("QUANTITY : " + rs.getString(5));
	                  System.out.println("=============================");
	                  System.out.println("");
	          }
	          
		}catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			try { if(cs!=null)
				cs.close();
	         if(conn!=null)	 
	         conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	
		
		
		/*
		 * This Function is to check and print the data currently present 
		 * in Supplier table. While the connection is same as for @showEmployees()
		 */	
		private void showSuppliers() {
			CallableStatement cs = null;
			Connection conn=null;
			try {
		   	 System.out.println("Connecting...");
			 OracleDataSource ds=new oracle.jdbc.pool.OracleDataSource();
			 ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
		     conn = ds.getConnection("phirema1","Piyu0809");
		     System.out.println("Connected");
		    //Statement stmt = conn.createStatement ();
			 cs = conn.prepareCall("begin ? := refcursor_jdbc5.getsuppliers(); end;");
			 cs.registerOutParameter (1, OracleTypes.CURSOR); 
	 		 cs.execute();
	 		ResultSet rs ;
	        
	 		 rs = (ResultSet) cs.getObject(1);
	          
	              while (rs.next()) {
	                  System.out.println("SID       : " + rs.getString(1)); // Supplier ID
	                  System.out.println("NAME       : " + rs.getString(2));
	                  System.out.println("CITY       : " + rs.getString(3));
	                  System.out.println("TELEPHONE# : " + rs.getString(4));
	                  System.out.println("EMAIL      : " + rs.getString(5));
	                  System.out.println("================================");
	                  System.out.println("");
	          }
	          
		}catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			try { if(cs!=null)
				cs.close();
	         if(conn!=null)	 
	         conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		

		/*
		 * This Function is to check and print the data currently present 
		 * in Purchases table. While the connection is same as for @showEmployees()
		 */	
		
			private void showPurchases() {
				CallableStatement cs = null;
				Connection conn=null;
				try {
			   	 System.out.println("Connecting...");
				 OracleDataSource ds=new oracle.jdbc.pool.OracleDataSource();
				 ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
			     conn = ds.getConnection("phirema1","Piyu0809");
			     System.out.println("Connected");
				 cs = conn.prepareCall("begin ? := refcursor_jdbc3.getpurchases(); end;");
				 cs.registerOutParameter (1, OracleTypes.CURSOR); 
		 		 cs.execute();
		 		ResultSet rs ;
		        
		 		 rs = (ResultSet) cs.getObject(1);
		          
		              while (rs.next()) {
		                  System.out.println("PUR#        : " + rs.getString(1)); // Purchase Number
		                  System.out.println("EID         : " + rs.getString(2)); // Employee ID
		                  System.out.println("PID         : " + rs.getString(3)); // Product ID
		                  System.out.println("CID         : " + rs.getString(4)); // Customer ID
		                  System.out.println("QTY         : " + rs.getString(5)); // Quantity
		                  System.out.println("PTIME       : " + rs.getString(6)); // Purchase Time
		                  System.out.println("TOTAL_PRICE : " + rs.getString(7)); // Total Price
		                  System.out.println("=====================");
		                  System.out.println("");
		          }
		          
			}catch(Exception e) {
				
				e.printStackTrace();
			} finally {
				try { if(cs!=null)
					cs.close();
		         if(conn!=null)	 
		         conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}

			
			/*
			 * This Function is to check and print the data currently present 
			 * in Customers table. While the connection is same as for @showEmployees()
			 */	
			
			private void showCustomers() {
				CallableStatement cs = null;
				Connection conn=null;
				try {
			   	 System.out.println("Connecting...");
				 OracleDataSource ds=new oracle.jdbc.pool.OracleDataSource();
				 ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
			     conn = ds.getConnection("phirema1","Piyu0809");
			     System.out.println("Connected");
				 cs = conn.prepareCall("begin ? := refcursor_jdbc1.getcustomers(); end;");
				 cs.registerOutParameter (1, OracleTypes.CURSOR); 
		 		 cs.execute();
		 		ResultSet rs ;
		        
		 		 rs = (ResultSet) cs.getObject(1);
		          
		              while (rs.next()) {
		                  System.out.println("CID             : " + rs.getString(1)); // Customer ID
		                  System.out.println("NAME            : " + rs.getString(2));
		                  System.out.println("TELEPHONE#      : " + rs.getString(3));
		                  System.out.println("VISITS_MADE     : " + rs.getString(4));
		                  System.out.println("LAST_VISIT_DATE : " + rs.getString(5));
		                  System.out.println("==================================");
		                  System.out.println("");
		          }
		          
			}catch(Exception e) {
				
				e.printStackTrace();
			} finally {
				try { if(cs!=null)
					cs.close();
		         if(conn!=null)	 
		         conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}

			/*
			 * This Function is to check and print the data currently present 
			 * in Products table. While the connection is same as for @showEmployees()
			 */	
			
			private void showProducts() {
				CallableStatement cs = null;
				Connection conn=null;
				try {
			   	 System.out.println("Connecting...");
				 OracleDataSource ds=new oracle.jdbc.pool.OracleDataSource();
				 ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
			     conn = ds.getConnection("phirema1","Piyu0809");
			     System.out.println("Connected");
				 cs = conn.prepareCall("begin ? := refcursor_jdbc2.getproducts(); end;");
				 cs.registerOutParameter (1, OracleTypes.CURSOR); 
		 		 cs.execute();
		 		ResultSet rs ;
		        
		 		 rs = (ResultSet) cs.getObject(1);
		          
		              while (rs.next()) {
		                  System.out.println("PID             : " + rs.getString(1)); // Products ID
		                  System.out.println("NAME            : " + rs.getString(2)); 
		                  System.out.println("QOH             : " + rs.getString(3)); // Quantity on hands
		                  System.out.println("QOH_THRESHOLD   : " + rs.getString(4)); // Quantity on hands Threshold
		                  System.out.println("ORIGINAL_PRICE  : " + rs.getString(5)); 
		                  System.out.println("DISCNT_CATEGORY : " + rs.getString(6));
		                  System.out.println("====================================");
		                  System.out.println("");
		          }
		          
			}catch(Exception e) {
				
				e.printStackTrace();
			} finally {
				try { if(cs!=null)
					cs.close();
		         if(conn!=null)	 
		         conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
			
			
			/*
			 * This Function is to check and print the data currently present 
			 * in LOGS table. While the connection is same as for @showEmployees()
			 */	
			
			private void showLogs() {
				CallableStatement cs = null;
				Connection conn=null;
				try {
			   	 System.out.println("Connecting...");
				 OracleDataSource ds=new oracle.jdbc.pool.OracleDataSource();
				 ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
			     conn = ds.getConnection("phirema1","Piyu0809");
			     System.out.println("Connected");
				 cs = conn.prepareCall("begin ? := refcursor_jdbc7.getlogs(); end;");
				 cs.registerOutParameter (1, OracleTypes.CURSOR); 
		 		 cs.execute();
		 	     ResultSet rs ;
		        
		 		 rs = (ResultSet) cs.getObject(1);
		          
		              while (rs.next()) {
		                  System.out.println("LOG#       : " + rs.getString(1));
		                  System.out.println("USER_NAME  : " + rs.getString(2));
		                  System.out.println("OPERATION  : " + rs.getString(3));
		                  System.out.println("OP_TIME    : " + rs.getString(4)); // Operation time
		                  System.out.println("TABLE_NAME : " + rs.getString(5));
		                  System.out.println("TUPLE_PKEY : " + rs.getString(6)); // Primary Key
		                  System.out.println("=================================");
		                  System.out.println("");
		          }
			}catch(Exception e) {
				
				e.printStackTrace();
			} finally {
				try { if(cs!=null)
					cs.close();
		         if(conn!=null)	 
		         conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
			/*
			 * This Function is to check and print the data currently present 
			 * in Discounts table. While the connection is same as for @showEmployees()
			 */	
					
				private void showDiscounts() {
							CallableStatement cs = null;
							Connection conn=null;
							try {
						   	 System.out.println("Connecting...");
							 OracleDataSource ds=new oracle.jdbc.pool.OracleDataSource();
							 ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
						     conn = ds.getConnection("phirema1","Piyu0809");
						     System.out.println("Connected");
							 cs = conn.prepareCall("begin ? := refcursor_jdbc6.getdiscounts(); end;");
							 cs.registerOutParameter (1, OracleTypes.CURSOR); 
					 		 cs.execute();
					 		 ResultSet rs ;
					         
					 		 rs = (ResultSet) cs.getObject(1);
					          
					              while (rs.next()) {
					                  System.out.println("DISCNT_CATEGORY : " + rs.getString(1));
					                  System.out.println("DISCNT_RATE     : " + rs.getString(2));
					                  System.out.println("===============================");
					                  System.out.println("");
					          }
					          
						}catch(Exception e) {
							
							e.printStackTrace();
						} finally {
							try { if(cs!=null)
								cs.close();
					         if(conn!=null)	 
					         conn.close();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						}
			
			
				/*
				 * This function is to take input from user for which  
				 * table data is to be printed.
				 */
				
				public void procedureTables(){
					System.out.println("Please choose the table");
					System.out.println("Please choose 1 for supplies table");
					System.out.println("Please choose 2 for suppliers table");
					System.out.println("Please choose 3 purchases table");
					System.out.println("Please choose 4 customers table");
					System.out.println("Please choose 5 employees table");
					System.out.println("Please choose 6 products table");
					System.out.println("Please choose 7 Logs table");
					System.out.println("Please choose 8 discounts table");
					int option = in.nextInt();
					
					switch(option) {
					
					case 1: showSupplies(); // calling supplies function to get supplies table data using JDBC
							break;
					 
					case 2: showSuppliers(); // calling suppliers function to get suppliers table data using JDBC
							break; 
					 
					case 3: showPurchases(); // calling purchases function to get purchases table data using JDBC
							break; 
			
					case 4: showCustomers(); // calling customers function to get customers table data using JDBC
							break; 
					
					case 5: showEmployees(); // calling employees function to get employees table data using JDBC
							break; 
							
					case 6: showProducts(); // calling products function to get products table data using JDBC
							break; 
							
					case 7: showLogs(); // calling logs function to get logs table data using JDBC
							break; 
			
							
					case 8: showDiscounts(); // calling discounts function to get discounts table data using JDBC
							break; 
							
					default: System.out.println("Please choose correct choice");
					
					
					
						} 
						
     }
	
				/*
				 * This Function is to check and print the saving in particular purchases 
				 * While the connection is same as for @showEmployees()
				 */	
				
				public void showSavings() {
					CallableStatement cs = null;
					Connection conn=null;
					try {
				   	 System.out.println("Connecting...");
					 OracleDataSource ds=new oracle.jdbc.pool.OracleDataSource();
					 ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
				     conn = ds.getConnection("phirema1","Piyu0809");
				     System.out.println("Connected");
				     cs = conn.prepareCall("begin ? := refcursor_jdbcSav.purchase_saving(?); end;");
				     System.out.println("Enter Purchase number");
					 String purchaseNumber = in.next();
					 System.out.println("Purchase Number::"+purchaseNumber);
					 cs.registerOutParameter (1, OracleTypes.CURSOR); // Out parameter is set as cursor  
			 		 cs.setString (2,purchaseNumber); 
			 		 cs.execute();
			 		 ResultSet rs ;
			        
			 		 rs = (ResultSet) cs.getObject(1);
			          
			              while (rs.next()) {
			                  System.out.println("Savings for purchase " +purchaseNumber+" : " + rs.getString(1));
			                  System.out.println("");

			              }
			          
				}catch(Exception e) {
					
					e.printStackTrace();
				} finally {
					try { if(cs!=null)
						cs.close();
			         if(conn!=null)	 
			         conn.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

				/*
				 * This Function is to insert New customer data into customer table 
				 * While the connection is same as for @showEmployees()
				 */	
					
				public void insertCustomers() {
					CallableStatement cs = null;
					Connection conn=null;
					try {
				   	 System.out.println("Connecting...");
					 OracleDataSource ds=new oracle.jdbc.pool.OracleDataSource();
					 ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
				     conn = ds.getConnection("phirema1","Piyu0809");
				     System.out.println("Connected");
				     cs = conn.prepareCall("begin add_customers(?,?,?); end;");
				     System.out.println("Enter Customer ID number");
					 String customerID = in.next();
					 System.out.println("Enter Customer Name");
					 String customerName = in.next();
					 System.out.println("Enter Customer Telephone Number");
					 String customerTelephone = in.next();
					 if(customerName!=null && customerTelephone != null && customerID !=null) { // checking if any value which is entered are not null
					 cs.setString(1,customerID); 
			 		 cs.setString(2,customerName); 
			 		 cs.setString(3,customerTelephone); 
			 		 cs.execute();
			 		 System.out.println("Customer Inserted");  
			 		 }else {
			 			 System.out.println("Check entered data for Customers!!!!!");
			 		 }
				}catch(Exception e) {
					
					e.printStackTrace();
				} finally {
					try { if(cs!=null)
						cs.close();
			         if(conn!=null)	 
			         conn.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}		

				
				/*
				 * This Function is to delete particular purchases 
				 * While the connection is same as for @showEmployees()
				 */	
				
				public void deletePurchase() {
					CallableStatement cs = null;
					Connection conn=null;
					try {
				   	 System.out.println("Connecting...");
					 OracleDataSource ds=new oracle.jdbc.pool.OracleDataSource();
					 ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
				     conn = ds.getConnection("phirema1","Piyu0809");
				     System.out.println("Connected");
				     cs = conn.prepareCall("begin delete_purchase(?); end;");
				     System.out.println("Enter Purchase Id number for returning purchase:");
					 String purchaseNumber = in.next();
					 if(purchaseNumber!=null) {
					 cs.setString(1,purchaseNumber); 
			 		 cs.execute();
			 		 System.out.println("Purchase Deleted");
			 	 	 System.out.println("");
			 		 }else {
			 			 System.out.println("Check purchase ID!!!!!");
			 		 }
				}catch(Exception e) {
					System.out.println("Please check Purchase ID");
					e.printStackTrace();
				} finally {
					try { if(cs!=null)
						cs.close();
			         if(conn!=null)	 
			         conn.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Check Purchase ID");
						e.printStackTrace();
						
					}
				}
				}		

				
				/*
				 * This Function is to adding purchase. 
				 * While the connection is same as for @showEmployees()
				 */	
				
				public void addingPurchases(){
					CallableStatement cs = null;
					Connection conn=null;
					try {
				   	 System.out.println("Connecting...");
					 OracleDataSource ds=new oracle.jdbc.pool.OracleDataSource();
					 ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
				     conn = ds.getConnection("phirema1","Piyu0809");
				     System.out.println("Connected");
				     cs = conn.prepareCall("begin add_purchases(?,?,?,?); end;");
				     System.out.println("Enter Employee Id number for purchase:");
					 String employeeId = in.next();
					 System.out.println("Enter Product Id number for purchase:");
					 String productId = in.next();
				     System.out.println("Enter Customer Id number for purchase:");
					 String customerId = in.next();
					 System.out.println("Enter the quantity to purchase:");
					 int qty = in.nextInt();
					 cs.setString(1,employeeId); 
					 cs.setString(2,productId); 
					 cs.setString(3,customerId); 
					 cs.setInt(4,qty); 
					 cs.execute();
			 		 System.out.println("Purchase Added");
			 		 System.out.println("");
			 		 
				}catch(Exception e) {
					
					e.printStackTrace();
				} finally {
					try { if(cs!=null)
						cs.close();
			         if(conn!=null)	 
			         conn.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}		

				
				/*
				 * This Function is to display the monthly sales by a particular Employee. 
				 * While the connection is same as for @showEmployees()
				 */	
				
				public void monthlySales() {
					CallableStatement cs = null;
					Connection conn=null;
					try {
				   	 System.out.println("Connecting...");
					 OracleDataSource ds=new oracle.jdbc.pool.OracleDataSource();
					 ds.setURL("jdbc:oracle:thin:@castor.cc.binghamton.edu:1521:acad111");
				     conn = ds.getConnection("phirema1","Piyu0809");
				     System.out.println("Connected");
				     cs = conn.prepareCall("begin monthly_sale_activities(?,?); end;");
				     System.out.println("Enter Employee id");
					 String employeeId = in.next();
					 cs.registerOutParameter (2, OracleTypes.CURSOR); 
			 		 cs.setString (1,employeeId); 
			 		 cs.execute();
			 		 ResultSet rs ;
			        
			 		 rs = (ResultSet) cs.getObject(2);
			          
			              while (rs.next()) {
			                  System.out.println("Employee ID              :" + rs.getString(1));
			                  System.out.println("Employee Name            :" + rs.getString(2));
			                  System.out.println("Month and year           :" + rs.getString(3));
			                  System.out.println("Total Price              :" + rs.getString(4));
			                  System.out.println("Total Number of purchases:" + rs.getString(5));
			                  System.out.println("======================================");
			                  System.out.println("");
			              }
			          
				}catch(Exception e) {
					
					e.printStackTrace();
				} finally {
					try { if(cs!=null)
						cs.close();
			         if(conn!=null)	 
			         conn.close();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}




} 


