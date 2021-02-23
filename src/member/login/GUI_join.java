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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


import java.awt.Button;

public class GUI_join extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel joinP;

	private String uName;
	private String uPh;
	private String uPw;
	private String uPwCh;
	
	JTextField nameField;
	JTextField phField=new JTextField();
	JPasswordField pwField=new JPasswordField();
	JPasswordField pwChField=new JPasswordField();
	

	public GUI_join() {
		
		setTitle("SONA 회원가입");
		
		setBounds(0,0, 800, 500);
		
		setLocationRelativeTo(null);
		
		joinP = new JPanel();
		joinP.setBackground(Color.WHITE);
		
		setContentPane(joinP);
		
		getContentPane().setLayout(null);
		Container c = getContentPane();
		
		JLabel phL = new JLabel("전화번호");
		phL.setHorizontalAlignment(SwingConstants.RIGHT);
		phL.setFont(new Font("돋움", Font.PLAIN, 17));
		c.add(phL);
	
		
		phField.setFont(new Font("돋움", Font.PLAIN, 20));
		c.add(phField);
		
		phL.setBounds(156, 134, 116, 50);
		phField.setBounds(286, 135, 345, 49);
		
		JLabel pwL = new JLabel("비밀번호");
		pwL.setHorizontalAlignment(SwingConstants.RIGHT);
		pwL.setFont(new Font("돋움", Font.PLAIN, 17));
		c.add(pwL);
		pwField.setHorizontalAlignment(SwingConstants.LEFT);
		
		pwL.setBounds(156, 196, 116, 50);
		pwField.setBounds(286, 197, 345, 49);
		
		pwField.setFont(new Font("돋움", Font.PLAIN, 20));
		pwField.setEchoChar('*');
		c.add(pwField);
		
		Button joinBtn = new Button("Join");
		joinBtn.setBackground(new Color(48, 56, 65));
		joinBtn.setForeground(Color.WHITE);
		joinBtn.setFont(new Font("돋움", Font.PLAIN, 20));
		joinBtn.setBounds(156, 328, 475, 50);
		joinP.add(joinBtn);
		
		nameField = new JTextField(1);
		nameField.setFont(new Font("돋움", Font.PLAIN, 20));
		nameField.setBounds(286, 72, 345, 50);
		joinP.add(nameField);
		
		JLabel nameL = new JLabel("이름");
		nameL.setHorizontalAlignment(SwingConstants.RIGHT);
		nameL.setFont(new Font("돋움", Font.PLAIN, 17));
		nameL.setBounds(156, 72, 116, 50);
		joinP.add(nameL);
		
		pwChField.setHorizontalAlignment(SwingConstants.LEFT);
		pwChField.setFont(new Font("돋움", Font.PLAIN, 20));
		pwChField.setEchoChar('*');
		pwChField.setBounds(286, 259, 345, 49);
		joinP.add(pwChField);
		
		JLabel pwChL = new JLabel("비밀번호 확인");
		pwChL.setHorizontalAlignment(SwingConstants.RIGHT);
		pwChL.setFont(new Font("돋움", Font.PLAIN, 17));
		pwChL.setBounds(156, 258, 116, 50);
		joinP.add(pwChL);
		
		
		joinBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				uName=nameField.getText();
				uPh=phField.getText();
				uPw=pwField.getText();
				uPwCh=pwChField.getText();
				
				Join j = new Join();
				
				String s=j.join(uName, uPh, uPw, uPwCh);
				
				if(s.equals("")){
					dispose();
					JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
					nameField.setText("");
					phField.setText("");
					pwField.setText("");
					pwChField.setText("");
				}
				else JOptionPane.showMessageDialog(null, s, "Message", JOptionPane.ERROR_MESSAGE); 
			}
			
		});
	}
}
