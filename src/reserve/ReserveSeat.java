package reserve;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.MainScreen;
import javax.swing.SwingConstants;

public class ReserveSeat extends JFrame {

   private static final long serialVersionUID = 1L;
   
   public static String choice;
   public static String seatNum="";
   public static String starttime = "";
   public static String finishtime = "";
   /**
    * Create the frame.
    */
   public ReserveSeat() {
      initialize();
   }
   
   public static void setSeatNum(String seatNum) {
      ReserveSeat.seatNum = seatNum;
   }
   
   public String getSeatNum() {
      return seatNum;
   }
   private void initialize() {
      

      JLabel intro_background = new JLabel("New label");
       intro_background.setIcon(new ImageIcon("img/back_1.png"));
       intro_background.setBounds(0, 0, 1000, 575);
       getContentPane().add(intro_background);
       
      //this.getContentPane().setBackground(new Color(190, 210, 230));
      setTitle("SONA Study Cafe");
      setSize(1030, 600);
      setLocation(300, 80);
      setResizable(false);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setLayout(null);
      
      JLabel message = new JLabel("�̿��� �ڸ��� �����ϼ���.");
      message.setForeground(Color.WHITE);
      intro_background.add(message);
      message.setHorizontalAlignment(SwingConstants.CENTER);
      message.setFont(new Font("���� ���", Font.BOLD, 19));
      message.setBounds(141, 413, 440, 73);
      
      String time[] = {"���� 9�� ~ ���� 11��", "���� 11�� ~ ���� 1��", "���� 1�� ~ ���� 3��", "���� 3�� ~ ���� 5��", "���� 5�� ~ ���� 7��", "���� 7�� ~ ���� 9��", "���� 9�� ~ ���� 11��"};
      JComboBox<String> selecttime = new JComboBox<String>(time);
      intro_background.add(selecttime);
      selecttime.setBounds(290, 320, 130, 30);
      
      
      
      
      JButton chooseTimeBtn = new JButton("�ð�����");
      chooseTimeBtn.setFont(new Font("���� ���", Font.PLAIN, 13));
      chooseTimeBtn.setBackground(Color.WHITE);
      chooseTimeBtn.setBounds(435, 320, 90, 30);
      intro_background.add(chooseTimeBtn);
      
      JLabel lblNewLabel = new JLabel("\uC608\uC57D\uC11D");
      lblNewLabel.setForeground(Color.WHITE);
      intro_background.add(lblNewLabel);
      lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 20));
      lblNewLabel.setBounds(465, 72, 98, 42);
      
      JButton pay = new JButton("�����ϱ�");
      intro_background.add(pay);
      pay.setBackground(Color.WHITE);
      pay.setFont(new Font("���� ���", Font.BOLD, 16));
      pay.setBounds(646, 360, 170, 50);
      
      JButton backBtn = new JButton("�ڷΰ���");
      intro_background.add(backBtn);
      backBtn.setFont(new Font("���� ���", Font.BOLD, 16));
      backBtn.setBackground(Color.WHITE);
      backBtn.setBounds(646, 435, 170, 50);
      
      ReserveButton seat1 = new ReserveButton("1");
      intro_background.add(seat1);
      seat1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("1�� �ڸ��� �����ϼ̽��ϴ�.");
            setSeatNum("1��");
         }
      });
      seat1.setBounds(266, 205, 80, 70);
      
      ReserveButton seat2 = new ReserveButton("2");
      intro_background.add(seat2);
      seat2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("2�� �ڸ��� �����ϼ̽��ϴ�.");
            setSeatNum("2��");
         }
      });
      seat2.setBounds(366, 205, 80, 70);
      
      ReserveButton seat3 = new ReserveButton("3");
      intro_background.add(seat3);
      seat3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("3�� �ڸ��� �����ϼ̽��ϴ�.");
            setSeatNum("3��");
         }
      });
      seat3.setBounds(466, 205, 80, 70);
      
      ReserveButton seat4 = new ReserveButton("4");
      intro_background.add(seat4);
      seat4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("4�� �ڸ��� �����ϼ̽��ϴ�.");
            setSeatNum("4��");
         }
      });
      seat4.setBounds(566, 205, 80, 70);
      
      ReserveButton seat5 = new ReserveButton("5");
      intro_background.add(seat5);
      seat5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("5�� �ڸ��� �����ϼ̽��ϴ�.");
            setSeatNum("5��");
         }
      });
      seat5.setBounds(666, 205, 80, 70);
      
      backBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            main.MainScreen mainscreen = new MainScreen();
            mainscreen.setVisible(true);
            member.login.GUI_login mGL = new member.login.GUI_login();
            try {
               mGL.loginComplete();
            } catch (ClassNotFoundException | SQLException e1) {
               e1.printStackTrace();
            }
            dispose();
         }
      });
      
      chooseTimeBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 choice = selecttime.getSelectedItem().toString();
            if(choice.equals("���� 9�� ~ ���� 11��")) {
               starttime = "09:00:00";
               finishtime = "11:00:00";
            }else if(choice.equals("���� 11�� ~ ���� 1��")) {
               starttime = "11:00:00";
               finishtime = "13:00:00";
            }else if(choice.equals("���� 1�� ~ ���� 3��")){
               starttime = "13:00:00";
               finishtime = "15:00:00";
            }else if(choice.equals("���� 3�� ~ ���� 5��")){
               starttime = "15:00:00";
               finishtime = "17:00:00";
            }else if(choice.equals("���� 5�� ~ ���� 7��")){
               starttime = "17:00:00";
               finishtime = "19:00:00";
            }else if(choice.equals("���� 7�� ~ ���� 9��")){
               starttime = "19:00:00";
               finishtime = " 21:00:00";
            }else if(choice.equals("���� 9�� ~ ���� 11��")){
               starttime = "21:00:00";
               finishtime = "23:00:00";
            }
         }
      });
      pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              String s=seatNum.replaceAll("[^0-9]","");
              boolean ch=false;
              try {
               ch=main.MainScreen.db.reserve_search(Integer.parseInt(s),starttime);
            } catch (NumberFormatException | SQLException e1) {}
              if(ch==false) {
                   Pay p = new Pay();
                   p.setVisible(true);
              }else {
                 JOptionPane.showMessageDialog(null, "������ �Ϸ�� �¼��Դϴ�.", "Message", JOptionPane.ERROR_MESSAGE); 
              }
            }
         });
   }
}