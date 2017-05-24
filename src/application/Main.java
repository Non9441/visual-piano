package application;
<<<<<<< HEAD:src/application/Main.java

import java.io.IOException;
=======
>>>>>>> 97d53e10669486f9732bb7b1e47a7e43f479c4a7:src/application/Main.java

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

	public static void main(String[] args) {
		launch(args);
	}
}
