package price;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SeatPrice {
	
	Statement stmt = null;// SQL 문을 데이터베이스에 보내기위한 객체
	ResultSet rs = null;// SQL 질의에 의해 생성된 테이블을 저장하는 객체
    Connection conn = null;
    
    
    public void setSeatPrice(String s, int p) throws SQLException {
    	String setdb = "UPDATE seat_price SET "+s+" = "+p+";";
		stmt.executeUpdate(setdb);	
    }
    public String getSeatPrice(String fn) throws SQLException {
    	
    	String search = "SELECT * FROM seat_price;";
		rs=stmt.executeQuery(search);
		String p;
		while(rs.next()) {
			p = rs.getString(fn);
			return p;
		}
		return null;
		
    }
	
    //db연동 생성자
	public SeatPrice() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost/sona_db?serverTimezone=UTC";

            conn = DriverManager.getConnection(url, "sona", "1111");
            String sqlSeletQ = "select * from seat_price;";
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
	
}
