
class seatDetails {
	
	char gender;
	String name;
	int seatNumber;
	char letter;
	int conversion;
	String btype;
	String stype;
	seatDetails(String btype, String stype, char gender, String name, int seatNumber,char letter, int conversion)
	{
		this.gender = gender;
		this.name = name;
		this.seatNumber = seatNumber;
		this.letter = letter;
		this.conversion = conversion;
		this.btype = btype;
		this.stype = stype;
	}
	
	public String printDetails()
	{
		String para = "Gender: " + gender+ "\n" + "Name: " + name + "\n" + "Seat: " + letter + seatNumber + "\n";
		
		
		return para;
	}

}
