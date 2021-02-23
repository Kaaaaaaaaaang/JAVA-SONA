package membership;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import select.UseSelect;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyMembership extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static int money;
	public static int time;
	public static int week;
	public static String membership, buy = "";
	public static int price;
	public BuyMembership() {
		initialize();
	}
	private void initialize() {
		
		JLabel intro_background = new JLabel("New label");
	    intro_background.setIcon(new ImageIcon("img/back_1.png"));
	    intro_background.setBounds(0, 0, 1000, 575);
	    getContentPane().add(intro_background);
		setTitle("SONA Study Cafe");
		setSize(1000, 600);
		setLocation(300, 80);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		String [] member = {"시간권", "금액권", "2주권"};
		
		JComboBox select = new JComboBox(member);
		
		select.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		select.setBackground(Color.WHITE);
		select.setSelectedIndex(0);
		select.setBounds(162, 208, 178, 50);
		intro_background.add(select);
		
		JLabel message = new JLabel("");
		message.setFont(new Font("돋움", Font.PLAIN, 16));
		intro_background.add(message);
		message.setForeground(Color.white);
		message.setBounds(190, 228, 250, 150);
		
		JButton cardpay = new JButton("\uC2E0\uC6A9\uCE74\uB4DC");
		cardpay.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		cardpay.setBackground(Color.WHITE);
		cardpay.setBounds(410, 420, 178, 50);
		intro_background.add(cardpay);
		cardpay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MembershipCardPay cp = new MembershipCardPay();
				cp.setVisible(true);
				//dispose();
			}
		});

		
		JButton cashpay = new JButton("\uD604\uAE08");
		cashpay.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		cashpay.setBackground(Color.WHITE);
		cashpay.setBounds(655, 420, 178, 50);
		intro_background.add(cashpay);
		cashpay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MembershipMoneyPay mp = new MembershipMoneyPay();
				mp.setVisible(true);
				//dispose();
			}
		});
		JButton backBtn = new JButton("뒤로가기");
		backBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
		backBtn.setBackground(Color.WHITE);
		backBtn.setBounds(161, 420, 178, 50);
		intro_background.add(backBtn);
		
		JButton hours50 = new JButton("<html>50시간<br/>40000\\</html>");
		hours50.setBackground(Color.WHITE);
		hours50.setFont(new Font("한컴 고딕", Font.PLAIN, 17));
		hours50.setBounds(533, 107, 110, 110);
		hours50.setVisible(false);
		intro_background.add(hours50);
		hours50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message.setText("50시간권을 선택하셨습니다.");
				membership = "50시간권";
				buy = "시간권";
				time = 50;
				price = 40000;
			}
		});
		
		JButton hours100 = new JButton("<html>100시간<br/>90000\\</html>");
		hours100.setBackground(Color.WHITE);
		hours100.setFont(new Font("한컴 고딕", Font.PLAIN, 17));
		hours100.setBounds(692, 107, 110, 110);
		hours100.setVisible(false);
		intro_background.add(hours100);
		hours100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message.setText("100시간권을 선택하셨습니다.");
				membership = "100시간권";
				buy = "시간권";
				time = 100;
				price = 75000;
			}
		});
		
		JButton hours150 = new JButton("<html>150시간<br/>120000\\</html>");
		hours150.setBackground(Color.WHITE);
		hours150.setFont(new Font("한컴 고딕", Font.PLAIN, 17));
		hours150.setBounds(533, 264, 110, 110);
		hours150.setVisible(false);
		intro_background.add(hours150);
		hours150.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message.setText("150시간권을 선택하셨습니다.");
				membership = "150시간권";
				buy = "시간권";
				time = 150;
				price = 115000;
			}
		});
		
		JButton hours200 = new JButton("<html>210시간<br/>150000\\</html>");
		hours200.setBackground(Color.WHITE);
		hours200.setFont(new Font("한컴 고딕", Font.PLAIN, 17));
		hours200.setBounds(692, 264, 110, 110);
		hours200.setVisible(false);
		intro_background.add(hours200);
		hours200.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message.setText("210시간권을 선택하셨습니다.");
				membership = "210시간권";
				buy = "시간권";
				time = 210;
				price = 150000;
			}
		});
		
		JButton money5 = new JButton("<html>5만원권<br/>40000\\</html>");
		money5.setBackground(Color.WHITE);
		money5.setFont(new Font("한컴 고딕", Font.PLAIN, 17));
		money5.setBounds(533, 107, 110, 110);
		money5.setVisible(false);
		intro_background.add(money5);
		money5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message.setText("5만권을 선택하셨습니다.");
				membership = "5만원권";
				buy = "금액권";
				money = 50000;
				price = 40000;
			}
		});
		
		JButton money10 = new JButton("<html>10만원권<br/>85000\\</html>");
		money10.setBackground(Color.WHITE);
		money10.setFont(new Font("한컴 고딕", Font.PLAIN, 17));
		money10.setBounds(692, 107, 110, 110);
		money10.setVisible(false);
		intro_background.add(money10);
		money10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message.setText("10만원권을 선택하셨습니다.");
				membership = "10만원권";
				buy = "금액권";
				money = 100000;
				price = 85000;
			}
		});
		
		JButton money15 = new JButton("<html>15만원권<br/>130000\\</html>");
		money15.setBackground(Color.WHITE);
		money15.setFont(new Font("한컴 고딕", Font.PLAIN, 17));
		money15.setBounds(533, 264, 110, 110);
		money15.setVisible(false);
		intro_background.add(money15);
		money15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message.setText("15만원권을 선택하셨습니다.");
				membership = "15만원권";
				buy = "금액권";
				money = 150000;
				price = 130000;
			}
		});
		
		JButton money20 = new JButton("<html>20만원권<br/>150000\\</html>");
		money20.setBackground(Color.WHITE);
		money20.setFont(new Font("한컴 고딕", Font.PLAIN, 17));
		money20.setBounds(692, 264, 110, 110);
		money20.setVisible(false);
		intro_background.add(money20);
		money20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message.setText("20만원권을 선택하셨습니다.");
				membership = "20만원권";
				buy = "금액권";
				money = 200000;
				price = 150000;
			}
		});
		
		JButton twoweek = new JButton("<html>2주권<br/>70000\\</html>");
		twoweek.setBackground(Color.WHITE);
		twoweek.setFont(new Font("한컴 고딕", Font.PLAIN, 17));
		twoweek.setBounds(613, 177, 110, 110);
		twoweek.setVisible(false);
		intro_background.add(twoweek);
		twoweek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message.setText("2주권을 선택하셨습니다.");
				membership = "2주권";
				buy = "2주권";
				week = 14;
				price = 70000;
			}
		});
		
		JButton search = new JButton("검색");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String choice = select.getSelectedItem().toString();
				if(choice.equals("시간권")) {
					hours50.setVisible(true);
					hours100.setVisible(true);
					hours150.setVisible(true);
					hours200.setVisible(true);
					money5.setVisible(false);
					money10.setVisible(false);
					money15.setVisible(false);
					money20.setVisible(false);
					twoweek.setVisible(false);
				}
				if(choice.equals("금액권")) {
					money5.setVisible(true);
					money10.setVisible(true);
					money15.setVisible(true);
					money20.setVisible(true);
					hours50.setVisible(false);
					hours100.setVisible(false);
					hours150.setVisible(false);
					hours200.setVisible(false);
					twoweek.setVisible(false);
				}
				if(choice.equals("2주권")) {
					twoweek.setVisible(true);
					hours50.setVisible(false);
					hours100.setVisible(false);
					hours150.setVisible(false);
					hours200.setVisible(false);
					money5.setVisible(false);
					money10.setVisible(false);
					money15.setVisible(false);
					money20.setVisible(false);
				}
			}
		});
		search.setFont(new Font("한컴 고딕", Font.PLAIN, 13));
		search.setBackground(Color.WHITE);
		search.setBounds(349, 208, 62, 50);
		intro_background.add(search);
		
		
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UseSelect us=new UseSelect();
				us.setVisible(true);
				dispose();
			}
		});

	}
}
