package seat.use.etc;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import member.info.User;
import seat.UseSeat;

public class Receipt extends JFrame{
   private static final long serialVersionUID = 1L;
   public static String starttime;
   public static String finishtime;
   
   member.info.User user=new member.info.User();
   timer.SeatTimerThread tt = new timer.SeatTimerThread();
   Thread seat1 = new Thread(tt);
   Thread seat2 = new Thread(tt);
   Thread seat3 = new Thread(tt);
   Thread seat4 = new Thread(tt);
   Thread seat5 = new Thread(tt);
   Thread seat6 = new Thread(tt);
   Thread seat7 = new Thread(tt);
   Thread seat8 = new Thread(tt);
   Thread seat9 = new Thread(tt);
   Thread seat10 = new Thread(tt);
   Thread seat11 = new Thread(tt);
   Thread seat12 = new Thread(tt);
   Thread seat13 = new Thread(tt);
   Thread seat14 = new Thread(tt);
   Thread seat15 = new Thread(tt);
   Thread room1 = new Thread(tt);
   Thread room2 = new Thread(tt);

   public Receipt() throws NumberFormatException, ClassNotFoundException, SQLException {
      initialize();
   }
   
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   
   Date d = new Date();
   
   private void initialize() throws NumberFormatException, ClassNotFoundException, SQLException {

      int usetime = pay.MemberPay.gettime();
      
      
      main.MainScreen.db.adduse(usetime);
      
      starttime = sdf.format(d);
      
      main.MainScreen.db.enter(user.getStartTime());
      main.MainScreen.db.leave(usetime);
      
      User user = new User();
      
      //this.getContentPane().setBackground(new Color(190, 210, 230));

      JLabel intro_background = new JLabel("New label");
       intro_background.setIcon(new ImageIcon("img/back_1.png"));
       intro_background.setBounds(0, 0, 1000, 575);
       getContentPane().add(intro_background);
       
      setTitle("SONA Study Cafe");
      setSize(1000, 600);
      setLocation(300, 80);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setLayout(null);
      setLocationRelativeTo(null);
      /*
      JPanel lineP = new JPanel();
      //lineP.setBorder(new LineBorder(new Color(0, 0, 0)));
      lineP.setForeground(Color.WHITE);
      //lineP.setBackground(new Color(190,210,230));
      lineP.setBounds(50, 46, 893, 480);
      intro_background.add(lineP);
      lineP.setLayout(null);
      */
      //seat.UseSeat us = new seat.UseSeat();
      String str = UseSeat.seatNum;
      /*
      JPanel titleP = new JPanel();
      intro_background.add(titleP);
      //titleP.setBackground(new Color(190,210,230));
      titleP.setBounds(331, 3, 241, 38);
      */
      JLabel titleL = new JLabel("결제내역");
      titleL.setHorizontalAlignment(SwingConstants.CENTER);
      titleL.setFont(new Font("한컴 고딕", Font.PLAIN, 21));
      titleL.setForeground(Color.WHITE);
      titleL.setBounds(410, 100, 183, 18);
      //titleL.setBackground(new Color(190,210,230));
      intro_background.add(titleL);
      
      Button backBtn = new Button("다른 서비스 이용하기");
      intro_background.add(backBtn);
      backBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
      backBtn.setBackground(Color.WHITE);
      backBtn.setBounds(430, 461, 151, 32);
      
      JLabel userNameL = new JLabel();
      intro_background.add(userNameL);
      userNameL.setHorizontalAlignment(SwingConstants.CENTER);
      userNameL.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
      userNameL.setBounds(70, 150, 869, 46);
      userNameL.setForeground(Color.WHITE);
      userNameL.setText(user.getName()+" 회원님");
      
      JLabel howmuch = new JLabel();
      intro_background.add(howmuch);
      howmuch.setText(AddTimePay.price+"\\");
      howmuch.setHorizontalAlignment(SwingConstants.CENTER);
      howmuch.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
      howmuch.setForeground(Color.WHITE);
      howmuch.setBounds(70, 206, 869, 46);
      
      JLabel howtime = new JLabel();
      intro_background.add(howtime);
      howtime.setText(AddTimePay.time +"시간");
      howtime.setHorizontalAlignment(SwingConstants.CENTER);
      howtime.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
      howtime.setBounds(70, 268, 869, 46);
      howtime.setForeground(Color.WHITE);
      
      JLabel howtime_1 = new JLabel();
      intro_background.add(howtime_1);
      howtime_1.setText(str+"번 자리");
      howtime_1.setForeground(Color.WHITE);
      howtime_1.setHorizontalAlignment(SwingConstants.CENTER);
      howtime_1.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
      howtime_1.setBounds(70, 328, 869, 46);
      
      backBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
            select.UseSelect select_useSelect=new select.UseSelect();
            select_useSelect.setVisible(true);
         }
      });   
      
      main.MainScreen.db.SaveUserInfo();
      if(str.equals("2인석 스터디룸")) {
         main.MainScreen.db.seat(16);
         room1.start();
      }else if(str.equals("4인석 스터디룸")) {
         main.MainScreen.db.seat(17);
         room2.start();
      }else{
         String s = str.replaceAll("[^0-9]","");
         int n = Integer.parseInt(s);
         main.MainScreen.db.seat(n);
         if(n == 1) {
            seat1.start();
         }else if(n == 2) {
            seat2.start();
         }else if(n == 3) {
            seat3.start();
         }else if(n == 4) {
            seat4.start();
         }else if(n == 5) {
            seat5.start();
         }else if(n == 6) {
            seat6.start();
         }else if(n == 7) {
            seat7.start();
         }else if(n == 8) {
            seat8.start();
         }else if(n == 9) {
            seat9.start();
         }else if(n == 10) {
            seat10.start();
         }else if(n == 11) {
            seat11.start();
         }else if(n == 12) {
            seat12.start();
         }else if(n == 13) {
            seat13.start();
         }else if(n == 14) {
            seat14.start();
         }else if(n == 15) {
            seat15.start();
         }
      }
   }
}