package member.login;

import java.sql.SQLException;

public class Login  {
	public static String UserPh_number;
	
	boolean userLogin(String ph, String pw) throws ClassNotFoundException, SQLException {
		
		
		UserPh_number=main.MainScreen.db.Login(ph, pw);
		
		if(UserPh_number==null) {
			return false;
			
		}else {
			main.MainScreen.db.SaveUserInfo();
			return true;
		}
	}
}
