package seat.use.etc;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import seat.SeatButton;
import seat.UseSeat;
import javax.swing.SwingConstants;

public class Seat_use_etc extends JFrame implements ActionListener{

   private static final long serialVersionUID = 1L;
   
   SeatButton seat1, seat2,seat3 ,seat4,seat5,seat6,seat7,seat8 ,seat9,seat10,seat11 ,seat12,seat13 ,seat14 ,seat15, studyroom1,studyroom2;

   static String use = "이용 가능";
   select.UseSelect us = new select.UseSelect();
   member.info.User user=new member.info.User();
   
   
   JButton backBtn = new JButton("다른 서비스 이용하기");
   JButton outSeat = new JButton("퇴실");
   JButton moveSeat = new JButton("자리이동");
   JButton addTime = new JButton("시간연장");
   
   JLabel message = new JLabel("현재 _번자리 이용 중");
   
   public Seat_use_etc() {
      try {
         initialize();
      } catch (ClassNotFoundException | SQLException e) {}
   }
   public static void setSeatNum(String seatNum) {UseSeat.seatNum = seatNum;}
   
   public String getSeatNum() {return UseSeat.seatNum;}
   private synchronized void initialize() throws ClassNotFoundException, SQLException {

      this.getContentPane().setBackground(new Color(48, 56, 65));
      setTitle("SONA Study Cafe");
      setSize(1030, 600);
      setLocation(300, 80);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setLayout(null);
      
      
      String str="현재 "+user.getSeat()+"번 자리 이용 중";
      setSeatNum(user.getSeat());
      message.setText(str);
      message.setHorizontalAlignment(SwingConstants.CENTER);
      message.setForeground(Color.WHITE);
      message.setFont(new Font("한컴 고딕", Font.BOLD, 19));
      message.setBounds(92, 422, 435, 65);
      getContentPane().add(message);
      setLocationRelativeTo(null);
   
      seat1=new SeatButton("1");seat2=new SeatButton("2");seat3=new SeatButton("3");
      seat4=new SeatButton("4");seat5=new SeatButton("5");seat6=new SeatButton("6");
      seat7=new SeatButton("7");seat8=new SeatButton("8");seat9=new SeatButton("9");
      seat10=new SeatButton("10");seat11=new SeatButton("11");seat12=new SeatButton("12");
      seat13=new SeatButton("13");seat14=new SeatButton("14");seat15=new SeatButton("15");
      
      seat1.setBounds(25, 35, 120, 80);seat2.setBounds(180, 35, 120, 80);seat3.setBounds(340, 35, 120, 80);
      seat4.setBounds(500, 35, 120, 80);seat5.setBounds(660, 35, 120, 80);seat6.setBounds(25, 150, 120, 80);
      seat7.setBounds(185, 150, 120, 80);seat8.setBounds(345, 150, 120, 80);seat9.setBounds(505, 150, 120, 80);
      seat10.setBounds(665, 150, 120, 80);seat11.setBounds(25, 265, 120, 80);seat12.setBounds(185, 265, 120, 80);
      seat13.setBounds(345, 265, 120, 80);seat14.setBounds(505, 265, 120, 80);seat15.setBounds(665, 265, 120, 80);
      
      getContentPane().add(seat1);getContentPane().add(seat2);getContentPane().add(seat3);
      getContentPane().add(seat4);getContentPane().add(seat5);getContentPane().add(seat6);
      getContentPane().add(seat7);getContentPane().add(seat8);getContentPane().add(seat9);
      getContentPane().add(seat10);getContentPane().add(seat11);getContentPane().add(seat12);
      getContentPane().add(seat13);getContentPane().add(seat14);getContentPane().add(seat15);
      
      studyroom1 = new SeatButton("2인석 스터디룸");
      studyroom1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("2인석 스터디룸을 선택하셨습니다.");
            setSeatNum("2인석 스터디룸");
         }
      });
      studyroom1.setBounds(820, 36, 165, 80);
      getContentPane().add(studyroom1);
      
      studyroom2 = new SeatButton("4인석 스터디룸");
      studyroom2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("4인석 스터디룸을 선택하셨습니다.");
            setSeatNum("4인석 스터디룸");
         }
      });
      studyroom2.setBounds(820, 150, 165, 195);
      getContentPane().add(studyroom2);
      
      
      moveSeat.setBackground(Color.WHITE);
      moveSeat.setFont(new Font("돋움", Font.BOLD, 14));
      moveSeat.setBounds(795, 386, 190, 65);
      getContentPane().add(moveSeat);
      
      
      backBtn.setFont(new Font("돋움", Font.BOLD, 14));
      backBtn.setBackground(Color.WHITE);
      backBtn.setBounds(795, 461, 190, 65);
      getContentPane().add(backBtn);
      
      outSeat.setFont(new Font("돋움", Font.BOLD, 14));
      outSeat.setBackground(Color.WHITE);
      outSeat.setBounds(590, 386, 190, 65);
      getContentPane().add(outSeat);
      
      
      addTime.setFont(new Font("돋움", Font.BOLD, 14));
      addTime.setBackground(Color.WHITE);
      addTime.setBounds(590, 461, 190, 65);
      getContentPane().add(addTime);
      
      outSeat.addActionListener(this);
      moveSeat.addActionListener(this);
      backBtn.addActionListener(this);
      addTime.addActionListener(this);
      seat1.addActionListener(this);seat2.addActionListener(this);seat3.addActionListener(this);
      seat4.addActionListener(this);seat5.addActionListener(this);seat6.addActionListener(this);
      seat7.addActionListener(this);seat8.addActionListener(this);seat9.addActionListener(this);
      seat10.addActionListener(this);seat11.addActionListener(this);seat12.addActionListener(this);
      seat13.addActionListener(this);seat14.addActionListener(this);seat15.addActionListener(this);
      
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==backBtn) {
         us.setVisible(true);
         dispose();
      }
      if(e.getSource()==outSeat) {
         int result = JOptionPane.showConfirmDialog(null, "정말 퇴실하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
         if(result == JOptionPane.YES_OPTION) {
            try {
               main.MainScreen.db.outSeat();
               us.setVisible(true);
               dispose();
            } catch (ClassNotFoundException | SQLException e1) {e1.printStackTrace();}
         }
      }
      if(e.getSource()==addTime) {
         AddTimePay atp=new AddTimePay();
         atp.setVisible(true);
         dispose();
      }
      if(e.getSource()==moveSeat) {
         if(UseSeat.seatNum.equals("")) {
            JOptionPane.showMessageDialog(null, "좌석을 선택해주세요!", "Message", JOptionPane.ERROR_MESSAGE);
         }else {
            try {
               String s = UseSeat.seatNum.replaceAll("[^0-9]","");
               int n = Integer.parseInt(s);
               main.MainScreen.db.seat(n);
               JOptionPane.showMessageDialog(null, "좌석이 이동되었습니다!", "Message", JOptionPane.ERROR_MESSAGE);
               us.setVisible(true); user.setSeat(s);
               dispose();
            } catch (NumberFormatException | ClassNotFoundException | SQLException e1) {}
         }
      }
      if(e.getSource()==seat1) {
         try {
            if(seat1.checkBtn("1")==false) {setSeatNum("1번");message.setText("1번 자리를 선택하셨습니다."); }
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat2) {
         try {
            if(seat1.checkBtn("2")==false) {message.setText("2번 자리를 선택하셨습니다.");setSeatNum("2번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat3) {
         try {
            if(seat1.checkBtn("3")==false) {message.setText("3번 자리를 선택하셨습니다.");setSeatNum("3번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat4) {
         try {
            if(seat1.checkBtn("4")==false) {message.setText("4번 자리를 선택하셨습니다.");setSeatNum("4번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat5) {
         try {
            if(seat1.checkBtn("5")==false) {message.setText("5번 자리를 선택하셨습니다.");setSeatNum("5번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat6) {
         try {
            if(seat1.checkBtn("6")==false) {message.setText("6번 자리를 선택하셨습니다.");setSeatNum("6번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat7) {
         try {
            if(seat1.checkBtn("7")==false) {message.setText("7번 자리를 선택하셨습니다.");setSeatNum("7번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat8) {
         try {
            if(seat1.checkBtn("8")==false) {message.setText("8번 자리를 선택하셨습니다.");setSeatNum("8번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat9) {
         try {
            if(seat1.checkBtn("9")==false) {message.setText("9번 자리를 선택하셨습니다.");setSeatNum("9번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat10) {
         try {
            if(seat1.checkBtn("10")==false) {message.setText("10번 자리를 선택하셨습니다.");setSeatNum("10번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat11) {
         try {
            if(seat1.checkBtn("11")==false) {message.setText("11번 자리를 선택하셨습니다.");setSeatNum("11번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat12) {
         try {
            if(seat1.checkBtn("12")==false) {message.setText("12번 자리를 선택하셨습니다.");setSeatNum("12번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat13) {
         try {
            if(seat1.checkBtn("13")==false) {message.setText("13번 자리를 선택하셨습니다.");setSeatNum("13번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat14) {
         try {
            if(seat1.checkBtn("14")==false) {message.setText("14번 자리를 선택하셨습니다.");setSeatNum("14번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat15) {
         try {
            if(seat1.checkBtn("15")==false) {message.setText("15번 자리를 선택하셨습니다.");setSeatNum("15번");}
            else {message.setText("이용 중인 좌석입니다.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      
   }
}