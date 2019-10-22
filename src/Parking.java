import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Parking {
	
	private static String name = "\"Parking's a Bitch!\" Parking Company";
	protected int capacity;
	private int occupancy;
	private double rate; //hourly rate
	
	Parking(int c, double r){
		
		if(c > 0)
			this.capacity = c;
		else
			throw new IllegalArgumentException("Initialize ParkingLot with postive number capacity.");
		
		if( r > 0)
			this.rate = r;
		else
			throw new IllegalArgumentException("Initialize ParkingLot with postive number rate.");
			
	}
	
	public double getRate() {
		return rate;
	}
	
	public Ticket carEntersLot(String timest) throws DateTimeParseException {
				
		if(occupancy<capacity) {
			occupancy++;
			System.out.println("Car may enter lot");
			System.out.println("Take your ticket!");
			
//			LocalDateTime time = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
			
			if(!timest.equals(""))
				LocalDateTime.parse(timest, dtf); //make sure date is written correctly 
			
//			String timeStr = dtf.format(time);
			
			Ticket ticket = new Ticket(timest, "");
			ticket.setMessage(makeTicketMsg(timest, ""));
			
			return ticket;
			
		}
		else {
			System.out.println("Lot at capacity!");
			System.out.println("Car may NOT enter.");
			return null;
		}
	}
	
	public String makeTicketMsg(String enterTime, String exitTime) {
		
		String ln1 = this.name;
		String ln2 = "Enter Time:";
		
		String ln3 = enterTime;
		
		String ln4 = "Exit Time:";
		String ln5 = exitTime;
		String ln6 = "Keep ticket in a safe place!";
		return ( ln1 + "\n" + ln2 + "\n" + ln3 + "\n" + ln4 + "\n"
				+ ln5 + "\n" + ln6 + "\n");
	}
	
	public Ticket carExitsLot(Ticket tckt, String timest) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		
		if(!timest.equals("")) {
			LocalDateTime.parse(timest, dtf);
		}
		
		tckt.setExitTime(timest);
		tckt.setMessage(makeTicketMsg(tckt.getEnterTime(), timest));
		long howManyHours = tckt.howManyMin();
		
		double tickPay = ((float) howManyHours)/60*rate;
		
		this.occupancy--;
		
		return tckt;
		
	}
	
	public int reportOccupancy() {
		return (this.capacity-this.occupancy);
	}
	
	public Ticket readTicket(File f) {
		
		Scanner scan = new Scanner(f);
		
		String ln="";
		String entrance = "";
		String exit = "";
		
		for(int i=0;i<9;i++) {
			ln = scan.nextLine();
			
			if(i == 3) {
				entrance = ln;
			}
			
			if(i == 5) {
				exit = ln;
			}			
		}
		
		Ticket ticket = new Ticket(entrance, makeTicketMsg(entrance, exit));
		ticket.setExitTime(exit);
	}
	
	public void testTimeStamp() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		LocalDateTime enter = LocalDateTime.parse("10/12/2019 07:00", dtf);
		LocalDateTime exit = LocalDateTime.parse("10/12/2019 17:00", dtf);
		
		long diff = Math.abs(Duration.between(exit, enter).toMinutes());
		
		System.out.println("How much time passed between " + enter + " & " + exit + " : " + diff + "min");
	}
	
//	public void testFileRead(String filename) {
//		
//		File file = new File(filename);
//		Scanner scan = new Scanner(file);
//		
//		System.out.println("Test File Read");
//		
//		while(scan.hasNextLine()) {
//			System.out.println(scan.nextLine());
//		}
//		
//	}
	
//	public void getCwd() {
//		File testFile = new File("");
//	    String currentPath = testFile.getAbsolutePath();
//	    System.out.println("current path is: " + currentPath);
//	}
	
	
}
