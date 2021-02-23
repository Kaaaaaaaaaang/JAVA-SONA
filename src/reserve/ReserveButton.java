package reserve;

import java.awt.Color;
import java.awt.Font;

import java.sql.SQLException;

import javax.swing.JButton;

public class ReserveButton extends JButton{
	
	private static final long serialVersionUID = 1L;

	public ReserveButton() { }
	
	public ReserveButton(String text) {
		setFont(new Font("µ¸¿ò", Font.BOLD, 14));
		setBackground(Color.WHITE);
		setText(text);
		
	}
}