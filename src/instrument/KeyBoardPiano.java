package instrument;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyBoardPiano {
	private static KeyBoardPiano piano;
	private List<KeyCode> key = new ArrayList<>();
	private Map<KeyCode, Note> notes = new HashMap<>();
	private int channel = 0;
	private SoundProvider sound = new SoundProvider(90);
//	private List<Integer> row1 = Arrays.asList(49,50,51,52,53,544,55,56,57,48,45,61);
//	private List<Integer> row2 = Arrays.asList(81,87,69,82,84,89,85,73,79,80,91,93);
//	private List<Integer> row3 = Arrays.asList(65,83,68,70,71,72,74,75,76,59,222,10);
	
	private KeyBoardPiano(){
		createDefaultNote();
	}
	
	private void createDefaultNote() {
		notes.put(KeyCode.A,new Note(KeyCode.A,NoteState.C,"Clow",4));
		notes.put(KeyCode.W,new Note(KeyCode.W,NoteState.Db,"Dblow",4));
		notes.put(KeyCode.S,new Note(KeyCode.S,NoteState.D,"Dlow",4));
		notes.put(KeyCode.E,new Note(KeyCode.E,NoteState.Eb,"Eblow",4));
		notes.put(KeyCode.D,new Note(KeyCode.D,NoteState.E,"Elow",4));
		notes.put(KeyCode.F,new Note(KeyCode.F,NoteState.F,"Flow",4));
		notes.put(KeyCode.T,new Note(KeyCode.T,NoteState.Gb,"Gblow",4));
		notes.put(KeyCode.G,new Note(KeyCode.G,NoteState.G,"Glow",4));
		notes.put(KeyCode.Y,new Note(KeyCode.Y,NoteState.Ab,"Ablow",4));
		notes.put(KeyCode.H,new Note(KeyCode.H,NoteState.A,"Alow",4));
		notes.put(KeyCode.U,new Note(KeyCode.U,NoteState.Bb,"Bblow",4));
		notes.put(KeyCode.J,new Note(KeyCode.J,NoteState.B,"Blow",4));
		notes.put(KeyCode.K,new Note(KeyCode.K,NoteState.C,"Cmedium",5));
		notes.put(KeyCode.O,new Note(KeyCode.O,NoteState.Db,"Dbmedium",5));
		notes.put(KeyCode.L,new Note(KeyCode.L,NoteState.D,"Dmedium",5));
		notes.put(KeyCode.P,new Note(KeyCode.P,NoteState.Eb,"Ebmedium",5));
		notes.put(KeyCode.SEMICOLON,new Note(KeyCode.SEMICOLON,NoteState.E,"Emedium",5));
		notes.put(KeyCode.QUOTE,new Note(KeyCode.QUOTE,NoteState.F,"Fmedium",5));
		notes.put(KeyCode.CLOSE_BRACKET,new Note(KeyCode.CLOSE_BRACKET,NoteState.Gb,"Gbmedium",5));
		notes.put(KeyCode.ENTER,new Note(KeyCode.ENTER,NoteState.G,"Gmedium",5));
		notes.put(KeyCode.BACK_SLASH,new Note(KeyCode.BACK_SLASH,NoteState.Ab,"Abmedium",5));
		notes.put(KeyCode.NUMPAD4,new Note(KeyCode.NUMPAD4,NoteState.A,"Amedium",5));
		notes.put(KeyCode.NUMPAD7,new Note(KeyCode.NUMPAD7,NoteState.Bb,"Bbmedium",5));
		notes.put(KeyCode.NUMPAD5,new Note(KeyCode.NUMPAD5,NoteState.B,"Bmedium",5));
		notes.put(KeyCode.NUMPAD6,new Note(KeyCode.NUMPAD6,NoteState.C,"Chigh",6));
		
	}
	
	public static KeyBoardPiano getInstance(){
		if(piano==null){
			piano = new KeyBoardPiano();
		} return piano;
	}
	
	public Map<KeyCode, Note> getAvailableNotes(){
		return this.notes;
	}

	public void keyPressed(KeyEvent e) {
		if(notes.containsKey(e.getCode())){
			if(!key.contains(e.getCode())){
//				System.out.println(e.getCode());
				key.add(e.getCode());
				sound.play(notes.get(e.getCode()).getNote());
			} 
		}
	}

	public void keyReleased(KeyEvent e) {
		if(notes.containsKey(e.getCode())){
			sound.stop(notes.get(e.getCode()).getNote());
			key.remove(e.getCode());
		}
	}

}
