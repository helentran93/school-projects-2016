package valuuttakone;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ValuuttakoneenGUI extends Application implements ValuuttakoneenGUI_IF {

	ValuuttakoneenOhjain_IF ohjain;
	private ListView<String> mist‰ = new ListView<String>();
	private ListView<String> mihin = new ListView<String>();

	private Button nappi;
	private TextField m‰‰r‰;
	private TextField tulos;

	public void init(){
		Valuuttakone_IF malli = new Valuuttakone();
		ohjain = new ValuuttakoneenOhjain(this, malli);
	}

	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Valuuttakone");

		HBox juuri = createHBox();
		Scene scene = new Scene(juuri);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private HBox createHBox()	{

		HBox hboxi = new HBox();
		hboxi.setPadding(new Insets(15, 12, 15, 12));
		hboxi.setSpacing(15);

		mist‰.setPrefSize(125, 125);
		ObservableList<String> rahayksikˆt = FXCollections.observableArrayList(ohjain.getValuutat());
		mist‰.setItems(rahayksikˆt);

		VBox valuuttabox = new VBox();
		valuuttabox.getChildren().addAll(new Label("Mist‰"), mist‰);


		mihin.setPrefSize(125, 125);
		ObservableList<String> rahayksikˆt2 = FXCollections.observableArrayList(ohjain.getValuutat());
		mihin.setItems(rahayksikˆt2);

		VBox valuuttabox2 = new VBox();
		valuuttabox2.getChildren().addAll(new Label("Mihin"), mihin);

		GridPane vaihtajaGridi = new GridPane();

		vaihtajaGridi.setHgap(5);
		vaihtajaGridi.setVgap(5);
		vaihtajaGridi.setPadding(new Insets(0, 5, 0, 5));

		Label m‰‰r‰nTieto = new Label("M‰‰r‰");
		vaihtajaGridi.add(m‰‰r‰nTieto, 0, 2);

		m‰‰r‰ = new TextField();
		vaihtajaGridi.add(m‰‰r‰, 0, 3);

		nappi = new Button("Muuta");
		nappi.setPrefSize(155, 20);
		vaihtajaGridi.add(nappi, 0, 4);
		nappi.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				try{
					ohjain.muunnos();
				}catch(Exception a){
					JOptionPane.showMessageDialog(null, "Valuuttam‰‰r‰ on oltava numeroina!");
				}
			}
		});

		Label tulosTieto = new Label("Tulos");
		vaihtajaGridi.add(tulosTieto, 0, 5);

		tulos = new TextField();
		vaihtajaGridi.add(tulos, 0, 6);

		hboxi.getChildren().addAll(valuuttabox, valuuttabox2, vaihtajaGridi);

	return hboxi;
	}

	@Override
	public int getL‰htˆIndeksi() {
		return mist‰.getSelectionModel().getSelectedIndex();
	}

	@Override
	public int getKohdeIndeksi() {
		return mihin.getSelectionModel().getSelectedIndex();
	}

	@Override
	public double getM‰‰r‰() throws NumberFormatException{
		double vastaus = Double.parseDouble(m‰‰r‰.getText());
		return vastaus;
	}

	@Override
	public void setTulos(double m‰‰r‰) {
		tulos.setText(Double.toString(m‰‰r‰));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
