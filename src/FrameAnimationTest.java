


import java.awt.HeadlessException;

import javax.swing.JFrame;

public class FrameAnimationTest extends JFrame {

	public FrameAnimationTest() throws HeadlessException {
		super();
		this.setBounds(150, 150, 600, 700);
		
	}

	
	public static void main(String[] args) {
		GamePlay play=new GamePlay();
		FrameAnimationTest frame=new FrameAnimationTest();
		frame.add(play);
		frame.setVisible(true);
		play.setVisible(true);
	}

}
