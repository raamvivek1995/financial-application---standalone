import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class FileChooser extends JFrame {
	
	public FileChooser()
	{
		super();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		// escape btn support
	    KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
	    Action escapeAction = new AbstractAction() {
	      public void actionPerformed(ActionEvent e) {
	        dispose();
	      }
	    };
	    getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		        escapeKeyStroke, "ESCAPE");
		    getRootPane().getActionMap().put("ESCAPE", escapeAction);
		    
		    JLabel upload = new javax.swing.JLabel();
	        JFileChooser selectinvoice = new javax.swing.JFileChooser();

	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        getContentPane().setLayout(new AbsoluteLayout());

	        upload.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        upload.setText("jLabel1");
	        upload.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
	        upload.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	        getContentPane().add(upload, new AbsoluteConstraints(180, 0, 650, 440));
	        getContentPane().add(selectinvoice, new AbsoluteConstraints(170, 30, -1, -1));

	        pack();
	}	
		}
	
	


