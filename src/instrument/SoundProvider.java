package instrument;


import javax.sound.midi.*;

/**
 * This class provide sound for a piano depends on Note that piano gives. 
 * @author Non
 *
 */
public class SoundProvider {
	
	private int DEFAULT_CHANNEL = 0;
	private MidiChannel[] channel;
	private Synthesizer syn;
	private Instrument[] instrument;
	private int velocity;
	
	/**
	 * Constructor of SoundProvider create
	 * @param velocity
	 */
	public SoundProvider(int velocity){
		try {
			syn = MidiSystem.getSynthesizer();
			channel = syn.getChannels();
			channel[0].setMono(false);
			instrument = syn.getAvailableInstruments();
			this.velocity = velocity;
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method play sound depend on Integer that user gives.
	 * Integer refers to each note value. 
	 * @param note is a value of note you want to play sound.
	 * @param channel is a channel in MidiChannel you want the sound to play on.
	 */
	public void play(int note, int channel){
		try {
			syn.open();
			syn.loadInstrument(getInstrument(50));
			getChannel(channel).noteOn(note, velocity);
			
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method play sound depend on Integer that user gives.
	 * Integer refers to each note value.
	 * @param note is a value of note you want to play sound.
	 */
	public void play(int note){
		try {
			syn.open();
			syn.loadInstrument(getInstrument(50));
			getChannel(DEFAULT_CHANNEL).noteOn(note, velocity);
			
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MidiChannel getChannel(int channel){
		return this.channel[channel];
	}
	
	public void stop(int note,int channel){
		getChannel(channel).noteOff(note,50);
	}
	
	public void stop(int note){
		getChannel(DEFAULT_CHANNEL).noteOff(note,50);
	}
	
	public Instrument getInstrument(int instrument){
		return this.instrument[instrument];
	}

}
