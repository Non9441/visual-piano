package instrument;

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
	private NoteState(int noteValue){
		this.noteValue = noteValue;
	}
	
	public int getNote(int octave){
		return octave*12+noteValue;
	}
}
