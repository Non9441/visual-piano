package application;

import java.util.Map;

import instrument.KeyBoardPiano;
import instrument.Note;
import instrument.SoundProvider;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PianoController {
	private KeyBoardPiano piano = KeyBoardPiano.getInstance();
	private Map<KeyCode, Note> notes = piano.getAvailableNotes();
	private SoundProvider sound = new SoundProvider(90);
	
	@FXML
	private AnchorPane background;
	
	@FXML
	void backgroundPressed(KeyEvent event) {
		if(notes.containsKey(event.getCode())){
			piano.keyPressed(event);
			String pressNote = notes.get(event.getCode()).toString();
			setColor(pressNote, 1);
		}
	}

	@FXML
	void backgroundReleased(KeyEvent event) {
		if(notes.containsKey(event.getCode())){
			piano.keyReleased(event);
			String pressNote = notes.get(event.getCode()).toString();
			setColor(pressNote, 0);
		}
	}
	
	public void setColor(String id, int status){
		Color color1 = Color.YELLOW;
		Color color2 = Color.WHITE;
		Color color3 = Color.AQUA;
		Color color4 = Color.BLACK;
		switch (id) {
		case "Clow" :
			if(status==1) Clow.setFill(color1);
			else Clow.setFill(color2);
			break;
		case "Dblow" :
			if(status==1) Dblow.setFill(color3);
			else Dblow.setFill(color4);
			break;
		case "Dlow" :
			if(status==1) Dlow.setFill(color1);
			else Dlow.setFill(color2);
			break;
		case "Eblow" :
			if(status==1) Eblow.setFill(color3);
			else Eblow.setFill(color4);
			break;
		case "Elow" :
			if(status==1) Elow.setFill(color1);
			else Elow.setFill(color2);
			break;
		case "Flow" :
			if(status==1) Flow.setFill(color1);
			else Flow.setFill(color2);
			break;
		case "Gblow" :
			if(status==1) Gblow.setFill(color3);
			else Gblow.setFill(color4);
			break;
		case "Glow" :
			if(status==1) Glow.setFill(color1);
			else Glow.setFill(color2);
			break;
		case "Ablow" :
			if(status==1) Ablow.setFill(color3);
			else Ablow.setFill(color4);
			break;
		case "Alow" :
			if(status==1) Alow.setFill(color1);
			else Alow.setFill(color2);
			break;
		case "Bblow" :
			if(status==1) Bblow.setFill(color3);
			else Bblow.setFill(color4);
			break;
		case "Blow" :
			if(status==1) Blow.setFill(color1);
			else Blow.setFill(color2);
			break;
		case "Cmedium" :
			if(status==1) Cmedium.setFill(color1);
			else Cmedium.setFill(color2);
			break;
		case "Dbmedium" :
			if(status==1) Dbmedium.setFill(color3);
			else Dbmedium.setFill(color4);
			break;
		case "Dmedium" :
			if(status==1) Dmedium.setFill(color1);
			else Dmedium.setFill(color2);
			break;
		case "Ebmedium" :
			if(status==1) Ebmedium.setFill(color3);
			else Ebmedium.setFill(color4);
			break;
		case "Emedium" :
			if(status==1) Emedium.setFill(color1);
			else Emedium.setFill(color2);
			break;
		case "Fmedium" :
			if(status==1) Fmedium.setFill(color1);
			else Fmedium.setFill(color2);
			break;
		case "Gbmedium" :
			if(status==1) Gbmedium.setFill(color3);
			else Gbmedium.setFill(color4);
			break;
		case "Gmedium" :
			if(status==1) Gmedium.setFill(color1);
			else Gmedium.setFill(color2);
			break;
		case "Abmedium" :
			if(status==1) Abmedium.setFill(color3);
			else Abmedium.setFill(color4);
			break;
		case "Amedium" :
			if(status==1) Amedium.setFill(color1);
			else Amedium.setFill(color2);
			break;
		case "Bbmedium" :
			if(status==1) Bbmedium.setFill(color3);
			else Bbmedium.setFill(color4);
			break;
		case "Bmedium" :
			if(status==1) Bmedium.setFill(color1);
			else Bmedium.setFill(color2);
			break;
		case "Chigh" :
			if(status==1) Chigh.setFill(color1);
			else Chigh.setFill(color2);
			
		}
	}


	@FXML
	private Rectangle Clow;

	@FXML
	private Rectangle Dlow;

	@FXML
	private Rectangle Elow;

	@FXML
	private Rectangle Flow;

	@FXML
	private Rectangle Glow;

	@FXML
	private Rectangle Alow;

	@FXML
	private Rectangle Blow;

	@FXML
	private Rectangle Cmedium;

	@FXML
	private Rectangle Dmedium;

	@FXML
	private Rectangle Emedium;

	@FXML
	private Rectangle Fmedium;

	@FXML
	private Rectangle Gmedium;

	@FXML
	private Rectangle Chigh;

	@FXML
	private Rectangle Bmedium;

	@FXML
	private Rectangle Amedium;

	@FXML
	private Rectangle Dblow;

	@FXML
	private Rectangle Eblow;

	@FXML
	private Rectangle Gblow;

	@FXML
	private Rectangle Ablow;

	@FXML
	private Rectangle Bblow;

	@FXML
	private Rectangle Dbmedium;

	@FXML
	private Rectangle Ebmedium;

	@FXML
	private Rectangle Gbmedium;

	@FXML
	private Rectangle Abmedium;

	@FXML
	private Rectangle Bbmedium;

	@FXML
	private TextField Bmediumtext;

	@FXML
	private TextField AmediumText;

	@FXML
	private TextField GmediumText;

	@FXML
	private TextField FmediumText;

	@FXML
	private TextField EmediumText;

	@FXML
	private TextField DmediumText;

	@FXML
	private TextField CmediumText;

	@FXML
	private TextField BlowText;

	@FXML
	private TextField AlowText;

	@FXML
	private TextField GlowText;

	@FXML
	private TextField FlowText;

	@FXML
	private TextField ElowText;

	@FXML
	private TextField DlowText;

	@FXML
	private TextField ClowText;

	@FXML
	private TextField EbmediumText;

	@FXML
	private TextField DbmediumText;

	@FXML
	private TextField BblowText;

	@FXML
	private TextField AblowText;

	@FXML
	private TextField GblowText;

	@FXML
	private TextField EblowText;

	@FXML
	private TextField DblowText;

	@FXML
	private TextField ChighText;

	@FXML
	private TextField BbmediumText;

	@FXML
	private TextField AbmediumText;

	@FXML
	void AbLowPress(MouseEvent event) {

	}

	@FXML
	void AbMediumPress(MouseEvent event) {

	}

	@FXML
	void AlowPress(MouseEvent event) {

	}

	@FXML
	void AmediumPress(MouseEvent event) {

	}

	@FXML
	void BbLowPress(MouseEvent event) {

	}

	@FXML
	void BbMediumPress(MouseEvent event) {

	}

	@FXML
	void BlowPress(MouseEvent event) {

	}

	@FXML
	void BmediumPress(MouseEvent event) {

	}

	@FXML
	void ChighPress(MouseEvent event) {

	}

	@FXML
	void ClowPress(MouseEvent event) {
		Clow.setFill(Color.YELLOW);
	}

	@FXML
	void ClowReleased(MouseEvent event) {
		Clow.setFill(Color.WHITE);
	}

	@FXML
	void CmediumPress(MouseEvent event) {

	}

	@FXML
	void DbLowPress(MouseEvent event) {

	}

	@FXML
	void DbLowReleased(MouseEvent event) {

	}

	@FXML
	void DbMediumPress(MouseEvent event) {

	}

	@FXML
	void DlowPress(MouseEvent event) {

	}

	@FXML
	void DlowReleased(MouseEvent event) {

	}

	@FXML
	void DmediumPress(MouseEvent event) {

	}

	@FXML
	void EbLowPress(MouseEvent event) {

	}

	@FXML
	void EbMediumPress(MouseEvent event) {

	}

	@FXML
	void EblowRelease(MouseEvent event) {

	}

	@FXML
	void ElowPress(MouseEvent event) {

	}

	@FXML
	void ElowRelease(MouseEvent event) {

	}

	@FXML
	void EmediumPress(MouseEvent event) {

	}

	@FXML
	void FlowPress(MouseEvent event) {

	}

	@FXML
	void FlowRelease(MouseEvent event) {

	}

	@FXML
	void FmediumPress(MouseEvent event) {

	}

	@FXML
	void GbLowPress(MouseEvent event) {

	}

	@FXML
	void GbMediumPress(MouseEvent event) {

	}

	@FXML
	void GlowPress(MouseEvent event) {

	}

	@FXML
	void GmediumPress(MouseEvent event) {

	}

}
