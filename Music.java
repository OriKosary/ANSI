package AssistantStep1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.util.Scanner;

public class Music extends Thread{
	int pisotion=0 ;
	Player player;
	private String location;
	public Music( String location){
		this.location=location;
	}
	public void run(){


		try {
			FileInputStream fileInputStream = new FileInputStream(location);
			player = new Player(fileInputStream);
			player.play();
			pisotion = player.getPosition();

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(JavaLayerException e) {
			e.printStackTrace();
		}

	}   
	
	public int getPosition() {
		return player.getPosition();
	}
}
