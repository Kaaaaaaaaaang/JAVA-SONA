package price;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SeatPrice {
	
	Statement stmt = null;// SQL ���� �����ͺ��̽��� ���������� ��ü
	ResultSet rs = null;// SQL ���ǿ� ���� ������ ���̺��� �����ϴ� ��ü
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
	
    //db���� ������
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
            System.out.println("����̹� �ε� ����");
        }
        catch(SQLException e){
            System.out.println(e);
        }

    }
	
}
