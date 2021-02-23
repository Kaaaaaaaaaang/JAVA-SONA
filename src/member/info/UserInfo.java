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
		
		JLabel titleL = new JLabel("ȸ�� ����");
		titleL.setBackground(new Color(48, 56, 65));
		titleL.setHorizontalAlignment(SwingConstants.CENTER);
		titleL.setFont(new Font("���� ���", Font.PLAIN, 21));
		titleL.setBounds(410, 36, 183, 18);
		titleP.add(titleL);
		
		JPanel lineP = new JPanel();
		lineP.setForeground(Color.BLACK);
		lineP.setBackground(new Color(0,0,0,0));
		lineP.setBounds(50, 46, 893, 480);
		intro_background.add(lineP);
		lineP.setLayout(null);
		
		Button backBtn = new Button("�ٸ� ���� �̿��ϱ�");
		backBtn.setFont(new Font("���� ���", Font.PLAIN, 12));
		backBtn.setBackground(Color.WHITE);
		backBtn.setBounds(130, 427, 151, 32);
		lineP.add(backBtn);
		
		
		
		if(user.getName()!=null) {
		
			JLabel nameL = new JLabel("�̸�");
			nameL.setBounds(273, 46, 83, 32);
			lineP.add(nameL);
		    nameL.setForeground(Color.WHITE);
			nameL.setFont(new Font("���� ���", Font.PLAIN, 18));
			nameL.setHorizontalAlignment(SwingConstants.LEFT);
			
			JLabel phL = new JLabel("��ȭ��ȣ");
			phL.setHorizontalAlignment(SwingConstants.LEFT);
			phL.setForeground(Color.WHITE);
			phL.setFont(new Font("���� ���", Font.PLAIN, 18));
			phL.setBounds(273, 106, 83, 32);
			lineP.add(phL);
			
			
			JLabel userNameL = new JLabel();
			userNameL.setHorizontalAlignment(SwingConstants.LEFT);
			userNameL.setForeground(Color.WHITE);
			userNameL.setFont(new Font("���� ���", Font.PLAIN, 18));
			userNameL.setBounds(370, 46, 277, 32);
			userNameL.setText(getName());
			lineP.add(userNameL);
			
			
			
			JLabel userPhL = new JLabel();
			userPhL.setText(getPh());
			userPhL.setForeground(Color.WHITE);
			userPhL.setHorizontalAlignment(SwingConstants.LEFT);
			userPhL.setFont(new Font("���� ���", Font.PLAIN, 18));
			userPhL.setBounds(370, 106, 277, 32);
			lineP.add(userPhL);
			
			Button modifyBtn = new Button("ȸ�� ���� �����ϱ�");
			modifyBtn.setFont(new Font("���� ���", Font.PLAIN, 12));
			modifyBtn.setBackground(Color.WHITE);
			modifyBtn.setBounds(293, 427, 151, 32);
			lineP.add(modifyBtn);
			
			Button deleteBtn = new Button("ȸ�� Ż���ϱ�");
			deleteBtn.setFont(new Font("���� ���", Font.PLAIN, 12));
			deleteBtn.setBackground(Color.WHITE);
			deleteBtn.setBounds(456, 427, 151, 32);
			lineP.add(deleteBtn);
			
	
			JLabel mem_moneyL = new JLabel("-");
			mem_moneyL.setForeground(Color.WHITE);
			mem_moneyL.setHorizontalAlignment(SwingConstants.LEFT);
			mem_moneyL.setFont(new Font("���� ���", Font.PLAIN, 18));
			mem_moneyL.setBounds(273, 233, 374, 32);
			if(user.getMem_money()!=0) 
				mem_moneyL.setText("�ݾױ� �̿�  :  "+Integer.toString(user.getMem_money())+"��");
			lineP.add(mem_moneyL);
			
			JLabel mem_weekL = new JLabel("");
			mem_weekL.setForeground(Color.WHITE);
			mem_weekL.setHorizontalAlignment(SwingConstants.LEFT);
			mem_weekL.setFont(new Font("���� ���", Font.PLAIN, 18));
			mem_weekL.setBounds(273, 294, 374, 32);
			if(user.getMem_week()!=0)
				mem_weekL.setText("2�ֱ� �̿�  :  "+Integer.toString(user.getMem_week())+"��");
			lineP.add(mem_weekL);
			
			JLabel mem_timeL = new JLabel("");
			mem_timeL.setForeground(Color.WHITE);
			mem_timeL.setHorizontalAlignment(SwingConstants.LEFT);
			mem_timeL.setFont(new Font("���� ���", Font.PLAIN, 18));
			mem_timeL.setBounds(273, 358, 374, 32);
			if(user.getMem_time()!=null) 
				mem_timeL.setText("�ð��� �̿�  :  "+user.getMem_time()+"�ð�");
			lineP.add(mem_timeL);
			
			
			JLabel seat_num= new JLabel();
			seat_num.setForeground(Color.WHITE);
			seat_num.setHorizontalAlignment(SwingConstants.LEFT);
			seat_num.setFont(new Font("���� ���", Font.PLAIN, 18));
			seat_num.setBounds(273, 170, 374, 32);
			if(user.getSeat()!=null)
				seat_num.setText(user.getSeat()+"�� �ڸ� �̿� ��");
			lineP.add(seat_num);
			
			deleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String pw=JOptionPane.showInputDialog("��й�ȣ�� �Է��ϼ���.");
	
					try {
						if(pw.equals(user.getPass())) {
							int result = JOptionPane.showConfirmDialog(null, "���� Ż���Ͻðڽ��ϱ�?", "Confirm", JOptionPane.YES_NO_OPTION);
							if(result == JOptionPane.YES_OPTION) {
								String str="���� ���� Ż���Ͻðڽ��ϱ�?";
								if(user.membershipUser()==true) {
									if(user.getMem_time()!=null) 
										str="�ܿ� �ð� : "+user.getMem_time()+", ���� Ż���Ͻðڽ��ϱ�?(Ż���Ͻø� ��� ������ ������ϴ�.)";
									else if(user.getMem_money()!=0)
										str="�ܿ� �ݾ� : "+user.getMem_money()+", ���� Ż���Ͻðڽ��ϱ�?(Ż���Ͻø� ��� ������ ������ϴ�.)";
									else if(user.getMem_week()!=0)
										str="�ܿ� ��¥ : "+user.getMem_week()+", ���� Ż���Ͻðڽ��ϱ�?(Ż���Ͻø� ��� ������ ������ϴ�.)";
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
							JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�.", "Message", JOptionPane.ERROR_MESSAGE); 
					}catch(Exception ec) {
					}
				}
			});
			
			modifyBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String pw=JOptionPane.showInputDialog("��й�ȣ�� �Է��ϼ���.");
	
					GUI_modify mg=new GUI_modify();
					try {
						if(pw.equals(user.getPass()))
							mg.setVisible(true);
						else
							JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�.", "Message", JOptionPane.ERROR_MESSAGE); 
					}catch(Exception ec) {
					}
					
				}
			});
		}else {
			JLabel guideL = new JLabel("���ΰ�ħ�� ���ּ���");
			guideL.setForeground(Color.WHITE);
			guideL.setFont(new Font("���� ���", Font.PLAIN, 16));
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
		Button reload = new Button("���ΰ�ħ");
		reload.setFont(new Font("���� ���", Font.PLAIN, 12));
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
