import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HowToPlay extends JLabel {

	public HowToPlay(StartFrame pencere) {
		this.setSize(600, 700);
		this.setIcon(new ImageIcon("images//howtoplay.png"));
		
		ImageIcon backicon = new ImageIcon("images//Back.png");
		JButton backbutton=new JButton("",backicon);
		backbutton.setOpaque(false);
		backbutton.setContentAreaFilled(false);
		backbutton.setBorderPainted(false);
		this.add(backbutton);
		backbutton.setBounds(218, 600, 164, 52);
		
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				pencere.setVisible(true);
				pencere.label.setVisible(true);
				
			}
		});
	}

}
