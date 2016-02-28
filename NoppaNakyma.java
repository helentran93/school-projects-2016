package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class NoppaNäkymä extends Application implements NoppaNäkymä_IF{

	private NoppaOhjain_IF ohjain;
	private Button nappi;
	private Text teksti;

	@Override
	public void init(){
		NoppaMalli_IF malli = new NoppaMalli();
		ohjain = new NoppaOhjain(this, malli);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Nopan heitto - MVC");

		nappi = new Button();
		teksti = new Text();

		nappi.setText("Heitä noppa!");
		nappi.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				ohjain.nopanHeitto();
			}

		});

		teksti.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		teksti.setTextAlignment(TextAlignment.CENTER);

		GridPane gridi = new GridPane();
		gridi.setAlignment(Pos.CENTER);
		gridi.setVgap(10);

		gridi.add(nappi, 0, 0);
		gridi.add(teksti, 0, 1);

		Scene scene = new Scene(gridi, 200, 100);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	@Override
	public void setSilmäluku(int luku) {
		teksti.setText("Noppa: "+String.valueOf(luku));
	}

	public static void main(String[] args){
		launch(args);
	}


}
