package instrument;

public class Note {
	private int keycode;
	private NoteState state;
	private String name;
	private int octave;
	
	public Note(int keycode, NoteState state, String name, int octave){
		this.keycode = keycode;
		this.state = state;
		this.name = name;
		this.octave = octave;
	}
	
	public int getKeycode(){
		return this.keycode;
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
