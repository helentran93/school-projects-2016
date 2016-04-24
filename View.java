package mvc;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import lejos.robotics.geometry.Rectangle;

/**
 * Näkymässä tuotetaan käyttöliittymä käyttäjälle ja kommunikoi käyttäjän kanssa
 * tulosteiden ja syötteiden avulla.
 *
 * @author Helen
 * @version Java 8
 *
 */
public class View extends Application implements View_IF {

	/**
	 * Muuttuja, joka on olio Controller_IF-luokasta.
	 */
	private Controller_IF ohjain;
	/**
	 * Olio Button-luokasta. Yksinkertaisella
	 * napinpainalluksella saadaan aikaan luodaan yhteys robottiin.
	 */
	private Button nappi;
	/**
	 * Olio Button-luokasta. Yksinkertaisella
	 * napinpainalluksella saadaan aikaan luodaan yhteys robottiin.
	 */
	private Button nappi2;
	/**
	 * Olio Button-luokasta. Yksinkertaisella
	 * napinpainalluksella asetetaan tarkastuspisteitä.
	 */
	private Button nappi3;
	/**
	 * Olio Button-luokasta. Yksinkertaisella
	 * napinpainalluksella luodaan seiniä.
	 */
	private Button nappi4;
	/**
	 * Olio Button-luokasta. Yksinkertaisella
	 * napinpainalluksella tyhjennetään tekstikentät.
	 */
	private Button nappi5;
	/**
	 * Olio Button-luokasta. Yksinkertaisella
	 * napinpainalluksella luodaan alue.
	 */
	private Button nappi6;
	/**
	 * Olio Text-luokasta. Ilmestyy tekstin muodossa
	 * ikkunaan ja tarvittaessa saattaa muuttaa tekstiä tilanteiden mukaan.
	 */
	private Text teksti;
	/**
	 * Olio Text-luokasta. Teksti ilmestyy ohjeena ikkunaan.
	 */
	private Text ilmoitus;
	/**
	 * Olio Text-luokasta. Ilmestyy tekstin muodossa
	 * ikkunaan ja tarvittaessa saattaa muuttaa tekstiä tilanteiden mukaan.
	 */
	private Text huomio;
	/**
	 * Olio Näyttö-luokasta. Sisältää erilaisia metodeja,
	 * jotka liittyvät taulun toteuttamiseen ja piirtämiseen.
	 */
	private Näyttö pohja;
	/**
	 * Olio TextField-luokasta. Tekstikenttään on syötettävä x-arvo.
	 */
	private TextField x;
	/**
	 * Olio TextField-luokasta. Tekstikenttään on syötettävä y-arvo.
	 */
	private TextField y;
	/**
	 * Olio TextField-luokasta. Tekstikenttään on syötettävä x2-arvo/leveyden arvo.
	 */
	private TextField x2;
	/**
	 * Olio TextField-luokasta. Tekstikenttään on syötettävä y2-arvo/korkeuden arvo.
	 */
	private TextField y2;
	/**
	 * Näyttää tekstiä käyttäjälle ja se voi muuttua tilanteiden mukaan, mutta
	 * käyttäjä ei voi muokata sitä suoraan.
	 */
	private Label update;
	/**
	 * Toimii nimikkeenä jokaiselle tekstikentälle.
	 */
	private Label arvoX, arvoY, arvoX2, arvoY2;

	@Override
	public void init() {
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

	private HBox createHBoxi() {

		Stage uusiStage = new Stage();
		uusiStage.setTitle("Kartan luonti ja yhteyden muodostaminen");
		pohja = new Näyttö(200, 200);

		HBox uusiHboxi = new HBox();
		uusiHboxi.setPadding(new Insets(15, 5, 15, 5));

		VBox kuvaBoxi = new VBox(3);
		kuvaBoxi.setPadding(new Insets(29, 15, 29, 15));

		VBox nappiBoxi = new VBox(8);
		nappiBoxi.setPadding(new Insets(50, 5, 26, 5));

		GridPane pop = new GridPane();
		pop.setVgap(4);
		pop.setPadding(new Insets(5, 15, 5, 15));

		pohja.lähtöKohta();

		pohja.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				try {
					ohjain.tarkistuspisteLuonti((float) event.getX(), (float) event.getY());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Tarkistuspisteen asettaminen ei onnistunut!");
				}
			}

		});

		nappi2 = new Button("Aseta tarkistuspiste");
		nappi2.setPrefSize(155, 5);
		nappi2.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				try{
					ohjain.tarkistuspisteLuonti(Float.parseFloat(x.getText()), Float.parseFloat(y.getText()));
				} catch(Exception e){
					JOptionPane.showMessageDialog(null, "Koordinaattien on oltava numeroina!");
				}
				x.clear();
				y.clear();
			}

		});

		nappi3 = new Button("Piirrä seinä");
		nappi3.setPrefSize(155, 5);
		nappi3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					ohjain.seinänLuonti(Float.parseFloat(x.getText()), Float.parseFloat(y.getText()),
							Float.parseFloat(x2.getText()), Float.parseFloat(y2.getText()));
				} catch (Exception e) {
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
		nappi5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					pohja.pyyhiTaulu();
					ohjain.kokoTuho();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Taulun pyyhkiminen epäonnistui!");
				}
			}

		});

		arvoX = new Label("x:n arvo");
		pop.add(arvoX, 0, 1);

		x = new TextField();
		pop.add(x, 0, 2);

		arvoY = new Label("y:n arvo");
		pop.add(arvoY, 0, 3);

		y = new TextField();
		pop.add(y, 0, 4);

		arvoX2 = new Label("x2:n arvo");
		pop.add(arvoX2, 0, 5);

		x2 = new TextField();
		pop.add(x2, 0, 6);

		arvoY2 = new Label("y2:n arvo");
		pop.add(arvoY2, 0, 7);

		y2 = new TextField();
		pop.add(y2, 0, 8);

		ilmoitus = new Text("Aseta koordinaatit. Jos haluat määrittää alueen,\n sijoita arvot x2- ja y2-kenttiin");
		ilmoitus.setTextAlignment(TextAlignment.CENTER);
		pop.add(ilmoitus, 0, 0);

		ilmoitus = new Text("Muista käynnistää robotti ennen yhteydenluontia.");
		pop.add(ilmoitus, 0, 9);

		teksti = new Text("Voit myös asettaa tarkistuspisteitä robotille \nklikkaamalla taulua tai syöttämällä arvot kenttään.");
		teksti.setFont(Font.font("Calibri", FontWeight.NORMAL, 13));
		pop.add(teksti, 0, 10);

		nappi4 = new Button("Tyhjennä");
		nappi4.setPrefSize(155, 5);
		nappi4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				x.clear();
				y.clear();
				x2.clear();
				y2.clear();
			}

		});

		update = new Label();
		update.setText("Valmiina...");

		nappi = new Button("Luo yhteys robottiin");
		nappi.setAlignment(Pos.CENTER);
		nappi.setPrefSize(155, 5);
		nappi.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					ohjain.yhteysStart();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Robottiin ei saada yhteyttä!");
				}

			}

		});

		nappi6 = new Button("Luo alue");
		nappi6.setPrefSize(155, 5);
		nappi6.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				try{
					ohjain.alueenLuonti(Float.parseFloat(x2.getText()), Float.parseFloat(y2.getText()));
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Alueen korkeutta ja leveyttä ei voi määrittää pienemmäksi kuin 0 ja suuremmaksi kuin 200!");
				}
				x.clear();
				y.clear();
				x2.clear();
				y2.clear();
			}

		});

		huomio = new Text();
		ilmoitus = new Text("Taulun koko on 200 cm x 200 cm");

		kuvaBoxi.getChildren().addAll(ilmoitus, pohja, huomio);
		nappiBoxi.getChildren().addAll(nappi3, nappi2, nappi6, nappi4, nappi5, nappi, update);

		uusiHboxi.getChildren().addAll(pop, nappiBoxi, kuvaBoxi);

		return uusiHboxi;
	}

	@Override
	public void setYhteys(boolean yhteys) {
		if (yhteys == true) {
			Vastaanottaja v = new Vastaanottaja(ohjain);
			v.start();
			update.setText("Yhteys muodostettu.");
		} else {
			update.setText("Yhteyden muodostaminen ei onnistunut.");
		}
	}

	public void setSeinä(Seinä[] getSeinä) {
		for (Seinä s : getSeinä) {
			pohja.piirräSeinä(s.getX(), s.getY(), s.getX2(), s.getY2());
		}
		huomio.setText("Seinä on piirretty.");
	}

	@Override
	public void updateTextLabel(String msg) {
		update.setText(msg);
	}

	@Override
	public void updatePallo(float x, float y) {
		pohja.piirräPaikannus(x, y);
	}

	@Override
	public void setPiste(Piste[] getPiste) {
		for (Piste p : getPiste) {
			pohja.piirräPiste(p.getX(), p.getY());
		}
		huomio.setText("Piste on piirretty.");
	}

	@Override
	public void setTuho(Seinä[] seinä, Piste[] piste, Rectangle suorakulmio) {
		huomio.setText("Taulu on pyyhitty!");
		pohja.lähtöKohta();
	}

	@Override
	public void setAlue(Rectangle suorakulmio) {
		pohja.piirräAlue(suorakulmio.width, suorakulmio.height);
		huomio.setText("Alue on piirretty.");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
