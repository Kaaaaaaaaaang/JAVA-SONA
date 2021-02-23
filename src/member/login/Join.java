package member.login;

import java.sql.SQLException;

public class Join {
	
   String join(String uName, String uPh, String uPw, String uPwCh) {
	   String str="";
	   
		
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
				if(main.MainScreen.db.checkPm(uPh)){
					str="�̹� ��� ���� ��ȭ��ȣ �Դϴ�.";
				}else {
					main.MainScreen.db.join(uName, uPh, uPw);
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