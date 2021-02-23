package member.info;

public class User {
	private static String name, ph_number, pass, seat, startTime, useTime,mem_time, finish_Time,seat_use_time;
	private static int mem_money, mem_week;
	private static String reserve_start, reserve_finish, reserve_seat;
	
	public String getSeat_use_time() {
		return seat_use_time;
	}
	public void setSeat_use_time(String seat_use_time) {
		User.seat_use_time=seat_use_time;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		User.name = name;
	}

	public static String getFinish_Time() {
		return finish_Time;
	}

	public void setFinish_Time(String finish_Time) {
		User.finish_Time = finish_Time;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		User.seat = seat;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		User.startTime = startTime;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		User.useTime = useTime;
	}

	public int getMem_money() {
		return mem_money;
	}

	public void setMem_money(int mem_money) {
		User.mem_money = mem_money;
	}

	public int getMem_week() {
		return mem_week;
	}

	public void setMem_week(int mem_week) {
		User.mem_week = mem_week;
	}

	public String getMem_time() {
		return mem_time;
	}

	public void setMem_time(String mem_time) {
		User.mem_time = mem_time;
	}

	public String getPh_number() {
		return ph_number;
	}

	public void setPh_number(String ph_number) {
		User.ph_number = ph_number;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		User.pass = pass;
	}
	public boolean membershipUser() {
		if(this.getMem_money()!=0 || this.getMem_time()!=null || this.getMem_week()!=0) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getReserve_start() {
		// TODO Auto-generated method stub
		return reserve_start;
	}
	public void setReserve_start(String reserve_start) {
		// TODO Auto-generated method stub
		User.reserve_start = reserve_start;
	}
	public String getReserve_finish() {
		// TODO Auto-generated method stub
		return reserve_finish;
	}
	public void setReserve_finish(String reserve_finish) {
		// TODO Auto-generated method stub
		User.reserve_finish = reserve_finish;
	}
	public String getReserve_seat() {
		// TODO Auto-generated method stub
		return reserve_seat;
	}
	public void setReserve_seat(String reserve_seat) {
		// TODO Auto-generated method stub
		User.reserve_seat = reserve_seat;
	}
}
