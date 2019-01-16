package przychodnia;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


/*Podstawowa klasa, która inicjuje start aplikacji*/
public class CalendarApp extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getClassLoader().getResource("kalendarz/resources/Calendar.fxml"));
		Pane Pane = loader.load();
		Scene scene = new Scene(Pane);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Kalendarz");
		primaryStage.setResizable(false);
		primaryStage.setOnHidden(e -> Platform.exit());
	}
}