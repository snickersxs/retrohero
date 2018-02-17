In RetroHero you can play songs with pressing buttons. You have three different song 1)Super Mario 2) Starwars 3) Affet(Müslüm Gürses)
 Our goal is pressing buttons at the right time. We used different methods to provide realism to the user.( We will talk about them later in the text.)

In this game we used 9 different classes. First of all we used swing library for java GUI. In Main class we create an object of class that contains frame to start the game.  NotMain class contains MainScreen of game. In HowToPlay class that contains How to Play button in main screen. GamePlay class is the biggest class in game because it contains game screen (rythm boxes playing sound etc.) With iterator and LinkedList we have been able to draw the objet immediately. 

	LinkedList<Rectangle> list = new LinkedList<Rectangle>();

Iterator<Rectangle> it=list.iterator();
		while(it.hasNext()){
			Rectangle temp2=it.next();
			
			g.fillRect((int) temp2.getX(), (int) temp2.getY(), 50, 30);
		}
		
		repaint();
		
	}


MainRectangles class help to us for flowing boxes in this class we used ArrayList to hold boxes. In sound classes we set playing sound in syncronized with boxes. For syncronization first of all we played song once with KeyDeneme class  and saved to .txt file. The boxes are sliding down as we specified. Boxes appear according to txt file. So we feel reality in game. If you press true button at the right time your box will be green, if you dont press the true button your box will be red and your sound will be low. For this stuation we used this code :
public void SetVolume(float a){
		
		gainControl.setValue(a);//-20.0f
	}
We had some problems with swing library. For example swing library’s sound player has problems. Sometimes we had sync problems between music and boxes.
For background and images we used canva.com and textcraft.com websites. We used musics in .wav format because javax.sound libraries support only .wav format.

