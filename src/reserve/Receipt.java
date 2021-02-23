package reserve;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import main.ManagerScreen;
import member.info.User;
import seat.UseSeat;

public class Receipt extends JFrame{
   private static final long serialVersionUID = 1L;

   member.info.User user=new member.info.User();
   timer.ReserveSeatThread tt = new timer.ReserveSeatThread();
   Thread seat1 = new Thread(tt);
   Thread seat2 = new Thread(tt);
   Thread seat3 = new Thread(tt);
   Thread seat4 = new Thread(tt);
   Thread seat5 = new Thread(tt);

   public Receipt() throws NumberFormatException, ClassNotFoundException, SQLException {
      initialize();
   }
   
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   
   Date d = new Date();
   
   private void initialize() throws NumberFormatException, ClassNotFoundException, SQLException {

      String s = ReserveSeat.seatNum.replaceAll("[^0-9]","");
      int n = Integer.parseInt(s);
      main.MainScreen.db.reserve(n);

      main.MainScreen.db.reserve_start(ReserveSeat.starttime);
      //db.reserve_finish(usetime);
      main.MainScreen.db.reserve_finish(ReserveSeat.finishtime);
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
      
      JLabel titleL = new JLabel("결제내역");
      titleL.setHorizontalAlignment(SwingConstants.CENTER);
      titleL.setFont(new Font("한컴 고딕", Font.PLAIN, 21));
      titleL.setForeground(Color.WHITE);
      titleL.setBounds(410, 100, 183, 18);
      titleL.setBackground(new Color(190,210,230));
      intro_background.add(titleL);
      
      JLabel userNameL = new JLabel();
      userNameL.setHorizontalAlignment(SwingConstants.CENTER);
      userNameL.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
      userNameL.setBounds(70, 150, 869, 46);
      userNameL.setText(user.getName()+" 회원님");
      userNameL.setForeground(Color.WHITE);
      intro_background.add(userNameL);
      
      Button backBtn = new Button("다른 서비스 이용하기");
      backBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
      backBtn.setBackground(Color.WHITE);
      backBtn.setBounds(430, 416, 151, 32);
      intro_background.add(backBtn);
      
      JLabel howmuch = new JLabel();
      howmuch.setText(Pay.price+"\\");
      howmuch.setHorizontalAlignment(SwingConstants.CENTER);
      howmuch.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
      howmuch.setBounds(70, 206, 869, 46);
      howmuch.setForeground(Color.WHITE);
      intro_background.add(howmuch);
      
      JLabel howtime = new JLabel();
      howtime.setText(Pay.time +"시간");
      howtime.setHorizontalAlignment(SwingConstants.CENTER);
      howtime.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
      howtime.setBounds(70, 268, 869, 46);
      howtime.setForeground(Color.WHITE);
      intro_background.add(howtime);
      
      JLabel howtime_1 = new JLabel();
      //seat.UseSeat us = new seat.UseSeat();
      String str = ReserveSeat.seatNum;
      howtime_1.setText(str+"자리");
      howtime_1.setHorizontalAlignment(SwingConstants.CENTER);
      howtime_1.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
      howtime_1.setBounds(70, 328, 869, 46);
      howtime_1.setForeground(Color.WHITE);
      intro_background.add(howtime_1);
      
      main.MainScreen.db.SaveUserInfo();

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
      }
      
   backBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
            main.MainScreen ms=new main.MainScreen();
            ms.setVisible(true);
         }
      });   
   }
}