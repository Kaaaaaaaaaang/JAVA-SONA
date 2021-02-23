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
		
		setTitle("SONA ����� ����");
		getContentPane().setBackground(Color.WHITE);
		setBounds(0,0, 800, 500);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		getContentPane();
		
		JLabel message = new JLabel("������ ����� ������ ������ �ּ���");
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setFont(new Font("����", Font.PLAIN, 20));
		getContentPane().add(message);
		
		message.setBounds(122, 83, 531, 53);
		
		JLabel tL=new JLabel();
		tL.setVisible(false);
		getContentPane().add(tL);
		
		JLabel howmuch = new JLabel();
		String str=AddTimePay.time+"�ð�   "+Integer.toString(AddTimePay.price)+"\\";
		howmuch.setText(str);
		howmuch.setHorizontalAlignment(SwingConstants.CENTER);
		howmuch.setFont(new Font("���� ���", Font.PLAIN, 20));
		howmuch.setBounds(122, 22, 531, 53);
		getContentPane().add(howmuch);
		
		JButton dontPayBtn = new JButton("���� ����ϱ�");
		dontPayBtn.setBackground(Color.LIGHT_GRAY);
		dontPayBtn.setFont(new Font("���� ���", Font.PLAIN, 14));
		dontPayBtn.setBounds(323, 384, 127, 33);
		getContentPane().add(dontPayBtn);
		
		if(user.getMem_money()!=0) {
			
			JLabel moneyL = new JLabel("");
			moneyL.setText(Integer.toString(user.getMem_money())+"��");
			moneyL.setHorizontalAlignment(SwingConstants.CENTER);
			moneyL.setBounds(323, 271, 127, 65);
			getContentPane().add(moneyL);
			JButton money = new JButton("�ݾױ�");
			money.setFont(new Font("���� ���", Font.PLAIN, 14));
			money.setBackground(Color.LIGHT_GRAY);
			money.setBounds(323, 163, 127, 98);
			getContentPane().add(money);
			
			money.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(main.MainScreen.db.minusmoney(AddTimePay.price)==true) {
							dispose(); pay.Receipt r=new pay.Receipt(); r.setVisible(true);
							JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
						}else {
							JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.");
						}
					} catch (ClassNotFoundException | SQLException e1) {e1.printStackTrace();}
					
				}
			});
		}
		
		if(user.getMem_time()!=null) {
			
			JButton time = new JButton("�ð���");
			time.setFont(new Font("���� ���", Font.PLAIN, 14));
			time.setBackground(Color.LIGHT_GRAY);
			time.setBounds(75, 163, 127, 98);
			getContentPane().add(time);
			JLabel timeL = new JLabel("");
			timeL.setText(user.getMem_time()+"�ð�");
			timeL.setHorizontalAlignment(SwingConstants.CENTER);
			timeL.setBounds(75, 271, 127, 65);
			getContentPane().add(timeL);
			time.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(main.MainScreen.db.minustime(AddTimePay.time)==true) {
							dispose(); Receipt r=new Receipt(); r.setVisible(true);
							JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
						}else {
							JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.");
						}
					} catch (ClassNotFoundException | SQLException e1) {e1.printStackTrace();}
					
				}
			});
		}
		if(user.getMem_week()!=0) {
			JButton week = new JButton("2�ֱ�");
			week.setFont(new Font("���� ���", Font.PLAIN, 14));
			week.setBackground(Color.LIGHT_GRAY);
			week.setBounds(560, 163, 127, 98);
			getContentPane().add(week);
			
			JLabel weekL = new JLabel("");
			weekL.setHorizontalAlignment(SwingConstants.CENTER);
			weekL.setText(Integer.toString(user.getMem_week())+"��");
			weekL.setBounds(560, 271, 127, 65);
			getContentPane().add(weekL);
		}
		
		dontPayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check=true;
				dispose();
				JOptionPane.showMessageDialog(null, "������ ��ҵǾ����ϴ�.");
				
			}
		});
		
	}
}