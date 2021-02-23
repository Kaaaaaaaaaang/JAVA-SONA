package membership;

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
import pay.MemberPay;
import seat.use.etc.AddTimePay;

public class MembershipReceipt extends JFrame{
   private static final long serialVersionUID = 1L;

   public MembershipReceipt() throws ClassNotFoundException, SQLException {
      initialize();
   }
   private void initialize() throws ClassNotFoundException, SQLException {
      
      
      if(BuyMembership.buy.equals("시간권")) {
         main.MainScreen.db.membertime(BuyMembership.time);
      }else if(BuyMembership.buy.equals("금액권")) {
         main.MainScreen.db.membermoney(BuyMembership.money);
      }else if(BuyMembership.buy.equals("2주권")) {
         main.MainScreen.db.memberweek(BuyMembership.week);
      }
      
      User user = new User();
      
      JLabel intro_background = new JLabel("New label");
       intro_background.setIcon(new ImageIcon("img/back_1.png"));
       intro_background.setBounds(0, 0, 1000, 575);
       getContentPane().add(intro_background);
       
      //this.getContentPane().setBackground(new Color(190, 210, 230));
      setTitle("SONA Study Cafe");
      setSize(1000, 600);
      setLocation(300, 80);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setLayout(null);
      /*
      JPanel titleP = new JPanel();
      titleP.setBackground(new Color(190,210,230));
      titleP.setBounds(381, 24, 241, 38);
      getContentPane().add(titleP);
      */
      setLocationRelativeTo(null);
      
      JLabel titleL = new JLabel("결제내역");
      titleL.setHorizontalAlignment(SwingConstants.CENTER);
      titleL.setFont(new Font("한컴 고딕", Font.PLAIN, 21));
      titleL.setForeground(Color.WHITE);
      titleL.setBounds(410, 100, 183, 18);
      intro_background.add(titleL);
      /*
      JPanel lineP = new JPanel();
      lineP.setBorder(new LineBorder(new Color(0, 0, 0)));
      lineP.setForeground(Color.BLACK);
      lineP.setBackground(new Color(190,210,230));
      lineP.setBounds(50, 46, 893, 480);
      getContentPane().add(lineP);
      lineP.setLayout(null);
      
      */
      JLabel userNameL = new JLabel();
      userNameL.setForeground(Color.WHITE);
      userNameL.setHorizontalAlignment(SwingConstants.CENTER);
      userNameL.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
      userNameL.setBounds(70, 150, 869, 46);
      userNameL.setText(user.getName()+" 회원님");
      intro_background.add(userNameL);
      
      Button backBtn = new Button("다른 서비스 이용하기");
      intro_background.add(backBtn);
      backBtn.setFont(new Font("한컴 고딕", Font.PLAIN, 12));
      backBtn.setBackground(Color.WHITE);
      backBtn.setBounds(430, 461, 151, 32);
      
      JLabel howmuch = new JLabel();
      intro_background.add(howmuch);
      howmuch.setText(BuyMembership.price+"\\");
      howmuch.setHorizontalAlignment(SwingConstants.CENTER);
      howmuch.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
      howmuch.setForeground(Color.WHITE);
      howmuch.setBounds(72, 262, 869, 46);
      
      JLabel membership = new JLabel();
      intro_background.add(membership);
      membership.setText(BuyMembership.membership);
      membership.setHorizontalAlignment(SwingConstants.CENTER);
      membership.setForeground(Color.WHITE);
      membership.setFont(new Font("한컴 고딕", Font.PLAIN, 18));
      membership.setBounds(72, 206, 869, 46);
   
      
      backBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
            select.UseSelect select_useSelect=new select.UseSelect();
            select_useSelect.setVisible(true);
         }
      });   
   }
}