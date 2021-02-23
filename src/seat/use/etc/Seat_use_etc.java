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

   static String use = "�̿� ����";
   select.UseSelect us = new select.UseSelect();
   member.info.User user=new member.info.User();
   
   
   JButton backBtn = new JButton("�ٸ� ���� �̿��ϱ�");
   JButton outSeat = new JButton("���");
   JButton moveSeat = new JButton("�ڸ��̵�");
   JButton addTime = new JButton("�ð�����");
   
   JLabel message = new JLabel("���� _���ڸ� �̿� ��");
   
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
      
      
      String str="���� "+user.getSeat()+"�� �ڸ� �̿� ��";
      setSeatNum(user.getSeat());
      message.setText(str);
      message.setHorizontalAlignment(SwingConstants.CENTER);
      message.setForeground(Color.WHITE);
      message.setFont(new Font("���� ���", Font.BOLD, 19));
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
      
      studyroom1 = new SeatButton("2�μ� ���͵��");
      studyroom1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("2�μ� ���͵���� �����ϼ̽��ϴ�.");
            setSeatNum("2�μ� ���͵��");
         }
      });
      studyroom1.setBounds(820, 36, 165, 80);
      getContentPane().add(studyroom1);
      
      studyroom2 = new SeatButton("4�μ� ���͵��");
      studyroom2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("4�μ� ���͵���� �����ϼ̽��ϴ�.");
            setSeatNum("4�μ� ���͵��");
         }
      });
      studyroom2.setBounds(820, 150, 165, 195);
      getContentPane().add(studyroom2);
      
      
      moveSeat.setBackground(Color.WHITE);
      moveSeat.setFont(new Font("����", Font.BOLD, 14));
      moveSeat.setBounds(795, 386, 190, 65);
      getContentPane().add(moveSeat);
      
      
      backBtn.setFont(new Font("����", Font.BOLD, 14));
      backBtn.setBackground(Color.WHITE);
      backBtn.setBounds(795, 461, 190, 65);
      getContentPane().add(backBtn);
      
      outSeat.setFont(new Font("����", Font.BOLD, 14));
      outSeat.setBackground(Color.WHITE);
      outSeat.setBounds(590, 386, 190, 65);
      getContentPane().add(outSeat);
      
      
      addTime.setFont(new Font("����", Font.BOLD, 14));
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
         int result = JOptionPane.showConfirmDialog(null, "���� ����Ͻðڽ��ϱ�?", "Confirm", JOptionPane.YES_NO_OPTION);
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
            JOptionPane.showMessageDialog(null, "�¼��� �������ּ���!", "Message", JOptionPane.ERROR_MESSAGE);
         }else {
            try {
               String s = UseSeat.seatNum.replaceAll("[^0-9]","");
               int n = Integer.parseInt(s);
               main.MainScreen.db.seat(n);
               JOptionPane.showMessageDialog(null, "�¼��� �̵��Ǿ����ϴ�!", "Message", JOptionPane.ERROR_MESSAGE);
               us.setVisible(true); user.setSeat(s);
               dispose();
            } catch (NumberFormatException | ClassNotFoundException | SQLException e1) {}
         }
      }
      if(e.getSource()==seat1) {
         try {
            if(seat1.checkBtn("1")==false) {setSeatNum("1��");message.setText("1�� �ڸ��� �����ϼ̽��ϴ�."); }
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat2) {
         try {
            if(seat1.checkBtn("2")==false) {message.setText("2�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("2��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat3) {
         try {
            if(seat1.checkBtn("3")==false) {message.setText("3�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("3��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat4) {
         try {
            if(seat1.checkBtn("4")==false) {message.setText("4�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("4��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat5) {
         try {
            if(seat1.checkBtn("5")==false) {message.setText("5�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("5��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat6) {
         try {
            if(seat1.checkBtn("6")==false) {message.setText("6�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("6��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat7) {
         try {
            if(seat1.checkBtn("7")==false) {message.setText("7�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("7��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat8) {
         try {
            if(seat1.checkBtn("8")==false) {message.setText("8�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("8��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat9) {
         try {
            if(seat1.checkBtn("9")==false) {message.setText("9�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("9��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat10) {
         try {
            if(seat1.checkBtn("10")==false) {message.setText("10�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("10��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat11) {
         try {
            if(seat1.checkBtn("11")==false) {message.setText("11�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("11��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat12) {
         try {
            if(seat1.checkBtn("12")==false) {message.setText("12�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("12��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat13) {
         try {
            if(seat1.checkBtn("13")==false) {message.setText("13�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("13��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat14) {
         try {
            if(seat1.checkBtn("14")==false) {message.setText("14�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("14��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      if(e.getSource()==seat15) {
         try {
            if(seat1.checkBtn("15")==false) {message.setText("15�� �ڸ��� �����ϼ̽��ϴ�.");setSeatNum("15��");}
            else {message.setText("�̿� ���� �¼��Դϴ�.");setSeatNum("");}
         } catch (ClassNotFoundException | SQLException e1) {}
      }
      
   }
}