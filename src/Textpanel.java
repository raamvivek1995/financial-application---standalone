import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Textpanel extends JPanel{
	private JTextArea textarea;
	public Textpanel()
	{
		//setBackground(Color.BLACK);
		textarea = new JTextArea();
		//setLayout(new BorderLayout());
		
		//add(new JScrollPane(textarea), BorderLayout.CENTER );
	}
	public void appendText(String s)
	{
		textarea.append(s);
	}
}