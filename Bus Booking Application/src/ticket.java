
class ticket
{
    int id;
    int[] bookedtickets;
    int[] convert;
    bus object;
    int noofseat;
    double fare;
    int customer_id;
    int cancellation;
    int initialTickets;
    int ticketCounter;
    ticket(int id,int[] bookedtickets,bus object,int noofseat,double fare,int customer_id,int[] convert,int ticketCounter)
    {
        this.id=id;
        this.bookedtickets=bookedtickets;
        this.object=object;
        this.noofseat=noofseat;
        this.fare=fare;
        this.customer_id=customer_id;
        this.convert = convert;
        this.ticketCounter = ticketCounter;
        cancellation = 0;
    }
    bus ticketDetails()
    {
    	System.out.println("-----------------------");
        System.out.println("Ticket details are:\n");
        System.out.println("Bus type:"+object.bustype);
        System.out.println("Seat type:"+object.seattype);
        System.out.println("Booked by the customer id:"+customer_id);
        System.out.println("No. of seats:"+noofseat);
      
        return object;
    }
    
    void updateCancellation(int seats)
    {
    	cancellation = seats;
    	initialTickets = noofseat;
    	noofseat-=seats;
    }
    
    void updateTickets(int [] tick, int [] con)
    {
    	int counter = 0;
    	for(int i = 0 ; i < bookedtickets.length; i++)
    	{
    		if(counter < tick.length)
    		{
    		if(tick[counter] == bookedtickets[i] && con[counter] == convert[i])
    		{
    			bookedtickets[i]-=tick[counter];
    			convert[i]-=con[counter];
    			counter++;
    		}
    		}
    		else
    		{
    			break;
    		}
    	}
    	int[] copy = new int[bookedtickets.length - 1];
    	int [] copy2 = new int[bookedtickets.length - 1];
    	for (int i = 0, j = 0,k=0; i < bookedtickets.length; i++) {
    	    if (bookedtickets[i] != 0) {
    	        copy[j++] = bookedtickets[i];
    	        copy2[k++] = convert[i];
    	    }
    	}
    	bookedtickets = copy;
    	convert = copy2;
    }
}
