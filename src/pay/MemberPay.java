package pay;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import member.info.User;
import price.SeatPrice;

import java.awt.Button;

public class MemberPay extends JFrame {

   private static final long serialVersionUID = 1L;
   boolean choose = false;
   static int price=0;
   static int time=0;
   SeatPrice sp=new SeatPrice();
   db.DB_connect db=new db.DB_connect();
   
   public MemberPay() {
      try {
         initialize();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   private void initialize() throws SQLException {
      
      seat.UseSeat sS=new seat.UseSeat();
      //this.getContentPane().setBackground(new Color(190, 210, 230));

      JLabel intro_background = new JLabel("New label");
       intro_background.setIcon(new ImageIcon("img/back_1.png"));
       intro_background.setBounds(0, 0, 1000, 575);
       getContentPane().add(intro_background);
       
      setTitle("결제");
      setSize(1000, 600);
      setLocation(300, 80);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setLayout(null);
      
      String sNum=sS.getSeatNum()+" 자리";
      JLabel seatNumL = new JLabel(sNum);
      seatNumL.setForeground(Color.WHITE);
      seatNumL.setHorizontalAlignment(SwingConstants.CENTER);
      seatNumL.setFont(new Font("한컴 고딕", Font.BOLD, 19));
      seatNumL.setBounds(55, 80, 878, 45);
      intro_background.add(seatNumL);
      setLocationRelativeTo(null);
      
      
      Button backBtn = new Button("결제 취소");
      backBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
      backBtn.setBackground(Color.WHITE);
      backBtn.setBounds(411, 460, 130, 30);
      intro_background.add(backBtn);
      
      JLabel message = new JLabel("시간을 선택해 주세요");
      message.setHorizontalAlignment(SwingConstants.CENTER);
      message.setForeground(Color.WHITE);
      message.setFont(new Font("한컴 고딕", Font.BOLD, 19));
      message.setBounds(53, 271, 878, 45);
      intro_background.add(message);
      setLocationRelativeTo(null);
      
      String str;
      JButton hour2Btn = new JButton();
      str="<html>2시간<br>"+sp.getSeatPrice("time2")+"\\</html>";
      hour2Btn.setText(str);
      hour2Btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("2시간 결제하시겠습니까?");
            choose = true;
            time=2;
            try {
               price=Integer.parseInt(sp.getSeatPrice("time2"));
            } catch (NumberFormatException | SQLException e1) {
               e1.printStackTrace();
            }
         }
      });
      hour2Btn.setFont(new Font("돋움", Font.BOLD, 14));
      hour2Btn.setBounds(80, 140, 165, 90);
      intro_background.add(hour2Btn);
      hour2Btn.setBackground(Color.WHITE);
      
      JButton hour5Btn = new JButton();
      str="<html>5시간<br>"+sp.getSeatPrice("time5")+"\\</html>";
      hour5Btn.setText(str);
      hour5Btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("5시간 결제하시겠습니까?");
            choose=true;
            time=5;
            try {
               price=Integer.parseInt(sp.getSeatPrice("time5"));
            } catch (NumberFormatException | SQLException e1) {
               e1.printStackTrace();
            }
         }
      });
      hour5Btn.setFont(new Font("돋움", Font.BOLD, 14));
      hour5Btn.setBounds(300, 140, 165, 90);
      intro_background.add(hour5Btn);
      hour5Btn.setBackground(Color.WHITE);
      
      JButton hour8Btn = new JButton();
      str="<html>8시간<br>"+sp.getSeatPrice("time8")+"\\</html>";
      hour8Btn.setText(str);
      hour8Btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("8시간 결제하시겠습니까?");
            choose=true;
            time=8;
            try {
               price=Integer.parseInt(sp.getSeatPrice("time8"));
            } catch (NumberFormatException | SQLException e1) {
               e1.printStackTrace();
            }
         }
      });
      hour8Btn.setFont(new Font("돋움", Font.BOLD, 14));
      hour8Btn.setBounds(538, 140, 165, 90);
      intro_background.add(hour8Btn);
      hour8Btn.setBackground(Color.WHITE);
      
      JButton hour10Btn = new JButton();
      str="<html>10시간<br>"+sp.getSeatPrice("time10")+"\\</html>";
      hour10Btn.setText(str);
      hour10Btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            message.setText("10시간 결제하시겠습니까?");
            choose=true;
            time=10;
            try {
               price=Integer.parseInt(sp.getSeatPrice("time10"));
            } catch (NumberFormatException | SQLException e1) {
               e1.printStackTrace();
            }
         }
      });
      hour10Btn.setFont(new Font("돋움", Font.BOLD, 14));
      hour10Btn.setBounds(768, 140, 165, 90);
      intro_background.add(hour10Btn);
      hour10Btn.setBackground(Color.WHITE);
      
      JButton cardPay = new JButton("카드결제");
      cardPay.setFont(new Font("한컴고딕", Font.BOLD, 14));
      cardPay.setBackground(Color.WHITE);
      cardPay.setBounds(53, 350, 246, 80);
      intro_background.add(cardPay);
      
      cardPay.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(choose==true) {
               CardPay cp=new CardPay();
               cp.setVisible(true);
               
            }else {
               JOptionPane.showMessageDialog(null, "시간을 선택해 주세요!");
            }
            
         }
      });
      
      JButton moneyPay = new JButton("현금결제");
      moneyPay.setFont(new Font("한컴고딕", Font.BOLD, 14));
      moneyPay.setBackground(Color.WHITE);
      moneyPay.setBounds(685, 350, 246, 80);
      intro_background.add(moneyPay);
      moneyPay.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(choose==true) {
               MoneyPay mp=new MoneyPay(); 
               mp.setVisible(true);
            }else {
               JOptionPane.showMessageDialog(null, "시간을 선택해 주세요!");
            }
         }
      });
      
      JButton membership = new JButton("<html>멤버십 결제<br/>시간권/금액권/2주권</html>");
      membership.setFont(new Font("한컴고딕", Font.BOLD, 14));
      membership.setBackground(Color.WHITE);
      membership.setBounds(367, 350, 246, 80);
      intro_background.add(membership);
      membership.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            User user= new User();
            if(user.membershipUser()==true) {
               if(choose==true) {
                  MemberShipPay msp=new MemberShipPay();
                  msp.setVisible(true);
                  
               }else {
                  JOptionPane.showMessageDialog(null, "시간을 선택해 주세요!");
               }
            }else
               JOptionPane.showMessageDialog(null, "멤버십 회원이 아닙니다!!");
         }
      });
      
      backBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
            sS.setVisible(true);
         }
      });   
   }
   public static int gettime() {
      return MemberPay.time;
   }
}