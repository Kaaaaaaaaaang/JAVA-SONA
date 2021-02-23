package manager.sona.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class SonaControler extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JButton backBtn, setPriceBtn;
	
	public SonaControler(){
		initialize();
	}
	
	private void initialize() {
		this.getContentPane().setBackground(new Color(48, 56, 65));
		setTitle("SONA 관리자 - sona 관리");
		setSize(1000, 600);
		setLocation(300, 80);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		backBtn = new JButton("Back");
		backBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		backBtn.setBackground(Color.WHITE);
		backBtn.setBounds(437, 503, 151, 32);
		getContentPane().add(backBtn);
		
		setPriceBtn = new JButton("가격 변경");
		setPriceBtn.setBackground(Color.WHITE);
		setPriceBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 15));
		setPriceBtn.setBounds(381, 238, 259, 77);
		getContentPane().add(setPriceBtn);
		
		backBtn.addActionListener(this);
		setPriceBtn.addActionListener(this);
	}
	 public void actionPerformed(ActionEvent e) {
		 
		 if(e.getSource()==backBtn) {
			 
			dispose();
			main.ManagerScreen ms = new main.ManagerScreen();
			ms.setVisible(true);
				
		 }
		 if(e.getSource()==setPriceBtn) {
			 dispose();
			 SonaPriceChange spc=new SonaPriceChange();
			 spc.setVisible(true);
		 }
	 }

}
