package application;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(ClassLoader.getSystemResource("application/Piano.fxml"));
			Scene scene = new Scene(root);
			scene.getRoot().requestFocus();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){

				@Override
				public void handle(KeyEvent event) {
					scene.getRoot().requestFocus();
					
				}
				
			});
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		launch(args);
	}
}
