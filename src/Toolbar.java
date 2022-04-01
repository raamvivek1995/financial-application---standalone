import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {
	private JButton signup;
	private JButton signoff;
   // private Textpanel textpanel;
	private Stringlistener listener;
	public Toolbar()
	{
		//setBackground(Color.DARK_GRAY);
		signup = new JButton("SIGN UP"); signoff = new JButton("SIGN OUT");
		//setLayout(new FlowLayout(FlowLayout.RIGHT));
		//add(signup);

		signup.addActionListener(this);
		signoff.addActionListener(this);
}
	public void setListener(Stringlistener listener)
	{
		this.listener = listener;
	}

	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == signup)
		{
			if(listener != null)
			{
				listener.textEmitted("sign up\n");
			}
		}
		else if (clicked == signoff)
		{
			if(listener != null)
			{
				listener.textEmitted("sign off\n");
			}
		}
	}

	
	 
	}


