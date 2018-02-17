

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePlay extends JLabel implements ActionListener {
	int time=0;
	SoundPlayer sound=null;
	int a=0;
	int s=0;
	int d=0;
	int f=0;
	int g=0;
	static boolean aPressed = false;
	static boolean sPressed = false;
	static boolean dPressed = false;
	static boolean fPressed = false;
	static boolean gPressed = false;
	SoundThread ab=null;
	Scanner scan=null;
	int score=0;
	int time2;
	
	boolean firstrun=true;
	
	ArrayList<Integer> scores = new ArrayList<>();
	JButton backbutton;
	Scanner scan3;
	LinkedList<Rectangle> list = new LinkedList<Rectangle>();
	/*LinkedList<Rectangle> listS = new LinkedList<Rectangle>();
	LinkedList<Rectangle> listD = new LinkedList<Rectangle>();
	LinkedList<Rectangle> listF = new LinkedList<Rectangle>();
	LinkedList<Rectangle> listG = new LinkedList<Rectangle>();*/
	
	ArrayList<Integer> timesA = new ArrayList<>();
	ArrayList<Integer> timesS = new ArrayList<>();
	ArrayList<Integer> timesD = new ArrayList<>();
	ArrayList<Integer> timesF = new ArrayList<>();
	ArrayList<Integer> timesG = new ArrayList<>();
	int zaman;

	Timer timer =new Timer(1,this);
	
	ArrayList<MainRectangles> rectList = new ArrayList<>();
	
	public GamePlay(String location,String textfile,StartFrame pencere) {
		super();
		sound=new SoundPlayer(location);
		//this.setIcon(new ImageIcon("images//mario.png"));
		
		
		ImageIcon backicon = new ImageIcon("images//Back.png");
		backbutton=new JButton("",backicon);
		backbutton.setOpaque(false);
		backbutton.setContentAreaFilled(false);
		backbutton.setBorderPainted(false);
		this.add(backbutton);
		backbutton.setBounds(4000, 4600, 164, 52);
		
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				pencere.setVisible(true);
				pencere.label.setVisible(true);
				
			}
		});
		
		
		rectList.add(new MainRectangles(65, 570, 70, 70, new Color(Color.TRANSLUCENT)));
		rectList.add(new MainRectangles(165, 570, 70, 70, new Color(Color.TRANSLUCENT)));
		rectList.add(new MainRectangles(265, 570, 70, 70, new Color(Color.TRANSLUCENT)));
		rectList.add(new MainRectangles(365, 570, 70, 70, new Color(Color.TRANSLUCENT)));
		rectList.add(new MainRectangles(465, 570, 70, 70, new Color(Color.TRANSLUCENT)));
		
		
		
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
                switch (ke.getID()) {
                case KeyEvent.KEY_PRESSED:
                	
                	
                	 if (ke.getKeyCode() == KeyEvent.VK_A) {
                    	//System.out.println("a is pressed");
                        aPressed = true;
                      
                        rectList.get(0).setColorInt(Color.RED);
                    } else if (ke.getKeyCode() == KeyEvent.VK_S) {
                    	sPressed  = true;
                    	rectList.get(1).setColorInt(Color.RED);
                    } else if (ke.getKeyCode() == KeyEvent.VK_D) {
                    	dPressed  = true;
                    	rectList.get(2).setColorInt(Color.RED);
                    } else if (ke.getKeyCode() == KeyEvent.VK_F) {
                    	fPressed  = true;
                    	rectList.get(3).setColorInt(Color.RED);
                    } else if (ke.getKeyCode() == KeyEvent.VK_G) {
                    	gPressed  = true;
                    	rectList.get(4).setColorInt(Color.RED);
                    }
                    break;
                case KeyEvent.KEY_RELEASED:
                    if (ke.getKeyCode() == KeyEvent.VK_A) {
                        aPressed = false;
                        rectList.get(0).setColorInt(Color.BLACK);
                    } else if (ke.getKeyCode() == KeyEvent.VK_S) {
                    	sPressed  = false;
                    	rectList.get(1).setColorInt(Color.BLACK);
                    } else if (ke.getKeyCode() == KeyEvent.VK_D) {
                    	dPressed  = false;
                    	rectList.get(2).setColorInt(Color.BLACK);
                    } else if (ke.getKeyCode() == KeyEvent.VK_F) {
                    	fPressed  = false;
                    	rectList.get(3).setColorInt(Color.BLACK);
                    } else if (ke.getKeyCode() == KeyEvent.VK_G) {
                    	gPressed  = false;
                    	rectList.get(4).setColorInt(Color.BLACK);
                    }
                    break;
                }
                return false;
            }
        });
		
		try {
			scan =new Scanner(new File(textfile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int ta=0,ts=0,td=0,tf=0,tg=0;
		String temp;
		int i=0;
		while(scan.hasNextLine()){
			temp=scan.nextLine();
			System.out.println(temp);
			
			Scanner scan2=new Scanner(temp);
			while(scan2.hasNextInt()){
				if(i==0){
					ta++;
					timesA.add(scan2.nextInt());
				}
				if(i==1){
					ts++;
					timesS.add(scan2.nextInt());
				}
					
				if(i==2){
					td++;
					timesD.add(scan2.nextInt());
				}
					
				if(i==3){
					tf++;
					timesF.add(scan2.nextInt());
					
				}
				if(i==4){
					tg++;
					timesG.add(scan2.nextInt());
				}
					
			}
			
			i++;
		}
		setSize(600,700);
		
		 ab=new SoundThread(sound);
		 ab.sound.SetVolume(-5.0f);
         
		 timer.start();
		 ab.start();
		 
		
	}
	public GamePlay(String location,String textfile,StartFrame pencere,String background) {
		this(location,textfile,pencere);
		this.setIcon(new ImageIcon(background));
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (int i = 0; i < rectList.size(); i++) {
			g.setColor(rectList.get(i).getColorInt());
			//g.drawImage(fKey, rectList.get(i).getX(), rectList.get(i).getY()+20, this);
			
			g.fillRect(rectList.get(i).getX(), rectList.get(i).getY(), rectList.get(i).getWidth(), rectList.get(i).getHeight());
			g.setColor(Color.WHITE);
			g.drawRect(rectList.get(i).getX(), rectList.get(i).getY(), rectList.get(i).getWidth(), rectList.get(i).getHeight());
		}
		g.setColor(Color.ORANGE);
		/*
		g.drawRect(65, 570, 70, 70);
		g.drawRect(165, 570, 70, 70);
		g.drawRect(265, 570, 70, 70);
		g.drawRect(365, 570, 70, 70);
		g.drawRect(465, 570, 70, 70);
		*/
		
		Iterator<Rectangle> it=list.iterator();
		while(it.hasNext()){
			Rectangle temp2=it.next();
			
			g.fillRect((int) temp2.getX(), (int) temp2.getY(), 50, 30);
		}
		
		repaint();
		
	}
	public void newRectangle(int a,int y){
		Rectangle rect =new Rectangle(a,y,50,50);
		list.add(rect);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		time++;
		
		
		
		time2=ab.getTime()-712;
		if(time2==timesA.get(a)-2212){    //if rectangle Y's increasing with +2 use "-2850" with +3 use "-1900"
			newRectangle(75,0);
			
			
			//System.out.print(""+(timesA.get(a)-712)+"a");
			System.out.println("       "+(timesA.get(a)));
			a++;
		}
		if(time2==timesS.get(s)-2212){
			newRectangle(175,0);
			
			
			System.out.println("      s "+(timesS.get(s)));
			//System.out.print(""+(timesS.get(s)-712)+"s");
			//System.out.println("       "+time2);
			//System.out.println(s+"s");
			s++;
		}
		if(time2==timesD.get(d)-2212){
			newRectangle(275,0);
			System.out.println("      d "+(timesD.get(d)));
			//System.out.print(""+(timesD.get(d)-712)+"d");
			//System.out.println("       "+time2);
			//System.out.println(d+"d");
			d++;
		}
		if(time2==timesF.get(f)-2212){
			newRectangle(375,0);
			
			//System.out.print(""+(timesF.get(f)-712)+"f");
			//System.out.println("       "+time2);
			//System.out.println(f+"f");
			f++;
		}
		if(time2==timesG.get(g)-2212){
			newRectangle(475,0);
			//System.out.print(""+(timesG.get(g)-712)+"g");
			//System.out.println("       "+time2);
			//System.out.println(g);
			g++;
		}
		if(time%10==0){
			move();
		}if(time%10==0){
		check();
		
		}
		repaint();
		
		if(sound.clip.isActive()==false){
			ab.stop();
			timer.stop();
			backbutton.setBounds(218, 50, 164, 52);
			//Game over screen i yada ana menüye döndüren screen i çaðýracaðýz buradan
			
			
			try {
				scan3 =new Scanner(new File("highscores.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(scan3.hasNextInt()){
				scores.add(scan3.nextInt());
			}
			try{
				scores.add(score);
				Collections.sort(scores);
				Collections.reverse(scores);
				PrintWriter writer2 = new PrintWriter("highscores.txt", "UTF-8");
	    	    for(int i=0;i<scores.size();i++){
	    	    	writer2.println(scores.get(i));
	    	    }
	    	    writer2.close();
	    	} catch (IOException e1) {
	    	   // do something
	    	}
		}
	}
	
	public void stopMusic() {
		if (sound != null) {
			sound.StopSong();
		}
	}

	public void move(){
		Iterator<Rectangle> it=list.iterator();
		while(it.hasNext()){
			Rectangle temp2=it.next();
			temp2.setLocation((int)temp2.getX(), (int)temp2.getY()+8);    //speed
			
		}
	}
	public void check(){
		Iterator<Rectangle> it=list.iterator();
		while(it.hasNext()){
			Rectangle temp2=it.next();
			if (temp2.getY()<620 && temp2.getY()>560){
				int t = (int) temp2.getX();
				if (t > 0 && t < 100) {
					if (isAPressed()) {
						rectList.get(0).setColorInt(Color.GREEN);
						temp2.setLocation(1000000, 100000);
						System.out.println("          "+sound.GetTime());
						ab.sound.SetVolume(0.0f);
						score++;
						
					} else {
						rectList.get(0).setColorInt(new Color(Color.TRANSLUCENT));
						ab.sound.SetVolume(-10.0f);
						
						
						
					}
				} else if (t > 75 && t < 200) {
					if (isSPressed()) {
						
						rectList.get(1).setColorInt(Color.GREEN);
						temp2.setLocation(1000000, 100000);
						ab.sound.SetVolume(0.0f);
						score++;
					} else {
						
						ab.sound.SetVolume(-10.0f);
						rectList.get(1).setColorInt(new Color(Color.TRANSLUCENT));
						
					}
				}else if (t > 150 && t < 300) {
					if (isDPressed()) {
						rectList.get(2).setColorInt(Color.GREEN);
						temp2.setLocation(1000000, 100000);
						ab.sound.SetVolume(0.0f);
						score++;
					} else {
						ab.sound.SetVolume(-10.0f);
						rectList.get(2).setColorInt(new Color(Color.TRANSLUCENT));
						
						
					}
				}else if (t > 350 && t < 400) {
					if (isFPressed()) {
						rectList.get(3).setColorInt(Color.GREEN);
						ab.sound.SetVolume(0.0f);
						temp2.setLocation(1000000, 100000);
						score++;
					} else {
						rectList.get(3).setColorInt(new Color(Color.TRANSLUCENT));
						ab.sound.SetVolume(-10.0f);
						
					}
				}else if (t > 400 && t < 500) {
					if (isGPressed()) {
						rectList.get(4).setColorInt(Color.GREEN);
						temp2.setLocation(1000000, 100000);
						ab.sound.SetVolume(0.0f);
						score++;
					} else {
						rectList.get(4).setColorInt(new Color(Color.TRANSLUCENT));
						ab.sound.SetVolume(-10.0f);
						
					}
				}
				else{
					
				}
				
			   //temp2.setLocation(1000000, 100000);
			}
		}
	}

    public static boolean isAPressed() {
    	return aPressed;
    }
    
    public static boolean isSPressed() {
    	return sPressed;
    }
    
    public static boolean isDPressed() {
    	return dPressed;
    }
    
    public static boolean isFPressed() {
    	return fPressed;
    }
    
    public static boolean isGPressed() {
    	return gPressed;
    }
	

	
}
