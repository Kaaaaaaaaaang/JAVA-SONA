package seat;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import member.info.User;
import timer.UseSeatTimer;


public class SeatButton extends JButton{
   
   //public static String seatNum="";
   //public static String btnLabel="";

   member.info.User user = new member.info.User();
   private static final long serialVersionUID = 1L;
   public SeatButton() {}
   
   public SeatButton(String t) throws ClassNotFoundException, SQLException {
      
      //UseSeatTimer ust=new UseSeatTimer();
      //Thread th=new Thread(ust);
      //seatNum=t;
      setText(t);
      setFont(new Font("����", Font.BOLD, 14));
      setForeground(Color.BLACK);
      setBackground(Color.WHITE);
      if(t.equals("2�μ� ���͵��")) {
         t="16";//seatNum="16";
      }
      if(t.equals("4�μ� ���͵��")) {
         t="17";//seatNum="17";
      }
      //setText(user.getFinish_Time());
      
      if(main.MainScreen.db.mySeat(t)==true) {
         setBackground(new Color(196, 155, 115));
         //th.start();
      }else if(main.MainScreen.db.seatUseTrue(t)==true) {
         setBackground(Color.DARK_GRAY);
         //th.start();
      }
      //setText(btnLabel);
      //setText(UseSeatTimer.btnL);
      
   }
   
   public boolean checkBtn(String t) throws ClassNotFoundException, SQLException {
      if(main.MainScreen.db.seatUseTrue(t)==true) {
         JOptionPane.showMessageDialog(null, "�̿����� �¼��Դϴ�.", "Message", JOptionPane.ERROR_MESSAGE);
         return true;
      }else return false;
   }
}