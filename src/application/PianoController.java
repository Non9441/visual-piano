package application;

import java.util.Map;
import java.util.Set;

import instrument.Piano;
import instrument.Note;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
				if (notes.get(k).toString().equals("chigh") && notes.get(k).getOctave() <= 8) {
					for(KeyCode key : key){
						notes.get(key).increaseOctave();
					}
				}
			}
		} else if (event.getCode().equals(KeyCode.SUBTRACT)){
			for (KeyCode k : key) {
				if (notes.get(k).toString().equals("clow") && notes.get(k).getOctave() >= 0) {
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
		case "clow":
			if (status == 1)
				clow.setFill(color1);
			else
				clow.setFill(color2);
			break;
		case "dblow":
			if (status == 1)
				dblow.setFill(color3);
			else
				dblow.setFill(color4);
			break;
		case "dlow":
			if (status == 1)
				dlow.setFill(color1);
			else
				dlow.setFill(color2);
			break;
		case "eblow":
			if (status == 1)
				eblow.setFill(color3);
			else
				eblow.setFill(color4);
			break;
		case "elow":
			if (status == 1)
				elow.setFill(color1);
			else
				elow.setFill(color2);
			break;
		case "flow":
			if (status == 1)
				flow.setFill(color1);
			else
				flow.setFill(color2);
			break;
		case "gblow":
			if (status == 1)
				gblow.setFill(color3);
			else
				gblow.setFill(color4);
			break;
		case "glow":
			if (status == 1)
				glow.setFill(color1);
			else
				glow.setFill(color2);
			break;
		case "ablow":
			if (status == 1)
				ablow.setFill(color3);
			else
				ablow.setFill(color4);
			break;
		case "alow":
			if (status == 1)
				alow.setFill(color1);
			else
				alow.setFill(color2);
			break;
		case "bblow":
			if (status == 1)
				bblow.setFill(color3);
			else
				bblow.setFill(color4);
			break;
		case "blow":
			if (status == 1)
				blow.setFill(color1);
			else
				blow.setFill(color2);
			break;
		case "cmedium":
			if (status == 1)
				cmedium.setFill(color1);
			else
				cmedium.setFill(color2);
			break;
		case "dbmedium":
			if (status == 1)
				dbmedium.setFill(color3);
			else
				dbmedium.setFill(color4);
			break;
		case "dmedium":
			if (status == 1)
				dmedium.setFill(color1);
			else
				dmedium.setFill(color2);
			break;
		case "ebmedium":
			if (status == 1)
				ebmedium.setFill(color3);
			else
				ebmedium.setFill(color4);
			break;
		case "emedium":
			if (status == 1)
				emedium.setFill(color1);
			else
				emedium.setFill(color2);
			break;
		case "fmedium":
			if (status == 1)
				fmedium.setFill(color1);
			else
				fmedium.setFill(color2);
			break;
		case "gbmedium":
			if (status == 1)
				gbmedium.setFill(color3);
			else
				gbmedium.setFill(color4);
			break;
		case "gmedium":
			if (status == 1)
				gmedium.setFill(color1);
			else
				gmedium.setFill(color2);
			break;
		case "abmedium":
			if (status == 1)
				abmedium.setFill(color3);
			else
				abmedium.setFill(color4);
			break;
		case "amedium":
			if (status == 1)
				amedium.setFill(color1);
			else
				amedium.setFill(color2);
			break;
		case "bbmedium":
			if (status == 1)
				bbmedium.setFill(color3);
			else
				bbmedium.setFill(color4);
			break;
		case "bmedium":
			if (status == 1)
				bmedium.setFill(color1);
			else
				bmedium.setFill(color2);
			break;
		case "chigh":
			if (status == 1)
				chigh.setFill(color1);
			else
				chigh.setFill(color2);

		}
	}
	@FXML
	private Button increased;
	
	@FXML
	private Button decreased;

	@FXML
	private Rectangle clow;

	@FXML
	private Rectangle dlow;

	@FXML
	private Rectangle elow;

	@FXML
	private Rectangle flow;

	@FXML
	private Rectangle glow;

	@FXML
	private Rectangle alow;

	@FXML
	private Rectangle blow;

	@FXML
	private Rectangle cmedium;

	@FXML
	private Rectangle dmedium;

	@FXML
	private Rectangle emedium;

	@FXML
	private Rectangle fmedium;

	@FXML
	private Rectangle gmedium;

	@FXML
	private Rectangle chigh;

	@FXML
	private Rectangle bmedium;

	@FXML
	private Rectangle amedium;

	@FXML
	private Rectangle dblow;

	@FXML
	private Rectangle eblow;

	@FXML
	private Rectangle gblow;

	@FXML
	private Rectangle ablow;

	@FXML
	private Rectangle bblow;

	@FXML
	private Rectangle dbmedium;

	@FXML
	private Rectangle ebmedium;

	@FXML
	private Rectangle gbmedium;

	@FXML
	private Rectangle abmedium;

	@FXML
	private Rectangle bbmedium;

	@FXML
	private TextField BmediumText;

	@FXML
	private TextField AmediumText;

	@FXML
	private TextField GmediumText;
	
	@FXML
	private TextField GbmediumText;

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
    private Rectangle vp2;

    @FXML
    private Label vptext;

    @FXML
    private Rectangle vp;

	@FXML
	void AblowPressed(MouseEvent event) {
		piano.keyPressed(ablow.getId());
		setColor(ablow.getId(), 1);
	}

	@FXML
	void AblowReleased(MouseEvent event) {
		piano.keyReleased(ablow.getId());
		setColor(ablow.getId(), 0);
	}

	@FXML
	void AbmediumPressed(MouseEvent event) {
		piano.keyPressed(abmedium.getId());
		setColor(abmedium.getId(), 1);
	}

	@FXML
	void AbmediumReleased(MouseEvent event) {
		piano.keyReleased(abmedium.getId());
		setColor(abmedium.getId(), 0);
	}

	@FXML
	void AlowPressed(MouseEvent event) {
		piano.keyPressed(alow.getId());
		setColor(alow.getId(), 1);
	}

	@FXML
	void AlowReleased(MouseEvent event) {
		piano.keyReleased(alow.getId());
		setColor(alow.getId(), 0);
	}

	@FXML
	void AmediumPressed(MouseEvent event) {
		piano.keyPressed(amedium.getId());
		setColor(amedium.getId(), 1);
	}

	@FXML
	void AmediumReleased(MouseEvent event) {
		piano.keyReleased(amedium.getId());
		setColor(amedium.getId(), 0);
	}

	@FXML
	void BblowPressed(MouseEvent event) {
		piano.keyPressed(bblow.getId());
		setColor(bblow.getId(), 1);
	}

	@FXML
	void BblowReleased(MouseEvent event) {
		piano.keyReleased(bblow.getId());
		setColor(bblow.getId(), 0);
	}

	@FXML
	void BbmediumPressed(MouseEvent event) {
		piano.keyPressed(bbmedium.getId());
		setColor(bbmedium.getId(), 1);
	}

	@FXML
	void BbmediumReleased(MouseEvent event) {
		piano.keyReleased(bbmedium.getId());
		setColor(bbmedium.getId(), 0);
	}

	@FXML
	void BlowPressed(MouseEvent event) {
		piano.keyPressed(blow.getId());
		setColor(blow.getId(), 1);
	}

	@FXML
	void BlowReleased(MouseEvent event) {
		piano.keyReleased(blow.getId());
		setColor(blow.getId(), 0);
	}

	@FXML
	void BmediumPressed(MouseEvent event) {
		piano.keyPressed(bmedium.getId());
		setColor(bmedium.getId(), 1);
	}

	@FXML
	void BmediumReleased(MouseEvent event) {
		piano.keyReleased(bmedium.getId());
		setColor(bmedium.getId(), 0);
	}

	@FXML
	void ChighPressed(MouseEvent event) {
		piano.keyPressed(chigh.getId());
		setColor(chigh.getId(), 1);
	}

	@FXML
	void ChighReleased(MouseEvent event) {
		piano.keyReleased(chigh.getId());
		setColor(chigh.getId(), 0);
	}

	@FXML
	void ClowPressed(MouseEvent event) {
		piano.keyPressed(clow.getId());
		setColor(clow.getId(), 1);
	}

	@FXML
	void ClowReleased(MouseEvent event) {
		piano.keyReleased(clow.getId());
		setColor(clow.getId(), 0);
	}

	@FXML
	void CmediumPressed(MouseEvent event) {
		piano.keyPressed(cmedium.getId());
		setColor(cmedium.getId(), 1);
	}

	@FXML
	void CmediumReleased(MouseEvent event) {
		piano.keyReleased(cmedium.getId());
		setColor(cmedium.getId(), 0);
	}

	@FXML
	void DblowPressed(MouseEvent event) {
		piano.keyPressed(dblow.getId());
		setColor(dblow.getId(), 1);
	}

	@FXML
	void DblowReleased(MouseEvent event) {
		piano.keyReleased(dblow.getId());
		setColor(dblow.getId(), 0);
	}

	@FXML
	void DbmediumPressed(MouseEvent event) {
		piano.keyPressed(dbmedium.getId());
		setColor(dbmedium.getId(), 1);
	}

	@FXML
	void DbmediumReleased(MouseEvent event) {
		piano.keyReleased(dbmedium.getId());
		setColor(dbmedium.getId(), 0);
	}

	@FXML
	void DlowPressed(MouseEvent event) {
		piano.keyPressed(dlow.getId());
		setColor(dlow.getId(), 1);
	}

	@FXML
	void DlowReleased(MouseEvent event) {
		piano.keyReleased(dlow.getId());
		setColor(dlow.getId(), 0);
	}

	@FXML
	void DmediumPressed(MouseEvent event) {
		piano.keyPressed(dmedium.getId());
		setColor(dmedium.getId(), 1);
	}

	@FXML
	void DmediumReleased(MouseEvent event) {
		piano.keyReleased(dmedium.getId());
		setColor(dmedium.getId(), 0);
	}

	@FXML
	void EblowPressed(MouseEvent event) {
		piano.keyPressed(eblow.getId());
		setColor(eblow.getId(), 1);
	}

	@FXML
	void EblowRelease(MouseEvent event) {
		piano.keyReleased(eblow.getId());
		setColor(eblow.getId(), 0);
	}

	@FXML
	void EbmediumPressed(MouseEvent event) {
		piano.keyPressed(ebmedium.getId());
		setColor(ebmedium.getId(), 1);
	}

	@FXML
	void EbmediumReleased(MouseEvent event) {
		piano.keyReleased(ebmedium.getId());
		setColor(ebmedium.getId(), 0);
	}

	@FXML
	void ElowPressed(MouseEvent event) {
		piano.keyPressed(elow.getId());
		setColor(elow.getId(), 1);
	}

	@FXML
	void ElowReleased(MouseEvent event) {
		piano.keyReleased(elow.getId());
		setColor(elow.getId(), 0);
	}

	@FXML
	void EmediumPressed(MouseEvent event) {
		piano.keyPressed(emedium.getId());
		setColor(emedium.getId(), 1);
	}

	@FXML
	void EmediumReleased(MouseEvent event) {
		piano.keyReleased(emedium.getId());
		setColor(emedium.getId(), 0);
	}

	@FXML
	void FlowPressd(MouseEvent event) {
		piano.keyPressed(flow.getId());
		setColor(flow.getId(), 1);
	}

	@FXML
	void FlowReleased(MouseEvent event) {
		piano.keyReleased(flow.getId());
		setColor(flow.getId(), 0);
	}

	@FXML
	void FmediumPressed(MouseEvent event) {
		piano.keyPressed(fmedium.getId());
		setColor(fmedium.getId(), 1);
	}

	@FXML
	void FmediumReleased(MouseEvent event) {
		piano.keyReleased(fmedium.getId());
		setColor(fmedium.getId(), 0);
	}

	@FXML
	void GblowPressed(MouseEvent event) {
		piano.keyPressed(gblow.getId());
		setColor(gblow.getId(), 1);
	}

	@FXML
	void GblowReleased(MouseEvent event) {
		piano.keyReleased(gblow.getId());
		setColor(gblow.getId(), 0);
	}

	@FXML
	void GbmediumPressed(MouseEvent event) {
		piano.keyPressed(gbmedium.getId());
		setColor(gbmedium.getId(), 1);
	}

	@FXML
	void GbmediumReleased(MouseEvent event) {
		piano.keyReleased(gbmedium.getId());
		setColor(gbmedium.getId(), 0);
	}

	@FXML
	void GlowPressed(MouseEvent event) {
		piano.keyPressed(glow.getId());
		setColor(glow.getId(), 1);
	}

	@FXML
	void GlowReleased(MouseEvent event) {
		piano.keyReleased(glow.getId());
		setColor(glow.getId(), 0);
	}

	@FXML
	void GmediumPressed(MouseEvent event) {
		piano.keyPressed(gmedium.getId());
		setColor(gmedium.getId(), 1);
	}

	@FXML
	void GmediumReleased(MouseEvent event) {
		piano.keyReleased(gmedium.getId());
		setColor(gmedium.getId(), 0);
	}

	@FXML
	void DecreaseOctave(MouseEvent event) {
		for (KeyCode k : key) {
			if (notes.get(k).toString().equals("clow") && notes.get(k).getOctave() >= 0) {
				for(KeyCode key : key){
					notes.get(key).decreaseOcctave();
				}
			}
		}
	}

	@FXML
	void IncreaseOctave(MouseEvent event) {
		for (KeyCode k : key) {
			if (notes.get(k).toString().equals("chigh") && notes.get(k).getOctave() <= 8) {
				for(KeyCode key : key){
					notes.get(key).increaseOctave();
				}
			}
		}
	}
	
	
	public boolean isDuplicate(KeyEvent event){
		if(notes.containsKey(event.getCode())){
			return true;
		
		} return false;
	}
	
	@FXML
    void TextAblowPressed(KeyEvent event) {
		if(!isDuplicate(event)){
			AblowText.setText(event.getText());
			piano.setNote("ablow", event.getCode());
		}
    }

    @FXML
    void TextAbmediumPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			AbmediumText.setText(event.getText());
			piano.setNote("abmedium", event.getCode());
		}
    }

    @FXML
    void TextAlowPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			AlowText.setText(event.getText());
			piano.setNote("alow", event.getCode());
		}
    }

    @FXML
    void TextAmediumPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			AmediumText.setText(event.getText());
			piano.setNote("amedium", event.getCode());
		}
    }

    @FXML
    void TextBblowPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			BblowText.setText(event.getText());
			piano.setNote("bblow", event.getCode());
		}
    }

    @FXML
    void TextBbmediumPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			BbmediumText.setText(event.getText());
			piano.setNote("bbmedium", event.getCode());
		}
    }

    @FXML
    void TextBlowPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			BlowText.setText(event.getText());
			piano.setNote("blow", event.getCode());
		}
    }

    @FXML
    void TextBmediumPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			BmediumText.setText(event.getText());
			piano.setNote("bmedium", event.getCode());
		}
    }

    @FXML
    void TextChighPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			ChighText.setText(event.getText());
			piano.setNote("chigh", event.getCode());
		}
    }

    @FXML
    void TextClowPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			ClowText.setText(event.getText());
			piano.setNote("clow", event.getCode());
		}
    }

    @FXML
    void TextCmediumPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			CmediumText.setText(event.getText());
			piano.setNote("cmedium", event.getCode());
		}
    }

    @FXML
    void TextDblowPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			DblowText.setText(event.getText());
			piano.setNote("dblow", event.getCode());
		}
    }

    @FXML
    void TextDbmediumPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			DbmediumText.setText(event.getText());
			piano.setNote("dbmedium", event.getCode());
		}
    }

    @FXML
    void TextDlowPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			DlowText.setText(event.getText());
			piano.setNote("dlow", event.getCode());
		}
    }

    @FXML
    void TextDmediumPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			DmediumText.setText(event.getText());
			piano.setNote("dmedium", event.getCode());
		}
    }

    @FXML
    void TextEblowPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			EblowText.setText(event.getText());
			piano.setNote("eblow", event.getCode());
		}
    }

    @FXML
    void TextEbmediumPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			EbmediumText.setText(event.getText());
			piano.setNote("ebmedium", event.getCode());
		}
    }

    @FXML
    void TextElowPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			ElowText.setText(event.getText());
			piano.setNote("elow", event.getCode());
		}
    }

    @FXML
    void TextEmediumPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			EmediumText.setText(event.getText());
			piano.setNote("emedium", event.getCode());
		}
    }

    @FXML
    void TextFlowPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			FlowText.setText(event.getText());
			piano.setNote("flow", event.getCode());
		}
    }

    @FXML
    void TextFmediumPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			FmediumText.setText(event.getText());
			piano.setNote("fmedium", event.getCode());
		}
    }

    @FXML
    void TextGblowPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			GblowText.setText(event.getText());
			piano.setNote("gblow", event.getCode());
		}
    }

    @FXML
    void TextGbmediumPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			GbmediumText.setText(event.getText());
			piano.setNote("gbmedium", event.getCode());
		}
    }

    @FXML
    void TextGlowPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			GlowText.setText(event.getText());
			piano.setNote("glow", event.getCode());
		}
    }

    @FXML
    void TextGmediumPressed(KeyEvent event) {
    	if(!isDuplicate(event)){
			GmediumText.setText(event.getText());
			piano.setNote("gmedium", event.getCode());
		}
    }
}
