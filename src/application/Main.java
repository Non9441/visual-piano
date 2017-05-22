package application;

import javax.xml.stream.EventFilter;

import instrument.KeyBoardPiano;
import instrument.SoundProvider;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Main extends Application {
	private KeyBoardPiano piano = new KeyBoardPiano();
	private SoundProvider sound = new SoundProvider(90);
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(ClassLoader.getSystemResource("application/Piano.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			scene.setOnMouseClicked(new EventHandler<MouseEvent>(){
//
//				@Override
//				public void handle(MouseEvent event) {
//					System.out.println("yy");
//					
//				}
//				
//			});
			scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){

				@Override
				public void handle(KeyEvent event) {
					piano.keyPressed(event);
					
				}
				
			});
			scene.setOnKeyReleased(new EventHandler<KeyEvent>(){

				@Override
				public void handle(KeyEvent event) {
					piano.keyReleased(event);
					
				}
				
			});
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
