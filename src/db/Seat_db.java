package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Seat_db {
	
	Statement stmt = null;// SQL 문을 데이터베이스에 보내기위한 객체
	ResultSet rs = null;// SQL 질의에 의해 생성된 테이블을 저장하는 객체
    Connection conn = null;
    
    seat.Seat s=new seat.Seat();
    
    //db연동 생성자
	public Seat_db() {
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost/sona_db?serverTimezone=UTC";

            conn = DriverManager.getConnection(url, "root", "sori0927");
            String sqlSeletQ = "select * from seat;";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sqlSeletQ);
        }
        catch(ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch(SQLException e){
            System.out.println(e);
        }

    }
	public void modify(int seat, String st, String ft, String ut) throws ClassNotFoundException, SQLException {
		String modify = "UPDATE seat SET use_time = '"+ut+"', start_time = '"+st+"' , finish_time = '"+ft+"' WHERE seat = '"+seat+"';";
		stmt.executeUpdate(modify);
		saveSeatInfo(seat);
	}
	public void useSeat(int seat, String st, String ft, String ut) throws SQLException {
		String use = "insert into User_info(seat, start_time, finish_time,use_time) "
				+ "values('" + seat + "', '" + st + "', '" + ft + "'," + ut + "');";
		stmt.executeUpdate(use);
	}
	public void outSeat(int num) throws ClassNotFoundException, SQLException {
		String q = "delete from seat where seat="+num+";";
		stmt.executeUpdate(q);
		
	}
	public void saveSeatInfo(int num) throws SQLException {
            rs = stmt.executeQuery("select * from seat where seat="+num+";");
            while(rs.next()) {
    			int seat = rs.getInt("seat"); 
            	String st = rs.getString("start_time");
            	String ft = rs.getString("finish_time");
            	String ut = rs.getString("use_time");
            	s.setSeat(seat);
            	s.setSt(st);
            	s.setFt(ft);
            	s.setUt(ut);
    		}
    }
	 
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