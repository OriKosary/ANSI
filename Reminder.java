package AssistantStep1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Reminder extends Thread implements ActionListener {

	private String time;

	private String hour1;
	private String minutes;

	public Reminder(){
		this.setScreen();

	}
	public String getTime() {
		return this.time;
	}
	
	public void setScreen() {
		JFrame window=new JFrame();
		GridLayout grid=new GridLayout(4,0);
		window.setLayout(grid);
		window.setVisible(true);

		Label text1=new Label("enter the hour that you want a reminder in");
		Label form=new Label("please enter 2 digits, like this:08");

		JButton submit=new JButton("submit");
		JButton submit1=new JButton("submit1");

		window.setSize(800, 800);
		window.add(text1);
		form.setVisible(true);
		window.add(form);
		TextField t=new TextField(200);
		t.setEditable(true);

		submit.setSize(50,90);
		window.add(t);
		submit1.addActionListener((new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				window.remove(t);
				window.add(t);
				minutes=t.getText().toString();

				window.remove(submit1);
				window.remove(t);
				text1.setText("your reminder is set");
				time=hour1+":"+minutes;
				System.out.println(time);
			}

		}));
		submit.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {

				window.remove(t);
				window.add(t);
				hour1=t.getText().toString();
				text1.setText("enter the minutes");
				submit.setEnabled(true);
				submit.setVisible(false);
				window.remove(submit);

				window.add(submit1);

				submit1.setVisible(true);
			}
		});


		t.setVisible(true);


		window.add(t);

		window.add(submit);
	}

	public String GetHour(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String time=  sdf.format(cal.getTime()) ;
		return time;
	}
	
	public void alarmFram ()  {
		JFrame f =new JFrame();
		f.setLayout(new GridLayout(3,0));
		f.setBackground(Color.orange);
		Label time=new Label();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		time.setText("00:00");
		time.setFont(new Font("TimesRoman", Font.PLAIN, 300));
		Label alarm=new Label();
		f.setIconImage(new ImageIcon("C:\\Users\\oriko\\OneDrive\\Desktop").getImage());
		alarm.setFont(new Font("TimesRoman", Font.PLAIN,300));
		alarm.setText("Time up");

		JButton b1=new JButton("stop");
		b1.setFont(new Font("TimesRoman", Font.PLAIN, 300));
		b1.setBackground(Color.orange);
		b1.setActionCommand("stop");
		Label empty=new Label("");
		f.setBackground(Color.ORANGE);
		time.setBackground(Color.ORANGE);
		alarm.setBackground(Color.ORANGE);
		b1.setBackground(Color.GRAY);

		f.add(alarm);
		f.add(empty);
		f.add(time);
		f.setSize(800,800);
		f.setVisible(true);
	}

	public boolean checkTime() throws InterruptedException {
		boolean corect=false;

		while(corect==false) {

			if(this.GetHour().equals(this.time)) {

				corect=true;
				this.alarmFram();

			}
			Thread.sleep(1000);
		}
		return corect;
	}
	
	public void start() {
		System.out.println("Starting 1" );
		try {

			System.out.println(this.checkTime());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}


