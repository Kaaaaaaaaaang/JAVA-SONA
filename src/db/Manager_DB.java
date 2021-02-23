package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class Manager_DB {
	Statement stmt = null;// SQL 문을 데이터베이스에 보내기위한 객체
	ResultSet rs = null;// SQL 질의에 의해 생성된 테이블을 저장하는 객체
    Connection conn = null;
    
    //db연동 생성자
	public Manager_DB() {
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost/sona_db?serverTimezone=UTC";

            conn = DriverManager.getConnection(url, "root", "sori0927");
            String sqlSeletQ = "select * from user_info;";
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
	
	public void userSelectAll(DefaultTableModel t_model) {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from User_info order by name");
 
            // DefaultTableModel에 있는 기존 데이터 지우기
            for (int i = 0; i < t_model.getRowCount();) {
                t_model.removeRow(0);
            }
 
            while (rs.next()) {
            	if(rs.getInt("seat")==0) {
            		Object data[] = { rs.getString("name"), rs.getString("ph_number"),
                            "-", rs.getString("mem_money"),rs.getString("mem_week"),rs.getString("mem_time") };
     
                    t_model.addRow(data); //DefaultTableModel에 레코드 추가
            	}
            	else {
            		Object data[] = { rs.getString("name"), rs.getString("ph_number"),
                            rs.getInt("seat"), rs.getString("mem_money"),rs.getString("mem_week"),rs.getString("mem_time") };
     
                    t_model.addRow(data); //DefaultTableModel에 레코드 추가
            	}
                
            }
 
        } catch (SQLException e) {
            System.out.println(e + "=> userSelectAll fail");
        } 
        
    }
	public void getUserSearch(DefaultTableModel dt, String fieldName, String word, boolean con[]) {
		
		 String sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() + "%'";
		 
		if(con[0]==true) {
			
			sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() + "%' And mem_money is not null";
			
			if(con[0]==true && con[1]==true && con[2]==true && con[3]==true) 
				sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() 
				+ "%' And mem_week is not null And mem_time is not null And mem_money is not null And seat is not null";
			
			else if(con[3]==true && con[0]==true && con[2]==true) 
				sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() 
				+ "%' And mem_week is not null And seat is not null And seat is not null";
			
			else if(con[3]==true && con[0]==true && con[1]==true) 
				sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() 
				+ "%' And mem_time is not null And seat is not null And seat is not null";
			
			else if(con[0]==true && con[1]==true && con[2]==true) 
				sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() 
				+ "%' And mem_week is not null And mem_time is not null And mem_money is not null";
			
			else if(con[0]==true && con[1]==true) 
				sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() 
				+ "%' And mem_money is not null And mem_time is not null";
			
			else if(con[0]==true && con[2]==true) 
				sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() 
				+ "%' And mem_money is not null And mem_week is not null";
			
			else if(con[0]==true && con[3]==true) 
				sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() 
				+ "%' And mem_money is not null And seat is not null";
		}
		else if(con[1]==true) {
			
			sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() + "%' And mem_time is not null";
			
			if(con[3]==true && con[1]==true && con[2]==true) 
				sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() 
				+ "%' And mem_week is not null And mem_time is not null And seat is not null";
			
			else if(con[1]==true && con[2]==true) 
				sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() 
				+ "%' And mem_week is not null And mem_time is not null";
			
			else if(con[1]==true && con[3]==true) 
				sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() 
				+ "%' And seat is not null And mem_time is not null";
		}
		else if(con[2]==true) {
			
			sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() + "%' And mem_week is not null";
			
			if(con[2]==true && con[3]==true) 
				sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() + "%' And seat is not null And mem_week is not null";
		}
		
		else if(con[3]==true) 
			sql = "SELECT * FROM user_info WHERE " + fieldName.trim() + " LIKE '%" + word.trim() + "%' And seat is not null";
 
 
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
 
            // DefaultTableModel에 있는 기존 데이터 지우기
            for (int i = 0; i < dt.getRowCount();) {
                dt.removeRow(0);
            }
 
            while (rs.next()) {
            	
            	if(rs.getInt("seat")==0) {
            		Object data[]= { rs.getString("name"), rs.getString("ph_number"),
                            "-", rs.getString("mem_money"),rs.getString("mem_week"),rs.getString("mem_time") };
            		dt.addRow(data);
            		
            	}else {
            		Object data[]= { rs.getString("name"), rs.getString("ph_number"),
                            rs.getInt("seat"), rs.getString("mem_money"),rs.getString("mem_week"),rs.getString("mem_time") };
            		dt.addRow(data);
            		
            	}
                
            }
 
        } catch (SQLException e) {
            System.out.println(e + "=> getUserSearch fail");
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
