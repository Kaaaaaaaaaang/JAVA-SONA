package manager.login;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class manager {
	private String id;
	private String pw;
	
	manager(){
		setId();
		setPw();
	}

	public String getId() {
		setId();
		return id;
	}

	public void setId() {
		DateFormat formatD = new SimpleDateFormat("yyyyMMdd");
		String datestr = formatD.format(Calendar.getInstance().getTime());
		id=datestr;
	}

	public String getPw() {
		setPw();
		return pw;
	}

	public void setPw() {
		DateFormat formatT = new SimpleDateFormat("hhmm");
		String time = formatT.format(Calendar.getInstance().getTime());
		pw=time;
	}
}
