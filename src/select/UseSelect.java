package select;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.MainScreen;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UseSelect extends JFrame {

   private static final long serialVersionUID = 1L;
   protected static final Component ContainerObject = null;
   member.info.User user=new member.info.User();
   public UseSelect() {
      initialize();
      try {
         main.MainScreen.db.SaveUserInfo();
      } catch (ClassNotFoundException | SQLException e) {}
   }
   private void initialize() {
      try {main.MainScreen.db.SaveUserInfo();} catch (ClassNotFoundException | SQLException e2) {}
      member.info.UserInfo mUinfo=new member.info.UserInfo();
      seat.UseSeat sUs=new seat.UseSeat();
      
      
      JLabel intro_background = new JLabel("New label");
       intro_background.setIcon(new ImageIcon("img/back_1.png"));
       intro_background.setBounds(0, 0, 1000, 575);
       getContentPane().add(intro_background);
          
      this.getContentPane().setBackground(new Color(190, 210, 230));
      setTitle("SONA Study Cafe");
      setSize(1000, 600);
      setLocation(300, 80);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getContentPane().setLayout(null);
      setLocationRelativeTo(null);

      JButton selectSeat = new JButton("좌석 이용");
      selectSeat.setFont(new Font("한컴 고딕", Font.BOLD, 19));
      selectSeat.setBackground(Color.WHITE);
      selectSeat.setBounds(170, 87, 310, 140);
      intro_background.add(selectSeat);
      selectSeat.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(user.getSeat()==null) {
               sUs.setVisible(true);
               dispose();
            }else {
               JOptionPane.showMessageDialog(null, "이미 좌석을 이용 중입니다.", "Message", JOptionPane.ERROR_MESSAGE); 
            }
         }
      });
      
      JButton useSeat = new JButton("시간 연장 / 퇴실 / 자리 이동");
      useSeat.setFont(new Font("한컴 고딕", Font.BOLD, 19));
      useSeat.setBackground(Color.WHITE);
      useSeat.setBounds(170, 258, 310, 140);
      intro_background.add(useSeat);
      useSeat.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(user.getSeat()!=null) {
               seat.use.etc.Seat_use_etc sue=new seat.use.etc.Seat_use_etc();
               sue.setVisible(true);
               dispose();
            }else {
               JOptionPane.showMessageDialog(null, "좌석을 먼저 선택해 주세요!", "Message", JOptionPane.ERROR_MESSAGE); 
            }
         }
      });
      
      JButton buyMember = new JButton("시간권 / 금액권 / 2주권");
      buyMember.setFont(new Font("한컴 고딕", Font.BOLD, 19));
      buyMember.setBackground(Color.WHITE);
      buyMember.setBounds(510, 87, 310, 140);
      intro_background.add(buyMember);
      
      buyMember.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            membership.BuyMembership bm=new membership.BuyMembership();
            bm.setVisible(true);
            dispose();
         }
      });
      
      JButton memberInfo = new JButton("회원 정보");
      memberInfo.setFont(new Font("한컴 고딕", Font.BOLD, 19));
      memberInfo.setBackground(Color.WHITE);
      memberInfo.setBounds(510, 258, 310, 140);
      intro_background.add(memberInfo);
      memberInfo.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            mUinfo.call();
            try {
               main.MainScreen.db.SaveUserInfo();
            } catch (ClassNotFoundException | SQLException e1) {}
            mUinfo.setVisible(true);
            dispose();
         }
      });
      
      
      JButton backBtn = new JButton("뒤로가기");
      backBtn.setFont(new Font("한컴 고딕", Font.BOLD, 19));
      backBtn.setBackground(Color.WHITE);
      backBtn.setBounds(328, 430, 340, 60);
      intro_background.add(backBtn);
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
      
   }
}