package instrument;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A Piano class gives contain all available notes and it's key.
 * @author Non
 *
 */
public class Piano {
	private static Piano piano;
	private SoundProvider sound = new SoundProvider(90);
	private List<KeyCode> key = new ArrayList<>();
	private Map<KeyCode, Note> notes = new ConcurrentHashMap<>();
	private ResourceBundle rb = ResourceBundle.getBundle("piano");
	private Properties prob = new Properties();
	private FileInputStream in;
	private FileOutputStream out;
	
	private Piano(){
		createDefaultNote();
	}
	
	/**
	 * create all default notes and put it in a map that has KeyCode as a value.
	 */
	private void createDefaultNote() {
		notes.put(KeyCode.getKeyCode(rb.getString("clow")),new Note(KeyCode.getKeyCode(rb.getString("clow")),NoteState.C,"Clow",4));
		notes.put(KeyCode.getKeyCode(rb.getString("dblow")),new Note(KeyCode.getKeyCode(rb.getString("dblow")),NoteState.Db,"Dblow",4));
		notes.put(KeyCode.getKeyCode(rb.getString("dlow")),new Note(KeyCode.getKeyCode(rb.getString("dlow")),NoteState.D,"Dlow",4));
		notes.put(KeyCode.getKeyCode(rb.getString("eblow")),new Note(KeyCode.getKeyCode(rb.getString("eblow")),NoteState.Eb,"Eblow",4));
		notes.put(KeyCode.getKeyCode(rb.getString("elow")),new Note(KeyCode.getKeyCode(rb.getString("elow")),NoteState.E,"Elow",4));
		notes.put(KeyCode.getKeyCode(rb.getString("flow")),new Note(KeyCode.getKeyCode(rb.getString("flow")),NoteState.F,"Flow",4));
		notes.put(KeyCode.getKeyCode(rb.getString("gblow")),new Note(KeyCode.getKeyCode(rb.getString("gblow")),NoteState.Gb,"Gblow",4));
		notes.put(KeyCode.getKeyCode(rb.getString("glow")),new Note(KeyCode.getKeyCode(rb.getString("glow")),NoteState.G,"Glow",4));
		notes.put(KeyCode.getKeyCode(rb.getString("ablow")),new Note(KeyCode.getKeyCode(rb.getString("ablow")),NoteState.Ab,"Ablow",4));
		notes.put(KeyCode.getKeyCode(rb.getString("alow")),new Note(KeyCode.getKeyCode(rb.getString("alow")),NoteState.A,"Alow",4));
		notes.put(KeyCode.getKeyCode(rb.getString("bblow")),new Note(KeyCode.getKeyCode(rb.getString("bblow")),NoteState.Bb,"Bblow",4));
		notes.put(KeyCode.getKeyCode(rb.getString("blow")),new Note(KeyCode.getKeyCode(rb.getString("blow")),NoteState.B,"Blow",4));
		notes.put(KeyCode.getKeyCode(rb.getString("cmedium")),new Note(KeyCode.getKeyCode(rb.getString("cmedium")),NoteState.C,"Cmedium",5));
		notes.put(KeyCode.getKeyCode(rb.getString("dbmedium")),new Note(KeyCode.getKeyCode(rb.getString("dbmedium")),NoteState.Db,"Dbmedium",5));
		notes.put(KeyCode.getKeyCode(rb.getString("dmedium")),new Note(KeyCode.getKeyCode(rb.getString("dmedium")),NoteState.D,"Dmedium",5));
		notes.put(KeyCode.getKeyCode(rb.getString("ebmedium")),new Note(KeyCode.getKeyCode(rb.getString("ebmedium")),NoteState.Eb,"Ebmedium",5));
		notes.put(KeyCode.getKeyCode(rb.getString("emedium")),new Note(KeyCode.getKeyCode(rb.getString("emedium")),NoteState.E,"Emedium",5));
		notes.put(KeyCode.getKeyCode(rb.getString("fmedium")),new Note(KeyCode.getKeyCode(rb.getString("fmedium")),NoteState.F,"Fmedium",5));
		notes.put(KeyCode.getKeyCode(rb.getString("gbmedium")),new Note(KeyCode.getKeyCode(rb.getString("gbmedium")),NoteState.Gb,"Gbmedium",5));
		notes.put(KeyCode.getKeyCode(rb.getString("gmedium")),new Note(KeyCode.getKeyCode(rb.getString("gmedium")),NoteState.G,"Gmedium",5));
		notes.put(KeyCode.getKeyCode(rb.getString("abmedium")),new Note(KeyCode.getKeyCode(rb.getString("abmedium")),NoteState.Ab,"Abmedium",5));
		notes.put(KeyCode.getKeyCode(rb.getString("amedium")),new Note(KeyCode.getKeyCode(rb.getString("amedium")),NoteState.A,"Amedium",5));
		notes.put(KeyCode.getKeyCode(rb.getString("bbmedium")),new Note(KeyCode.getKeyCode(rb.getString("bbmedium")),NoteState.Bb,"Bbmedium",5));
		notes.put(KeyCode.getKeyCode(rb.getString("bmedium")),new Note(KeyCode.getKeyCode(rb.getString("bmedium")),NoteState.B,"Bmedium",5));
		notes.put(KeyCode.getKeyCode(rb.getString("chigh")),new Note(KeyCode.getKeyCode(rb.getString("chigh")),NoteState.C,"Chigh",6));
		
	}
	
	/**
	 * get a resource bundle that contain a key text.
	 * @return resource bundle.
	 */
	public ResourceBundle getResource(){
		return this.rb;
	}
	
	public void setNote(String name, KeyCode key){
		for (KeyCode k : getAvailableKey()) {
			if(notes.get(k).toString().equals(name)){
				notes.put(key, notes.remove(k));
			}
		}
	}
	
	public void setProp(String key, String value) {
		try {
			in = new FileInputStream("src/piano.properties");
			prob.load(in);
			in.close();
			
			out = new FileOutputStream("src/piano.properties");
			prob.setProperty(key, value);
			prob.store(out, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * get this piano object.
	 * @return an object of this piano.
	 */
	public static Piano getInstance(){
		if(piano==null){
			piano = new Piano();
		} return piano;
	}
	
	/**
	 * get all available KeyCode in notes.
	 * @return
	 */
	public Set<KeyCode> getAvailableKey(){
		return notes.keySet();
	}
	
	/**
	 * get a map that contain all notes.
	 * @return map that contain all notes.
	 */
	public Map<KeyCode, Note> getAvailableNotes(){
		return this.notes;
	}
	
	public void keyPressed(KeyEvent e) {
		if(notes.containsKey(e.getCode())){
			if(!key.contains(e.getCode())){
				key.add(e.getCode());
				sound.play(notes.get(e.getCode()).getNote());
			} 
		}
	}
	
	public void keyPressed(String note){
		for (KeyCode k : getAvailableKey()){
			if(notes.get(k).toString().equals(note)){
				sound.play(notes.get(k).getNote());
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		if(notes.containsKey(e.getCode())){
			sound.stop(notes.get(e.getCode()).getNote());
			key.remove(e.getCode());
		}
	}
	
	public void keyReleased(String note){
		for (KeyCode k : getAvailableKey()){
			if(notes.get(k).toString().equals(note)){
				sound.stop(notes.get(k).getNote());
			}
		}
	}

}
