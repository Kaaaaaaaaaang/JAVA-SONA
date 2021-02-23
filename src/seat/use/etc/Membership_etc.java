package seat.use.etc;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import member.info.User;

import javax.swing.JButton;

public class Membership_etc extends JFrame{
	
	private static final long serialVersionUID = 1L;
	boolean check=false;
	User user= new User();

	public Membership_etc() {
		
		setTitle("SONA 멤버십 결제");
		getContentPane().setBackground(Color.WHITE);
		setBounds(0,0, 800, 500);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		getContentPane();
		
		JLabel message = new JLabel("결제할 멤버십 종류를 선택해 주세요");
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setFont(new Font("돋움", Font.PLAIN, 20));
		getContentPane().add(message);
		
		message.setBounds(122, 83, 531, 53);
		
		JLabel tL=new JLabel();
		tL.setVisible(false);
		getContentPane().add(tL);
		
		JLabel howmuch = new JLabel();
		String str=AddTimePay.time+"시간   "+Integer.toString(AddTimePay.price)+"\\";
		howmuch.setText(str);
		howmuch.setHorizontalAlignment(SwingConstants.CENTER);
		howmuch.setFont(new Font("한컴 고딕", Font.PLAIN, 20));
		howmuch.setBounds(122, 22, 531, 53);
		getContentPane().add(howmuch);
		
		JButton dontPayBtn = new JButton("결제 취소하기");
		dontPayBtn.setBackground(Color.LIGHT_GRAY);
		dontPayBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 14));
		dontPayBtn.setBounds(323, 384, 127, 33);
		getContentPane().add(dontPayBtn);
		
		if(user.getMem_money()!=0) {
			
			JLabel moneyL = new JLabel("");
			moneyL.setText(Integer.toString(user.getMem_money())+"원");
			moneyL.setHorizontalAlignment(SwingConstants.CENTER);
			moneyL.setBounds(323, 271, 127, 65);
			getContentPane().add(moneyL);
			JButton money = new JButton("금액권");
			money.setFont(new Font("한컴 고딕", Font.PLAIN, 14));
			money.setBackground(Color.LIGHT_GRAY);
			money.setBounds(323, 163, 127, 98);
			getContentPane().add(money);
			
			money.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(main.MainScreen.db.minusmoney(AddTimePay.price)==true) {
							dispose(); pay.Receipt r=new pay.Receipt(); r.setVisible(true);
							JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.");
						}else {
							JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
						}
					} catch (ClassNotFoundException | SQLException e1) {e1.printStackTrace();}
					
				}
			});
		}
		
		if(user.getMem_time()!=null) {
			
			JButton time = new JButton("시간권");
			time.setFont(new Font("한컴 고딕", Font.PLAIN, 14));
			time.setBackground(Color.LIGHT_GRAY);
			time.setBounds(75, 163, 127, 98);
			getContentPane().add(time);
			JLabel timeL = new JLabel("");
			timeL.setText(user.getMem_time()+"시간");
			timeL.setHorizontalAlignment(SwingConstants.CENTER);
			timeL.setBounds(75, 271, 127, 65);
			getContentPane().add(timeL);
			time.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(main.MainScreen.db.minustime(AddTimePay.time)==true) {
							dispose(); Receipt r=new Receipt(); r.setVisible(true);
							JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.");
						}else {
							JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
						}
					} catch (ClassNotFoundException | SQLException e1) {e1.printStackTrace();}
					
				}
			});
		}
		if(user.getMem_week()!=0) {
			JButton week = new JButton("2주권");
			week.setFont(new Font("한컴 고딕", Font.PLAIN, 14));
			week.setBackground(Color.LIGHT_GRAY);
			week.setBounds(560, 163, 127, 98);
			getContentPane().add(week);
			
			JLabel weekL = new JLabel("");
			weekL.setHorizontalAlignment(SwingConstants.CENTER);
			weekL.setText(Integer.toString(user.getMem_week())+"일");
			weekL.setBounds(560, 271, 127, 65);
			getContentPane().add(weekL);
		}
		
		dontPayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check=true;
				dispose();
				JOptionPane.showMessageDialog(null, "결제가 취소되었습니다.");
				
			}
		});
		
	}
}