package timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RoomTimerThread implements Runnable{
	
	String currenttime = "";
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); 
	Date date = new Date();
	 
	public RoomTimerThread() {
		
		System.out.println(date);
		 
		cal.setTime(date);
		
		currenttime = sdf.format(cal.getTime());
		cal.add(Calendar.SECOND, 1);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*
		while(!currenttime.equals(pay.Receipt.finishtime)) {
			cal.add(Calendar.SECOND, 1);
			currenttime = sdf.format(cal.getTime());
			System.out.println(currenttime);
			try {
				Thread.sleep(1000); // 1/1000초 단위로 스레드 지연
			}catch (InterruptedException ie) {
				// TODO: handle exception
				return;
			}
		}*/
	}
	
}
