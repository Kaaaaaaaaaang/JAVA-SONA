package manager.login;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Login extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel loginP;
	private String mId;
	private String mPw;
	JTextField idField = new JTextField(1);
	JPasswordField pwField=new JPasswordField(1);
	
	public static String managerID=null;
	
	public Login() {
		
		
		setTitle("SONA 관리자 로그인");
		
		setBounds(0,0, 800, 500);
		
		setLocationRelativeTo(null);
		
		loginP = new JPanel();
		loginP.setBackground(Color.WHITE);
		
		setContentPane(loginP);
		
		getContentPane().setLayout(null);
		Container c = getContentPane();
		
		JLabel phL = new JLabel("ID");
		phL.setHorizontalAlignment(SwingConstants.CENTER);
		phL.setFont(new Font("돋움", Font.PLAIN, 20));
		c.add(phL);
	
		
		idField.setFont(new Font("돋움", Font.PLAIN, 20));
		c.add(idField);
		
		phL.setBounds(72, 155, 100, 70);
		idField.setBounds(186, 156, 345, 70);
		
		JLabel pwL = new JLabel("PW");
		pwL.setHorizontalAlignment(SwingConstants.CENTER);
		pwL.setFont(new Font("돋움", Font.PLAIN, 20));
		c.add(pwL);
		pwField.setHorizontalAlignment(SwingConstants.LEFT);
		
		pwL.setBounds(72, 233, 100, 70);
		pwField.setBounds(186, 234, 345, 70);
		
		pwField.setFont(new Font("돋움", Font.PLAIN, 20));
		pwField.setEchoChar('*');
		c.add(pwField);
		
		Button loginBtn = new Button("LOGIN");
		loginBtn.setBackground(new Color(48, 56, 65));
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setFont(new Font("돋움", Font.PLAIN, 20));
		loginBtn.setBounds(545, 154, 150, 150);
		loginP.add(loginBtn);
		
		loginBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				mId=idField.getText();
				mPw=pwField.getText();
				if(loginM()==false) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 확인해 주세요", "Message", JOptionPane.ERROR_MESSAGE); 
				}else {
					loginComplete();
					dispose();
				}
				
	          }
			
		});
	}
	public boolean loginM() {
		manager m=new manager();
		if(mId.equals(m.getId())){
			if(mPw.equals(m.getPw())) {
				managerID=m.getId();
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	public void loginComplete(){
		main.MainScreen ms = new main.MainScreen();
		main.ManagerScreen m=new main.ManagerScreen();
		m.setVisible(true);
		ms.setVisible(false);
	}
	public void logOut() {
		main.MainScreen.login.setVisible(true);
		main.MainScreen.join.setVisible(true);
		main.MainScreen.userHi.setVisible(false);
		main.MainScreen.logOut.setVisible(false);
		idField.setText("");
		pwField.setText("");
		Login.managerID=null;
	}
}
