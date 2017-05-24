package application;

import java.util.Map;
import java.util.Set;

import instrument.Piano;
import instrument.Note;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * This class controls all the activities on gui.
 * 
 * @author Non
 *
 */
public class PianoController {
	private Piano piano = Piano.getInstance();
	private Map<KeyCode, Note> notes = piano.getAvailableNotes();
	private Set<KeyCode> key = notes.keySet();

	@FXML
	private AnchorPane background;

	/**
	 * Make piano provide sound depends on key that user pressed.
	 * 
	 * @param event
	 *            is a key press event from user.
	 */
	@FXML
	void backgroundPressed(KeyEvent event) {
		if (notes.containsKey(event.getCode())) {
			piano.keyPressed(event);
			String pressNote = notes.get(event.getCode()).toString();
			setColor(pressNote, 1);
		} else if (event.getCode().equals(KeyCode.ADD)){
			for (KeyCode k : key) {
				if (notes.get(k).toString().equals("Chigh") && notes.get(k).getOctave() <= 8) {
					for(KeyCode key : key){
						notes.get(key).increaseOctave();
					}
				}
			}
		} else if (event.getCode().equals(KeyCode.SUBTRACT)){
			for (KeyCode k : key) {
				if (notes.get(k).toString().equals("Clow") && notes.get(k).getOctave() >= 0) {
					for(KeyCode key : key){
						notes.get(key).decreaseOcctave();
					}
				}
			}
		}
	}

	/**
	 * Make piano stop playing note depends on which key user released.
	 * 
	 * @param event
	 *            is a key release event from user.
	 */
	@FXML
	void backgroundReleased(KeyEvent event) {
		if (notes.containsKey(event.getCode())) {
			piano.keyReleased(event);
			String pressNote = notes.get(event.getCode()).toString();
			setColor(pressNote, 0);
		}
	}

	/**
	 * Change color of piano button on gui when it was pressed or released.
	 * 
	 * @param id
	 *            is a button id of button that you want to change it's color.
	 * @param status
	 *            is a integer which define what color will be set on button.
	 *            When integer is 1 it's mean button has been pressed and is 0
	 *            if button has been released.
	 */
	public void setColor(String id, int status) {
		Color color1 = Color.YELLOW;
		Color color2 = Color.WHITE;
		Color color3 = Color.AQUA;
		Color color4 = Color.BLACK;
		switch (id) {
		case "Clow":
			if (status == 1)
				Clow.setFill(color1);
			else
				Clow.setFill(color2);
			break;
		case "Dblow":
			if (status == 1)
				Dblow.setFill(color3);
			else
				Dblow.setFill(color4);
			break;
		case "Dlow":
			if (status == 1)
				Dlow.setFill(color1);
			else
				Dlow.setFill(color2);
			break;
		case "Eblow":
			if (status == 1)
				Eblow.setFill(color3);
			else
				Eblow.setFill(color4);
			break;
		case "Elow":
			if (status == 1)
				Elow.setFill(color1);
			else
				Elow.setFill(color2);
			break;
		case "Flow":
			if (status == 1)
				Flow.setFill(color1);
			else
				Flow.setFill(color2);
			break;
		case "Gblow":
			if (status == 1)
				Gblow.setFill(color3);
			else
				Gblow.setFill(color4);
			break;
		case "Glow":
			if (status == 1)
				Glow.setFill(color1);
			else
				Glow.setFill(color2);
			break;
		case "Ablow":
			if (status == 1)
				Ablow.setFill(color3);
			else
				Ablow.setFill(color4);
			break;
		case "Alow":
			if (status == 1)
				Alow.setFill(color1);
			else
				Alow.setFill(color2);
			break;
		case "Bblow":
			if (status == 1)
				Bblow.setFill(color3);
			else
				Bblow.setFill(color4);
			break;
		case "Blow":
			if (status == 1)
				Blow.setFill(color1);
			else
				Blow.setFill(color2);
			break;
		case "Cmedium":
			if (status == 1)
				Cmedium.setFill(color1);
			else
				Cmedium.setFill(color2);
			break;
		case "Dbmedium":
			if (status == 1)
				Dbmedium.setFill(color3);
			else
				Dbmedium.setFill(color4);
			break;
		case "Dmedium":
			if (status == 1)
				Dmedium.setFill(color1);
			else
				Dmedium.setFill(color2);
			break;
		case "Ebmedium":
			if (status == 1)
				Ebmedium.setFill(color3);
			else
				Ebmedium.setFill(color4);
			break;
		case "Emedium":
			if (status == 1)
				Emedium.setFill(color1);
			else
				Emedium.setFill(color2);
			break;
		case "Fmedium":
			if (status == 1)
				Fmedium.setFill(color1);
			else
				Fmedium.setFill(color2);
			break;
		case "Gbmedium":
			if (status == 1)
				Gbmedium.setFill(color3);
			else
				Gbmedium.setFill(color4);
			break;
		case "Gmedium":
			if (status == 1)
				Gmedium.setFill(color1);
			else
				Gmedium.setFill(color2);
			break;
		case "Abmedium":
			if (status == 1)
				Abmedium.setFill(color3);
			else
				Abmedium.setFill(color4);
			break;
		case "Amedium":
			if (status == 1)
				Amedium.setFill(color1);
			else
				Amedium.setFill(color2);
			break;
		case "Bbmedium":
			if (status == 1)
				Bbmedium.setFill(color3);
			else
				Bbmedium.setFill(color4);
			break;
		case "Bmedium":
			if (status == 1)
				Bmedium.setFill(color1);
			else
				Bmedium.setFill(color2);
			break;
		case "Chigh":
			if (status == 1)
				Chigh.setFill(color1);
			else
				Chigh.setFill(color2);

		}
	}
	@FXML
	private Button increased;
	
	@FXML
	private Button decreased;

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
	void AblowPressed(MouseEvent event) {
		piano.keyPressed(Ablow.getId());
		setColor(Ablow.getId(), 1);
	}

	@FXML
	void AblowReleased(MouseEvent event) {
		piano.keyReleased(Ablow.getId());
		setColor(Ablow.getId(), 0);
	}

	@FXML
	void AbmediumPressed(MouseEvent event) {
		piano.keyPressed(Abmedium.getId());
		setColor(Abmedium.getId(), 1);
	}

	@FXML
	void AbmediumReleased(MouseEvent event) {
		piano.keyReleased(Abmedium.getId());
		setColor(Abmedium.getId(), 0);
	}

	@FXML
	void AlowPressed(MouseEvent event) {
		piano.keyPressed(Alow.getId());
		setColor(Alow.getId(), 1);
	}

	@FXML
	void AlowReleased(MouseEvent event) {
		piano.keyReleased(Alow.getId());
		setColor(Alow.getId(), 0);
	}

	@FXML
	void AmediumPressed(MouseEvent event) {
		piano.keyPressed(Amedium.getId());
		setColor(Amedium.getId(), 1);
	}

	@FXML
	void AmediumReleased(MouseEvent event) {
		piano.keyReleased(Amedium.getId());
		setColor(Amedium.getId(), 0);
	}

	@FXML
	void BblowPressed(MouseEvent event) {
		piano.keyPressed(Bblow.getId());
		setColor(Bblow.getId(), 1);
	}

	@FXML
	void BblowReleased(MouseEvent event) {
		piano.keyReleased(Bblow.getId());
		setColor(Bblow.getId(), 0);
	}

	@FXML
	void BbmediumPressed(MouseEvent event) {
		piano.keyPressed(Bbmedium.getId());
		setColor(Bbmedium.getId(), 1);
	}

	@FXML
	void BbmediumReleased(MouseEvent event) {
		piano.keyReleased(Bbmedium.getId());
		setColor(Bbmedium.getId(), 0);
	}

	@FXML
	void BlowPressed(MouseEvent event) {
		piano.keyPressed(Blow.getId());
		setColor(Blow.getId(), 1);
	}

	@FXML
	void BlowReleased(MouseEvent event) {
		piano.keyReleased(Blow.getId());
		setColor(Blow.getId(), 0);
	}

	@FXML
	void BmediumPressed(MouseEvent event) {
		piano.keyPressed(Bmedium.getId());
		setColor(Bmedium.getId(), 1);
	}

	@FXML
	void BmediumReleased(MouseEvent event) {
		piano.keyReleased(Bmedium.getId());
		setColor(Bmedium.getId(), 0);
	}

	@FXML
	void ChighPressed(MouseEvent event) {
		piano.keyPressed(Chigh.getId());
		setColor(Chigh.getId(), 1);
	}

	@FXML
	void ChighReleased(MouseEvent event) {
		piano.keyReleased(Chigh.getId());
		setColor(Chigh.getId(), 0);
	}

	@FXML
	void ClowPressed(MouseEvent event) {
		piano.keyPressed(Clow.getId());
		setColor(Clow.getId(), 1);
	}

	@FXML
	void ClowReleased(MouseEvent event) {
		piano.keyReleased(Clow.getId());
		setColor(Clow.getId(), 0);
	}

	@FXML
	void CmediumPressed(MouseEvent event) {
		piano.keyPressed(Cmedium.getId());
		setColor(Cmedium.getId(), 1);
	}

	@FXML
	void CmediumReleased(MouseEvent event) {
		piano.keyReleased(Cmedium.getId());
		setColor(Cmedium.getId(), 0);
	}

	@FXML
	void DblowPressed(MouseEvent event) {
		piano.keyPressed(Dblow.getId());
		setColor(Dblow.getId(), 1);
	}

	@FXML
	void DblowReleased(MouseEvent event) {
		piano.keyReleased(Dblow.getId());
		setColor(Dblow.getId(), 0);
	}

	@FXML
	void DbmediumPressed(MouseEvent event) {
		piano.keyPressed(Dbmedium.getId());
		setColor(Dbmedium.getId(), 1);
	}

	@FXML
	void DbmediumReleased(MouseEvent event) {
		piano.keyReleased(Dbmedium.getId());
		setColor(Dbmedium.getId(), 0);
	}

	@FXML
	void DlowPressed(MouseEvent event) {
		piano.keyPressed(Dlow.getId());
		setColor(Dlow.getId(), 1);
	}

	@FXML
	void DlowReleased(MouseEvent event) {
		piano.keyReleased(Dlow.getId());
		setColor(Dlow.getId(), 0);
	}

	@FXML
	void DmediumPressed(MouseEvent event) {
		piano.keyPressed(Dmedium.getId());
		setColor(Dmedium.getId(), 1);
	}

	@FXML
	void DmediumReleased(MouseEvent event) {
		piano.keyReleased(Dmedium.getId());
		setColor(Dmedium.getId(), 0);
	}

	@FXML
	void EblowPressed(MouseEvent event) {
		piano.keyPressed(Eblow.getId());
		setColor(Eblow.getId(), 1);
	}

	@FXML
	void EblowRelease(MouseEvent event) {
		piano.keyReleased(Eblow.getId());
		setColor(Eblow.getId(), 0);
	}

	@FXML
	void EbmediumPressed(MouseEvent event) {
		piano.keyPressed(Ebmedium.getId());
		setColor(Ebmedium.getId(), 1);
	}

	@FXML
	void EbmediumReleased(MouseEvent event) {
		piano.keyReleased(Ebmedium.getId());
		setColor(Ebmedium.getId(), 0);
	}

	@FXML
	void ElowPressed(MouseEvent event) {
		piano.keyPressed(Elow.getId());
		setColor(Elow.getId(), 1);
	}

	@FXML
	void ElowReleased(MouseEvent event) {
		piano.keyReleased(Elow.getId());
		setColor(Elow.getId(), 0);
	}

	@FXML
	void EmediumPressed(MouseEvent event) {
		piano.keyPressed(Emedium.getId());
		setColor(Emedium.getId(), 1);
	}

	@FXML
	void EmediumReleased(MouseEvent event) {
		piano.keyReleased(Emedium.getId());
		setColor(Emedium.getId(), 0);
	}

	@FXML
	void FlowPressd(MouseEvent event) {
		piano.keyPressed(Flow.getId());
		setColor(Flow.getId(), 1);
	}

	@FXML
	void FlowReleased(MouseEvent event) {
		piano.keyReleased(Flow.getId());
		setColor(Flow.getId(), 0);
	}

	@FXML
	void FmediumPressed(MouseEvent event) {
		piano.keyPressed(Fmedium.getId());
		setColor(Fmedium.getId(), 1);
	}

	@FXML
	void FmediumReleased(MouseEvent event) {
		piano.keyReleased(Fmedium.getId());
		setColor(Fmedium.getId(), 0);
	}

	@FXML
	void GblowPressed(MouseEvent event) {
		piano.keyPressed(Gblow.getId());
		setColor(Gblow.getId(), 1);
	}

	@FXML
	void GblowReleased(MouseEvent event) {
		piano.keyReleased(Gblow.getId());
		setColor(Gblow.getId(), 0);
	}

	@FXML
	void GbmediumPressed(MouseEvent event) {
		piano.keyPressed(Gbmedium.getId());
		setColor(Gbmedium.getId(), 1);
	}

	@FXML
	void GbmediumReleased(MouseEvent event) {
		piano.keyReleased(Gbmedium.getId());
		setColor(Gbmedium.getId(), 0);
	}

	@FXML
	void GlowPressed(MouseEvent event) {
		piano.keyPressed(Glow.getId());
		setColor(Glow.getId(), 1);
	}

	@FXML
	void GlowReleased(MouseEvent event) {
		piano.keyReleased(Glow.getId());
		setColor(Glow.getId(), 0);
	}

	@FXML
	void GmediumPressed(MouseEvent event) {
		piano.keyPressed(Gmedium.getId());
		setColor(Gmedium.getId(), 1);
	}

	@FXML
	void GmediumReleased(MouseEvent event) {
		piano.keyReleased(Gmedium.getId());
		setColor(Gmedium.getId(), 0);
	}

	@FXML
	void DecreaseOctave(MouseEvent event) {
		for (KeyCode k : key) {
			if (notes.get(k).toString().equals("Clow") && notes.get(k).getOctave() >= 0) {
				for(KeyCode key : key){
					notes.get(key).decreaseOcctave();
				}
			}
		}
	}

	@FXML
	void IncreaseOctave(MouseEvent event) {
		for (KeyCode k : key) {
			if (notes.get(k).toString().equals("Chigh") && notes.get(k).getOctave() <= 8) {
				for(KeyCode key : key){
					notes.get(key).increaseOctave();
				}
			}
		}
	}
}
