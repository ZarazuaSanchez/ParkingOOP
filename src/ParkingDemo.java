
public class ParkingDemo {
	
	public static void main(String[] args) {
			
		Parking lot = new Parking(15, 7.0);
		
		Ticket[] allMyTickets = new Ticket[15];		
		
		//5 cars enter after 7:30
		String date = "10/19/2019";
		String h = "07";
		String min = "30";
		String timestamp = "";
		for(int i=0;i<5;i++) {
			System.out.println("Car at entrance gate.");
			timestamp = date + " " + h + ":" + (Integer.valueOf(min) + i);
			allMyTickets[i] = lot.carEntersLot(timestamp);
			System.out.println("At time " + timestamp);
		}
		
		System.out.println("Now room for " + lot.reportOccupancy() + "as of " + timestamp + "\n");
		
		//5 cars enter after 8:30
		date = "10/19/2019";
		h = "08";
		min = "30";
		timestamp = "";
		for(int i=5;i<10;i++) {
			System.out.println("Car at entrance gate.");
			timestamp = date + " " + h + ":" + (Integer.valueOf(min) + i);
			allMyTickets[i] = lot.carEntersLot(timestamp);
			System.out.println("At time " + timestamp);
		}
		
		System.out.println("Now room for " + lot.reportOccupancy() + " as of " + timestamp + "\n");
		
		//5 cars enter after 9:30
		date = "10/19/2019";
		h = "09";
		min = "00";
		timestamp = "";
		for(int i=10;i<15;i++) {
			System.out.println("Car at entrance gate.");
			timestamp = date + " " + h + ":" + (Integer.valueOf(min) + i);
			allMyTickets[i] = lot.carEntersLot(timestamp);
			System.out.println("At time " + timestamp);
		}
		
		System.out.println("Now room for " + lot.reportOccupancy() + " as of " + timestamp + "\n");
		
		//Car tries to enter when full too late
		Ticket t = lot.carEntersLot("10/19/2019 9:30");
		if(t == null) {
			System.out.println("The lot is full. We apologize for any inconvinience!\n");
		}
		
		//5 cars leave after 5:15 p.m.
		date = "10/19/2019";
		h = "17";
		min = "15";
		timestamp = "";
		for(int j=0;j<15;j++) {
			
			timestamp = date + " " + h + ":" + (Integer.valueOf(min) + j);
			
			//every 3rd car leaves
			double tickPay;
			if((j % 3) == 0) {
				allMyTickets[j] = lot.carExitsLot(allMyTickets[j], timestamp);
				System.out.println(allMyTickets[j]);
				tickPay = allMyTickets[j].howManyMin() / 60 * lot.getRate(); 
				System.out.printf("Pay $%.2f\n", tickPay);
				System.out.println("Thank you very much, bye!\n");
				
			}
		}
		
		System.out.println("Now room for " + lot.reportOccupancy() + " as of " + timestamp + "\n");
		
		//lot.getCwd();
	
	}

}
