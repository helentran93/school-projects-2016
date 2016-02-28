package mvc;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import lejos.robotics.mapping.LineMap;

/**
 * Näkymässä tuotetaan käyttöliittymä käyttäjälle ja
 * kommunikoi käyttäjän kanssa tulosteiden ja syötteiden avulla.
 *
 * @author Helen
 *
 */
public class View extends Application implements View_IF{

	/**
	 *Muuttuja, joka on olio Controller_IF-luokasta.
	 */
	private Controller_IF ohjain;
	/**
	 * Muuttujat, jotka edustavat olioina Button-luokasta.
	 * Yksinkertaisella napinpainalluksella saadaan aikaan erilaisia toimintoja.
	 */
	private Button nappi, nappi2, nappi3, nappi4, nappi5, nappi6;
	/**
	 * Muuttuja, joka edustaa oliona Text-luokasta.
	 * Ilmestyy tekstin muodossa ikkunoihin ja tarvittaessa saattavat muuttaa
	 * tekstiä tilanteiden mukaan.
	 */
	private Text teksti, ilmoitus;
	/**
	 * Muuttuja, joka edustaa oliona Näyttö-luokasta.
	 */
	private Näyttö pohja;
	/**
	 * Muuttujia, jotka edustavat olioina TextField-luokasta. Käyttäjä syöttää
	 * näihin arvot, joiden kautta niitä voidaan käsitellä.
	 */
	private TextField x, y, x2, y2;
	private Label update;

	@Override
	public void init(){
		Model_IF malli = new Model();
		ohjain = new Controller(this, malli);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("GUI - RoboScorpion");

		HBox juuri = createHBoxi();

		Scene scene = new Scene(juuri);
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	private HBox createHBoxi(){

		HBox hboxi = new HBox();
		hboxi.setPadding(new Insets(100, 200, 100, 200));
		hboxi.setSpacing(10);

		teksti = new Text("Käynnistä robotti ensin.");
		teksti.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		teksti.setTextAlignment(TextAlignment.CENTER);

		nappi2 = new Button("Luo kartta");
		nappi2.setAlignment(Pos.CENTER);
		nappi2.setPrefSize(123, 5);
		nappi2.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Stage uusiStage = new Stage();
				uusiStage.setTitle("Kartan luonti");
				pohja = new Näyttö(400, 320);

				HBox uusiHboxi = new HBox();
				uusiHboxi.setPadding(new Insets(15, 5, 15, 5));

				VBox kuvaBoxi = new VBox();
				kuvaBoxi.setPadding(new Insets(0, 5, 0, 5));
				kuvaBoxi.getChildren().add(pohja);

				GridPane pop = new GridPane();
				pop.setVgap(5);
				pop.setPadding(new Insets(10, 15, 10, 15));

				nappi3 = new Button("Piirrä seinä");
				nappi3.setPrefSize(155, 5);
				nappi3.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {
						try{
							ohjain.seinänLuonti(Float.parseFloat(x.getText()), Float.parseFloat(y.getText()),
									Float.parseFloat(x2.getText()), Float.parseFloat(y2.getText()));

						} catch(Exception e){
							JOptionPane.showMessageDialog(null, "Koordinaattien on oltava numeroina!");

						}
						x.clear();
						y.clear();
						x2.clear();
						y2.clear();
					}

				});

				nappi5 = new Button("Tyhjennä taulu");
				nappi5.setPrefSize(155, 5);
				nappi5.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {
						try{
							pohja.pyyhiTaulu();
							ohjain.seinänTuho();
						} catch(Exception e){
							JOptionPane.showMessageDialog(null, "Taulu on pyyhitty.");
						}
					}

				});

				Label arvoX = new Label("x:n arvo");
				pop.add(arvoX, 0, 0);

				x = new TextField();
				pop.add(x, 0, 1);

				Label arvoY = new Label("y:n arvo");
				pop.add(arvoY, 0, 2);

				y = new TextField();
				pop.add(y, 0, 3);

				Label arvoX2 = new Label("x2:n arvo");
				pop.add(arvoX2, 0, 4);

				x2 = new TextField();
				pop.add(x2, 0, 5);

				Label arvoY2 = new Label("y2:n arvo");
				pop.add(arvoY2, 0, 6);

				y2 = new TextField();
				pop.add(y2, 0, 7);

				ilmoitus = new Text("Aseta koordinaatit.");
				ilmoitus.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
				ilmoitus.setTextAlignment(TextAlignment.CENTER);
				pop.add(ilmoitus, 0, 8);


				nappi4 = new Button("Tyhjennä");
				nappi4.setPrefSize(155, 5);
				nappi4.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {
						x.clear();
						y.clear();
						x2.clear();
						y2.clear();
					}

				});

				nappi = new Button("Yhteydenluonti");
				nappi.setAlignment(Pos.CENTER);
				nappi.setPrefSize(123, 5);
				nappi.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event){
						Stage uusiStage = new Stage();
						uusiStage.setTitle("Yhteydenluonti");
						pohja = new Näyttö(400, 320);

						ohjain.kartanTuonti();

						update = new Label();
						update.setText("Valmiina...");

						ilmoitus = new Text("Muistitko käynnistää robotti ensin?");

						nappi6 = new Button("Luo yhteys robottiin");
						nappi6.setPrefSize(155, 5);
						nappi6.setOnAction(new EventHandler<ActionEvent>(){

							@Override
							public void handle(ActionEvent event) {
								try{
									ohjain.yhteysStart();	//miten saada pallo liikkumaan robotin koordinaattien mukaisesti?
								} catch(Exception e){
									JOptionPane.showMessageDialog(null, "Robottiin ei saada yhteyttä!");
								}
							}

						});

						HBox uusiHboxi = new HBox();
						uusiHboxi.setPadding(new Insets(0, 5, 0, 5));

						VBox kuvaBoxi = new VBox();
						kuvaBoxi.setPadding(new Insets(10, 15, 10, 15));
						kuvaBoxi.getChildren().add(pohja);

						GridPane pop = new GridPane();
						pop.setVgap(5);
						pop.setHgap(10);
						pop.setPadding(new Insets(10, 15, 10, 15));

						pop.add(update, 0, 4);
						pop.add(nappi6, 0, 5);
						pop.add(ilmoitus, 0, 7);

						uusiHboxi.getChildren().addAll(pop, kuvaBoxi);

						Scene uusiScene = new Scene(uusiHboxi, 700, 350);
						uusiStage.setScene(uusiScene);
						uusiStage.show();
					}
				});

				VBox nappiBoxi = new VBox(8);
				nappiBoxi.setPadding(new Insets(26, 5, 26, 5));

				nappiBoxi.getChildren().add(nappi3);
				nappiBoxi.getChildren().add(nappi5);
				nappiBoxi.getChildren().add(nappi4);
				nappiBoxi.getChildren().add(nappi);

				uusiHboxi.getChildren().addAll(pop, nappiBoxi, kuvaBoxi);

				Scene uusiScene = new Scene(uusiHboxi, 700, 350);
				uusiStage.setScene(uusiScene);
				uusiStage.show();
			}

		});

		GridPane gridi = new GridPane();
		gridi.setAlignment(Pos.CENTER);
		gridi.setVgap(15);

		gridi.add(teksti, 0, 1);
		gridi.add(nappi2, 0, 2);


		hboxi.getChildren().addAll(gridi);

		return hboxi;
	}


	@Override
	public void setYhteys(boolean yhteys) {
		if(yhteys == true){
			Vastaanottaja v = new Vastaanottaja(ohjain);
			v.start();
			update.setText("Yhteys muodostettu.");
		}else{
			update.setText("Yhteyden muodostaminen ei onnistunut.");
		}
	}

	@Override
	public void setKartta(Seinä[] getSeinä) {
		for(Seinä s: getSeinä){
			pohja.piirräSeinä(s.x, s.y, s.x2, s.y2);
		}
	}

	public void setSeinä(Seinä[] getSeinä){
		for(Seinä s: getSeinä){
			pohja.piirräSeinä(s.x, s.y, s.x2, s.y2);
		}
	}

	@Override
	public void updateTextLabel(String msg) {
		update.setText(msg);
	}

	@Override
	public void updateNäyttö(float x, float y) {
		pohja.piirräPaikannus(x, y);
	}

	public static void main(String[] args){
		launch(args);
	}












}
