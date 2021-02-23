package timer;
import seat.SeatButton;

import java.sql.SQLException;

import member.info.User;

public class UseSeatTimer implements Runnable{
	/*
	public static String btnL="";
	static User user=new User();
	public static String time_str="";
	*/
	public UseSeatTimer() {}
	@Override
	public void run() {
		/*
				int h=1,m=0,s=1;
				String str[]=user.getSeat_use_time().split(":");
				int time[]=new int[3];
				for(int i=0; i<str.length;i++) {
					time[i]=Integer.parseInt(str[i]);
				}
				
				int hour=time[0];
				int min = hour * 60 + time[1];
				int sec= min * 60 + time[2];
				
				for(int i = sec; i>=0; i--) {
					
					min=i/60;
					
					h=min/60;
					m=min%60;
					s=i%60;
					
					System.out.println(h+"시간"+m+"분"+s+"초");
					
					
					String s_h=Integer.toString(h);
					String s_m=Integer.toString(m);
					String s_s=Integer.toString(s);
					
					time_str=s_h+":"+s_m+":"+s_s;
					try {
						main.MainScreen.db.seat_use_time_Refresh(time_str);
					} catch (ClassNotFoundException | SQLException e1) {}
					
					btnL="<HTML><body><center>"+SeatButton.seatNum+"<br>"+time_str+"</center></body></HTML>";
					SeatButton sb=new SeatButton();
					
					
					try {
						Thread.sleep(1000);
						sb.setText(btnL);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(h==0 && m==0 && s==0) {
					try {
						main.MainScreen.db.outSeatAuto(Integer.parseInt(SeatButton.seatNum));
						
					} catch (ClassNotFoundException | SQLException k) {}
				}
				
	*/	
	}
}

