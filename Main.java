package AssistantStep1;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;

public class Main {

	@SuppressWarnings({ "deprecation", "deprecation" })
	public static void main (String[]args) throws FileNotFoundException, InterruptedException, JavaLayerException{
//		
//		Music music = new Music();
//		music.start();
//		while (true) {
//			Scanner keyboard = new Scanner(System.in);
//
//			
//
//			System.out.println("Stop music: ");
//			int off = keyboard.nextInt();
//
//			if(off == 0) {
//				music.stop();
//			}
//			else if (off == 1) {
//				music.stop();
//				 music = new Music();
//				music.run2();
//				music.start();
//			
//			}
//		}
		MusicPlayer music = new MusicPlayer();
		music.getAndPlay();
	}
	
}
