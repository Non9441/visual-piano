package instrument;

import javafx.scene.input.KeyCode;

/**
 * This class represent each note on piano.
 * It has it's own name, it's note and it's KeyCode to use on keyboard.
 * @author Non
 *
 */
public class Note {
	private KeyCode key;
	private NoteState state;
	private String name;
	private int octave;
	
	/**
	 * A Constructor to define new notes and it's value.
	 * @param key is a KeyCode represent which key this note are on keyboard.
	 * @param state is a note state for this note.
	 * @param name is a musical note name for this note.
	 * @param octave is integer represent which octave this note on.
	 */
	public Note(KeyCode key, NoteState state, String name, int octave){
		this.key = key;
		this.state = state;
		this.name = name;
		this.octave = octave;
	}
	
	/**
	 * get this note KeyCode.
	 * @return this note KeyCode.
	 */
	public KeyCode getKey(){
		return this.key;
	}
	
	/**
	 * increase an octave of this note.
	 */
	public void increaseOctave(){
		this.octave++;
	}
	
	/**
	 * decrease an octave of this note.
	 */
	public void decreaseOcctave(){
		this.octave--;
	}
	
	/**
	 * get current octave that this note are on.
	 * @return
	 */
	public int getOctave(){
		return octave;
	}
	
	/**
	 * get note value from this note after calculate with it's octave.
	 * @return integer of note value of this note.
	 */
	public int getNote(){
		return state.getNote(octave);
	}
	
	/**
	 * get this note name.
	 */
	public String toString(){
		return this.name;
	}
}
