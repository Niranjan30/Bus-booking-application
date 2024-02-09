/**
* 
* The program encompasses code which illustrates the development
* of a bus booking system named Zobus. The system has 4 buses and 
* the user/customer is required to input data into any of the 4 buses
* and after inputting the data, the system will demonstrate how efficiently
* a user/customer journey from destination A to destination B will be handled.
* 
* Class: zobus.java, bus.java, ticket.java, customer.java, seatDetails.java
*
* @author  Niranjan Rajendran
* @version 1.0
* 
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class zobus
{

    Scanner sc=new Scanner(System.in);
    ArrayList<customer> customerobj=new ArrayList<customer>();
    ArrayList<bus> busobj=new ArrayList<bus>();
    ArrayList<ticket> ticketobj=new ArrayList<ticket>();
    ArrayList<seatDetails>seatobj = new ArrayList<seatDetails>();
    ArrayList<seatDetails>seatobj2 = new ArrayList<seatDetails>();
    ArrayList<admin>adminobj = new ArrayList<admin>();
    int totalseats=12;
    int noofseat;
    int bookedseats;
    int [] convert;
    String[][] seater = new String[4][3];
    String[][] seaterNonac = new String[4][3];
    String [][][] seatSleeper = new String[2][3][2];
    String [][][] seatSleeperNon = new String[2][3][2];
    
    zobus()
    {
        for(int i = 0;i < 4; i++)
            for(int j = 0;j < 3; j++)
            {
                seater[i][j] = "Available";
            }
         
        for(int i = 0;i < 4; i++)
            for(int j = 0;j < 3; j++)
            {
                seaterNonac[i][j] = "Available";
            }
        
        
           for(int i = 0; i < 2; i++)
           {
           	for(int j = 0; j < 3; j++)
           	{
           		for(int k = 0; k < 2; k++)
           		{
           			seatSleeper[i][j][k] = "Available";
           		}
           	}
           }
           
           for(int i = 0; i < 2; i++)
           {
           	for(int j = 0; j < 3; j++)
           	{
           		for(int k = 0; k < 2; k++)
           		{
           			seatSleeperNon[i][j][k] = "Available";
           		}
           	}
           }
           
    }
    
    
    void viewSeats(String btype, String stype)
    
    {
    
    	if(stype.equalsIgnoreCase("seater") && btype.equalsIgnoreCase("ac"))
    	{
	    
	        for(int i=0;i<4;i++)
	        {
	        	if(i == 0)
	        	{
	        		System.out.println("	   A"+ "   	   " + "   	   B" +  "   	  " + "   	   C"  );
	        	}
	        	int u;
        		
        		
        		
    			u = i+1;
    			System.out.print(u);
	         for(int j=0;j<3;j++)
	         {
	        	 
	        		
	        	 if(seater[i][j].equalsIgnoreCase("available"))
	        	 {
	                 System.out.print("	"+seater[i][j]+" ");
	        	 }
	        	 else if(seater[i][j].equalsIgnoreCase("male"))
	        	 {
	        		 System.out.print("	   M" + "   	" );
	        	 }
	        	 else
	        	 {
	        		 System.out.print("	   F" + "   	" );
	        	 }
	         }
	         System.out.println();
	         if(i==1)
	         {
	        	 System.out.println("\n");
	         }
	      
	        }
	       
    	}
    	
    	else if(stype.equalsIgnoreCase("seater") && btype.equalsIgnoreCase("non-ac"))
    	{
	    
	        for(int i=0;i<4;i++)
	        {
	        	if(i == 0)
	        	{
	        		System.out.println("	   A"+ "   	   " + "   	   B" +  "   	  " + "   	   C"  );
	        	}
	        	int u;
        		
        		
        		
    			u = i+1;
    			System.out.print(u);
	         for(int j=0;j<3;j++)
	         {
	        	 if(seaterNonac[i][j].equalsIgnoreCase("available"))
	        	 {
	                 System.out.print("	"+seaterNonac[i][j]+" ");
	        	 }
	        	 else if(seaterNonac[i][j].equalsIgnoreCase("male"))
	        	 {
	        		 System.out.print("	   M" + "   	" );
	        	 }
	        	 else
	        	 {
	        		 System.out.print("	   F" + "   	" );
	        	 }
	         }
	         System.out.println();
	         if(i==1)
	         {
	        	 System.out.println("\n");
	         }
	         
	        }
	       
    	}
    	
    	
    	else if(stype.equalsIgnoreCase("sleeper") && btype.equalsIgnoreCase("ac"))
    	{
    		 for(int i = 0; i < 2; i++)
    	        {
    			 	if(i == 0)
    			 	{
    			 		System.out.println();
    			 		System.out.println("Lower Deck");
    			 		   	
    			 		System.out.println("	   A"+ "   	   " + "   	   B" );
    			 	}
    			 	else
    			 	{
    			 		System.out.println();
    			 		System.out.println("Upper Deck ");
    			 		System.out.println("	   A"+ "   	   " + "   	   B");
    			 	}
    	        	for(int j = 0; j < 3; j++)
    	        	{
    	        		int u;
    	        		
    	        		if(i == 0)
    	        		{
    	        			u = j+1;
    	        			System.out.print(u + " ");
    	        		}
    	        		else
    	        		{
    	        			u = j+4;
    	        			System.out.print(u + " ");
    	        		}
    	        		for(int k = 0; k < 2; k++)
    	        		{
    	        		
    	        			if(seatSleeper[i][j][k].equalsIgnoreCase("available"))
    	        		
    	        			{
    	        				System.out.print("	" + seatSleeper[i][j][k] + " ");
    	        			}
    	        			else if(seatSleeper[i][j][k].equalsIgnoreCase("male"))
    	        			{
    	        				System.out.print("	   M" + "   	");
    	        			}
    	        			else
    	        			{
    	        				System.out.print("	   F" + "   	");
    	        			}
    	        		}
    	        		System.out.println();
    	        		if(j == 1)
    	        		{
    	        			 System.out.println("\n");
    	        		}
    	        	
    	        	}
    	        	
    	        }
    	}
    	
    	else if(stype.equalsIgnoreCase("sleeper") && btype.equalsIgnoreCase("non-ac"))
    	{
   		 for(int i = 0; i < 2; i++)
   	        {
   			 	if(i == 0)
   			 	{
   			 		System.out.println();
   			 		System.out.println("Lower Deck");
   			 		   	
   			 		System.out.println("	   A"+ "   	   " + "   	   B" );
   			 	}
   			 	else
   			 	{
   			 		System.out.println();
   			 		System.out.println("Upper Deck ");
   			 		System.out.println("	   A"+ "   	   " + "   	   B");
   			 	}
   	        	for(int j = 0; j < 3; j++)
   	        	{
   	        		int u;
   	        		
   	        		if(i == 0)
   	        		{
   	        			u = j+1;
   	        			System.out.print(u + " ");
   	        		}
   	        		else
   	        		{
   	        			u = j+4;
   	        			System.out.print(u + " ");
   	        		}
   	        		for(int k = 0; k < 2; k++)
   	        		{
   	        		
   	        			if(seatSleeperNon[i][j][k].equalsIgnoreCase("available"))
   	        		
   	        			{
   	        				System.out.print("	" + seatSleeperNon[i][j][k] + " ");
   	        			}
   	        			else if(seatSleeperNon[i][j][k].equalsIgnoreCase("male"))
   	        			{
   	        				System.out.print("	   M" + "   	");
   	        			}
   	        			else
   	        			{
   	        				System.out.print("	   F" + "   	");
   	        			}
   	        		}
   	        		System.out.println();
   	        		if(j == 1)
   	        		{
   	        			 System.out.println("\n");
   	        		}
   	        		
   	        	}
   	        	
   	        }
   	}
    }
    

    
    
    public boolean checkAvail(String seatno, String btype, String stype, int id)
    {
    	boolean a = false;
    	
    	
        char letter = seatno.charAt(0);
        int conversion = -1;
        if(letter == 'A' || letter == 'a')
        {
        	conversion = 0;
        }
        if(letter == 'B' || letter == 'b')
        {
        	conversion = 1;
        }
        if(letter == 'C' || letter == 'c')
        {
        	conversion = 2;
        }
      
        
        int seatNumber = Character.getNumericValue(seatno.charAt(1));
        
        int deck = -1;
        if(stype.equalsIgnoreCase("sleeper") && (seatNumber <= 3 && seatNumber >0))
        {
        	deck = 0;
        }
        else if(stype.equalsIgnoreCase("sleeper") && seatNumber <= 6 && seatNumber >=4)
        {
        	deck = 1;
        }
        
        
        if(btype.equalsIgnoreCase("non-ac") && stype.equalsIgnoreCase("sleeper"))
        {
       	 
		         for(int j=0;j<3;j++)
		         {
		        	 for(int k = 0; k < 2; k++ )
		        	 {
		                	
		              if(seatNumber == j + 1 && conversion == k && !(seatSleeperNon[deck][j][k].equalsIgnoreCase("available")))
		              {
		         			               
		            	  		a = true;
			                     return a;
		              }     
		             else if(seatNumber == j+4 && conversion == k && !(seatSleeperNon[deck][j][k].equalsIgnoreCase("available")))
		             {
		            					             			               		                    
			                     a = true;
			                     return a;
			               
		             }
		                   
		                }
		                }
		         }
		            
        
        else if(btype.equalsIgnoreCase("ac") && stype.equalsIgnoreCase("sleeper"))
        {
       	 
		         for(int j=0;j<3;j++)
		         {
		        	 for(int k = 0; k < 2; k++ )
		        	 {
		                	
		              if(seatNumber == j + 1 && conversion == k && !(seatSleeper[deck][j][k].equalsIgnoreCase("available")))
		              {
		         			               
		            	  		a = true;
			                     return a;
		              }     
		             else if(seatNumber == j+4 && conversion == k && !(seatSleeper[deck][j][k].equalsIgnoreCase("available")))
		             {
		            					             			               		                    
			                     a = true;
			                     return a;
			               
		             }
		                   
		                }
		                }
		         }
		            
        	
        	     
        
        else if(btype.equalsIgnoreCase("non-ac") && stype.equalsIgnoreCase("seater"))
        {
        	 for(int i=0;i<4;i++)
 		    {
 		         for(int j=0;j<3;j++)
 		         {
 		                	
 		              if(seatNumber == i + 1 && conversion == j)
 		              {
 		                   if(!(seaterNonac[i][j].equalsIgnoreCase("available")))
 		               
 			               {
 		                    	
 			                     a = true;
 			                     return a;
 			               }
 		                    	
 		                    else 
 		                   {
 		      
 		                            a = false;
 		                   }
 		                    }
 		                }
 		            }
         	}
        
        
        else if(btype.equalsIgnoreCase("ac") && stype.equalsIgnoreCase("seater"))
        {
        		
		    for(int i=0;i<4;i++)
		    {
		         for(int j=0;j<3;j++)
		         {
		                	
		              if(seatNumber == i + 1 && conversion == j)
		              {
		                   if(!(seater[i][j].equalsIgnoreCase("available")))
		               
			               {		                    	
			                     a = true;
			                     return a;
			               }
		                    	
		                    else 
		                   {
		      
		                            a = false;
		                   }
		                    }
		                }
		            }
        	}
        	
        	                  
           return a;
    }
    
    public boolean checkGender(String seatno, String btype, String stype, int id, char gender)
    {
    	boolean a = false;
    	
    	if(ticketobj.size() == 0)
    	{
    		
    		return a;
    	}
    	
        char letter = seatno.charAt(0);
        int conversion = -1;
        if(letter == 'A' || letter == 'a')
        {
        	conversion = 0;
        }
        if(letter == 'B' || letter == 'b')
        {
        	conversion = 1;
        }
        if(letter == 'C' || letter == 'c')
        {
        	conversion = 2;
        }
        
        
        
        int seatNumber = Character.getNumericValue(seatno.charAt(1));
        
        int deck = -1;
        if(stype.equalsIgnoreCase("sleeper") && (seatNumber <= 3 && seatNumber >0))
        {
        	deck = 0;
        }
        else if(stype.equalsIgnoreCase("sleeper") && (seatNumber <= 6 && seatNumber >=4))
        {
        	deck = 1;
        }
        
        
        if(btype.equalsIgnoreCase("non-ac") && stype.equalsIgnoreCase("sleeper"))
        {
        	
           
                for(int j=0;j<2;j++)
                {
                	for(int k = 0; k < 2; k++)
                	{
                	if(seatNumber == j + 1 && conversion == k && deck ==0)
                    {
                		
                		if(((j+1)%2!=0 && seatSleeperNon[deck][j+1][k].equalsIgnoreCase("male")) || ((j+1)%2==0 && seatSleeperNon[deck][j-1][k].equalsIgnoreCase("male")) 
                				&& gender == 'F')
                    	{
                			
                			int index = returnId(j,k,id,btype,stype);
                
                			if(id != index)
                			{
              
                				a = true;
                				return a;
                			}
                    	}
                    	
                    
                    	else if(((j+1)%2!=0 && seatSleeperNon[deck][j+1][k].equalsIgnoreCase("female")) || ((j+1)%2==0 && seatSleeperNon[deck][j-1][k].equalsIgnoreCase("female")) 
                				&& gender == 'M')
                    	{
                    		int index = returnId(j,k,id,btype,stype);
                	
                			if(id != index)
                			{
           
                				a = true;
                				return a;
                			}
                    	}
                    }
                    else if(seatNumber == j + 4 && conversion == k && deck == 1)
                    {
                    	if(((j+1)%2!=0 && seatSleeperNon[deck][j+1][k].equalsIgnoreCase("male")) || ((j+1)%2==0 && seatSleeperNon[deck][j-1][k].equalsIgnoreCase("male")) 
                    				&& gender == 'F')
                        {
                    			
                    		int index = returnId(j,k,id,btype,stype);
                    
                    		if(id != index)
                    		{
                  
                    				a = true;
                    				return a;
                    		}
                        }
                        	
                        
                        	else if(((j+1)%2!=0 && seatSleeperNon[deck][j+1][k].equalsIgnoreCase("female")) || ((j+1)%2==0 && seatSleeperNon[deck][j-1][k].equalsIgnoreCase("female")) 
                    				&& gender == 'M')
                        	{
                        		int index = returnId(j,k,id,btype,stype);
                    	
                    			if(id != index)
                    			{
               
                    				a = true;
                    				return a;
                    			}
                        	}
                    	
                    }
                }
            }
            }
        
        if(btype.equalsIgnoreCase("ac") && stype.equalsIgnoreCase("sleeper"))
        {
        	
           
                for(int j=0;j<2;j++)
                {
                	for(int k = 0; k < 2; k++)
                	{
                	if(seatNumber == j + 1 && conversion == k && deck ==0)
                    {
                		
                		if(((j+1)%2!=0 && seatSleeper[deck][j+1][k].equalsIgnoreCase("male")) || ((j+1)%2==0 && seatSleeper[deck][j-1][k].equalsIgnoreCase("male")) 
                				&& gender == 'F')
                    	{
                			
                			int index = returnId(j,k,id,btype,stype);
                
                			if(id != index)
                			{
              
                				a = true;
                				return a;
                			}
                    	}
                    	
                    
                    	else if(((j+1)%2!=0 && seatSleeper[deck][j+1][k].equalsIgnoreCase("female")) || ((j+1)%2==0 && seatSleeper[deck][j-1][k].equalsIgnoreCase("female")) 
                				&& gender == 'M')
                    	{
                    		int index = returnId(j,k,id,btype,stype);
                	
                			if(id != index)
                			{
           
                				a = true;
                				return a;
                			}
                    	}
                    }
                    else if(seatNumber == j + 4 && conversion == k && deck == 1)
                    {
                    	if(((j+1)%2!=0 && seatSleeper[deck][j+1][k].equalsIgnoreCase("male")) || ((j+1)%2==0 && seatSleeper[deck][j-1][k].equalsIgnoreCase("male")) 
                    				&& gender == 'F')
                        {
                    			
                    		int index = returnId(j,k,id,btype,stype);
                    
                    		if(id != index)
                    		{
                  
                    				a = true;
                    				return a;
                    		}
                        }
                        	
                        
                        	else if(((j+1)%2!=0 && seatSleeper[deck][j+1][k].equalsIgnoreCase("female")) || ((j+1)%2==0 && seatSleeper[deck][j-1][k].equalsIgnoreCase("female")) 
                    				&& gender == 'M')
                        	{
                        		int index = returnId(j,k,id,btype,stype);
                    	
                    			if(id != index)
                    			{
               
                    				a = true;
                    				return a;
                    			}
                        	}
                    	
                    }
                }
            }
            }
        
        
        if(btype.equalsIgnoreCase("non-ac") && stype.equalsIgnoreCase("seater"))
        {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<3;j++)
            {
            	
            	if(seatNumber == i + 1 && conversion == j)
                {
            		
            		if(((i+1)%2!=0 && seaterNonac[i+1][j].equalsIgnoreCase("male")) || ((i+1)%2==0 && seaterNonac[i-1][j].equalsIgnoreCase("male")) 
            				&& gender == 'F')
                	{
            			
            			int index = returnId(i,j,id,btype,stype);
            
            			if(id != index)
            			{
          
            				a = true;
            			}
                	}
                	
                
                	else if(((i+1)%2!=0 && seaterNonac[i+1][j].equalsIgnoreCase("female")) || ((i+1)%2==0 && seaterNonac[i-1][j].equalsIgnoreCase("female")) 
            				&& gender == 'M')
                	{
                		int index = returnId(i,j,id,btype,stype);
            	
            			if(id != index)
            			{
       
            				a = true;
            			}
                	}
                	else
                	{
                		a = false;
                	}
                }
            }
        }
        }
        
        
        else if(btype.equalsIgnoreCase("ac") && stype.equalsIgnoreCase("seater"))
        {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<3;j++)
            {
            	
            	if(seatNumber == i + 1 && conversion == j)
                {
            		
            		if(((i+1)%2!=0 && seater[i+1][j].equalsIgnoreCase("male")) || ((i+1)%2==0 && seater[i-1][j].equalsIgnoreCase("male")) 
            				&& gender == 'F')
                	{
            			
            			int index = returnId(i,j,id,btype,stype);
            			
            			if(id != index)
            			{
            				
            				a = true;
            				
            			}
                	}
                	
                
                	else if((((i+1)%2!=0 && seater[i+1][j].equalsIgnoreCase("female")) || ((i+1)%2==0 && seater[i-1][j].equalsIgnoreCase("female"))) 
            				&& gender == 'M')
                	{
                		int index = returnId(i,j,id,btype,stype);
            	
            			if(id != index)
            			{
            			
            				a = true;
            				
            			}
                	}
                }
                	
                
            }
        }
        }
        return a;
    }
    
    public int returnId(int i,int j,int id, String btype, String stype)
    {
    	int returnid = id;
  	
    	for(ticket t: ticketobj)
    	{
    	
    		if(t.object.bustype.equalsIgnoreCase(btype) && t.object.seattype.equalsIgnoreCase(stype))
    		{	
    			
    		int m = t.customer_id;
    		int []k = t.bookedtickets;
    		int [] conv = t.convert;
    		
    	
    		for(int g = 0; g < k.length; g++)
    		{
    		  		
    			
	    			if((k[g] == i && conv[g] == j) || k[g] == i+2 && conv[g] == j)
	    			{
	    				returnid = m;
	    			}
    					   			
    		}
		   		
    		}
    	}
    	return returnid;
    	
    }
    
   public void checkBooking(String btype, String stype, int id, int noofseat)
   {
	   
	   if(btype.equalsIgnoreCase("ac") && stype.equalsIgnoreCase("seater"))
	   {
   			
	        for(int i=0;i<noofseat;i++)
	        {
	        	
	        	  System.out.print("Enter gender M or F:");
		            char gender=sc.next().charAt(0);		          
		            if(gender != 'M' && gender != 'F' && gender != 'm' && gender != 'f')
		            {
		            	System.out.println("Invalid gender. Choose either M or F");
		            	gender = Character.MIN_VALUE;
		            	i--;
		            	
		            	continue;
		            }
		            sc.nextLine();
		            System.out.print("Enter the name of co-traveller: ");
		            String name = sc.nextLine();
	            System.out.print("Enter seat number want to be booked:");
	          
	            String seatno = sc.next();
	            int seatNumber = Character.getNumericValue(seatno.charAt(1));
	            char letter = seatno.charAt(0);
	            int conversion = -1;
	            if(letter == 'A' || letter == 'a')
	            {
	            	conversion = 0;
	            }
	            if(letter == 'B' || letter == 'b')
	            {
	            	conversion = 1;
	            }
	            if(letter == 'C' || letter == 'c')
	            {
	            	conversion = 2;
	            }
	            
	            if(conversion < 0 || conversion > 2)
	            {
	            	System.out.println("Invalid seat selection.\nPlease choose seat between A-C");
	            	seatNumber = 0;
	            	i--;
	            }
	            
	            else if(seatNumber<1 || seatNumber>4)
	            {
	                System.out.println("Invalid seat number!!\nPlease choose seat between 1-4");
	                seatNumber = 0;
	                i--;
	            }
	            
	          
	            
	           
	            if(checkAvail(seatno, btype, stype,id))
	            {
	                System.out.println("Entered seat is booked.\nPlease choose another seat");
	                seatNumber = 0;
	                i--;
	            }
	            else if(checkGender(seatno, btype, stype,id,gender))
	            {
	            	System.out.println("Invalid seat selection due to gender.\nPlease choose another seat");
	            	seatNumber = 0;
	            	i--;
	            }
	           
	            
	            seatobj.add(new seatDetails(btype,stype,gender,name,seatNumber,letter,conversion));
	        }
	       
	        
   			
	   }   else if(btype.equalsIgnoreCase("non-ac") && stype.equalsIgnoreCase("seater"))
	   		{
	   		
	        for(int i=0;i<noofseat;i++)
	        {
	        	
	        	  System.out.print("Enter gender M or F:");
		            char gender=sc.next().charAt(0);		          
		            if(gender != 'M' && gender != 'F' && gender != 'm' && gender != 'f')
		            {
		            	System.out.println("Invalid gender. Choose either M or F");
		            	gender = Character.MIN_VALUE;
		            	i--;
		            	
		            	continue;
		            }
		            sc.nextLine();
		            
		            System.out.println("Enter the name of co-traveller: ");
		            String name = sc.nextLine();
	            System.out.print("Enter seat number want to be booked:");
	          
	            String seatno = sc.next();
	            int seatNumber = Character.getNumericValue(seatno.charAt(1));
	            char letter = seatno.charAt(0);
	            int conversion = -1;
	            if(letter == 'A' || letter == 'a')
	            {
	            	conversion = 0;
	            }
	            if(letter == 'B' || letter == 'b')
	            {
	            	conversion = 1;
	            }
	            if(letter == 'C' || letter == 'c')
	            {
	            	conversion = 2;
	            }
	            
	            if(conversion < 0 || conversion > 2)
	            {
	            	System.out.println("Invalid seat selection.\nPlease choose seat between A-C");
	            	seatNumber = 0;
	            	i--;
	            }
	            
	            else if(seatNumber<1 || seatNumber>4)
	            {
	                System.out.println("Invalid seat number!!\nPlease choose seat between 1-4");
	                seatNumber = 0;
	                i--;
	            }
	            
	          
	            
	           
	            if(checkAvail(seatno, btype, stype,id))
	            {
	                System.out.println("Entered seat is booked.\nPlease choose another seat");
	                seatNumber = 0;
	                i--;
	            }
	            else if(checkGender(seatno, btype, stype,id,gender))
	            {
	            	System.out.println("Invalid seat selection due to gender.\nPlease choose another seat");
	            	seatNumber = 0;
	            	i--;
	            }
	            seatobj.add(new seatDetails(btype,stype,gender,name,seatNumber,letter,conversion));
	         
	        }
	   } else  if(btype.equalsIgnoreCase("non-ac") && stype.equalsIgnoreCase("sleeper"))
	   	{
      	 for(int i=0;i<noofseat;i++)
	         {
	      		System.out.print("Enter gender M or F:");
	            char gender=sc.next().charAt(0);		          
	            if(gender != 'M' && gender != 'F' && gender != 'm' && gender != 'f')
	            {
	            	System.out.println("Invalid gender. Choose either M or F");
	            	gender = Character.MIN_VALUE;
	            	i--;
	            	
	            	continue;
	            }
	            sc.nextLine();
	            
	            System.out.println("Enter the name of co-traveller: ");
	            String name = sc.nextLine();
	            System.out.print("Enter seat number want to be booked:");
	         
	            String seatno = sc.next();
	            int seatNumber = Character.getNumericValue(seatno.charAt(1));
	            char letter = seatno.charAt(0);
	            int conversion = -1;
	            if(letter == 'A' || letter == 'a')
	            {
	            	conversion = 0;
	            }
	            if(letter == 'B' || letter == 'b')
	            {
	            	conversion = 1;
	            }
	            
	          
	            
	           if(seatNumber<1 || seatNumber>6)
	            {
	                System.out.println("Invalid seat number!!\nPlease choose seat between 1-4");
	                seatNumber = 0;
	                i--;
	            }
	            else if(conversion < 0 || conversion > 2)
	            {
	            	System.out.println("Invalid seat selection.\nPlease choose seat between A-B");
	            	seatNumber = 0;
	            	i--;
	            }
	            	       	            	               
	            
	            if(checkAvail(seatno, btype, stype,id))
	            {
	                System.out.println("Entered seat is booked.\nPlease choose another seat");
	                seatNumber = 0;
	                i--;
	            }
	            else if(checkGender(seatno, btype, stype,id,gender))
	            {
	            	System.out.println("Invalid seat selection due to gender.\nPlease choose another seat");
	            	seatNumber = 0;
	            	i--;
	            }
	            
	            int f = 0;
	            if(seatNumber < 4 && seatNumber > 0)
	            {
	            	 f = 0;
	            }
	            else if(seatNumber < 7)
	            {
	            	f = 1;
	            }
	            
	            seatobj.add(new seatDetails(btype,stype,gender,name,seatNumber,letter,conversion));
	         }
       } else  if(btype.equalsIgnoreCase("ac") && stype.equalsIgnoreCase("sleeper"))
	   	{
        	 for(int i=0;i<noofseat;i++)
  	         {
  	      		System.out.print("Enter gender M or F:");
  	            char gender=sc.next().charAt(0);		          
  	            if(gender != 'M' && gender != 'F' && gender != 'm' && gender != 'f')
	            {
	            	System.out.println("Invalid gender. Choose either M or F");
	            	gender = Character.MIN_VALUE;
	            	i--;
	            	
	            	continue;
	            }
	            sc.nextLine();
  	            
  	            System.out.println("Enter the name of co-traveller: ");
  	            String name = sc.nextLine();
  	            System.out.print("Enter seat number want to be booked:");
  	         
  	            String seatno = sc.next();
  	            int seatNumber = Character.getNumericValue(seatno.charAt(1));
  	            char letter = seatno.charAt(0);
  	            int conversion = -1;
  	            if(letter == 'A' || letter == 'a')
  	            {
  	            	conversion = 0;
  	            }
  	            if(letter == 'B' || letter == 'b')
  	            {
  	            	conversion = 1;
  	            }
  	            
  	           	            
  	           if(seatNumber<1 || seatNumber>6)
  	            {
  	                System.out.println("Invalid seat number!!\nPlease choose seat between 1-4");
  	                seatNumber = 0;
  	                i--;
  	            }
  	            else if(conversion < 0 || conversion > 2)
  	            {
  	            	System.out.println("Invalid seat selection.\nPlease choose seat between A-B");
  	            	seatNumber = 0;
  	            	i--;
  	            }
  	            	       	            	               
  	            
  	            if(checkAvail(seatno, btype, stype,id))
  	            {
  	                System.out.println("Entered seat is booked.\nPlease choose another seat");
  	                seatNumber = 0;
  	                i--;
  	            }
  	            else if(checkGender(seatno, btype, stype,id,gender))
  	            {
  	            	System.out.println("Invalid seat selection due to gender.\nPlease choose another seat");
  	            	seatNumber = 0;
  	            	i--;
  	            }
  	            
  	            int f = 0;
  	            if(seatNumber < 4 && seatNumber > 0)
  	            {
  	            	 f = 0;
  	            }
  	            else if(seatNumber < 7)
  	            {
  	            	f = 1;
  	            }
  	          seatobj.add(new seatDetails(btype,stype,gender,name,seatNumber,letter,conversion));
  	         }
	   	}
       	   
   }
    
    public int[][] book(String btype, String stype, int id, int noofseat)
    {
    	      
        int[] seat=new int[noofseat];
    	int []convert = new int[noofseat];
        int [][] bookedSeats = new int[][] {seat,convert};
        int counter = 0;
        int counterSleNon = 0;
        int counterNonSea = 0;
        int counterAcSle = 0;
       
               
        for(seatDetails s : seatobj)
    	{
        	
        if(s.btype.equalsIgnoreCase("non-ac") && s.stype.equalsIgnoreCase("sleeper"))
        {
        	
 	            String gend;
 	            if(s.gender=='F' || s.gender == 'f')
 	            	
 	             gend = "female";
 	            
 	            else
 	            	
 	             gend = "male";
 	           
 	           int f = 0;
	            if(s.seatNumber < 4 && s.seatNumber > 0)
	            {
	            	 f = 0;
	            }
	            else if(s.seatNumber < 7)
	            {
	            	f = 1;
	            }
	            
 	                for(int j=0;j<3;j++)
 	                {
 	                	for(int v = 0; v < 2; v++)
 	                	{
 	                		if(f == 0)
 	                		{
 	                			
		 	                    if(s.seatNumber == j + 1 && s.conversion == v)
		 	                    {
		 	                  
		 	                        seatSleeperNon[f][j][v] = gend;
		 	                       
		 	                    }
 	                		}
 	                		else
 	                		{
 	                			if(s.seatNumber == j + 4 && s.conversion == v)
 	                			{
 	                				seatSleeperNon[f][j][v] = gend;
 	                			}
 	                		}
 	                }
 	            }
 	            
 	               if(s.seatNumber!=0 && s.conversion !=-1)
 		            {	
 		             seat[counterSleNon]=s.seatNumber;
 		             convert[counterSleNon] = s.conversion;
 		         
 		            }
        	counterSleNon++;
        }
        
        
        else if(s.btype.equalsIgnoreCase("ac") && s.stype.equalsIgnoreCase("sleeper"))
        {
        	 
 	            
 	            
 	            int f = 0;
 	            if(s.seatNumber < 4 && s.seatNumber > 0)
 	            {
 	            	 f = 0;
 	            }
 	            else if(s.seatNumber < 7)
 	            {
 	            	f = 1;
 	            }
 	            
 	            
 	            
 	            String gend;
 	            if(s.gender=='F' || s.gender == 'f')
 	            	
 	             gend = "female";
 	            
 	            else
 	            	
 	             gend = "male";
 	           
 	           
 	                for(int j=0;j<3;j++)
 	                {
 	                	for(int v = 0; v < 2; v++)
 	                	{
 	                		if(f == 0)
 	                		{
 	                			
		 	                    if(s.seatNumber == j + 1 && s.conversion == v)
		 	                    {
		 	                  
		 	                        seatSleeper[f][j][v] = gend;
		 	                       
		 	                    }
 	                		}
 	                		else
 	                		{
 	                			if(s.seatNumber == j + 4 && s.conversion == v)
 	                			{
 	                				seatSleeper[f][j][v] = gend;
 	                			}
 	                		}
 	                }
 	            }
 	            
 	               if(s.seatNumber!=0 && s.conversion !=-1)
 		            {	
 		             seat[counterAcSle]=s.seatNumber;
 		             convert[counterAcSle] = s.conversion;
 		         
 		            }
 	              counterAcSle++;
        }
        
        
        else if(s.btype.equalsIgnoreCase("non-ac") && s.stype.equalsIgnoreCase("seater"))
    	{
    		
	       
	            
	            String gend;
	            if(s.gender=='F' || s.gender == 'f')
	             gend = "female";
	            else
	             gend = "male";
	            for(int f=0;f<4;f++)
	            {
	                for(int j=0;j<3;j++)
	                {
	                	
	                    if(s.seatNumber == f + 1 && s.conversion == j)
	                    {
	                    	
	                        seaterNonac[f][j] = gend;
	                       
	                    }
	                }
	            }
	            if(s.seatNumber!=0 && s.conversion !=-1)
	            {	
	             seat[counterNonSea]=s.seatNumber;
	             convert[counterNonSea] = s.conversion;
	         
	            }
	        
	        counterNonSea++;
        }
        
        else if(s.btype.equalsIgnoreCase("ac") && s.stype.equalsIgnoreCase("seater"))
    	{
    		
	       	           	       
	            String gend;
	            if(s.gender =='F' || s.gender == 'f')
	             gend = "female";
	            else
	             gend = "male";
	            for(int f=0;f<4;f++)
	            {
	                for(int j=0;j<3;j++)
	                {
	                	
	                    if(s.seatNumber == f + 1 && s.conversion == j)
	                    {
	                    	
	                        seater[f][j] = gend;
	                       
	                    }
	                }
	            }
	            
	            if(s.seatNumber!=0 && s.conversion !=-1)
	            {		 
	            
	             	
	             seat[counter]=s.seatNumber;
	             convert[counter] = s.conversion;
	            
	            }
	        
	       counter++;
        }
    	
    	}
               
         counter = 0;
         counterSleNon = 0;
         counterNonSea = 0;
         counterAcSle = 0;
       
        seatobj2.addAll(seatobj);
        
        seatobj.clear();
        bookedseats+=seat.length;
        return bookedSeats;
    	
    }
    
    
    void deleteSeats(int[] bookedtickets, int[] conv, String btype, String stype)
    {
           	
    	 String seat = "Available";
       	    	 
    	for(int a = 0 ; a < bookedtickets.length; a++)
    	{
    	   
    		if(btype.equalsIgnoreCase("ac") && stype.equalsIgnoreCase("seater"))
        	{
        		
    		
	            for(int i=0;i<4;i++)
	            {
	                for(int j=0;j<3;j++)
	                {
	                	
	                    if((i+1)==bookedtickets[a] && j == conv[a])
	                    {	                 	
	                        seater[i][j]=seat;
	                        bookedseats--;                           
	                    }
	                 
	                }
	               
	            }
        	}
    		else if(btype.equalsIgnoreCase("non-ac") && stype.equalsIgnoreCase("seater"))
        	{
    			for(int i=0;i<4;i++)
	            {
	                for(int j=0;j<3;j++)
	                {
	                	
	                    if((i+1)==bookedtickets[a] && j == conv[a])
	                    {	                 	
	                    	seaterNonac[i][j]=seat;
	                        bookedseats--;                           
	                    }                 
	                }
	               
	            }
	    	}
    		else if(btype.equalsIgnoreCase("ac") && stype.equalsIgnoreCase("sleeper"))
            {
    			for(int i = 0; i < 2; i++)
    			{
    				for(int j = 0; j < 3; j++)
    				{
    					for(int k = 0; k < 2; k++)
    					{
    						if((j+1) == bookedtickets[a] && k == conv[a] && i == 0)
    						{
    							seatSleeper[i][j][k] = seat;
    							bookedseats--;
    						}
    						else if((j+4) == bookedtickets[a] && k == conv[a] && i ==1)
    						{
    							seatSleeper[i][j][k] = seat;
    							bookedseats--;
    						}
    					}
    				}
    			}
            }
    		else if(btype.equalsIgnoreCase("non-ac") && stype.equalsIgnoreCase("sleeper"))
            {
    			for(int i = 0; i < 2; i++)
    			{
    				for(int j = 0; j < 3; j++)
    				{
    					for(int k = 0; k < 2; k++)
    					{
    						if((j+1) == bookedtickets[a] && k == conv[a] && i == 0)
    						{
    							seatSleeperNon[i][j][k] = seat;
    							bookedseats--;
    						}
    						else if((j+4) == bookedtickets[a] && k == conv[a] && i ==1)
    						{
    							seatSleeperNon[i][j][k] = seat;
    							bookedseats--;
    						}
    					}
    				}
    			}
            }
    	}
    }
    
          
    double calculateFare(int noofseats, String btype, String stype)
    {
    	
    	double fare = 0;
    	       
        if(btype.equalsIgnoreCase("ac") && stype.equalsIgnoreCase("sleeper"))
        {
            fare=noofseats*700.00;
        }
        else if(btype.equalsIgnoreCase("ac") && stype.equalsIgnoreCase("seater"))
        {
            fare=noofseats*550.00;
        }
        else if(btype.equalsIgnoreCase("Non-ac") && stype.equalsIgnoreCase("sleeper"))
        {
            fare=noofseats*600.00;
        }
        else
        {
            fare=noofseats*450.00;
        }
    	
        return fare;
    }
    
    void customerSignUp() 
    {
    	int id = -1;
        System.out.println("Enter id,name,password,age,gender to sign-up");
        if(sc.hasNextInt())
        {
        	 id=sc.nextInt();
        }
        else
        {
        	System.out.println("Input id in natural numbers again.");
        	sc.nextLine();
        	return;
        }
       
        String name=sc.next();
        String pass=sc.next();
        int age=sc.nextInt();
        char gender=sc.next().charAt(0);
        int f=0;
        gender = Character.toUpperCase(gender);
        
        if(gender != 'M' && gender != 'F')
        {
        	System.out.println("Invalid gender. Try again");
        	return;
        }
        for(customer c:customerobj)
        {
            if(c.id==(id))
            {
                f++;
            }
        }
        if(f==0)
        {
        	if(age > 100 || age < 0)
        	{
        		
        		System.out.println("Incorrect input data for age. Please recheck");
        	}
        	else {
            customerobj.add(new customer(id,name,pass,age,gender));
            System.out.println("Back to home page");
        	}
        }
        else
        {
            System.out.println("User id already exist");
        }
    	
    }
    void customerLogin() throws ArrayIndexOutOfBoundsException
    {
        System.out.println("Enter username,password to Login");
        String username=sc.next();
        String pass=sc.next();
        int f=0;
        int id = -1;
        customer currcustomer = null;
        int ticketCounter =0;
        for(customer c:customerobj)
        {
            if(c.name.equalsIgnoreCase(username) && c.password.equals(pass))
            {
                currcustomer=c;
                f++;
                id = c.id;
                break;
            }
        }
        
       
        if(f==0)
        {
            System.out.println("Invalid Login or Password");
        }
        else
        {
            int t=0;
            System.out.println("Login Successful...\nWelcome "+currcustomer.name);            
            while(t==0)
            {
            System.out.println("\n1)BookTicket\n2)CancelTicket\n3)Filter&ViewTicket\n4)Logout");
            int choiceafterlogin=sc.nextInt();
            outerloop:
                for(customer c:customerobj)
                {
                	for(ticket ti : ticketobj)
                	{
                		if(ti.customer_id == c.id && ti.customer_id == (id))
                		{         
                			
                			ticketCounter = ti.ticketCounter;
                			break outerloop;
                		}
                		
                	}
                }
          
            switch(choiceafterlogin)
            {
                case 1:
                	
                	if(ticketCounter == 0)
                	{
                	int counter = 1;
                	
                	for(bus b: busobj)
                	{   
                			System.out.println(counter + " - " +b.bustype + " " + b.seattype + " - " + b.noofseatsleft + " seats");
                			counter++;
                	
                	}
                	counter = 1;
                	System.out.println("Choose bustype and seattype");
                String btype=sc.next();
                String stype=sc.next();
                
                for(bus b:busobj)
                {
                    if(b.bustype.equalsIgnoreCase(btype) && b.seattype.equalsIgnoreCase(stype))
                    {
                    
                        viewSeats(btype,stype);
                    }
                }
                             
                for(bus b:busobj)
                {
                    if(b.bustype.equalsIgnoreCase(btype) && b.seattype.equalsIgnoreCase(stype))
                    {
                    	
                    	System.out.print("Enter the number of seats to be booked: ");
                    	noofseat = sc.nextInt();
                        
                    	checkBooking(btype,stype,id,noofseat);
                    	
                        double fare=calculateFare(noofseat,btype,stype);
                       
                        System.out.println("The fare is : Rs." + fare );
                        System.out.print("Would you like to book the ticket? (Y/N) : ");
                        char confirmation=sc.next().charAt(0);
                        
                        if(confirmation == 'N' || confirmation == 'n')
                        {                      	                    	
                        	break;
                        }
                        else if(confirmation == 'Y' || confirmation == 'y')
                        {
                        
                        	int[][] bookedseat=book(btype,stype,id,noofseat);
                        	
                            b.noofseatsleft -= noofseat;
	                        int tickid=ticketobj.size();
	                        System.out.println("-----------------------------");
	                        ticketobj.add(new ticket(tickid,bookedseat[0],b,noofseat,fare,currcustomer.id,bookedseat[1],1));
	                        	                   	                    	                        
	                        System.out.println("Your Ticket is id:"+tickid+"\nYou have to pay Rs."+fare+"\nYour seats were booked");
	                        System.out.println("-----------------------------");
                        }
                    }
                }
                	}
                	else
                	{
                		System.out.println("Invalid option as you have already booked a ticket. Choose Another Option.");
                	}
                break;
              
                case 2:System.out.println("Enter booking id");
                int bid=sc.nextInt();
                for(ticket ti:ticketobj)
                {
                	              	
                	if(ti.id==bid && ti.customer_id!=currcustomer.id)
                	{
                		System.out.println("Ticket does not belong to you!\n");
                		break;
                	}
                	else if(ti.id==bid)
                    {
                        bus bookedbus=ti.ticketDetails();
                        int[] booked=ti.bookedtickets;
                        int[] convert = ti.convert;
                        
                        char letter = Character.MIN_VALUE;
                        System.out.println("The seats you have booked: ");
                        for(int i = 0; i < convert.length; i++)
                        {
                        	                               	           
             	            if(convert[i] == 0)
             	            {
             	            	letter = 'A';
             	            }
             	            if(convert[i] == 1)
             	            {
             	            	letter = 'B';
             	            }
             	            if(convert[i] == 2)
             	            {
             	            	letter = 'C';
             	            }
             	            System.out.print(letter +"" +booked[i] + " ");
             	            
                        }    
                        
                       
                        System.out.println("------------------------");
                        
                        System.out.println("Would you like to completely cancel or partially cancel?");
                        System.out.println("Enter complete for complete or partial for partially: ");
                        
                        String deletion = sc.next();
                        if(deletion.equalsIgnoreCase("complete"))
                        {
	                        deleteSeats(booked,convert,ti.object.bustype,ti.object.seattype);
	                        double updatedFare = 0;
	                        if(ti.object.bustype.equalsIgnoreCase("ac"))
	                        {	                    
	                        	updatedFare = ti.fare * 0.5;
	                        }
	                        else if(ti.object.bustype.equalsIgnoreCase("non-ac"))
	                        {
	                        	updatedFare = ti.fare * 0.25;
	                        }
	                        for(bus b: busobj)
	                        {
	                        	if(ti.object.bustype.equalsIgnoreCase(b.bustype) && ti.object.seattype.equalsIgnoreCase(b.seattype))
	                        	{
	                        		b.noofseatsleft += ti.noofseat;
	                        		
	                        	}
	                        }
	                        ticketobj.remove(ti);
	                        System.out.println("Your ticket has been deleted!!!\nCancellation fee: "+updatedFare+"\n");
	                        
	                        ticketCounter = 0;
	                        break;
                        }
                     
                        else if(deletion.equalsIgnoreCase("partial"))
                        {
                        	try {
                        	System.out.println("Enter the no of seat(s) you would like to delete: ");
                        	int seats = sc.nextInt();
                        	if(seats == 0 || seats > ti.bookedtickets.length)
                        	{
                        		System.out.println("No seats has been cancelled.");
                        	}
                        	else {
                        	int [] book = new int[seats];
                        	int [] con = new int[seats];
                        	for(int i = 0 ; i < seats; i++)
                        	{
                        		
	                        	System.out.println("Enter the seat you would like to delete: ");
	                        	String seatno = sc.next();
	             	            int seatNumber = Character.getNumericValue(seatno.charAt(1));
	             	            char let = seatno.charAt(0);
	             	            int conversion = -1;
	             	            if(let == 'A' || let == 'a')
	             	            {
	             	            	conversion = 0;
	             	            }
	             	            if(let == 'B' || let == 'b')
	             	            {
	             	            	conversion = 1;
	             	            }
	             	            if(let == 'C' || let == 'c')
	             	            {
	             	            	conversion = 2;
	             	            }
	             	            
	             	            
	             	            if(conversion < 0 || conversion > 2)
	             	            {
	             	            	System.out.println("Invalid seat selection.\nPlease choose seat between A-C");
	             	            	seatNumber = 0;
	             	            	i--;
	             	            }
	             	            
	             	            else if(ti.object.seattype.equalsIgnoreCase("seater"))
	             	            {
	             	            	if(seatNumber<1 || seatNumber>4)
		             	            {
		             	                System.out.println("Invalid seat number!!\nPlease choose seat between 1-4");
		             	                seatNumber = 0;
		             	                i--;
		             	            }
	             	            }
	             	            
	             	            else if(ti.object.seattype.equalsIgnoreCase("sleeper"))
	             	            {
	             	            	if((seatNumber<1 || seatNumber>6))
		             	            {
		             	                System.out.println("Invalid seat number!!\nPlease choose seat between 1-4");
		             	                seatNumber = 0;
		             	                i--;
		             	            }
	             	            }
	             	            
	             	            book[i] = seatNumber;
	             	            con[i] = conversion;
                        	}
                        	
                        	deleteSeats(book,con,ti.object.bustype,ti.object.seattype);
                            ti.updateTickets(book,con);
                            
                            for (Iterator<seatDetails> iterator = seatobj2.iterator(); iterator.hasNext();) {
                                seatDetails s = iterator.next();
                                for(int a = 0; a < seats; a++)
                                {
                                	if(s.btype.equalsIgnoreCase(ti.object.bustype) && s.stype.equalsIgnoreCase(ti.object.seattype))
	                            	{
	                            		if(s.seatNumber == book[a] && s.conversion == con[a])
	                            			iterator.remove();	                            		
	                            	}
                            	}
                                }
                            
                            
                            double updatedFare = 0;
                            double far = 0;
	                        if(ti.object.bustype.equalsIgnoreCase("ac") && ti.object.seattype.equalsIgnoreCase("seater"))
	                        {	             
	                        	 far = ti.fare;
	                        	far -= seats*550;
	                        	updatedFare = far * 0.5;
	                        }
	                        else if(ti.object.bustype.equalsIgnoreCase("non-ac") && ti.object.seattype.equalsIgnoreCase("seater"))
	                        {
	                        	 far = ti.fare;
	                        	far -= seats*450;
	                        	updatedFare = far * 0.25;
	                        }
	                        else if(ti.object.bustype.equalsIgnoreCase("ac") && ti.object.seattype.equalsIgnoreCase("sleeper"))
	                        {
	                        	 far = ti.fare;
	                        	far -= seats*700;
	                        	updatedFare = far * 0.5;
	                        }
	                        else if(ti.object.bustype.equalsIgnoreCase("non-ac") && ti.object.seattype.equalsIgnoreCase("sleeper"))
	                        {
	                        	 far = ti.fare;
	                        	far -= seats*600;
	                        	updatedFare = far * 0.25;
	                        }
	                        ti.fare = far;
	                        ti.updateCancellation(seats); 
	                        for(bus b: busobj)
	                        {
	                        	if(ti.object.bustype.equalsIgnoreCase(b.bustype) && ti.object.seattype.equalsIgnoreCase(b.seattype))
	                        	{
	                        		b.noofseatsleft += seats;
	                        		
	                        	}
	                        }
	                        
	                        System.out.println("Your ticket has been deleted!!!\nCancellation fee:  "+updatedFare+"\n");
                        }
                    }catch(IndexOutOfBoundsException e) {
                    	System.out.println("You attempted to delete seat that doesn't exist. Please try cancelling again.");
                    }
                        } 
                }
                }
                break;
                
                case 3:
                	               	
                	
                	Collections.sort(busobj);
                	
                	int count = 1; 
                	for(bus b : busobj)
                	{
                		
                		System.out.println(count + " - " +b.bustype + " " + b.seattype + " - " + b.noofseatsleft + " seats");
            			count++;
            			continue;
                	}
                	count = 1;
                	System.out.println("Enter (bustype and seattype) or (both to view both AC and Non AC and Seater and Non Seater)");
                String btype=sc.next();
                String stype=sc.next();
                System.out.println();
                for(bus b:busobj)
                {
                    if(b.bustype.equalsIgnoreCase(btype) && b.seattype.equalsIgnoreCase(stype))
                    {                   
                        viewSeats(btype,stype);
                        break;
                    }
                    else if(btype.equalsIgnoreCase("both") || stype.equalsIgnoreCase("both"))
                    {
                    		if(btype.equalsIgnoreCase("both") && stype.equalsIgnoreCase("seater"))
                    		{
                    			System.out.println("AC, Seater");
                    		viewSeats("ac","seater");
                    		
                    		System.out.println("\n");
                    		System.out.println("Non-AC, Seater");
                    		viewSeats("non-ac","seater");
                    		
                    		break;
                    		}
                    		else if(btype.equalsIgnoreCase("both") && stype.equalsIgnoreCase("sleeper"))
                    		{
                    			System.out.println("AC, Sleeper");
                    			viewSeats("ac","sleeper");
                    			System.out.println("\n");
                    			System.out.println("Non-AC, Sleeper");
                    			viewSeats("non-ac","sleeper");
                    			break;
                    		}
                    		else if(btype.equalsIgnoreCase("ac") && stype.equalsIgnoreCase("both"))
                    		{
                    			System.out.println("AC, Sleeper");
                    			viewSeats("ac","sleeper");
                    			System.out.println("\n");
                    			System.out.println("AC, Seater");
                    			viewSeats("ac","seater");
                    			break;
                    		}
                    		else if(btype.equalsIgnoreCase("non-ac") && stype.equalsIgnoreCase("both"))
                    		{
                    			System.out.println("Non-AC, Sleeper");
                    			viewSeats("non-ac","sleeper");
                    			System.out.println("\n");
                    			System.out.println("Non-AC, Seater");
                    			viewSeats("non-ac","seater");
                    			break;
                    		}
                    		else if(btype.equalsIgnoreCase("both") && stype.equalsIgnoreCase("both"))
                    		{
                    			System.out.println("AC, Sleeper");
                    			viewSeats("ac","sleeper");
                    			System.out.println("\n");
                    			System.out.println("AC, Seater");
                    			viewSeats("ac","seater");
                    			System.out.println("\n");
                    			System.out.println("Non-AC, Sleeper");
                    			viewSeats("non-ac","sleeper");
                    			System.out.println("\n");
                    			System.out.println("Non-AC, Seater");
                    			viewSeats("non-ac","seater");
                    			break;
                    		}
                    }
                }
                break;
                
                case 4:
                System.out.println("You have successfully loggedout...come back again!!!");
                       t++;
                       break;
            }
        }
    }
}
    
    void adminLogin()
    {
    	
    	System.out.println("Enter admin username,password to Login");
        String username=sc.next();
        String pass=sc.next();
        int f=0;
        int id = -1;
        admin ad = null;
        for(admin a:adminobj)
        {
            if(a.name.equalsIgnoreCase(username) && a.password.equals(pass))
            {
            
               ad = a;
                f++;
                
                break;
            }
        }
        
       
        if(f==0)
        {
            System.out.println("Invalid Login or Password");
            return;
        }
        else
        {
            
            System.out.println("Login Successful...\nWelcome "+ad.name); 
        }
        
        
    	String paraACSle = "";
    	String paraACSea = "";
    	String paraNonSle = "";
    	String paraNonSea = "";
    	for(seatDetails s : seatobj2)
        {
        	if(s.btype.equalsIgnoreCase("ac") && s.stype.equalsIgnoreCase("sleeper"))
        	{
        		paraACSle = paraACSle.concat(s.printDetails());
        		
        	}
        	else if(s.btype.equalsIgnoreCase("ac") && s.stype.equalsIgnoreCase("seater"))
        	{
        		paraACSea = paraACSea.concat(s.printDetails());
        	}
        	else if(s.btype.equalsIgnoreCase("non-ac") && s.stype.equalsIgnoreCase("seater"))
        	{
        		paraNonSea = paraNonSea.concat(s.printDetails());
        	}
        	else if(s.btype.equalsIgnoreCase("non-ac") && s.stype.equalsIgnoreCase("sleeper"))
        	{
        		paraNonSle = paraNonSle.concat(s.printDetails());
        	}
        }
    	System.out.println("The bus summary are:");
        for(ticket t :ticketobj)
        {
            System.out.println("Bus type: "+t.object.bustype);
            System.out.println("Seat type: "+t.object.seattype);
            System.out.println("Number of Seats filled: "+ t.noofseat);
            System.out.println("Total Fare collected: " + t.fare + " (" + t.initialTickets + " tickets + " + t.cancellation + " cancellation)");
            System.out.println("Seat Details : ");
            if(t.object.bustype.equalsIgnoreCase("ac") && t.object.seattype.equalsIgnoreCase("sleeper"))
            {
            	System.out.println(paraACSle);
          	
            }
            else if(t.object.bustype.equalsIgnoreCase("ac") && t.object.seattype.equalsIgnoreCase("seater"))
            {
            	System.out.println(paraACSea);
            }
            else if(t.object.bustype.equalsIgnoreCase("non-ac") && t.object.seattype.equalsIgnoreCase("sleeper"))
            {
            	System.out.println(paraNonSle);
            }
            else if(t.object.bustype.equalsIgnoreCase("non-ac") && t.object.seattype.equalsIgnoreCase("seater"))
            {
            	System.out.println(paraNonSea);
            }
            
        }
        
                    
    }
    public void createObj()
    {
            customerobj.add(new customer(1,"aaa","111",25,'F'));
            customerobj.add(new customer(2,"bbb","222",61,'M'));
            customerobj.add(new customer(3,"ccc","333",22,'M'));
            customerobj.add(new customer(4,"ddd","444",36,'F'));
            busobj.add(new bus("AC","Sleeper"));
            busobj.add(new bus("AC","Seater"));
            busobj.add(new bus("Non-AC","Sleeper"));
            busobj.add(new bus("Non-AC","Seater"));
            adminobj.add(new admin(0,"Niranjan","Rajendran",23,'M'));
    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        
        int choice;
        zobus z=new zobus();
        z.createObj();
        while(true)
        {
            
        	System.out.println("1)Customer Sign-up\n2)Customer Login\n3)AdminLogin\n4)Stop Program");
        	choice=in.nextInt();
        	switch(choice)
        	{
        		case 1:z.customerSignUp();
        			break;
        		case 2:z.customerLogin();
                   break;
        		case 3:z.adminLogin();
        			break;
        		case 4:System.exit(0);
        	}
        }
     
    }
}


