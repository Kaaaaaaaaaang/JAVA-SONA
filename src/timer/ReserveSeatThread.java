package timer;

import java.util.Calendar;

import member.info.User;

public class ReserveSeatThread implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String current = "";
		while(!current.equals(reserve.ReserveSeat.starttime)) {
			Calendar cal = Calendar.getInstance();
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int min = cal.get(Calendar.MINUTE);
			int sec = cal.get(Calendar.SECOND);
			current = hour + ":" + min + ":" + sec;
			try {
				Thread.sleep(1000); // 1/1000초 단위로 스레드 지연
				System.out.println("현재 시간 : " + current);
			}catch (InterruptedException ie) {
				// TODO: handle exception
				return;
			}
		}
		while(!current.equals(reserve.ReserveSeat.finishtime)) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.SECOND, 1);
			try {
				Thread.sleep(1000); // 1/1000초 단위로 스레드 지연
			}catch (InterruptedException ie) {
				// TODO: handle exception
				return;
			}
		}
	}

}
