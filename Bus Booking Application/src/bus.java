import java.util.ArrayList;
import java.util.Comparator;

class bus implements Comparable<bus>{
	
	String bustype;
    String seattype;
    int noofseatsleft;
 
    ArrayList<ticket> ticketobj=new ArrayList<ticket>();

       
    bus(String bustype,String seattype)
    {
    	this.bustype = bustype;
        this.seattype = seattype;
        noofseatsleft = 12;
    }

   

    @Override
	public int compareTo(bus compares) {
		int compareSeats = compares.noofseatsleft;
	
		return compareSeats-this.noofseatsleft;
	}
	   
}
