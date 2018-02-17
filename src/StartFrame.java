
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class StartFrame extends JFrame {

	JButton one,high,how;
	JLabel label;
	
	public StartFrame() throws HeadlessException {
		super ("Retro Hero");              
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		

		
		setBounds(500,50,600,700);
		setResizable(false);
		
		
		ImageIcon icon = new ImageIcon("images//R.png");
		setIconImage(icon.getImage());
		
		label = new JLabel(new ImageIcon("images//background.png")); // set image for background
		getContentPane().add(label);
		
		
		
		ImageIcon imageForOne = new ImageIcon("images//START.png");	//sets image for start button	
		one = new JButton("",imageForOne);
		label.add(one);
		one.setBounds(195, 250,209,56);
		
		
		
		ImageIcon imageForHow = new ImageIcon("images//howhow.png"); //sets image for how to play button
		how = new JButton("",imageForHow);
		label.add(how);
		how.setBounds(71,350,458,56);
		
		
		
		ImageIcon imageForHigh = new ImageIcon("images//highscore.png");// sets þmage for highscore button
		high = new JButton("",imageForHigh);
		label.add(high);
		high.setBounds(84,450,431,56);
	}
	

}
