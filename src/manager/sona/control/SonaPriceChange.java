package manager.sona.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import price.SeatPrice;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SonaPriceChange extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	SeatPrice sp=new SeatPrice();
	String fn="";
	JButton backBtn,search;
	JComboBox menu;
	JLabel label;
	
	JPanel generalP,timeP,commP,weekP,studyrommP;
	
	private JButton time2B;
	private JButton time8B;
	private JButton time5B;
	private JButton time10B;
	private JTextField updateF;
	private JButton updateBtn;
	
	public SonaPriceChange() {
		
		try {
			initialize();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void initialize() throws SQLException {
		this.getContentPane().setBackground(new Color(48, 56, 65));
		setTitle("SONA 관리자 - sona 가격 변경");
		setSize(1000, 600);
		setLocation(300, 80);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		backBtn = new JButton("Back");
		backBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		backBtn.setBackground(Color.WHITE);
		backBtn.setBounds(24, 519, 151, 32);
		getContentPane().add(backBtn);
		
		String m[]= {"이용권","시간권","금액권","2주권","스터디룸"};
		menu = new JComboBox(m);
		menu.setBackground(Color.WHITE);
		menu.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		menu.setBounds(303, 40, 436, 54);
		getContentPane().add(menu);
		
		search = new JButton("검색");
		search.setBackground(Color.WHITE);
		search.setBounds(769, 40, 91, 54);
		getContentPane().add(search);
		
		generalP = new JPanel();
		generalP.setBounds(271, 113, 651, 309);
		getContentPane().add(generalP);
		generalP.setBackground(new Color(255, 0, 0, 0));
		generalP.setLayout(null);
		
		
		String str;
				
				
		time2B = new JButton();
		time2B.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		time2B.setBackground(Color.WHITE);
		str="<html>2시간<br>"+sp.getSeatPrice("time2")+"\\</html>";
		time2B.setText(str);
		time2B.setBounds(33, 36, 247, 92);
		generalP.add(time2B);
		
		time8B = new JButton();
		str="<html>8시간<br>"+sp.getSeatPrice("time8")+"\\</html>";
		time8B.setText(str);
		time8B.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		time8B.setBackground(Color.WHITE);
		time8B.setBounds(33, 172, 247, 92);
		generalP.add(time8B);
		
		time5B = new JButton();
		str="<html>5시간<br>"+sp.getSeatPrice("time5")+"\\</html>";
		time5B.setText(str);
		time5B.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		time5B.setBackground(Color.WHITE);
		time5B.setBounds(347, 36, 247, 92);
		generalP.add(time5B);
		
		time10B = new JButton();
		str="<html>10시간<br>"+sp.getSeatPrice("time10")+"\\</html>";
		time10B.setText(str);
		time10B.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		time10B.setBackground(Color.WHITE);
		time10B.setBounds(347, 172, 247, 92);
		generalP.add(time10B);
		
		label = new JLabel();
		label.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
		label.setBounds(303, 479, 130, 54);
		getContentPane().add(label);
		
		updateF = new JTextField();
		updateF.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		updateF.setBounds(445, 479, 316, 54);
		getContentPane().add(updateF);
		updateF.setColumns(10);
		
		updateBtn = new JButton("수정");
		updateBtn.setBackground(Color.LIGHT_GRAY);
		updateBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		updateBtn.setBounds(769, 475, 91, 58);
		getContentPane().add(updateBtn);

		
		backBtn.addActionListener(this);
		search.addActionListener(this);
		updateBtn.addActionListener(this);
		
		time2B.addActionListener(this);
		time5B.addActionListener(this);
		time8B.addActionListener(this);
		time10B.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==backBtn) {
			dispose();
			SonaControler sc = new SonaControler();
			sc.setVisible(true);
					
		}
		 if(e.getSource()==search) {
			 if(menu.getSelectedItem().toString().equals("이용권")) {
				 generalP.setVisible(true);	timeP.setVisible(false);	commP.setVisible(false);
				 weekP.setVisible(false);	studyrommP.setVisible(false);
				 
			 }
			 else if(menu.getSelectedItem().toString().equals("시간권")) {
				 generalP.setVisible(false);	timeP.setVisible(true);	
				 commP.setVisible(false);	weekP.setVisible(false);	studyrommP.setVisible(false);
			 }	
			 else if(menu.getSelectedItem().toString().equals("금액권")) {
				 generalP.setVisible(false);	timeP.setVisible(false);	
				 commP.setVisible(true);	weekP.setVisible(false);	studyrommP.setVisible(false);
			 }	
			 else if(menu.getSelectedItem().toString().equals("2주권")) {
				 generalP.setVisible(false);	timeP.setVisible(false);	
				 commP.setVisible(false);	weekP.setVisible(true);	studyrommP.setVisible(false);
			 }	
			 else if(menu.getSelectedItem().toString().equals("스터디룸")) {
				 generalP.setVisible(false);	timeP.setVisible(true);	
				 commP.setVisible(false);	weekP.setVisible(false);	studyrommP.setVisible(true);
			 }	
		}
		 
		 
		 
		 if(e.getSource()==time2B) {
			 label.setText("2시간"); fn="time2";
			 try {updateF.setText(sp.getSeatPrice("time2"));} catch (SQLException e1) {}
		 }
		 if(e.getSource()==time5B) {
			 label.setText("5시간"); fn="time5";
			 try {updateF.setText(sp.getSeatPrice("time5"));} catch (SQLException e1) {}
		 }
		 if(e.getSource()==time8B) {
			 label.setText("8시간"); fn="time8";
			 try {updateF.setText(sp.getSeatPrice("time8"));} catch (SQLException e1) {}
		 }
		 if(e.getSource()==time10B) {
			 label.setText("10시간"); fn="time10";
			 try {updateF.setText(sp.getSeatPrice("time10"));} catch (SQLException e1) {}
		 }
		 
		 if(e.getSource()==updateBtn) {
			 try {
				sp.setSeatPrice(fn, Integer.parseInt(updateF.getText()));
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
		 }
	}
}
