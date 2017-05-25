package application;

import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
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
	private ResourceBundle rb = piano.getResource();
	
	@FXML
    public void initialize() {
		ClowText.setText(rb.getString("clowText"));
        DblowText.setText(rb.getString("dblowText"));
        DlowText.setText(rb.getString("dlowText"));
        EblowText.setText(rb.getString("eblowText"));
        ElowText.setText(rb.getString("elowText"));
        FlowText.setText(rb.getString("flowText"));
        GblowText.setText(rb.getString("gblowText"));
        GlowText.setText(rb.getString("glowText"));
        AblowText.setText(rb.getString("ablowText"));
        AlowText.setText(rb.getString("alowText"));
        BblowText.setText(rb.getString("bblowText"));
        BlowText.setText(rb.getString("blowText"));
        CmediumText.setText(rb.getString("cmediumText"));
        DbmediumText.setText(rb.getString("dbmediumText"));
        DmediumText.setText(rb.getString("dmediumText"));
        EbmediumText.setText(rb.getString("ebmediumText"));
        EmediumText.setText(rb.getString("emediumText"));
        FmediumText.setText(rb.getString("fmediumText"));
        GbmediumText.setText(rb.getString("gbmediumText"));
        GmediumText.setText(rb.getString("gmediumText"));
        AbmediumText.setText(rb.getString("abmediumText"));
        AmediumText.setText(rb.getString("amediumText"));
        BbmediumText.setText(rb.getString("bbmediumText"));
        BmediumText.setText(rb.getString("bmediumText"));
        ChighText.setText(rb.getString("chighText"));
    }
	
	public Set<String> getAlltext(){
		Set<String> alltext = new HashSet<>();
		alltext.add(ClowText.getText());
        alltext.add(DblowText.getText());
        alltext.add(DlowText.getText());
        alltext.add(EblowText.getText());
        alltext.add(ElowText.getText());
        alltext.add(FlowText.getText());
        alltext.add(GblowText.getText());
        alltext.add(GlowText.getText());
        alltext.add(AblowText.getText());
        alltext.add(AlowText.getText());
        alltext.add(BblowText.getText());
        alltext.add(BlowText.getText());
        alltext.add(CmediumText.getText());
        alltext.add(DbmediumText.getText());
        alltext.add(DmediumText.getText());
        alltext.add(EbmediumText.getText());
        alltext.add(EmediumText.getText());
        alltext.add(FmediumText.getText());
        alltext.add(GbmediumText.getText());
        alltext.add(GmediumText.getText());
        alltext.add(AbmediumText.getText());
        alltext.add(AmediumText.getText());
        alltext.add(BbmediumText.getText());
        alltext.add(BmediumText.getText());
        alltext.add(ChighText.getText());
        return alltext;
	}
	
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
	
	@FXML
    void TextAblowPressed(KeyEvent event) {
		if(!getAlltext().contains(event.getText())){
			AblowText.setText(event.getText());
			piano.setNote("Ablow", event.getCode());
			piano.setProp("ablow", event.getCode().getName());
			piano.setProp("ablowText", event.getText());
		} 
    }

    @FXML
    void TextAbmediumPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		AbmediumText.setText(event.getText());
        	piano.setNote("Abmedium", event.getCode());
    		piano.setProp("abmedium", event.getCode().getName());
    		piano.setProp("abmediumText", event.getText());
    	}
    }

    @FXML
    void TextAlowPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		AlowText.setText(event.getText());
        	piano.setNote("Alow", event.getCode());
    		piano.setProp("alow", event.getCode().getName());
    		piano.setProp("alowText", event.getText());
    	}
    }

    @FXML
    void TextAmediumPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		AmediumText.setText(event.getText());
        	piano.setNote("Amedium", event.getCode());
    		piano.setProp("amedium", event.getCode().getName());
    		piano.setProp("amediumText", event.getText());
    	}
    }

    @FXML
    void TextBblowPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		BblowText.setText(event.getText());
        	piano.setNote("Bblow", event.getCode());
    		piano.setProp("bblow", event.getCode().getName());
    		piano.setProp("bblowText", event.getText());
    	}
    }

    @FXML
    void TextBbmediumPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		BbmediumText.setText(event.getText());
        	piano.setNote("Bbmedium", event.getCode());
    		piano.setProp("bbmedium", event.getCode().getName());
    		piano.setProp("bbmediumText", event.getText());
    	}
    }

    @FXML
    void TextBlowPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		BlowText.setText(event.getText());
        	piano.setNote("Blow", event.getCode());
    		piano.setProp("blow", event.getCode().getName());
    		piano.setProp("blowText", event.getText());
    	}
    }

    @FXML
    void TextBmediumPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		BmediumText.setText(event.getText());
        	piano.setNote("Bmedium", event.getCode());
    		piano.setProp("bmedium", event.getCode().getName());
    		piano.setProp("bmediumText", event.getText());
    	}
    }

    @FXML
    void TextChighPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		ChighText.setText(event.getText());
        	piano.setNote("Chigh", event.getCode());
    		piano.setProp("chigh", event.getCode().getName());
    		piano.setProp("chighText", event.getText());
    	}
    }

    @FXML
    void TextClowPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		ClowText.setText(event.getText());
        	piano.setNote("Clow", event.getCode());
    		piano.setProp("clow", event.getCode().getName());
    		piano.setProp("clowText", event.getText());
    	}
    }

    @FXML
    void TextCmediumPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		CmediumText.setText(event.getText());
        	piano.setNote("Cmedium", event.getCode());
    		piano.setProp("cmedium", event.getCode().getName());
    		piano.setProp("cmediumText", event.getText());
    	}
    }

    @FXML
    void TextDblowPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		DblowText.setText(event.getText());
        	piano.setNote("Dblow", event.getCode());
    		piano.setProp("dblow", event.getCode().getName());
    		piano.setProp("dblowText", event.getText());
    	}
    }

    @FXML
    void TextDbmediumPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		DbmediumText.setText(event.getText());
        	piano.setNote("Dbmedium", event.getCode());
    		piano.setProp("dbmedium", event.getCode().getName());
    		piano.setProp("dbmediumText", event.getText());
    	}
    }

    @FXML
    void TextDlowPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		DlowText.setText(event.getText());
        	piano.setNote("Dlow", event.getCode());
    		piano.setProp("dlow", event.getCode().getName());
    		piano.setProp("dlowText", event.getText());
    	}
    }

    @FXML
    void TextDmediumPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		DmediumText.setText(event.getText());
        	piano.setNote("Dmedium", event.getCode());
    		piano.setProp("dmedium", event.getCode().getName());
    		piano.setProp("dmediumText", event.getText());
    	}
    }

    @FXML
    void TextEblowPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		EblowText.setText(event.getText());
        	piano.setNote("Eblow", event.getCode());
    		piano.setProp("eblow", event.getCode().getName());
    		piano.setProp("eblowText", event.getText());
    	}
    }

    @FXML
    void TextEbmediumPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		EbmediumText.setText(event.getText());
        	piano.setNote("Ebmedium", event.getCode());
    		piano.setProp("ebmedium", event.getCode().getName());
    		piano.setProp("ebmediumText", event.getText());
    	}
    }

    @FXML
    void TextElowPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		ElowText.setText(event.getText());
        	piano.setNote("Elow", event.getCode());
    		piano.setProp("elow", event.getCode().getName());
    		piano.setProp("elowText", event.getText());
    	}
    }

    @FXML
    void TextEmediumPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		EmediumText.setText(event.getText());
        	piano.setNote("Emedium", event.getCode());
    		piano.setProp("emedium", event.getCode().getName());
    		piano.setProp("emediumText", event.getText());
    	}
    }

    @FXML
    void TextFlowPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		FlowText.setText(event.getText());
        	piano.setNote("Flow", event.getCode());
    		piano.setProp("flow", event.getCode().getName());
    		piano.setProp("flowText", event.getText());
    	}
    }

    @FXML
    void TextFmediumPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		FmediumText.setText(event.getText());
        	piano.setNote("Fmedium", event.getCode());
    		piano.setProp("fmedium", event.getCode().getName());
    		piano.setProp("fmediumText", event.getText());
    	}
    }

    @FXML
    void TextGblowPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		GblowText.setText(event.getText());
        	piano.setNote("Gblow", event.getCode());
    		piano.setProp("gblow", event.getCode().getName());
    		piano.setProp("gblowText", event.getText());
    	}
    }

    @FXML
    void TextGbmediumPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		GbmediumText.setText(event.getText());
        	piano.setNote("Gbmedium", event.getCode());
    		piano.setProp("gbmedium", event.getCode().getName());
    		piano.setProp("gbmediumText", event.getText());
    	}
    }

    @FXML
    void TextGlowPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		GlowText.setText(event.getText());
        	piano.setNote("Glow", event.getCode());
    		piano.setProp("glow", event.getCode().getName());
    		piano.setProp("glowText", event.getText());
    	}
    }

    @FXML
    void TextGmediumPressed(KeyEvent event) {
    	if(!getAlltext().contains(event.getText())){
    		GmediumText.setText(event.getText());
        	piano.setNote("Gmedium", event.getCode());
    		piano.setProp("gmedium", event.getCode().getName());
    		piano.setProp("gmediumText", event.getText());
    	}
    }
}
