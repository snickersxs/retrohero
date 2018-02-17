import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javafx.scene.text.Font;

public class Highscore extends JLabel {

	ImageIcon bg;
	Scanner scan3;
	ArrayList<Integer> scr = new ArrayList<>();
	public Highscore(StartFrame pencere) {
		this.setSize(600, 700);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		bg =new ImageIcon("images//highscoress.png");
		setIcon(bg);
	    setIconTextGap(-350);
		setOpaque(true);
	    setLayout(null);
		
		try {
			scan3 =new Scanner(new File("highscores.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(scan3.hasNextInt()){
			scr.add(scan3.nextInt());
		}
		String result = "<html><span style='font-size:40px'><font color='FireBrick'>"+ "1:   " + String.valueOf(scr.get(0)) + "<br>" + "2:   " + String.valueOf(scr.get(1)) + "<br>" 
				+ "3:   " + String.valueOf(scr.get(2)) + "<br>" + "4:   " + String.valueOf(scr.get(3)) + "<br>" + "5:   " + String.valueOf(scr.get(4))+ "</font></span></html>";
		setText(getText() + result);
		
		
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

