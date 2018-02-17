import javax.swing.*;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NotMain {
	
	StartFrame pencere;
	
		public NotMain(){
	
		pencere=new StartFrame();//
		
		pencere.addWindowListener(new WindowAdapter() {
			   public void windowClosing(WindowEvent evt) {
				     onExit();
				   }

			private void onExit() {
				System.err.println("Exit oguzhan");
				  
				  System.exit(0);
				
			}
				  });
		makeUnvisible(pencere.one);
		makeUnvisible(pencere.high);
		makeUnvisible(pencere.how);
		

		moveAnimation(pencere.one);
		moveAnimation(pencere.high);
		moveAnimation(pencere.how);
		
		pencere.setVisible(true);
		
		pencere.one.addActionListener(new ActionListener()  //for control if player click the button 
		{
		  public void actionPerformed(ActionEvent e){
			  SongsMenu menu=new SongsMenu(pencere);
			  
				//FrameAnimationTest frame=new FrameAnimationTest();
				pencere.label.setVisible(false);
				pencere.add(menu);
				
				menu.setVisible(true);
				
				/*frame.setVisible(true);
				frame.add(play);
				frame.setVisible(true);
				play.setVisible(true);
				pencere.setVisible(false);*/
			  //FrameAnimationTest newPlay = new FrameAnimationTest();
			  //pencere.setVisible(false);
		  }
		});
		
		pencere.how.addActionListener(new ActionListener()      
		{
			public void actionPerformed(ActionEvent e){
				HowToPlay howw=new HowToPlay(pencere);
				pencere.add(howw);
				pencere.label.setVisible(false);
				howw.setVisible(true);
			}
				});
		pencere.high.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				Highscore highh=new Highscore(pencere);
				pencere.add(highh);
				pencere.label.setVisible(false);
				highh.setVisible(true);
			}
		});
		
	}
		/*
		public void cutMusic() {
			if (play != null) {
				play.stopMusic();
			}
		}
		*/
		

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

