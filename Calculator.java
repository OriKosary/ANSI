package AssistantStep1;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Calculator{
	private TextToSpeech tts;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	TextField tf = new TextField();
	JButton b;
	ActionListener al;
	JLabel Answer;
	String ans;
	boolean util = false;
	boolean util2 = false;
	boolean Continue = true;
	int Ans;

	public Calculator() {tts = new TextToSpeech();}

	// Set the voice of ANSI according to the decision of the user 
	public void setVoice(String voice) {
		tts.setVoice(voice);
	}

	// The main of the calculator 
	public boolean calculate() throws ScriptException {
		JFrame f = new JFrame("Calculator");
		f.setSize(750, 632);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tts.speak("Please enter your exercise here : ", 1.0f, false, true);
		System.out.println("Please enter ....");
		tf.setSize(300, 100);
		tf.setLocation(100, 100);
		b = new JButton("Submit");
		b.setSize(100, 100);
		b.setLocation(400, 200);
		JLabel stop = new JLabel("If you want to stop calculating please enter stop");
		stop.setLocation(400, 400);;
		f.add(tf);
		f.add(b);
		JButton d = new JButton();
		d.setVisible(false);
		f.add(d);
		al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals(b.getText()) && util == false) {
					boolean stop=false;
					while(stop==false) {

						ScriptEngineManager mgr = new ScriptEngineManager();
						ScriptEngine engine = mgr.getEngineByName("JavaScript");
						String Ex = tf.getText();
						String NotPossible = "/0";
						String notPossible1=":0";
						String notPossible2="\0";
						boolean tryToSolve = true;
						if (Ex.contains(NotPossible)==true||Ex.contains(notPossible1)==true||Ex.contains(notPossible2)==true) {
							tts.speak("Math error", 1.0f, false, true);
							tryToSolve = false;
							stop = true;
						}
						if (tryToSolve == true) {
							try {
								Ans = (int) (engine.eval(Ex)); // converting the string into an Integer
							} catch (ScriptException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
							ans = Integer.toString(Ans); // Back to string format for the voice answer
							tts.speak("The answer is " + ans, 1.0f, false, false);
							stop=true;
						}
					}
					//util = true;
				}
			}
		};
		b.addActionListener(al);
		return Continue;
	}

	public boolean isExRight() {
		JFrame f = new JFrame("Calculator");
		f.setSize(750, 632);
		f.setIconImage(new ImageIcon("C:\\Users\\oriko\\OneDrive\\Desktop\\AnsiPIC.jpg").getImage()); // pic of a calc
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tts.speak("Please enter your exercise here : ", 1.0f, false, true);
		System.out.println("Please enter ....");
		tf.setSize(300, 100);
		tf.setLocation(100, 100);
		b = new JButton("Submit");
		b.setSize(100, 100);
		b.setLocation(400, 200);
		JLabel stop = new JLabel("If you want to stop calculating please enter stop");
		stop.setLocation(400, 400);;
		f.add(tf);
		f.add(b);
		JButton d = new JButton();
		d.setVisible(false);
		f.add(d);
		boolean ExWrong = false;
		al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals(b.getText()) && util == false) {
					boolean stop=false;
					while(!stop) {
						ScriptEngineManager mgr = new ScriptEngineManager();
						ScriptEngine engine = mgr.getEngineByName("JavaScript");
						String Ex = tf.getText();
						String NotPossible = "/0";
						String notPossible1=":0";
						String notPossible2="\0";
						boolean check = true;
						if (Ex.contains(NotPossible)==true||Ex.contains(notPossible1)==true||Ex.contains(notPossible2)==true) {
							tts.speak("Math error, you cant divide by zero", 1.0f, false, true);
							check = false;
							stop = true;
						}
						if (check == true) {
							try {
								String str = Ex.trim(); // to elimanate unwanted stuff
								String digits="";
								char poula = ' ';
								boolean[] isDigit = new boolean[str.length()];
								for (int i = 0; i < isDigit.length; i++) {
									isDigit[i] = false;
								}
								String[] digitsSplitted = new String[str.length()];
								int place = 0;
								for (int i = 0; i < str.length(); i++) { // this will get all the numbers from a string
									char chrs = str.charAt(i);              
									if (Character.isDigit(chrs)) {
										digits = digits+chrs;
										isDigit[i] = true;
										digitsSplitted[place] = "" + chrs;
										place ++;
									}
									if (chrs == '+' || chrs == '-' || chrs == '*' || chrs == '/') {
										poula = chrs;
									}
								}
								String ExAfterFilter = " ";
								int util = 1;
								for (int i = 2; i < isDigit.length; i++) {
									if (isDigit[i-2] == true && poula != ' ' && isDigit[i] == true && isDigit[i-1] == false) {
										ExAfterFilter = digitsSplitted[util-1] + poula + digitsSplitted[util];
									}
								}
								Ans = (int) (engine.eval(ExAfterFilter));
								//System.out.println(digits.charAt(digits.length()-1));
								if ((char)(Ans + '0') == (digits.charAt(digits.length()-1))) {
									tts.speak("The targil is true", 1.0f, false, false);
								}
								else {
									tts.speak("The targil is not true the correcr answer is " + Ans, 1.0f, false, false);
								}

								stop = true;
							}
							catch (ScriptException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}

				}
			}
		};
		b.addActionListener(al);
		return ExWrong;
	}

	public void isExWrong2() {
		JFrame f = new JFrame("Calculator");
		f.setSize(750, 632);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tts.speak("Please enter your exercise here : ", 1.0f, false, true);
		System.out.println("Please enter ....");
		tf.setSize(300, 100);
		tf.setLocation(100, 100);
		b = new JButton("Submit");
		b.setSize(100, 100);
		b.setLocation(400, 200);
		JLabel stop = new JLabel("If you want to stop calculating please enter stop");
		stop.setLocation(400, 400);;
		f.add(tf);
		f.add(b);
		JButton d = new JButton();
		d.setVisible(false);
		f.add(d);
		al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand().equals(b.getText())) {
					boolean stop=false;
					while(stop==false) {

						ScriptEngineManager mgr = new ScriptEngineManager();
						ScriptEngine engine = mgr.getEngineByName("JavaScript");
						String Ex = tf.getText();
						String NotPossible = "/0";
						String notPossible1=":0";
						String notPossible2="\0";
						boolean tryToSolve = true;
						if (Ex.contains(NotPossible)==true||Ex.contains(notPossible1)==true||Ex.contains(notPossible2)==true) {
							tts.speak("Math error", 1.0f, false, true);
							tryToSolve = false;
							stop = true;
						}
						if (tryToSolve == true) {
							try {
								
								String[] Split = new String[2];
								Split = Ex.split("\\=");
								Ans = (int) (engine.eval(Split[0])); // converting the string into an Integer
								int Answer = (int) (engine.eval(Split[1])); // converting the string into an Integer
								if (Ans == Answer) {
									tts.speak("true", 1.0f, false, false);
								}
								else {
									tts.speak("false", 1.0f, false, false);
								}
								
							} catch (ScriptException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
						}
					}
				}
			}
		};
	}
}