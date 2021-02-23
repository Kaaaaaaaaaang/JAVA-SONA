package main;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import member.login.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {

   private static final long serialVersionUID = 1L;
   public static db.DB_connect db= new db.DB_connect();

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MainScreen frame = new MainScreen();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }
   public static JLabel userHi = new JLabel();
   public static JButton join = new JButton("ȸ������");
   public static JButton login = new JButton("�α���");
   public static JButton logOut = new JButton("�α׾ƿ�");
   
   public MainScreen(){
      initialize();
   }
   
   private void initialize() {
	   

	  Font font = login.getFont();
      
      GUI_login memberLogin_guilogin=new GUI_login();
      GUI_join memberLogin_guijoin=new GUI_join();
      reserve.ReserveSeat reserveS = new reserve.ReserveSeat();
      select.UseSelect selectGUI = new select.UseSelect();
      member.info.User user = new member.info.User();
      
      JLabel intro_background = new JLabel("New label");
      intro_background.setIcon(new ImageIcon("img/mainScreen.png"));
      intro_background.setBounds(0, 0, 1000, 600);
      getContentPane().add(intro_background);
         
      setTitle("SONA Study Cafe");
      setSize(1000, 600);
      setLocation(300, 80);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setLayout(null);
      setLocationRelativeTo(null);
      Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
      attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
      
      JButton reserve = new JButton("�¼� �����ϱ�");
      intro_background.add(reserve);
      reserve.setBorderPainted(false);
      reserve.setForeground(Color.WHITE);
      reserve.setContentAreaFilled(false);
      reserve.setFont(font.deriveFont(attributes));
      reserve.setFont(new Font("���� ���", Font.PLAIN, 18));
      reserve.setSize(200, 56);
      reserve.setLocation(66, 451);
      
      JButton sona = new JButton("SONA �̿��ϱ�");
      intro_background.add(sona);
     
      sona.setSize(200, 56);
      sona.setLocation(66, 371);
      sona.setBorderPainted(false);
      sona.setContentAreaFilled(false);
      sona.setForeground(Color.WHITE);
      sona.setFont(font.deriveFont(attributes));
      sona.setFont(new Font("���� ���", Font.PLAIN, 18));
      intro_background.add(userHi);
      userHi.setForeground(Color.WHITE);
      
      userHi.setHorizontalAlignment(SwingConstants.CENTER);
      userHi.setFont(new Font("����", Font.PLAIN, 18));
      userHi.setBounds(256, 383, 494, 115);
      
      
      intro_background.add(login);
      login.setForeground(Color.WHITE);
      
      login.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            memberLogin_guilogin.setVisible(true);
         }
      });
      login.setBorderPainted(false);
      login.setContentAreaFilled(false);
      login.setFont(new Font("���� ���", Font.BOLD, 15));
      login.setBounds(818, 367, 91, 23);
      
     
      login.setFont(font.deriveFont(attributes));
      intro_background.add(join);
      join.setForeground(Color.WHITE);
      
      join.setBorderPainted(false);
      join.setContentAreaFilled(false);
      join.setFont(new Font("���� ���", Font.BOLD, 15));
      join.setBounds(801, 425, 124, 23);
      join.setFont(font.deriveFont(attributes));
      intro_background.add(logOut);
      logOut.setForeground(Color.WHITE);
      
      logOut.setBorderPainted(false);
      logOut.setContentAreaFilled(false);
      logOut.setFont(new Font("���� ���", Font.BOLD, 15));
      logOut.setBounds(801, 425, 124, 23);
      logOut.setFont(font.deriveFont(attributes));
      
      JButton manager = new JButton("������ �α���");
      intro_background.add(manager);
      manager.setForeground(Color.WHITE);
      manager.setFont(new Font("���� ���", Font.BOLD, 15));
      manager.setContentAreaFilled(false);
      manager.setBorderPainted(false);
      manager.setBounds(771, 480, 193, 23);
      
      manager.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            manager.login.Login managerL= new manager.login.Login();
            managerL.setVisible(true);
         }
      });
      logOut.setVisible(false);
      
      
      logOut.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(null, "���� �α׾ƿ� �Ͻðڽ��ϱ�?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION) {
               String str="�α׾ƿ� �Ǿ����ϴ�. �̿��� �ּż� �����մϴ�  " + user.getName().toString() + " ȸ����";
               JOptionPane.showMessageDialog(null, str, "Message", JOptionPane.ERROR_MESSAGE);
               memberLogin_guilogin.logOut();
            }
         }
      });
      
      join.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            memberLogin_guijoin.setVisible(true);
         }
      });
      userHi.setVisible(false);
      
      sona.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(Login.UserPh_number==null) {
               JOptionPane.showMessageDialog(null, "�α��� �� �̿��� �ּ���.");
            }else{
               dispose();
               selectGUI.setVisible(true);
            }
         }
      });
      reserve.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(Login.UserPh_number==null) {
               JOptionPane.showMessageDialog(null, "�α��� �� �̿��� �ּ���.");
            }else{
               dispose();
               reserveS.setVisible(true);
            }
         }
      });
   }
}