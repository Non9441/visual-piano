package instrument;

public enum NoteState {
	C(0), 
	CS(1),
	D(2),
	DS(3),
	E(4),
	F(5),
	FS(6),
	G(7),
	GS(8),
	A(9),
	AS(10),
	B(11);
	private int noteValue;
	private NoteState(int noteValue){
		this.noteValue = noteValue;
	}
	
	public int getNote(int octave){
		return octave*12+noteValue;
	}
}
