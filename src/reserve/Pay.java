package reserve;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import member.info.User;
import price.SeatPrice;
import seat.use.etc.Membership_etc;

import java.awt.Button;

public class Pay extends JFrame {

   private static final long serialVersionUID = 1L;
   static int price=0;
   static int time=0;
   SeatPrice sp=new SeatPrice();
   
   public Pay() {
      try {
         initialize();
      } catch (SQLException e) {}
   }
   private void initialize() throws SQLException {
      
      ReserveSeat rs=new ReserveSeat();
      
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
      
      String sNum=rs.getSeatNum()+" 자리";
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
      
      JLabel message = new JLabel(ReserveSeat.choice);
      message.setForeground(Color.WHITE);
      message.setHorizontalAlignment(SwingConstants.CENTER);
      message.setFont(new Font("한컴 고딕", Font.BOLD, 19));
      message.setBounds(53, 271, 878, 45);
      intro_background.add(message);
      setLocationRelativeTo(null);
      
      String str;
      JButton hour2Btn = new JButton();
      str="<html>2시간<br>"+sp.getSeatPrice("time2")+"\\</html>";
      hour2Btn.setText(str);
      price=3500;
      time=2;
      
      hour2Btn.setFont(new Font("돋움", Font.BOLD, 14));
      hour2Btn.setBounds(80, 140, 800, 110);
      intro_background.add(hour2Btn);
      hour2Btn.setBackground(Color.WHITE);
      
      JButton cardPay = new JButton("카드결제");
      cardPay.setFont(new Font("한컴고딕", Font.BOLD, 14));
      cardPay.setBackground(Color.WHITE);
      cardPay.setBounds(53, 350, 246, 80);
      intro_background.add(cardPay);
      
      cardPay.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
               CardPay cp=new CardPay();
               cp.setVisible(true);
         }
      });
      
      JButton moneyPay = new JButton("현금결제");
      moneyPay.setFont(new Font("한컴고딕", Font.BOLD, 14));
      moneyPay.setBackground(Color.WHITE);
      moneyPay.setBounds(685, 350, 246, 80);
      intro_background.add(moneyPay);
      moneyPay.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
               MoneyPay mp=new MoneyPay(); 
               mp.setVisible(true);
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
               MemberShipPay msp=new MemberShipPay();
               msp.setVisible(true);
            }else
               JOptionPane.showMessageDialog(null, "멤버십 회원이 아닙니다!!");
         }
      });
      
      backBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
            rs.setVisible(true);
         }
      });   
   }
   public static int gettime() {
      return Pay.time;
   }
}