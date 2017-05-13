package testGUI;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

import instrument.KeyBoardPiano;

public class UI {

	private JFrame frame;
	
	public UI(){
		initcomponent();
	}

	private void initcomponent() {
		KeyListener key = new KeyBoardPiano();
		frame = new JFrame();
		frame.addKeyListener(key);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
	}
	
	public void run(){
		frame.setVisible(true);
	}

}
