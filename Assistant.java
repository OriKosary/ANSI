package AssistantStep1;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.script.ScriptException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;

public class Assistant {
	private Calculator calc;
	private FileReaderO fish;
	private String userName;
	private TextToSpeech tts;
	private Reminder reminder;
	private MusicPlayer mp;
	// Universal p
	Scanner s;	
	boolean stop = false; // program
	TextField tf;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	public Assistant() {
		calc = new Calculator();
		tts = new TextToSpeech();
		fish = new FileReaderO();
		try {
			mp = new MusicPlayer();
		} catch (FileNotFoundException | InterruptedException | JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void assist() throws MalformedURLException, InterruptedException {
		part1();
		URL url = new URL("https://cdn.dribbble.com/users/341264/screenshots/2203511/wave.gif");
		Icon icon = new ImageIcon(url);
		JLabel label = new JLabel(icon);
		JFrame f = new JFrame("INTRODUCATION");
		f.getContentPane().setLayout(new GridLayout(2, 1));
		JPanel upPannel = new JPanel();
		upPannel.add(label);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(screenSize);
		f.setIconImage(new ImageIcon("C:\\Users\\oriko\\OneDrive\\Desktop\\AnsiPIC.jpg").getImage());
		f.setVisible(true);
		f.getContentPane().add(upPannel);
		tts.speak("Hello I am ANSI your personal artificial intelligence", 1.0f, false, true);
		tts.speak("we are starting right now an introudaction and adjustment proccess, please answer the following questions", 1.0f, false, true);
		tts.speak("first, what is your name?", 1.0f, false, false); 
		JFrame f1 = new JFrame();
		GridLayout grid=new GridLayout(2,0);
		f1.setSize(300,300);
		f1.setLayout(grid);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel upLabel = new JLabel("Please enter your name");
		upLabel.setVisible(true);
		tf = new TextField();
		tf.setVisible(true);
		f1.add(upLabel);
		f1.add(tf);
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tf.getText() != null) {
					setUserName(tf.getText());
					f1.dispose();
					tts.speak("okay " + userName + "what should my gender be ?", 1.0f, false, true);
					tts.speak("Male sounds like this", 1.0f, false,true);
					tts.setVoice("dfki-poppy-hsmm");
					tts.speak("Female sounds like this", 1.0f, false, false);
					JFrame f2 = new JFrame("Gender selection");
					f2.setSize(800, 800);
					JButton setMale = new JButton("Male");
					JButton setFemale = new JButton("Female");
					JButton reHear = new JButton("Hear again");
					JPanel downPannel = new JPanel();
					downPannel.add(setMale);
					downPannel.add(setFemale);
					downPannel.add(reHear);
					f2.getContentPane().add(downPannel);
					f2.setVisible(true);
					f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setMale.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
							//Here goes the action (method) you want to execute when clicked
							tts.setVoice("cmu-rms-hsmm"); // set the voice to male
							f2.dispose();
							f.dispose();
							try {
								program();
							} catch (ScriptException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					setFemale.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
							//Here goes the action (method) you want to execute when clicked
							tts.setVoice("dfki-poppy-hsmm"); // set the voice to female
							calc.setVoice("dfki-poppy-hsmm");
							fish.setVoice("dfki-poppy-hsmm");
							mp.setVoice("dfki-poppy-hsmm");
							f2.dispose();	
							f.dispose();
							try {
								program();
							} catch (ScriptException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});
					reHear.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
							tts.setVoice("cmu-rms-hsmm"); 
							tts.speak("Male sounds like this", 1.0f, false,true);
							tts.setVoice("dfki-poppy-hsmm");
							tts.speak("Female sounds like this", 1.0f, false, false);
						}
					});
				}
			};
		};
		tf.addActionListener(al);
	}

	public void part1() throws MalformedURLException, InterruptedException {
		URL url = new URL("https://leonzandman.files.wordpress.com/2014/04/personaassets720x1280_circle_siri1_10.gif");
		Icon icon = new ImageIcon(url);
		JLabel label = new JLabel(icon);
		JFrame f = new JFrame("Animation");
		f.getContentPane().add(label);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setIconImage(new ImageIcon("C:\\Users\\oriko\\OneDrive\\Desktop\\AnsiPIC.jpg").getImage());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setSize(284, 332);
		f.setVisible(true);
		Thread.sleep(2000);
		f.setVisible(false);
	}

	public void program() throws ScriptException, IOException {
		URL url = new URL("https://i.pinimg.com/originals/77/9c/c5/779cc579ae3da9dba7f44b1b740029e7.gif");
		Icon icon = new ImageIcon(url);
		JLabel label = new JLabel(icon);
		JFrame f = new JFrame("Animation");
		GridLayout grid = new GridLayout(2,0);
		f.setLayout(grid);

		f.setSize(screenSize);
		f.setIconImage(new ImageIcon("C:\\Users\\oriko\\OneDrive\\Desktop\\AnsiPIC.jpg").getImage());
		f.getContentPane().add(label);
		tts.speak(this.userName + "I can offer you four diffrent types of help for now. The calculator the file reader the reminder and the music player, Please select the program  you want to use. If you'd like an explenation of each program press Help", 1.0f, false, false);
		s = new Scanner(System.in);
		JButton calculator = new JButton("Calculator");
		JButton fileReader = new JButton("File Reader");
		JButton help = new JButton("Help");
		JButton reminder = new JButton("Reminder");
		JButton musicPlayer = new JButton("Music Player");
		JPanel buttons=new JPanel();
		GridLayout down=new GridLayout(0,5);
		buttons.setLayout(down);
		f.add(label);
		buttons.add(calculator);
		buttons.add(fileReader);
		buttons.add(reminder);
		buttons.add(musicPlayer);
		buttons.add(help);
		buttons.setVisible(true);
		f.add(buttons);
		f.setVisible(true);
		calculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//Here goes the action (method) you want to execute when clicked
				try {
					calc.calculate();
				} catch (ScriptException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				stop = true;
			}
		});
		musicPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//Here goes the action (method) you want to execute when clicked
				try {
					mp.getAndPlay();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JavaLayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				stop = true;
			}
		});
		fileReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//Here goes the action (method) you want to execute when clicked
				try {
					fish.readFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				stop = true;
			}
		});
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//Here goes the action (method) you want to execute when clicked
				JFrame f = new JFrame("Help");
				f.setSize(450, 450);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				tts.speak("The file reader can search a key word that you enter to it and find it in a file, then it will print you all the sentences that contains that word saving you a lot of time and effort!", 1.0f, false, true);
				JLabel l1 = new JLabel("The file reader can search a key word that you enter to it and find it in a file, then it will print you all the sentences that contains that word saving you a lot of time and effort!");
				f.add(l1);
				tts.speak("The calculator can calculate any math problom you got", 1.0f, false, true);
				tts.speak("with the reminder you can set alarms at any time of the day", 1.0f, false, true);
				tts.speak("The music player can play any song you would like", 1.0f, false, false);
				JLabel l2 = new JLabel("The calculator can calculate any math problom you got ");
				f.add(l2);
			}
		});
		reminder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				//Here goes the action (method) you want to execute when clicked
				Assistant.this.reminder = new Reminder();
				Assistant.this.reminder.start();

			}
		});
	}
}

