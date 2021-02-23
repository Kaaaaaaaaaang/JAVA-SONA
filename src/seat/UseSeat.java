package seat;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UseSeat extends JFrame implements ActionListener{
   JLabel message = new JLabel("이용할 자리를 선택하세요.");
   
   SeatButton seat1, seat2,seat3 ,seat4,seat5,seat6,seat7,seat8 ,seat9,seat10,seat11 ,seat12,seat13 ,seat14 ,seat15;
   SeatButton studyroom1, studyroom2;
   
   private static final long serialVersionUID = 1L;
   
   public static String seatNum="";
   static String use = "이용 가능";
   public UseSeat() {
      try {
         initialize();
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }
   public static void setSeatNum(String seatNum) {
      UseSeat.seatNum = seatNum;
   }
   
   public String getSeatNum() {
      return seatNum;
   }
   private synchronized void initialize() throws ClassNotFoundException, SQLException {
      
       //new Color(48, 56, 65)
      this.getContentPane().setBackground(new Color(48, 56, 65));
      setTitle("SONA Study Cafe");
      setSize(1030, 600);
      setLocation(300, 80);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setLayout(null);
      message.setForeground(Color.WHITE);
      
      
      message.setFont(new Font("한컴 고딕", Font.BOLD, 19));
      message.setBounds(249, 414, 285, 73);
      message.setForeground(Color.WHITE);
      getContentPane().add(message);
      setLocationRelativeTo(null);
   
      seat1=new SeatButton("1");seat2=new SeatButton("2");seat3=new SeatButton("3");
      seat4=new SeatButton("4");seat5=new SeatButton("5");seat6=new SeatButton("6");
      seat7=new SeatButton("7");seat8=new SeatButton("8");seat9=new SeatButton("9");
      seat10=new SeatButton("10");seat11=new SeatButton("11");seat12=new SeatButton("12");
      seat13=new SeatButton("13");seat14=new SeatButton("14");seat15=new SeatButton("15");
      

      seat1.setBounds(25, 35, 120, 80);
      getContentPane().add(seat1);
      
      
      seat2.setBounds(180, 35, 120, 80);
      getContentPane().add(seat2);

      seat3.setBounds(340, 35, 120, 80);
      getContentPane().add(seat3);
      
      seat4.setBounds(500, 35, 120, 80);
      getContentPane().add(seat4);
      
      seat5.setBounds(660, 35, 120, 80);
      getContentPane().add(seat5);
      
      seat6.setBounds(25, 150, 120, 80);
      getContentPane().add(seat6);
      
      seat7.setBounds(185, 150, 120, 80);
      getContentPane().add(seat7);
      
      seat8.setBounds(345, 150, 120, 80);
      getContentPane().add(seat8);
      
      seat9.setBounds(505, 150, 120, 80);
      getContentPane().add(seat9);
      
      seat10.setBounds(665, 150, 120, 80);
      getContentPane().add(seat10);
      
      seat11.setBounds(25, 265, 120, 80);
      getContentPane().add(seat11);
      
      seat12.setBounds(185, 265, 120, 80);
      getContentPane().add(seat12);
      
      seat13.setBounds(345, 265, 120, 80);
      getContentPane().add(seat13);
      
      seat14.setBounds(505, 265, 120, 80);
      getContentPane().add(seat14);
      
      seat15.setBounds(665, 265, 120, 80);
      getContentPane().add(seat15);
      
      
      studyroom1= new SeatButton("2인석 스터디룸");
      studyroom2= new SeatButton("2인석 스터디룸");
      
      studyroom1.setBounds(820, 36, 165, 80);
      getContentPane().add(studyroom1);
      
      studyroom2.setBounds(820, 150, 165, 195);
      getContentPane().add(studyroom2);
      
      JButton pay = new JButton("결제하기");
      pay.setBackground(Color.WHITE);
      pay.setFont(new Font("돋움", Font.BOLD, 14));
      pay.setBounds(733, 386, 252, 65);
      getContentPane().add(pay);
      
      JButton backBtn = new JButton("다른 서비스 이용하기");
      backBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
               select.UseSelect us = new select.UseSelect();
               us.setVisible(true);
               dispose();
         }
      });
      backBtn.setFont(new Font("돋움", Font.BOLD, 14));
      backBtn.setBackground(Color.WHITE);
      backBtn.setBounds(733, 461, 252, 65);
      getContentPane().add(backBtn);
      pay.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            if(getSeatNum().equals("")) {
               JOptionPane.showMessageDialog(null, "좌석을 선택해주세요!", "Message", JOptionPane.ERROR_MESSAGE);
            }else {
               pay.MemberPay mp = new pay.MemberPay();
               mp.setVisible(true);
               dispose();
            }
         }
      });
      seat1.addActionListener(this);seat2.addActionListener(this);seat3.addActionListener(this);
      seat4.addActionListener(this);seat5.addActionListener(this);seat6.addActionListener(this);
      seat7.addActionListener(this);seat8.addActionListener(this);seat9.addActionListener(this);
      seat10.addActionListener(this);seat11.addActionListener(this);seat12.addActionListener(this);
      seat13.addActionListener(this);seat14.addActionListener(this);seat15.addActionListener(this);
      studyroom1.addActionListener(this); studyroom2.addActionListener(this);
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==studyroom1) {
         message.setText("2인석 스터디룸을 선택하셨습니다.");
         try {seat1.checkBtn("16");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("2인석 스터디룸");
      }
      if(e.getSource()==studyroom2) {
         message.setText("4인석 스터디룸을 선택하셨습니다.");
         try {seat1.checkBtn("17");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("4인석 스터디룸");
      }
      if(e.getSource()==seat1) {
         message.setText("1번 자리를 선택하셨습니다.");
         try {seat1.checkBtn("1");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("1번");
      }
      if(e.getSource()==seat2) {
         message.setText("2번 자리를 선택하셨습니다.");
         try {seat2.checkBtn("1");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("2번");
      }
      if(e.getSource()==seat3) {
         message.setText("3번 자리를 선택하셨습니다.");
         try {seat3.checkBtn("3");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("3번");
      }
      if(e.getSource()==seat4) {
         message.setText("4번 자리를 선택하셨습니다.");
         try {seat4.checkBtn("4");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("4번");
      }
      if(e.getSource()==seat5) {
         message.setText("5번 자리를 선택하셨습니다.");
         try {seat5.checkBtn("5");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("5번");
      }
      if(e.getSource()==seat6) {
         message.setText("6번 자리를 선택하셨습니다.");
         try {seat6.checkBtn("6");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("6번");
      }
      if(e.getSource()==seat7) {
         message.setText("7번 자리를 선택하셨습니다.");
         try {seat7.checkBtn("7");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("7번");
      }
      if(e.getSource()==seat8) {
         message.setText("8번 자리를 선택하셨습니다.");
         try {seat8.checkBtn("8");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("8번");
      }
      if(e.getSource()==seat9) {
         message.setText("9번 자리를 선택하셨습니다.");
         try {seat9.checkBtn("9");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("9번");
      }
      if(e.getSource()==seat10) {
         message.setText("10번 자리를 선택하셨습니다.");
         try {seat10.checkBtn("10");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("10번");
      }
      if(e.getSource()==seat11) {
         message.setText("11번 자리를 선택하셨습니다.");
         try {seat11.checkBtn("11");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("11번");
      }
      if(e.getSource()==seat12) {
         message.setText("12번 자리를 선택하셨습니다.");
         try {seat12.checkBtn("12");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("12번");
      }
      if(e.getSource()==seat13) {
         message.setText("13번 자리를 선택하셨습니다.");
         try {seat13.checkBtn("13");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("13번");
      }
      if(e.getSource()==seat14) {
         message.setText("14번 자리를 선택하셨습니다.");
         try {seat14.checkBtn("14");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("14번");
      }
      if(e.getSource()==seat15) {
         message.setText("15번 자리를 선택하셨습니다.");
         try {seat15.checkBtn("15");} catch (ClassNotFoundException | SQLException e1) {}
         setSeatNum("15번");
      }
   }
}