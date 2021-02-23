package manager.user.control;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import db.Manager_DB;


public class UserManage extends JFrame implements ActionListener{
	
	public static boolean condition[]= {false, false,false,false};
	private static final long serialVersionUID = 1L;
	
	 String[] list = { "이름", "전화번호" , "이용중인 자리", "금액권", "2주권","시간권"};
	 DefaultTableModel dt = new DefaultTableModel(list, 0) {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int i, int c){ 
			return false; 
		} 
	};
	 JTable jt = new JTable(dt);
	 JScrollPane jsp = new JScrollPane(jt);

	 String[] comboName = { "  ALL  ", " 이름 ", " 전화번호 " };
	 
	 JComboBox combo = new JComboBox(comboName);
	 JTextField jtf = new JTextField(20);
	 JButton search = new JButton("검색");
	 Button backBtn;

	 Manager_DB db =new Manager_DB();
	 JCheckBox mem_comCh = new JCheckBox("금액권 사용자");
	 JCheckBox mem_timeCh = new JCheckBox("시간권 사용자");
	 JCheckBox mem_weekCh = new JCheckBox("2주권 사용자");
	 JCheckBox useSeatCh = new JCheckBox("현재 이용 중인 사용자");
	 
	public UserManage(){
		initialize();
	}
	
	private void initialize() {
		JPanel p = new JPanel();
		p.setBackground(new Color(48, 56, 65));
		p.setBounds(207, 26, 749, 525);
		getContentPane().add(p);
		
		
		combo.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		getContentPane().setBackground(Color.WHITE);
	    combo.setBounds(189, 6, 80, 29);
	    combo.setBackground(Color.WHITE);
	    search.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
	    search.setBounds(505, 5, 80, 30);
	    search.setBackground(Color.WHITE);
	    getContentPane().add(p, "South");
	    p.setLayout(null);
	    p.add(combo);
	    jtf.setBounds(274, 6, 226, 29);
	    p.add(jtf);
	    p.add(search);
	    jsp.setBounds(0, 77, 749, 448);
	    p.add(jsp);
	    
	    
	    mem_comCh.setBackground(new Color(48, 56, 65));
	    mem_comCh.setForeground(Color.WHITE);
	    mem_comCh.setBounds(119, 48, 107, 23);
	    p.add(mem_comCh);
	    mem_comCh.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
	    
	    db.userSelectAll(dt);
		this.getContentPane().setBackground(new Color(48, 56, 65));
		setTitle("SONA 관리자 - 회원관리");
		setSize(1000, 600);
		setLocation(300, 80);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		backBtn = new Button("Back");
		backBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		backBtn.setBackground(Color.WHITE);
		backBtn.setBounds(24, 519, 151, 32);
		getContentPane().add(backBtn);
		
		jt.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		mem_timeCh.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		mem_timeCh.setBackground(new Color(48, 56, 65));
	    mem_timeCh.setForeground(Color.WHITE);
		mem_timeCh.setBounds(253, 48, 107, 23);
		
		p.add(mem_timeCh);
		mem_weekCh.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		mem_weekCh.setBackground(new Color(48, 56, 65));
	    mem_weekCh.setForeground(Color.WHITE);
		mem_weekCh.setBounds(393, 48, 107, 23);
		
		p.add(mem_weekCh);
		useSeatCh.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
		useSeatCh.setBackground(new Color(48, 56, 65));
		useSeatCh.setForeground(Color.WHITE);
		useSeatCh.setBounds(522, 48, 135, 23);
		
		p.add(useSeatCh);
		
		search.addActionListener(this);
		backBtn.addActionListener(this);
		
	}
	  public void actionPerformed(ActionEvent e) {
		  	
		  	if(e.getSource()==backBtn) {
		  		dispose();
				main.ManagerScreen ms = new main.ManagerScreen();
				ms.setVisible(true);
		  	}
		  	
		    if (e.getSource() == search) {// 검색 버튼 클릭
		    	
		    	 if(mem_comCh.isSelected()==true)
		    		 condition[0]=true;
		    	 
		    	 if(mem_timeCh.isSelected()==true) 
		    		 condition[1]=true;
		    	 
		    	 if(mem_weekCh.isSelected()==true) 
		    		 condition[2]=true;
		    	 
		    	 if(useSeatCh.isSelected()==true) 
		    		 condition[3]=true;
		    	 
		          String fieldName = combo.getSelectedItem().toString();
		          if(fieldName.equals(" 이름 ")) {
		        	  fieldName="name";
		          }else if(fieldName.equals(" 전화번호 ")) {
		        	  fieldName="ph_number";
		          }
		          
		          if (fieldName.trim().equals("ALL")) {// 전체검색
		        	  db.userSelectAll(dt);
		          } 
		          else if (jtf.getText().trim().equals("")) {
		        	  db.userSelectAll(dt);
	        		  db.getUserSearch(dt, fieldName, jtf.getText(),condition);
	                  if (dt.getRowCount() > 0)
	                      jt.setRowSelectionInterval(0, 0);
		        	  
		          }
		    }
		}
}