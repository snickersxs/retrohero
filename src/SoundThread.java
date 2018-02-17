

public class SoundThread extends Thread {
	SoundPlayer sound;
	public SoundThread(SoundPlayer sound) {
		this.sound=sound;
	}

	@Override
	public void run() {
		do{
						 
			sound.StartSong();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}while(sound.clip.isActive());
			
			

	}
	public int getTime(){
		return (int) (sound.clip.getMicrosecondPosition()/1000);
	}

}
