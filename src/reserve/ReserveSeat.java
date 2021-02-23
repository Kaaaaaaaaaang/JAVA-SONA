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
      
      JLabel message = new JLabel("이용할 자리를 선택하세요.");
      message.setForeground(Color.WHITE);
      intro_background.add(message);
      message.setHorizontalAlignment(SwingConstants.CENTER);
      message.setFont(new Font("한컴 고딕", Font.BOLD, 19));
      message.setBounds(141, 413, 440, 73);
      
      String time[] = {"오전 9시 ~ 오전 11시", "오전 11시 ~ 오후 1시", "오후 1시 ~ 오후 3시", "오후 3시 ~ 오후 5시", "오후 5시 ~ 오후 7시", "오후 7시 ~ 오후 9시", "오후 9시 ~ 오후 11시"};
      JComboBox<String> selecttime = new JComboBox<String>(time);
      intro_background.add(selecttime);
      selecttime.setBounds(290, 320, 130, 30);
      
      
      
      
      JButton chooseTimeBtn = new JButton("시간선택");
      chooseTimeBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 13));
      chooseTimeBtn.setBackground(Color.WHITE);
      chooseTimeBtn.setBounds(435, 320, 90, 30);
      intro_background.add(chooseTimeBtn);
      
      JLabel lblNewLabel = new JLabel("\uC608\uC57D\uC11D");
      lblNewLabel.setForeground(Color.WHITE);
      intro_background.add(lblNewLabel);
      lblNewLabel.setFont(new Font("한컴 고딕", Font.BOLD, 20));
      lblNewLabel.setBounds(465, 72, 98, 42);
      
      JButton pay = new JButton("결제하기");
      intro_background.add(pay);
      pay.setBackground(Color.WHITE);
      pay.setFont(new Font("한컴 고딕", Font.BOLD, 16));
      pay.setBounds(646, 360, 170, 50);
      
      JButton backBtn = new JButton("뒤로가기");
      intro_background.add(backBtn);
      backBtn.setFont(new Font("한컴 고딕", Font.BOLD, 16));
      backBtn.setBackground(Color.WHITE);
      backBtn.setBounds(646, 435, 170, 50);
      
      ReserveButton seat1 = new ReserveButton("1");
      intro_background.add(seat1);
      seat1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("1번 자리를 선택하셨습니다.");
            setSeatNum("1번");
         }
      });
      seat1.setBounds(266, 205, 80, 70);
      
      ReserveButton seat2 = new ReserveButton("2");
      intro_background.add(seat2);
      seat2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("2번 자리를 선택하셨습니다.");
            setSeatNum("2번");
         }
      });
      seat2.setBounds(366, 205, 80, 70);
      
      ReserveButton seat3 = new ReserveButton("3");
      intro_background.add(seat3);
      seat3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("3번 자리를 선택하셨습니다.");
            setSeatNum("3번");
         }
      });
      seat3.setBounds(466, 205, 80, 70);
      
      ReserveButton seat4 = new ReserveButton("4");
      intro_background.add(seat4);
      seat4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("4번 자리를 선택하셨습니다.");
            setSeatNum("4번");
         }
      });
      seat4.setBounds(566, 205, 80, 70);
      
      ReserveButton seat5 = new ReserveButton("5");
      intro_background.add(seat5);
      seat5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("5번 자리를 선택하셨습니다.");
            setSeatNum("5번");
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
            if(choice.equals("오전 9시 ~ 오전 11시")) {
               starttime = "09:00:00";
               finishtime = "11:00:00";
            }else if(choice.equals("오전 11시 ~ 오후 1시")) {
               starttime = "11:00:00";
               finishtime = "13:00:00";
            }else if(choice.equals("오후 1시 ~ 오후 3시")){
               starttime = "13:00:00";
               finishtime = "15:00:00";
            }else if(choice.equals("오후 3시 ~ 오후 5시")){
               starttime = "15:00:00";
               finishtime = "17:00:00";
            }else if(choice.equals("오후 5시 ~ 오후 7시")){
               starttime = "17:00:00";
               finishtime = "19:00:00";
            }else if(choice.equals("오후 7시 ~ 오후 9시")){
               starttime = "19:00:00";
               finishtime = " 21:00:00";
            }else if(choice.equals("오후 9시 ~ 오후 11시")){
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
                 JOptionPane.showMessageDialog(null, "예약이 완료된 좌석입니다.", "Message", JOptionPane.ERROR_MESSAGE); 
              }
            }
         });
   }
}