package member.info;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Button;

public class UserInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	User user = new User();
	
	public UserInfo() {
		initialize();
	}
	private void initialize() {
		
		this.getContentPane().setBackground(new Color(190, 210, 230));
		setTitle("SONA Study Cafe");
		setSize(1000, 600);
		setLocation(300, 80);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		 JLabel intro_background = new JLabel("New label");
	     intro_background.setIcon(new ImageIcon("img/back_1.png"));
	     intro_background.setBounds(0, 0, 1000, 600);
	     getContentPane().add(intro_background);
		
		JPanel titleP = new JPanel();
		titleP.setBackground(new Color(48, 56, 65));
		intro_background.add(titleP);
		setLocationRelativeTo(null);
		
		JLabel titleL = new JLabel("회원 정보");
		titleL.setBackground(new Color(48, 56, 65));
		titleL.setHorizontalAlignment(SwingConstants.CENTER);
		titleL.setFont(new Font("한컴 고딕", Font.PLAIN, 21));
		titleL.setBounds(410, 36, 183, 18);
		titleP.add(titleL);
		
		JPanel lineP = new JPanel();
		lineP.setForeground(Color.BLACK);
		lineP.setBackground(new Color(0,0,0,0));
		lineP.setBounds(50, 46, 893, 480);
		intro_background.add(lineP);
		lineP.setLayout(null);
		
		Button backBtn = new Button("다른 서비스 이용하기");
		backBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		backBtn.setBackground(Color.WHITE);
		backBtn.setBounds(130, 427, 151, 32);
		lineP.add(backBtn);
		
		
		
		if(user.getName()!=null) {
		
			JLabel nameL = new JLabel("이름");
			nameL.setBounds(273, 46, 83, 32);
			lineP.add(nameL);
		    nameL.setForeground(Color.WHITE);
			nameL.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
			nameL.setHorizontalAlignment(SwingConstants.LEFT);
			
			JLabel phL = new JLabel("전화번호");
			phL.setHorizontalAlignment(SwingConstants.LEFT);
			phL.setForeground(Color.WHITE);
			phL.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
			phL.setBounds(273, 106, 83, 32);
			lineP.add(phL);
			
			
			JLabel userNameL = new JLabel();
			userNameL.setHorizontalAlignment(SwingConstants.LEFT);
			userNameL.setForeground(Color.WHITE);
			userNameL.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
			userNameL.setBounds(370, 46, 277, 32);
			userNameL.setText(getName());
			lineP.add(userNameL);
			
			
			
			JLabel userPhL = new JLabel();
			userPhL.setText(getPh());
			userPhL.setForeground(Color.WHITE);
			userPhL.setHorizontalAlignment(SwingConstants.LEFT);
			userPhL.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
			userPhL.setBounds(370, 106, 277, 32);
			lineP.add(userPhL);
			
			Button modifyBtn = new Button("회원 정보 수정하기");
			modifyBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
			modifyBtn.setBackground(Color.WHITE);
			modifyBtn.setBounds(293, 427, 151, 32);
			lineP.add(modifyBtn);
			
			Button deleteBtn = new Button("회원 탈퇴하기");
			deleteBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
			deleteBtn.setBackground(Color.WHITE);
			deleteBtn.setBounds(456, 427, 151, 32);
			lineP.add(deleteBtn);
			
	
			JLabel mem_moneyL = new JLabel("-");
			mem_moneyL.setForeground(Color.WHITE);
			mem_moneyL.setHorizontalAlignment(SwingConstants.LEFT);
			mem_moneyL.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
			mem_moneyL.setBounds(273, 233, 374, 32);
			if(user.getMem_money()!=0) 
				mem_moneyL.setText("금액권 이용  :  "+Integer.toString(user.getMem_money())+"원");
			lineP.add(mem_moneyL);
			
			JLabel mem_weekL = new JLabel("");
			mem_weekL.setForeground(Color.WHITE);
			mem_weekL.setHorizontalAlignment(SwingConstants.LEFT);
			mem_weekL.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
			mem_weekL.setBounds(273, 294, 374, 32);
			if(user.getMem_week()!=0)
				mem_weekL.setText("2주권 이용  :  "+Integer.toString(user.getMem_week())+"일");
			lineP.add(mem_weekL);
			
			JLabel mem_timeL = new JLabel("");
			mem_timeL.setForeground(Color.WHITE);
			mem_timeL.setHorizontalAlignment(SwingConstants.LEFT);
			mem_timeL.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
			mem_timeL.setBounds(273, 358, 374, 32);
			if(user.getMem_time()!=null) 
				mem_timeL.setText("시간권 이용  :  "+user.getMem_time()+"시간");
			lineP.add(mem_timeL);
			
			
			JLabel seat_num= new JLabel();
			seat_num.setForeground(Color.WHITE);
			seat_num.setHorizontalAlignment(SwingConstants.LEFT);
			seat_num.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
			seat_num.setBounds(273, 170, 374, 32);
			if(user.getSeat()!=null)
				seat_num.setText(user.getSeat()+"번 자리 이용 중");
			lineP.add(seat_num);
			
			deleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String pw=JOptionPane.showInputDialog("비밀번호를 입력하세요.");
	
					try {
						if(pw.equals(user.getPass())) {
							int result = JOptionPane.showConfirmDialog(null, "정말 탈퇴하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
							if(result == JOptionPane.YES_OPTION) {
								String str="정말 정말 탈퇴하시겠습니까?";
								if(user.membershipUser()==true) {
									if(user.getMem_time()!=null) 
										str="잔여 시간 : "+user.getMem_time()+", 정말 탈퇴하시겠습니까?(탈퇴하시면 모든 정보가 사라집니다.)";
									else if(user.getMem_money()!=0)
										str="잔여 금액 : "+user.getMem_money()+", 정말 탈퇴하시겠습니까?(탈퇴하시면 모든 정보가 사라집니다.)";
									else if(user.getMem_week()!=0)
										str="잔여 날짜 : "+user.getMem_week()+", 정말 탈퇴하시겠습니까?(탈퇴하시면 모든 정보가 사라집니다.)";
								}
								int rs= JOptionPane.showConfirmDialog(null, str, "Confirm", JOptionPane.YES_NO_OPTION);
								if(rs==JOptionPane.YES_OPTION) {
									main.MainScreen.db.delete();
									main.MainScreen ms=new main.MainScreen();
									ms.setVisible(true);
									dispose();
									member.login.GUI_login mlgl=new member.login.GUI_login();
									mlgl.logOut();
								}
							}
						}
							
						else
							JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.", "Message", JOptionPane.ERROR_MESSAGE); 
					}catch(Exception ec) {
					}
				}
			});
			
			modifyBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String pw=JOptionPane.showInputDialog("비밀번호를 입력하세요.");
	
					GUI_modify mg=new GUI_modify();
					try {
						if(pw.equals(user.getPass()))
							mg.setVisible(true);
						else
							JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.", "Message", JOptionPane.ERROR_MESSAGE); 
					}catch(Exception ec) {
					}
					
				}
			});
		}else {
			JLabel guideL = new JLabel("새로고침을 해주세요");
			guideL.setForeground(Color.WHITE);
			guideL.setFont(new Font("한컴 고딕", Font.PLAIN, 16));
			guideL.setHorizontalAlignment(SwingConstants.CENTER);
			guideL.setBounds(180, 127, 533, 220);
			lineP.add(guideL);
			
			
		}
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				select.UseSelect select_useSelect=new select.UseSelect();
				select_useSelect.setVisible(true);
			}
		});
		Button reload = new Button("새로고침");
		reload.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		reload.setBackground(Color.WHITE);
		reload.setBounds(620, 427, 151, 32);
		lineP.add(reload);
		reload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserInfo ui=new UserInfo();
				ui.setVisible(true);
			}
		});
		
	}
	public String getName() {
		String name=user.getName();
		return name;
	}
	public String getPh() {
		String ph;
		String str="";
		if(user.getPh_number()==null) {
			ph="";
		}else {
			ph=user.getPh_number();
		}
		if(ph.length()==11) {
			String str1=ph.substring(0, 3);
			String str2=ph.substring(3, 7);
			String str3=ph.substring(7);
			str3=str3.replaceAll(str3, "****");
			str=str1+"-"+str2+"-"+str3;
		}
		return str;
	}
	public void call() {
		getName();
		getPh();
	}
}
