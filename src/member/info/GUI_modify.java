package member.info;

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

public class GUI_modify extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel modifyP;

	private String uName;
	private String uPh;
	private String uPw;
	private String uPwCh;
	
	JTextField nameField;
	JTextField phField=new JTextField();
	JPasswordField pwField=new JPasswordField();
	JPasswordField pwChField=new JPasswordField();
	
	db.DB_connect dc=new db.DB_connect();

	public GUI_modify() {
		
		User user=new User();
		
		setTitle("SONA È¸¿ø Á¤º¸ ¼öÁ¤");
		
		setBounds(0,0, 800, 500);
		
		setLocationRelativeTo(null);
		
		modifyP = new JPanel();
		modifyP.setBackground(Color.WHITE);
		
		setContentPane(modifyP);
		
		getContentPane().setLayout(null);
		Container c = getContentPane();
		
		JLabel phL = new JLabel("\uC804\uD654\uBC88\uD638");
		phL.setHorizontalAlignment(SwingConstants.RIGHT);
		phL.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
		c.add(phL);
	
		
		phField.setFont(new Font("µ¸¿ò", Font.PLAIN, 20));
		phField.setText(user.getPh_number());
		c.add(phField);
		
		phL.setBounds(147, 134, 116, 50);
		phField.setBounds(277, 135, 345, 49);
		
		JLabel pwL = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwL.setHorizontalAlignment(SwingConstants.RIGHT);
		pwL.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
		c.add(pwL);
		pwField.setHorizontalAlignment(SwingConstants.LEFT);
		
		pwL.setBounds(147, 196, 116, 50);
		pwField.setBounds(277, 197, 345, 49);
		
		pwField.setFont(new Font("µ¸¿ò", Font.PLAIN, 20));
		pwField.setEchoChar('*');
		pwField.setText(user.getPass());
		c.add(pwField);
		
		Button modifyBtn = new Button("¼öÁ¤");
		modifyBtn.setBackground(new Color(48, 56, 65));
		modifyBtn.setFont(new Font("µ¸¿ò", Font.PLAIN, 20));
		modifyBtn.setBounds(147, 328, 475, 50);
		modifyP.add(modifyBtn);
		
		nameField = new JTextField(1);
		nameField.setFont(new Font("µ¸¿ò", Font.PLAIN, 20));
		nameField.setBounds(277, 72, 345, 50);
		nameField.setText(user.getName());
		modifyP.add(nameField);
		
		JLabel nameL = new JLabel("ÀÌ¸§");
		nameL.setHorizontalAlignment(SwingConstants.RIGHT);
		nameL.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
		nameL.setBounds(147, 72, 116, 50);
		modifyP.add(nameL);
		
		pwChField.setHorizontalAlignment(SwingConstants.LEFT);
		pwChField.setFont(new Font("µ¸¿ò", Font.PLAIN, 20));
		pwChField.setEchoChar('*');
		pwChField.setBounds(277, 259, 345, 49);
		pwChField.setText(user.getPass());
		modifyP.add(pwChField);
		
		JLabel pwChL = new JLabel("ºñ¹Ð¹øÈ£ È®ÀÎ");
		pwChL.setHorizontalAlignment(SwingConstants.RIGHT);
		pwChL.setFont(new Font("µ¸¿ò", Font.PLAIN, 17));
		pwChL.setBounds(147, 258, 116, 50);
		modifyP.add(pwChL);
		
		
		modifyBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				uName=nameField.getText();
				uPh=phField.getText();
				uPw=pwField.getText();
				uPwCh=pwChField.getText();
				
				Modify m = new Modify();
				
				String s=m.modify(uName, uPh, uPw, uPwCh);
				
				if(s.equals("")){
					dispose();
					JOptionPane.showMessageDialog(null, "¼öÁ¤ÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
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
