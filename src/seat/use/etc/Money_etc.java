package seat.use.etc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Money_etc extends JFrame{
	
	private static final long serialVersionUID = 1L;
	boolean check=false;

	public Money_etc(){
		setTitle("SONA 현금 결제");
		getContentPane().setBackground(Color.WHITE);
		setBounds(0,0, 800, 500);
		
		setLocationRelativeTo(null);
		
		
		getContentPane().setLayout(null);
		getContentPane();
		
		JLabel howmuch = new JLabel();
		String str=Integer.toString(AddTimePay.price)+"\\";
		howmuch.setText(str);
		howmuch.setHorizontalAlignment(SwingConstants.CENTER);
		howmuch.setFont(new Font("돋움", Font.PLAIN, 20));
		howmuch.setBounds(122, 22, 531, 53);
		getContentPane().add(howmuch);
		
		JLabel messege = new JLabel("현금을 현금 투입구에 넣어 주세요");
		messege.setHorizontalAlignment(SwingConstants.CENTER);
		messege.setFont(new Font("돋움", Font.PLAIN, 20));
		getContentPane().add(messege);
		
		messege.setBounds(123, 57, 531, 70);
		
	
		JLabel moneyImg = new JLabel();
		moneyImg.setIcon(new ImageIcon("img/money.png"));
		moneyImg.setBounds(309, 137, 150, 150);
		getContentPane().add(moneyImg);
		
		JButton dontPayBtn = new JButton("결제 취소하기");
		dontPayBtn.setBackground(Color.LIGHT_GRAY);
		dontPayBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 14));
		dontPayBtn.setBounds(323, 354, 127, 33);
		getContentPane().add(dontPayBtn);

		dontPayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check=true;
				dispose();
				JOptionPane.showMessageDialog(null, "결제가 취소되었습니다.");
				
			}
		});
		
		JLabel tL=new JLabel();
		tL.setVisible(false);
		getContentPane().add(tL);
		
		JPanel load1 = new JPanel();
		load1.setBackground(Color.GREEN);
		load1.setBounds(323, 308, 20, 20);
		getContentPane().add(load1);
		
		JPanel load2 = new JPanel();
		load2.setBackground(Color.GREEN);
		load2.setBounds(377, 308, 20, 20);
		getContentPane().add(load2);
		
		JPanel load3 = new JPanel();
		load3.setBounds(430, 308, 20, 20);
		load3.setBackground(Color.GREEN);
		getContentPane().add(load3);
		
		load1.setVisible(false);
		load2.setVisible(false);
		load3.setVisible(false);
		
		Timer tm = new Timer();
		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				if(check==false)
					load1.setVisible(true);
			}
		};
		TimerTask task2=new TimerTask() {
			@Override
			public void run() {
				if(check==false)
					load2.setVisible(true);
			}
		};
		TimerTask task3=new TimerTask() {
			@Override
			public void run() {
				if(check==false) {
					load3.setVisible(true);
					JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.");
					dispose();
					Receipt rc = null;
					try {
						rc = new Receipt();
						rc.setVisible(true);
					} catch (NumberFormatException | ClassNotFoundException | SQLException e) {}
				}
					
				
			}
		};
			tm.schedule(task, 1000);
			tm.schedule(task2, 2000);
			tm.schedule(task3, 3000);
		
	}
}
