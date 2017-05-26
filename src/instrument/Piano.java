package instrument;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A Piano class gives contain all available notes and it's key.
 * 
 * @author Non
 *
 */
public class Piano {
	private static Piano piano;
	private SoundProvider sound = new SoundProvider(90);
	private List<KeyCode> key = new ArrayList<>();
	private Map<KeyCode, Note> notes = new ConcurrentHashMap<>();

	private Piano() {
		createDefaultNote();
	}

	/**
	 * create all default notes and put it in a map that has KeyCode as a value.
	 */
	private void createDefaultNote() {
		notes.put(KeyCode.A, new Note(KeyCode.A, NoteState.C, "clow", 4));
		notes.put(KeyCode.W, new Note(KeyCode.W, NoteState.Db, "dblow", 4));
		notes.put(KeyCode.S, new Note(KeyCode.S, NoteState.D, "dlow", 4));
		notes.put(KeyCode.E, new Note(KeyCode.E, NoteState.Eb, "eblow", 4));
		notes.put(KeyCode.D, new Note(KeyCode.D, NoteState.E, "elow", 4));
		notes.put(KeyCode.F, new Note(KeyCode.F, NoteState.F, "flow", 4));
		notes.put(KeyCode.T, new Note(KeyCode.T, NoteState.Gb, "gblow", 4));
		notes.put(KeyCode.G, new Note(KeyCode.G, NoteState.G, "glow", 4));
		notes.put(KeyCode.Y, new Note(KeyCode.Y, NoteState.Ab, "ablow", 4));
		notes.put(KeyCode.H, new Note(KeyCode.H, NoteState.A, "alow", 4));
		notes.put(KeyCode.U, new Note(KeyCode.U, NoteState.Bb, "bblow", 4));
		notes.put(KeyCode.J, new Note(KeyCode.J, NoteState.B, "blow", 4));
		notes.put(KeyCode.K, new Note(KeyCode.K, NoteState.C, "cmedium", 5));
		notes.put(KeyCode.O, new Note(KeyCode.O, NoteState.Db, "dbmedium", 5));
		notes.put(KeyCode.L, new Note(KeyCode.L, NoteState.D, "dmedium", 5));
		notes.put(KeyCode.P, new Note(KeyCode.P, NoteState.Eb, "ebmedium", 5));
		notes.put(KeyCode.SEMICOLON, new Note(KeyCode.SEMICOLON, NoteState.E, "emedium", 5));
		notes.put(KeyCode.QUOTE, new Note(KeyCode.QUOTE, NoteState.F, "fmedium", 5));
		notes.put(KeyCode.CLOSE_BRACKET, new Note(KeyCode.CLOSE_BRACKET, NoteState.Gb, "gbmedium", 5));
		notes.put(KeyCode.ENTER, new Note(KeyCode.ENTER, NoteState.G, "gmedium", 5));
		notes.put(KeyCode.BACK_SLASH, new Note(KeyCode.BACK_SLASH, NoteState.Ab, "abmedium", 5));
		notes.put(KeyCode.NUMPAD4, new Note(KeyCode.NUMPAD4, NoteState.A, "amedium", 5));
		notes.put(KeyCode.NUMPAD7, new Note(KeyCode.NUMPAD7, NoteState.Bb, "bbmedium", 5));
		notes.put(KeyCode.NUMPAD5, new Note(KeyCode.NUMPAD5, NoteState.B, "bmedium", 5));
		notes.put(KeyCode.NUMPAD6, new Note(KeyCode.NUMPAD6, NoteState.C, "chigh", 6));

	}

	public Set<String> getAllnames() {
		Set<String> names = new HashSet<>();
		for (KeyCode k : getAvailableKey()) {
			names.add(notes.get(k).toString());
		}
		return names;
	}

	public void setNote(String name, KeyCode key) {
		for (KeyCode k : getAvailableKey()) {
			if (notes.get(k).toString().equals(name)) {
				notes.put(key, notes.remove(k));
			}
		}
	}

	/**
	 * get this piano object.
	 * 
	 * @return an object of this piano.
	 */
	public static Piano getInstance() {
		if (piano == null) {
			piano = new Piano();
		}
		return piano;
	}

	/**
	 * get all available KeyCode in notes.
	 * 
	 * @return
	 */
	public Set<KeyCode> getAvailableKey() {
		return notes.keySet();
	}

	/**
	 * get a map that contain all notes.
	 * 
	 * @return map that contain all notes.
	 */
	public Map<KeyCode, Note> getAvailableNotes() {
		return this.notes;
	}

	public void keyPressed(KeyEvent e) {
		if (notes.containsKey(e.getCode())) {
			if (!key.contains(e.getCode())) {
				key.add(e.getCode());
				sound.play(notes.get(e.getCode()).getNote());
			}
		}
	}

	public void keyPressed(String note) {
		for (KeyCode k : getAvailableKey()) {
			if (notes.get(k).toString().equals(note)) {
				sound.play(notes.get(k).getNote());
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if (notes.containsKey(e.getCode())) {
			sound.stop(notes.get(e.getCode()).getNote());
			key.remove(e.getCode());
		}
	}

	public void keyReleased(String note) {
		for (KeyCode k : getAvailableKey()) {
			if (notes.get(k).toString().equals(note)) {
				sound.stop(notes.get(k).getNote());
			}
		}
	}

}
