package instrument;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyBoardPiano implements KeyListener{
	private List<Integer> key = new ArrayList<>();
	private Map<Integer, Note> notes = new HashMap<>();
	private int channel = 0;
	private SoundProvider sound = new SoundProvider(90);
//	private List<Integer> row1 = Arrays.asList(49,50,51,52,53,544,55,56,57,48,45,61);
//	private List<Integer> row2 = Arrays.asList(81,87,69,82,84,89,85,73,79,80,91,93);
//	private List<Integer> row3 = Arrays.asList(65,83,68,70,71,72,74,75,76,59,222,10);
	
	public KeyBoardPiano(){
		createDefaultNote();
	}
	
	private void createDefaultNote() {
		notes.put(65,new Note(65,NoteState.C,"Low_C",4));
		notes.put(87,new Note(87,NoteState.CS,"Low_CS",4));
		notes.put(83,new Note(83,NoteState.D,"Low_D",4));
		notes.put(69,new Note(69,NoteState.DS,"Low_DS",4));
		notes.put(68,new Note(68,NoteState.E,"Low_E",4));
		notes.put(70,new Note(70,NoteState.F,"Low_F",4));
		notes.put(84,new Note(84,NoteState.FS,"Low_FS",4));
		notes.put(71,new Note(71,NoteState.G,"Low_G",4));
		notes.put(89,new Note(89,NoteState.GS,"Low_GS",4));
		notes.put(72,new Note(72,NoteState.A,"Low_A",4));
		notes.put(85,new Note(85,NoteState.AS,"Low_AS",4));
		notes.put(74,new Note(74,NoteState.B,"Low_B",4));
		notes.put(75,new Note(75,NoteState.C,"Medium_C",5));
		notes.put(79,new Note(79,NoteState.CS,"Medium_CS",5));
		notes.put(76,new Note(76,NoteState.D,"Medium_D",5));
		notes.put(80,new Note(80,NoteState.DS,"Medium_DS",5));
		notes.put(59,new Note(59,NoteState.E,"Medium_E",5));
		notes.put(222,new Note(222,NoteState.F,"Medium_F",5));
		notes.put(93,new Note(93,NoteState.FS,"Medium_FS",5));
		notes.put(10,new Note(10,NoteState.G,"Medium_G",5));
		notes.put(92,new Note(92,NoteState.GS,"Medium_GS",5));
		notes.put(100,new Note(100,NoteState.A,"Medium_A",5));
		notes.put(103,new Note(103,NoteState.AS,"Medium_AS",5));
		notes.put(101,new Note(101,NoteState.B,"Medium_B",5));
		notes.put(102,new Note(102,NoteState.C,"High_B",6));
		
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

	@Override
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
		if(notes.containsKey(e.getKeyCode())){
			if(!key.contains(e.getKeyCode())){
				System.out.println(e.getKeyCode());
				key.add(e.getKeyCode());
				sound.play(notes.get(e.getKeyCode()).getNote());
			} 
		}
	}

	@Override
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
		if(notes.containsKey(e.getKeyCode())){
			sound.stop(notes.get(e.getKeyCode()).getNote());
			key.remove((Integer)e.getKeyCode());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
