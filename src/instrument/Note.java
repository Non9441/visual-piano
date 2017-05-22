package instrument;

import javafx.scene.input.KeyCode;

public class Note {
	private KeyCode key;
	private NoteState state;
	private String name;
	private int octave;
	
	public Note(KeyCode key, NoteState state, String name, int octave){
		this.key = key;
		this.state = state;
		this.name = name;
		this.octave = octave;
	}
	
	public KeyCode getKey(){
		return this.key;
	}
	
	public void increaseOctave(){
		this.octave++;
	}
	
	public void decreaseOcctave(){
		this.octave--;
	}
	
	public int getNote(){
		return state.getNote(octave);
	}
	
	public String toString(){
		return this.name;
	}
}
