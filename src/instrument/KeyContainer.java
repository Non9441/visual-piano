package instrument;

import java.awt.event.KeyEvent;

public class KeyContainer {
	
	private KeyEvent e;
	private int counter = 0;
	
	public KeyContainer(KeyEvent e){
		this.e = e;
	}
	
	public KeyEvent getKey(){
		return this.e;
	}
	
	public void count(){
		this.counter++;
	}
	
	public int getCount(){
		return this.counter;
	}

}
