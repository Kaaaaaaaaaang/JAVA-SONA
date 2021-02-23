package member.login;

import java.sql.SQLException;

public class Join {
	
   String join(String uName, String uPh, String uPw, String uPwCh) {
	   String str="";
	   
		
		if(uName.equals("") || uPh.equals("") || uPw.equals("")) {
			str="모든 항목을 작성해 주세요";
		}
		else if(chkString(uPh)==false) {
			str="전화번호를 다시 입력해 주세요";
		}
		else if(uPh.length()!=11) {
			str="전화번호를 다시 입력해 주세요";
		}
		else if(uPw.length()<4 && 10<uPw.length()) {
			str="비밀번호는 4 ~ 10 글자 이용 가능합니다.";
		}
		else if(uName.length()>10) {
			str="이름은 10글자 이내로 입력해 주세요";
		}
		else if(uPw.equals(uPwCh)==false){
			str="비밀번호를 다시 확인해 주세요";
		} else
			try {
				if(main.MainScreen.db.checkPm(uPh)){
					str="이미 사용 중인 전화번호 입니다.";
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