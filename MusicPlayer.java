package AssistantStep1;
import java.io.FileInputStream;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
public class MusicPlayer  {
	static int TimePassed = 0;
	static FileInputStream fl;
	static int util = 0;
	static Player player;
	static boolean play = false;
	static String Location;
	static Music music ;
	static boolean stoped=false;
	static Scanner s = new Scanner(System.in);
	static TextToSpeech tts;
	private Thread t1;
	public MusicPlayer() throws FileNotFoundException, InterruptedException, JavaLayerException {
		tts = new TextToSpeech();
	}

	public void setVoice(String voice) {
		tts.setVoice(voice);
	}

	public  void getAndPlay() throws InterruptedException, FileNotFoundException, JavaLayerException  {
		tts.speak("Welcome to the music player", 1.0f, false, true);
		tts.speak("here you can play all of your favorite songs, please enter the location of the song here", 1.0f, false, false);
		JFrame frame = new JFrame("Get song");
		frame.setSize(333, 333);
		frame.setIconImage(new ImageIcon("C:\\Users\\oriko\\OneDrive\\Desktop\\AnsiPIC.jpg").getImage());
		frame.setVisible(true);
		TextField tf = new TextField();
		JPanel q=new JPanel();
		GridLayout two =new GridLayout(2,0);
		q.setLayout(two);

		JButton submit = new JButton("SUBMIT");
		q.add(tf);
		q.add(submit);
		q.setVisible(true);
		frame.add(q);

		ActionListener al4 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Location = tf.getText();
				try {
					frame.dispose();
					playSong(Location);
				} catch (FileNotFoundException | JavaLayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					tts.speak("File not found. please make sure you wrote double slashes", 1.0f, false, false);
				}
			}
		};
		submit.addActionListener(al4);
	}	
	public static void playSong(String Location) throws FileNotFoundException, JavaLayerException {
		JFrame f = new JFrame("Sa");
		f.setSize(333, 333);
		f.setIconImage(new ImageIcon("C:\\Users\\oriko\\OneDrive\\Desktop\\AnsiPIC.jpg").getImage());
		f.setVisible(true);
		JButton stop = new JButton("STOP");
		JButton Continue = new JButton("CONTINUE");
		JButton start = new JButton("START");

		GridLayout down=new GridLayout(0,2);
		f.setLayout(down);
		fl = new FileInputStream(Location);
		player = new Player(fl);
		ActionListener al = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				music.stop();
				stoped=true;
				System.out.println("A");
			}
		};
		stop.addActionListener(al);
		ActionListener al2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				music=new Music(Location);
				tts.speak("Playing", 1.0f, false, false);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				music.start();
				System.out.println("b");
			}
		};
		start.addActionListener(al2);
		ActionListener al3 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(stoped==true) {
						System.out.println(music.getPosition());
						int time=music.pisotion;
						Player play =new Player(fl);
						play.play(time);
					} }
				catch(JavaLayerException e1){
					e1.printStackTrace();
				}
				System.out.println("b");
			}

		};
		Continue.addActionListener(al3);

		start.setVisible(true);
		stop.setVisible(true);
		Continue.setVisible(true);
		f.add(start);
		f.add(stop);
		//f.add(Continue);
		f.setVisible(true);
	}
}
