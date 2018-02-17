import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SongsMenu extends JLabel {
	JButton starwars,affet,supermario;
	GamePlay play;
	StartFrame pencere;
	public SongsMenu(StartFrame pencere) {
		setSize(600, 700);
		this.pencere=pencere;
		
		this.setIcon(new ImageIcon("images//songsmenu.png"));
		ImageIcon imageForSupermario = new ImageIcon("images//SUPERMARIO.png");	//sets image for start button	
		supermario = new JButton("",imageForSupermario);
		add(supermario);
		supermario.setBounds(86, 250,427,52);



		ImageIcon imageForStarwars = new ImageIcon("images//STARWARS.png"); //sets image for how to play button
		starwars= new JButton("",imageForStarwars);
		add(starwars);
		starwars.setBounds(132,350,336,52);



		ImageIcon imageForAffet = new ImageIcon("images//AFFET.png");// sets þmage for highscore button
		affet = new JButton("",imageForAffet);
		add(affet);
		affet.setBounds(192,450,215,53);
		
		makeUnvisible(starwars);
		makeUnvisible(supermario);
		makeUnvisible(affet);
		

		moveAnimation(starwars);
		moveAnimation(supermario);
		moveAnimation(affet);
		
		setVisible(true);
		
		starwars.addActionListener(new ActionListener()      
		{
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				play=new GamePlay("starwars.wav","Notes//starwars.txt",pencere,"images//vaderbabaa.png");
				pencere.add(play);
			}
				});
		
		affet.addActionListener(new ActionListener()      
		{
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				play=new GamePlay("affet.wav","Notes//affet.txt",pencere,"images//muslumbabaa.png");
				pencere.add(play);
			}
				});
		
		supermario.addActionListener(new ActionListener()      
		{
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				play=new GamePlay("supermario.wav","Notes//supermario.txt",pencere,"images//mario.png");
				pencere.add(play);
				play.setVisible(true);
				
			}
				});
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



	public void makeUnvisible(JButton button){             //it makes unvisible button background
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
	}
	public void moveAnimation(JButton button){             //it is for make moved the buttons when mouse entered in buttons area
		int x,y;
		x=button.getLocation().x;
		y=button.getLocation().y;

		button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				button.setLocation(x, y-5);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				button.setLocation(x, y);
			}
		});
	}
}
