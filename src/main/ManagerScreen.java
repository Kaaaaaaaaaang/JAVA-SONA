package main;

import java.awt.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerScreen extends JFrame {

	private static final long serialVersionUID = 1L;

	public static JLabel userHi = new JLabel();
	public static JButton logOut = new JButton("로그아웃");
	public ManagerScreen(){
		initialize();
	}
	
	private void initialize() {
		JLabel intro_background = new JLabel("New label");
	    intro_background.setIcon(new ImageIcon("img/mainScreen.png"));
	    intro_background.setBounds(0, 0, 1000, 600);
	    getContentPane().add(intro_background);
		
		this.getContentPane().setBackground(new Color(190, 210, 230));
		setTitle("SONA Study Cafe");
		setSize(1000, 600);
		setLocation(300, 80);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		logOut.setBorderPainted(false);
		logOut.setContentAreaFilled(false);
		logOut.setForeground(Color.white);
		logOut.setFont(new Font("한컴 고딕", Font.BOLD, 15));
		logOut.setBounds(775, 430, 117, 23);
		intro_background.add(logOut);
		
		JButton sona = new JButton("스터디카페 관리");
		intro_background.add(sona);
		sona.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		sona.setSize(200, 56);
		sona.setLocation(412, 411);
		sona.setBackground(Color.WHITE);
		
		JButton userManage = new JButton("회원 관리");
		intro_background.add(userManage);
		userManage.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		userManage.setSize(200, 56);
		userManage.setLocation(98, 411);
		userManage.setBackground(Color.WHITE);
		userManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.user.control.UserManage muc = new manager.user.control.UserManage();
				muc.setVisible(true);
				dispose();
			}
		});
		
		sona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//manager.sona.control.SonaControler msc = new manager.sona.control.SonaControler();
				//msc.setVisible(true);
				
				manager.sona.control.SonaPriceChange spc=new manager.sona.control.SonaPriceChange();
				spc.setVisible(true);
				dispose();
			}
		});
		
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말 로그아웃 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					String str="로그아웃 되었습니다.";
					JOptionPane.showMessageDialog(null, str, "Message", JOptionPane.ERROR_MESSAGE);
					dispose();
				}
			}
		});
	}
}