package instrument;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.Synthesizer;

public class KeyBoardPiano implements KeyListener{
	private List<Integer> key = new ArrayList<>();
	private int count = 0;
	private int channel = 0;
	private SoundProvider sound = new SoundProvider(90);
	private List<Integer> row1 = Arrays.asList(49,50,51,52,53,54,55,56,57,48,45,61);
	private List<Integer> row2 = Arrays.asList(81,87,69,82,84,89,85,73,79,80,91,93);
	private List<Integer> row3 = Arrays.asList(65,83,68,70,71,72,74,75,76,59,222,10);
	
	public NoteState notePress(KeyEvent e){
		int code = e.getKeyCode();
		switch(code){
		case 65:
		case 81:
		case 49:
			return NoteState.C;
		case 83:
		case 87:
		case 50:
			return NoteState.CS;
		case 68:
		case 69:
		case 51:
			return NoteState.D;
		case 70:
		case 82:
		case 52:
			return NoteState.DS;
		case 71:
		case 84:
		case 53:
			return NoteState.E;
		case 72:
		case 89:
		case 54:
			return NoteState.F;
		case 74:
		case 85:
		case 55:
			return NoteState.FS;
		case 75:
		case 73:
		case 56:
			return NoteState.G;
		case 76:
		case 79:
		case 57:
			return NoteState.GS;
		case 59:
		case 80:
		case 48:
			return NoteState.A;
		case 222:
		case 91:
		case 45:
			return NoteState.AS;
		case 10:
		case 93:
		case 61:
			return NoteState.B;
		}
		return NoteState.C;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(row1.contains(e.getKeyCode())){
			if(!key.contains(e.getKeyCode())){
				key.add(e.getKeyCode());
				sound.play(notePress(e).getNote(4), 0);
			} 
		}
		if(row2.contains(e.getKeyCode())){
			if(!key.contains(e.getKeyCode())){
				key.add(e.getKeyCode());
				sound.play(notePress(e).getNote(5), 0);
			} 
		}
		if(row3.contains(e.getKeyCode())){
			if(!key.contains(e.getKeyCode())){
				key.add(e.getKeyCode());
				sound.play(notePress(e).getNote(6), 0);
			} 
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(row1.contains(e.getKeyCode())){
			sound.stop(notePress(e).getNote(4), 0);
			key.remove((Integer)e.getKeyCode());
			count = 0;
		}
		if(row2.contains(e.getKeyCode())){
			sound.stop(notePress(e).getNote(5), 0);
			key.remove((Integer)e.getKeyCode());
			count = 0;
		}
		if(row3.contains(e.getKeyCode())){
			sound.stop(notePress(e).getNote(6), 0);
			key.remove((Integer)e.getKeyCode());
			count = 0;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
