
//We use this class to create music notes..
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Keydeneme extends JFrame implements KeyListener{
	static SoundPlayer sound;
	String aline="";
	String sline="";
	String dline="";
	String fline="";
	String gline="";
	String textfile;
	public Keydeneme(String location,String textfile){
		super();
		//this.setVisible(true);
		this.setBounds(150, 150, 600, 700);
		addKeyListener(this);
		sound =new SoundPlayer(location);
		this.textfile=textfile;
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==e.VK_A){
			System.out.println("A typet"+sound.GetTime());
			aline +=sound.GetTime()/1000+" ";
		}
		/*if(e.getKeyCode()==e.VK_B){
			sound.SetVolume(-20.0f);
		}*/
		if (e.getKeyCode() == KeyEvent.VK_S) {
	        System.out.println(sound.GetTime());
	        sline +=sound.GetTime()/1000+" ";
	    }

	    if (e.getKeyCode() == KeyEvent.VK_D) {
	    	System.out.println(sound.GetTime());
	    	dline +=sound.GetTime()/1000+" ";
	    }

	    if (e.getKeyCode() == KeyEvent.VK_F) {
	    	System.out.println(sound.GetTime());
	    	fline +=sound.GetTime()/1000+" ";
	    }

	    if (e.getKeyCode() == KeyEvent.VK_G) {
	    	System.out.println(sound.GetTime());
	    	gline +=sound.GetTime()/1000+" ";
	    }
	    if(sound.clip.isActive()==false){
	    	try{
	    	    PrintWriter writer = new PrintWriter(textfile, "UTF-8");
	    	    writer.println(aline);
	    	    writer.println(sline);
	    	    writer.println(dline);
	    	    writer.println(fline);
	    	    writer.println(gline);
	    	    writer.close();
	    	} catch (IOException e1) {
	    	   // do something
	    	}
	    }
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
