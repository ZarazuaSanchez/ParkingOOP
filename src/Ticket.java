import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

public class Ticket {

	static final String borders = "------------------------------------------";
	String message;
	LocalDateTime enterTime;
	LocalDateTime exitTime;   
	
	Ticket(String entrance, String exit){			
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		
		if(!entrance.equals(""))
			enterTime = LocalDateTime.parse(entrance, dtf);
		if(!exit.contentEquals(""))
			exitTime = LocalDateTime.parse(exit, dtf);
	}
	
	public String getFileName() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		System.out.println("filename: " + (dtf.format(enterTime) + "" + dtf.format(exitTime)) + ".txt");
		return (dtf.format(enterTime) + "" + dtf.format(exitTime));
	}
	
	public String toString() {
		return ( this.borders + "\n" +  message + this.borders);
	}
	
	public void setMessage(String msg) {
		this.message = msg;
	}
	
	protected String getMessage() {
		return (this.borders + "\n" +  message + this.borders);
	}
	
	public void setEnterTime(String entrTime) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		this.enterTime = LocalDateTime.parse(entrTime, dtf);
		
	}
	
	public void setExitTime(String exTime) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		this.exitTime = LocalDateTime.parse(exTime, dtf);
	}
	
	public String getEnterTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		return dtf.format(enterTime);
	}
	
	public String getExitTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		return dtf.format(exitTime);
	}
	
	public void setEnterTimeFromString(String date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		enterTime = LocalDateTime.parse(date, dtf);
	}
	
	public void setExitTimeFromString(String date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		exitTime = LocalDateTime.parse(date, dtf);
	}
	
	public void setTimes(String enter, String exit) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		
		enterTime = LocalDateTime.parse(enter, dtf);
		exitTime = LocalDateTime.parse(exit, dtf);
	}
	
	public long howManyHours(){
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		long duration = Math.abs(Duration.between(this.enterTime, this.exitTime).toHours());		
		return duration;
		
	}
	
	public long howManyMin() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		
		long duration;
		duration = Math.abs(Duration.between(this.enterTime, this.exitTime).toMinutes());
		
		return duration;
		
	}
	
	public void saveAsFile() throws FileNotFoundException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		String filename = getFileName() + ".txt";
		Formatter f = new File(filename);
		FileWriter writer = New FileWriter(f);
		
		StringReader sr = new StringReader(message);
		
		InputStream msg = new BufferedInputStream(message));
		
		InputStream ipstream = ByteArrayInputStream(message, "UTF-8");
		
		
//		FileWriter writer = new FileWriter(f);
//		writer.write(message);
//		writer.close();		
	}
}

