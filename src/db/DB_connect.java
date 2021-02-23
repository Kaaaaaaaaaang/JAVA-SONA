package db;
import java.sql.*;
import member.info.User;
import member.login.Login;

public class DB_connect {
	
	Statement stmt = null;// SQL ���� �����ͺ��̽��� ���������� ��ü
	ResultSet rs = null;// SQL ���ǿ� ���� ������ ���̺��� �����ϴ� ��ü
    Connection conn = null;
    
    member.info.User user = new User();
    
    //db���� ������
	public DB_connect() {
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost/sona_db?serverTimezone=UTC";

            conn = DriverManager.getConnection(url, "root", "sori0927");
            String sqlSeletQ = "select * from user_info;";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlSeletQ);
           
        }
        catch(ClassNotFoundException e){
            System.out.println("����̹� �ε� ����");
        }
        catch(SQLException e){
            System.out.println(e);
        }

    }
	
	//ȸ�� �α��� �޼���
	public String Login(String ph, String pw) throws ClassNotFoundException, SQLException {
		
		String search = "select * from User_Info where ph_number='"+ph+"'and pass='"+pw+"';";
		rs=stmt.executeQuery(search);
		while(rs.next()) {
			String ph1 = rs.getString("ph_number"); 
        	String pw1 = rs.getString("pass");
        	String name = rs.getString("name");
        	System.out.println(ph1 + "   " + pw1+"  "+name);
        	return ph1;
		}
		return null;
	}
	
	//�α��� �� UserŬ������ ���� ����
	public void SaveUserInfo() throws ClassNotFoundException, SQLException {
		
		String search = "select * from User_Info where ph_number='"+Login.UserPh_number+"';";
	
		rs=stmt.executeQuery(search);
		
		String name = null, 
				pass = null,
				ph_number=null,
				seat = null,
				startTime = null,
				useTime = null,
				finishTime = null,
				seat_use_time=null,
				reserve_start = null,
				reserve_finish = null,
				reserve_seat = null;
		int	mem_money = 0;
		String mem_time = null;
		int mem_week = 0;
		
		while(rs.next()) {
			name = rs.getString("name"); 
			pass=rs.getString("pass");
			ph_number=rs.getString("ph_number");
        	seat = rs.getString("seat");
        	startTime = rs.getString("start_time");
        	useTime = rs.getString("use_time");
        	finishTime = rs.getString("finish_time");
        	mem_money = rs.getInt("mem_money");
        	mem_week = rs.getInt("mem_week");
        	mem_time = rs.getString("mem_time");
        	seat_use_time = rs.getString("seat_use_time");
        	reserve_start = rs.getString("reserve_start");
        	reserve_finish = rs.getString("reserve_finish");
        	reserve_seat = rs.getString("reserve_seat");
		}
		User info=new User();
		
		info.setName(name);
		info.setPh_number(ph_number);
		info.setPass(pass);
		info.setSeat(seat);
		info.setStartTime(startTime);
		info.setUseTime(useTime);
		info.setFinish_Time(finishTime);
		info.setMem_money(mem_money);
		info.setMem_time(mem_time);
		info.setMem_week(mem_week);
		info.setSeat_use_time(seat_use_time);
		info.setReserve_finish(reserve_finish);
		info.setReserve_seat(reserve_seat);
		info.setReserve_start(reserve_start);
	}
	
	
	//ȸ������ 
	public void join(String name, String ph, String pw) throws ClassNotFoundException, SQLException {
		String joinUser = "insert into User_info(name, ph_number, pass) values('" + name + "', '"+ph+"', '"+pw+"');";
		stmt.executeUpdate(joinUser);
		
	}
	
	//ȸ�� ����
	public void delete() throws ClassNotFoundException, SQLException {
		String joinUser = "delete from User_info where ph_number="+Login.UserPh_number+";";
		stmt.executeUpdate(joinUser);
		
	}
	
	//ȸ�� �α��� �ߴ��� �˻�
	public boolean checkPm(String ph) throws ClassNotFoundException, SQLException {
		String search = "select * from User_Info where ph_number='"+ph+"';";
		rs=stmt.executeQuery(search);
		while(rs.next()) {
			String ph1 = rs.getString("ph_number");
			if(ph1.equals(ph))
				return true;
		}
		return false;
	}
	
	//�������� �޼���
	public void modify(String name, String ph, String pw) throws ClassNotFoundException, SQLException {
		String modify = "UPDATE user_info SET name = '"+name+"', ph_number = '"+ph+"' , pass = '"+pw+"' WHERE ph_number = '"+ph+"';";
		stmt.executeUpdate(modify);
	}
	
	public void seat_use_time_Refresh(String time) throws ClassNotFoundException, SQLException {
		String q = "UPDATE user_info SET seat_use_time = '"+time+"' WHERE ph_number = '"+user.getPh_number()+"';";
		stmt.executeUpdate(q);
	}
	
	//�����ͺ��̽��� �¼� �����ϴ� �޼���
	public void seat(int seat) throws ClassNotFoundException, SQLException {
		String modify = "UPDATE user_info SET seat = '" + seat + "' WHERE ph_number = '" + user.getPh_number()+"';";
		stmt.executeUpdate(modify);	
	}
	public void studyroom(int seat)throws ClassNotFoundException, SQLException{
		String modify = "UPDATE user_info SET studyroom = '" + seat + "'WHERE ph_number = '" + user.getPh_number() + "';";
		stmt.executeUpdate(modify);
	}
	//�����ͺ��̽��� ���� �ð��� �����ϴ� �޼���
	public void enter(String time)throws ClassNotFoundException, SQLException{
		String entertime = "UPDATE user_info SET start_time = '" + time + "' WHERE ph_number = '" + user.getPh_number() + "';";
		stmt.executeUpdate(entertime);
	}
	//�����ͺ��̽��� ��� �ð��� �����ϴ� �޼���
	public void use(int time)throws ClassNotFoundException, SQLException{
		String usetime = "UPDATE user_info SET use_time = '" + time + "' WHERE ph_number = '" + user.getPh_number() + "';";
		stmt.executeUpdate(usetime);
	}
	public void adduse(int time)throws ClassNotFoundException, SQLException{
		String usetime = "UPDATE user_info SET use_time = use_time + " + time + " WHERE ph_number = '" + user.getPh_number() + "';";
		stmt.executeUpdate(usetime);
	}
	//�����ͺ��̽��� ��� �ð��� �����ϴ� �޼���
	public void leave(int time)throws ClassNotFoundException, SQLException{
		String finishtime = "UPDATE user_info SET finish_time = DATE_ADD(start_time, INTERVAL '" + time + "' HOUR) WHERE ph_number = '" + user.getPh_number() + "';";
		stmt.executeUpdate(finishtime);
	}
	//�����ͺ��̽��� ���� �¼� �����ϴ� �޼���
	public void reserve(int seat) throws ClassNotFoundException, SQLException {
		String modify = "UPDATE user_info SET reserve_seat = '" + seat + "' WHERE ph_number = '" + user.getPh_number()+"';";
		stmt.executeUpdate(modify);	
	}
	//�����ͺ��̽��� ���༮ ��� ���� �ð��� �����ϴ� �޼���
	public void reserve_start(String time)throws ClassNotFoundException, SQLException{
		SaveUserInfo();
		String starttime = "UPDATE user_info SET reserve_start = '" + time + "' WHERE ph_number = '" + user.getPh_number() + "';";
		stmt.executeUpdate(starttime);
	}
	//�����ͺ��̽��� ���༮ ��� �ð��� �����ϴ� �޼���
	public void reserve_finish(String time)throws ClassNotFoundException, SQLException{
		String finishtime = "UPDATE user_info SET reserve_finish = '" + time + "' WHERE ph_number = '" + user.getPh_number() + "';";
		stmt.executeUpdate(finishtime);
	}
	//�����ͺ��̽��� �ð����� �����ϴ� �޼���
	public void membertime(int time)throws ClassNotFoundException, SQLException{
		if(user.getMem_time() == null) {
			String membertime = "UPDATE user_info SET mem_time = '" + time + ":00:00' WHERE ph_number = '" + user.getPh_number() + "';";
			stmt.executeUpdate(membertime);
		}else {
			String membertime = "UPDATE user_info SET mem_time = DATE_ADD(mem_time, INTERVAL '" + time + "' HOUR) WHERE ph_number = '" + user.getPh_number() + "';";
			stmt.executeUpdate(membertime);
		}
	}
	public boolean minustime(int time)throws ClassNotFoundException, SQLException{
		String str[]=user.getMem_time().split(":");
		int sum=Integer.parseInt(str[0])-time;
		if(sum<0) {
			return false;
		}else {
			String membertime = "UPDATE user_info SET mem_time = DATE_SUB(mem_time, INTERVAL '" + time + "' HOUR) WHERE ph_number = '" + user.getPh_number() + "';";
			stmt.executeUpdate(membertime);
			return true;
		}
	}
	public void outSeat()throws ClassNotFoundException, SQLException{
		String outSeat = "UPDATE user_info SET seat = " + null + " WHERE ph_number = '" + user.getPh_number() + "';";
		user.setSeat(null);
		stmt.executeUpdate(outSeat);
	}
	public void outSeatAuto(int seat)throws ClassNotFoundException, SQLException{
		String outSeat = "UPDATE user_info SET seat = " + null + " WHERE seat = " + seat + ";";
		user.setSeat(null);
		stmt.executeUpdate(outSeat);
		String q = "UPDATE user_info SET seat_use_time = " + null + " WHERE seat = " + seat + ";";
		stmt.executeUpdate(q);
	}
	//�����ͺ��̽��� �ݾױ��� �����ϴ� �޼���
	public void membermoney(int money)throws ClassNotFoundException, SQLException{
		if(user.getMem_money() == 0) {
			String membermoney = "UPDATE user_info SET mem_money = '" + money + "' WHERE ph_number = '" + user.getPh_number() + "';";
			stmt.executeUpdate(membermoney);
		}else {
			String membermoney = "UPDATE user_info SET mem_money =  mem_money + '" + money + "' WHERE ph_number = '" + user.getPh_number() + "';";
			stmt.executeUpdate(membermoney);
		}
	}
	public boolean minusmoney(int money)throws ClassNotFoundException, SQLException{
			int sum=user.getMem_money()-money;
			if(sum<0) {
				return false;
			}else {
				String membermoney = "UPDATE user_info SET mem_money =  mem_money - '" + money + "' WHERE ph_number = '" + user.getPh_number() + "';";
				stmt.executeUpdate(membermoney);
				return true;
			}
	}
	//�����ͺ��̽��� 2�ֱ��� �����ϴ� �޼���
	public void memberweek(int twoweek)throws ClassNotFoundException, SQLException{
		if(user.getMem_week() == 0) {
			String memberweek = "UPDATE user_info SET mem_week = '" + twoweek + "' WHERE ph_number = '" + user.getPh_number() + "';";
			stmt.executeUpdate(memberweek);
		}else {
			String memberweek = "UPDATE user_info SET mem_week =  mem_week + '" + twoweek + "' WHERE ph_number = '" + user.getPh_number() + "';";
			stmt.executeUpdate(memberweek);
		}
	}
	public boolean reserve_search(int seat, String st) throws SQLException {
		String q = "select count(*) from user_info where reserve_seat="+seat+" and reserve_start='"+st+"';";
		rs=stmt.executeQuery(q);
		int cnt=0;
		if(rs.next())cnt=rs.getInt(1);
		if(cnt==0)return false;
		else return true;
	}
	public boolean seatUseTrue(String seat)throws ClassNotFoundException, SQLException{
		String ss = "select count(*) from user_info where seat = " + seat + ";";
		rs=stmt.executeQuery(ss);
		int rowcount=0;
		if(rs.next())  rowcount = rs.getInt(1);
	    if(rowcount==0)return false;
	    else return true;
				
	}
	public boolean mySeat(String seat)throws ClassNotFoundException, SQLException{
		String ss =  "select count(*) from user_info where seat="+seat+" and ph_number='"+user.getPh_number()+"';";
		rs=stmt.executeQuery(ss);
		int rowcount=0;
		if(rs.next())  rowcount = rs.getInt(1);
	    if(rowcount==0)return false;
	    else return true;
				
	}
	//�����ͺ��̽� ����
	public void closeDB() {
	     try{
	    	 if( conn != null && !conn.isClosed()) {
	    		 conn.close();
	    	 }
	    		
	    }catch( SQLException e) {
	    	e.printStackTrace();
	    }
	}
	
}
