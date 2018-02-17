

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {
	Clip clip = null;
	FloatControl gainControl;
	public SoundPlayer(String location) {
		File song =new File(location);
		
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (clip != null && song.isFile()) {
				clip.open(AudioSystem.getAudioInputStream(song));
			}
			
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		gainControl = 
			    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	}
	public void StartSong(){
		clip.start();
		
	}
	public void SetVolume(float a){
		
		gainControl.setValue(a);//-20.0f
	}
	public void StopSong(){
		clip.stop();
	}
	public long GetTime(){
		return clip.getMicrosecondPosition();
	}
	
}
