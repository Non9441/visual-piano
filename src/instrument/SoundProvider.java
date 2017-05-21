package instrument;


import javax.sound.midi.*;

public class SoundProvider {
	
	private int DEFAULT_CHANNEL = 0;
	private MidiChannel[] channel;
	private Synthesizer syn;
	private Instrument[] instrument;
	private int velocity;
	
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
