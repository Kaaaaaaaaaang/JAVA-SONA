package member.login;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


import java.awt.Button;

public class GUI_login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel loginP;
	private String uPh;
	private String uPw;
	JTextField phField = new JTextField(1);
	JPasswordField pwField=new JPasswordField(1);

	public GUI_login() {
		
		
		setTitle("SONA 로그인");
		
		setBounds(0,0, 800, 500);
		
		setLocationRelativeTo(null);
		
		loginP = new JPanel();
		loginP.setBackground(Color.WHITE);
		
		setContentPane(loginP);
		
		getContentPane().setLayout(null);
		Container c = getContentPane();
		
		JLabel phL = new JLabel("\uC804\uD654\uBC88\uD638");
		phL.setHorizontalAlignment(SwingConstants.CENTER);
		phL.setFont(new Font("돋움", Font.PLAIN, 20));
		c.add(phL);
	
		
		phField.setFont(new Font("돋움", Font.PLAIN, 20));
		c.add(phField);
		
		phL.setBounds(72, 111, 100, 70);
		phField.setBounds(186, 112, 345, 70);
		
		JLabel pwL = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwL.setHorizontalAlignment(SwingConstants.CENTER);
		pwL.setFont(new Font("돋움", Font.PLAIN, 20));
		c.add(pwL);
		pwField.setHorizontalAlignment(SwingConstants.LEFT);
		
		pwL.setBounds(72, 189, 100, 70);
		pwField.setBounds(186, 190, 345, 70);
		
		pwField.setFont(new Font("돋움", Font.PLAIN, 20));
		pwField.setEchoChar('*');
		c.add(pwField);
		
		Button joinBtn = new Button("회원가입");
		joinBtn.setBackground(Color.WHITE);
		joinBtn.setFont(new Font("돋움", Font.PLAIN, 15));
		joinBtn.setBounds(330, 318, 116, 40);
		loginP.add(joinBtn);
		
		Button loginBtn = new Button("LOGIN");
		loginBtn.setBackground(new Color(48, 56, 65));
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setFont(new Font("돋움", Font.PLAIN, 20));
		loginBtn.setBounds(545, 110, 150, 150);
		loginP.add(loginBtn);
		
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_join j=new GUI_join();
				dispose();
				j.setVisible(true);
			}
		});
		
		loginBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				uPh=phField.getText();
				uPw=pwField.getText();
				Login l=new Login();
				boolean loginTF=false;
				try {
					loginTF=l.userLogin(uPh,uPw);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				if(loginTF==false) {
					JOptionPane.showMessageDialog(null, "전화번호와 비밀번호를 다시 확인해 주세요", "Message", JOptionPane.ERROR_MESSAGE); 
				}else {
					try {
						loginComplete();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					dispose();
				}
	          }
		});
	}
	public void loginComplete() throws ClassNotFoundException, SQLException {
		main.MainScreen.login.setVisible(false);
		main.MainScreen.join.setVisible(false);
		main.MainScreen.userHi.setVisible(true);
		main.MainScreen.logOut.setVisible(true);
		member.info.User user=new member.info.User();
		String uname=user.getName();
		main.MainScreen.db.SaveUserInfo();
		main.MainScreen.userHi.setText(uname+" 회원님, 오늘도 sona를 이용해 주셔서 감사합니다.");
	}
	public void logOut() {
		main.MainScreen.login.setVisible(true);
		main.MainScreen.join.setVisible(true);
		main.MainScreen.userHi.setVisible(false);
		main.MainScreen.logOut.setVisible(false);
		phField.setText("");
		pwField.setText("");
		Login.UserPh_number=null;
	}
	
}
