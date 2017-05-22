package instrument;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyBoardPiano {
	private List<KeyCode> key = new ArrayList<>();
	private Map<KeyCode, Note> notes = new HashMap<>();
	private int channel = 0;
	private SoundProvider sound = new SoundProvider(90);
//	private List<Integer> row1 = Arrays.asList(49,50,51,52,53,544,55,56,57,48,45,61);
//	private List<Integer> row2 = Arrays.asList(81,87,69,82,84,89,85,73,79,80,91,93);
//	private List<Integer> row3 = Arrays.asList(65,83,68,70,71,72,74,75,76,59,222,10);
	
	public KeyBoardPiano(){
		createDefaultNote();
	}
	
	private void createDefaultNote() {
		notes.put(KeyCode.A,new Note(KeyCode.A,NoteState.C,"Low_C",4));
		notes.put(KeyCode.W,new Note(KeyCode.W,NoteState.Db,"Low_Db",4));
		notes.put(KeyCode.S,new Note(KeyCode.S,NoteState.D,"Low_D",4));
		notes.put(KeyCode.E,new Note(KeyCode.E,NoteState.Eb,"Low_Eb",4));
		notes.put(KeyCode.D,new Note(KeyCode.D,NoteState.E,"Low_E",4));
		notes.put(KeyCode.F,new Note(KeyCode.F,NoteState.F,"Low_F",4));
		notes.put(KeyCode.T,new Note(KeyCode.T,NoteState.Gb,"Low_Gb",4));
		notes.put(KeyCode.G,new Note(KeyCode.G,NoteState.G,"Low_G",4));
		notes.put(KeyCode.Y,new Note(KeyCode.Y,NoteState.Ab,"Low_Ab",4));
		notes.put(KeyCode.H,new Note(KeyCode.H,NoteState.A,"Low_A",4));
		notes.put(KeyCode.U,new Note(KeyCode.U,NoteState.Bb,"Low_Bb",4));
		notes.put(KeyCode.J,new Note(KeyCode.J,NoteState.B,"Low_B",4));
		notes.put(KeyCode.K,new Note(KeyCode.K,NoteState.C,"Medium_C",5));
		notes.put(KeyCode.O,new Note(KeyCode.O,NoteState.Db,"Medium_Db",5));
		notes.put(KeyCode.L,new Note(KeyCode.L,NoteState.D,"Medium_D",5));
		notes.put(KeyCode.P,new Note(KeyCode.P,NoteState.Eb,"Medium_Eb",5));
		notes.put(KeyCode.SEMICOLON,new Note(KeyCode.SEMICOLON,NoteState.E,"Medium_E",5));
		notes.put(KeyCode.QUOTE,new Note(KeyCode.QUOTE,NoteState.F,"Medium_F",5));
		notes.put(KeyCode.CLOSE_BRACKET,new Note(KeyCode.CLOSE_BRACKET,NoteState.Gb,"Medium_Gb",5));
		notes.put(KeyCode.ENTER,new Note(KeyCode.ENTER,NoteState.G,"Medium_G",5));
		notes.put(KeyCode.BACK_SLASH,new Note(KeyCode.BACK_SLASH,NoteState.Ab,"Medium_Ab",5));
		notes.put(KeyCode.NUMPAD4,new Note(KeyCode.NUMPAD4,NoteState.A,"Medium_A",5));
		notes.put(KeyCode.NUMPAD7,new Note(KeyCode.NUMPAD7,NoteState.Bb,"Medium_Bb",5));
		notes.put(KeyCode.NUMPAD5,new Note(KeyCode.NUMPAD5,NoteState.B,"Medium_B",5));
		notes.put(KeyCode.NUMPAD6,new Note(KeyCode.NUMPAD6,NoteState.C,"High_B",6));
		
	}

//	public NoteState notePress(KeyEvent e){
//		int code = e.getKeyCode();
//		switch(code){
//		case 65:
//		case 81:
//		case 49:
//			return NoteState.C;
//		case 83:
//		case 87:
//		case 50:
//			return NoteState.CS;
//		case 68:
//		case 69:
//		case 51:
//			return NoteState.D;
//		case 70:
//		case 82:
//		case 52:
//			return NoteState.DS;
//		case 71:
//		case 84:
//		case 53:
//			return NoteState.E;
//		case 72:
//		case 89:
//		case 54:
//			return NoteState.F;
//		case 74:
//		case 85:
//		case 55:
//			return NoteState.FS;
//		case 75:
//		case 73:
//		case 56:
//			return NoteState.G;
//		case 76:
//		case 79:
//		case 57:
//			return NoteState.GS;
//		case 59:
//		case 80:
//		case 48:
//			return NoteState.A;
//		case 222:
//		case 91:
//		case 45:
//			return NoteState.AS;
//		case 10:
//		case 93:
//		case 61:
//			return NoteState.B;
//		}
//		return NoteState.C;
//	}

	public void keyPressed(KeyEvent e) {
//		System.out.println(e.getKeyCode());
//		if(row1.contains(e.getKeyCode())){
//			if(!key.contains(e.getKeyCode())){
//				key.add(e.getKeyCode());
//				sound.play(notePress(e).getNote(4), 0);
//			} 
//		}
//		if(row2.contains(e.getKeyCode())){
//			if(!key.contains(e.getKeyCode())){
//				key.add(e.getKeyCode());
//				sound.play(notePress(e).getNote(5), 0);
//			} 
//		}
//		if(row3.contains(e.getKeyCode())){
//			if(!key.contains(e.getKeyCode())){
//				key.add(e.getKeyCode());
//				sound.play(notePress(e).getNote(6), 0);
//			} 
//		}
		if(notes.containsKey(e.getCode())){
			if(!key.contains(e.getCode())){
				System.out.println(e.getCode());
				key.add(e.getCode());
				sound.play(notes.get(e.getCode()).getNote());
			} 
		}
	}

	public void keyReleased(KeyEvent e) {
//		if(row1.contains(e.getKeyCode())){
//			sound.stop(notePress(e).getNote(4), 0);
//			key.remove((Integer)e.getKeyCode());
//			count = 0;
//		}
//		if(row2.contains(e.getKeyCode())){
//			sound.stop(notePress(e).getNote(5), 0);
//			key.remove((Integer)e.getKeyCode());
//			count = 0;
//		}
//		if(row3.contains(e.getKeyCode())){
//			sound.stop(notePress(e).getNote(6), 0);
//			key.remove((Integer)e.getKeyCode());
//			count = 0;
//		}
		if(notes.containsKey(e.getCode())){
			sound.stop(notes.get(e.getCode()).getNote());
			key.remove(e.getCode());
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
