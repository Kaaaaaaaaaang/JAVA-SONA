package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class Manager_DB {
	Statement stmt = null;// SQL ���� �����ͺ��̽��� ���������� ��ü
	ResultSet rs = null;// SQL ���ǿ� ���� ������ ���̺��� �����ϴ� ��ü
    Connection conn = null;
    
    //db���� ������
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
            System.out.println("����̹� �ε� ����");
        }
        catch(SQLException e){
            System.out.println(e);
        }

    }
	
	public void userSelectAll(DefaultTableModel t_model) {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from User_info order by name");
 
            // DefaultTableModel�� �ִ� ���� ������ �����
            for (int i = 0; i < t_model.getRowCount();) {
                t_model.removeRow(0);
            }
 
            while (rs.next()) {
            	if(rs.getInt("seat")==0) {
            		Object data[] = { rs.getString("name"), rs.getString("ph_number"),
                            "-", rs.getString("mem_money"),rs.getString("mem_week"),rs.getString("mem_time") };
     
                    t_model.addRow(data); //DefaultTableModel�� ���ڵ� �߰�
            	}
            	else {
            		Object data[] = { rs.getString("name"), rs.getString("ph_number"),
                            rs.getInt("seat"), rs.getString("mem_money"),rs.getString("mem_week"),rs.getString("mem_time") };
     
                    t_model.addRow(data); //DefaultTableModel�� ���ڵ� �߰�
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
 
            // DefaultTableModel�� �ִ� ���� ������ �����
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
