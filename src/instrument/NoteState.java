package instrument;

/**
 * enum class that contain all note status.
 * You can get an Integer of note by call a getNote method and give it which octave you want.
 * @author Non
 *
 */
public enum NoteState {
	C(0), 
	Db(1),
	D(2),
	Eb(3),
	E(4),
	F(5),
	Gb(6),
	G(7),
	Ab(8),
	A(9),
	Bb(10),
	B(11);
	
	private int noteValue;
	
	/**
	 * A constructor of NoteState define value for each note. 
	 * @param noteValue
	 */
	private NoteState(int noteValue){
		this.noteValue = noteValue;
	}
	
	/**
	 * Give an integer value of note depends on which octave user give.
	 * @param octave is the interval between one musical pitch 
	 * 		  and another with half or double its frequency.
	 * @return note value after calculated with given octave;
	 */
	public int getNote(int octave){
		return octave*12+noteValue;
	}
}
