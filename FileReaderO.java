package AssistantStep1;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FileReaderO {

	private BufferedReader reader;
	private TextToSpeech tts;
	private FileReader file1;
	private int level;
	public FileReaderO() {
		tts = new TextToSpeech();
	}

	// Set the voice of ANSI according to the decision of the user 
	public void setVoice(String voice) {
		tts.setVoice(voice);
	}

	// This will get a file location, name and key word from the user and will print all the sentences that contains this word 
	public boolean readFile() throws IOException {
		boolean countinue = true;
		JFrame f = new JFrame("File reader");
		f.setIconImage(new ImageIcon("C:\\Users\\oriko\\OneDrive\\Desktop").getImage());
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridLayout grid=new GridLayout(4,0);
		f.setLayout(grid);
		TextField t=new TextField();
		JButton submit=new JButton("submit");
		tts.speak("Hello ,welcome to the file reader with this program you can to search words that you want to find in a file!", 1.0f, false, true);
		tts.speak("Please enter the location and the name of the file you want to search", 1.0f, false, false);
		JLabel label=new JLabel("Please enter the location of the file and it's name with double \\ and at the end add .txt. For example : ,if you dont know how to find the location enter location and press submit");
		JLabel label2=new JLabel("C:\\\\Users\\\\oriko\\\\OneDrive\\\\Desktop\\\\file name.txt");
		level=0;

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String input = t.getText().toString();
				String[] spleat=null;
				if(level ==0) {

					String location=t.getText().toString();
					try {
						file1 = new FileReader(location);
						level++;
					}
					catch(Exception e1) {
						label.setText("the file not found try again");
						tts.speak("enter the location and the name of the file you want to search in", 1.0f, false, false);
						label2.setText(("Please enter the location of the file and it's name with double \\ and at the end add .txt. For example : "));
					}


				}
				else if(level==1) {
					tts.speak("Please enter the word you want to search in the text", 1.0f, false, false);
					label.setText( ("Enter the word you want to search in the text here : "));
					level++;
				}
				else if(level==2) {
					String keyWord = t.getText().toString();

					reader=new BufferedReader(file1);
					boolean searching = true;
					String line="";
					String line1 = null;
					while (searching == true) {
						try {
							line1=reader.readLine();
							line =line+line1;
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						if (line1 == null) {
							searching=false;
						}
						else {}
					}
					spleat=line.split("\\.");
					JFrame results = new JFrame();
					int times=0;
					int t=0;
					String[] spleat1=new String[spleat.length];
					results.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					for( int i1=0; i1 < spleat.length; i1++) {
						if (spleat[i1].indexOf(keyWord)!=-1) { // this condition is to filter all the lines that contians the keyword
							spleat1[t]=spleat[i1];
							times++;
							t++;
						}

					}
					JLabel[] labelsArr=new JLabel[times]; 
					for(int i1=0;i1<times;i1++) {
						labelsArr[i1]=new JLabel(spleat1[i1]);
						labelsArr[i1].setVisible(true);
					}
					GridLayout	grid1=new GridLayout(labelsArr.length+1,0);
					results.setLayout(grid1);
					JLabel label3=new JLabel("the results:");
					label3.setVisible(true);
					results.add(label3);
					for (int j = 0; j < labelsArr.length; j++) {
						results.add(labelsArr[j]);
					}
					submit.setText("close");
					results.setSize(800, 800);
					results.setVisible(true);
					level++;

				}
				else {
					f.setVisible(false);
					tts.speak("thank you for using the file reder",1.0f,false ,false);

				}
			}

		});
		label.setVisible(true);
		label2.setVisible(true);
		submit.setVisible(true);
		t.setVisible(true);
		f.add(label);
		f.add(label2);
		f.add(submit);
		f.add(t);
		f.setSize(800, 800);
		f.setIconImage(new ImageIcon("C:\\Users\\oriko\\OneDrive\\Desktop\\AnsiPIC.jpg").getImage());
		f.setVisible(true);

		return countinue;
	}
}
