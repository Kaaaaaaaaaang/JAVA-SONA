package member.info;

import java.sql.SQLException;

import member.login.Login;

public class Modify {
	
	
   String modify(String uName, String uPh, String uPw, String uPwCh) {
	   String str="";
	   
	   User user=new User();
		
		if(uName.equals("") || uPh.equals("") || uPw.equals("")) {
			str="��� �׸��� �ۼ��� �ּ���";
		}
		else if(chkString(uPh)==false) {
			str="��ȭ��ȣ�� �ٽ� �Է��� �ּ���";
		}
		else if(uPh.length()!=11) {
			str="��ȭ��ȣ�� �ٽ� �Է��� �ּ���";
		}
		else if(uPw.length()<4 && 10<uPw.length()) {
			str="��й�ȣ�� 4 ~ 10 ���� �̿� �����մϴ�.";
		}
		else if(uName.length()>10) {
			str="�̸��� 10���� �̳��� �Է��� �ּ���";
		}
		else if(uPw.equals(uPwCh)==false){
			str="��й�ȣ�� �ٽ� Ȯ���� �ּ���";
		} else
			try {
				if(main.MainScreen.db.checkPm(uPh) && uPh.equals(Login.UserPh_number)==false){
					str="�̹� ��� ���� ��ȭ��ȣ �Դϴ�.";
				}else {
					main.MainScreen.db.modify(uName, uPh, uPw);
					user.setName(uName);
					user.setPh_number(uPh);
					user.setPass(uPw);
				}
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		return str;
     }

	boolean chkString(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (Exception e) {
			return false;
		}		
	}

}