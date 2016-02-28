package valuuttakone;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ValuuttaAccessObject implements ValuuttaDAO_IF {


	private Valuutta valuutta;
	private Connection connect = null;
	private Statement kysely = null;
	private ResultSet tulos = null;

	public ValuuttaAccessObject(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			System.err.println("Ajurin lataus epäonnistui.");
		}
	}

	@Override
	public boolean createValuutta(Valuutta valuutta) {
		try{
			connect = DriverManager.getConnection("jdbc:mysql://localhost/valuutat","olso","olso");
		}catch(SQLException e){
			System.err.println("Yhteyden avaus epäonnistui.");
		}

		try{
			String x = "insert into valuutta (tunnus, vaihtokurssi, nimi)" + "values (?, ?, ?)";
			PreparedStatement prepared = connect.prepareStatement(x);
			prepared.setString(1, valuutta.tunnus);
			prepared.setFloat(2, valuutta.vaihtokurssi);
			prepared.setString(3, valuutta.nimi);

			prepared.executeUpdate();
			if (prepared != null){
				System.out.println("Uuden valuutan lisääminen onnistui!");
				prepared.close();
				connect.close();
				return true;
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("Uuden valuutan lisääminen epäonnistui.");
		return false;
	}

	@Override
	public Valuutta readValuutta(String tunnus) {

		try{
			connect = DriverManager.getConnection("jdbc:mysql://localhost/valuutat","olso","olso");
		}catch(SQLException e){
			System.err.println("Yhteyden avaus epäonnistui.");
		}
		try {
			kysely = connect.createStatement();
			tulos = kysely.executeQuery("select * from valuutta where tunnus='"+tunnus+"'");

			if(tulos.next()){
				String rahatunnus = tulos.getString("tunnus");
				float rahavaihtokurssi = tulos.getFloat("vaihtokurssi");
				String rahanimi = tulos.getString("nimi");
				valuutta = new Valuutta(rahatunnus, rahavaihtokurssi, rahanimi);
				System.out.println(valuutta.tunnus+" "+valuutta.vaihtokurssi+" "+valuutta.nimi);
			}

			}catch(SQLException e){
				System.err.println("Kyselyä ei voida suorittaa");
			}finally{
				try{
					if(tulos != null)
						tulos.close();
					if(kysely != null)
						kysely.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		return valuutta;
		}


	@Override
	public Valuutta[] readValuutat() {
		ArrayList<Valuutta> valuutat = new ArrayList<Valuutta>();
		try{
			connect = DriverManager.getConnection("jdbc:mysql://localhost/valuutat","olso","olso");
		}catch(SQLException e){
			System.err.println("Yhteyden avaus epäonnistui.");
		}

		try{
			kysely = connect.createStatement();
			tulos = kysely.executeQuery("select * from valuutta");

			while(tulos.next()){
				String tunnus = tulos.getString("tunnus");
				float vaihtokurssi = tulos.getFloat("vaihtokurssi");
				String nimi = tulos.getString("nimi");
				valuutta = new Valuutta(tunnus, vaihtokurssi, nimi);
				valuutta.setTunnus(tunnus);
				valuutta.setVaihtokurssi(vaihtokurssi);
				valuutta.setNimi(nimi);
				valuutat.add(valuutta);
			}
		}catch(SQLException e){
			System.err.println("Kyselyä ei voida suorittaa.");
		}finally{
			try{
				if (tulos != null){
					tulos.close();
				}if(kysely != null){
					kysely.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		Valuutta[] palautaTiedot = new Valuutta[valuutat.size()];
		for(Valuutta v: valuutat){
			System.out.println(v.tunnus+" "+v.vaihtokurssi+" "+v.nimi);
		}
		return (Valuutta[])valuutat.toArray(palautaTiedot);
	}

	@Override
	public boolean updateValuutta(Valuutta valuutta) {
		try{
			connect = DriverManager.getConnection("jdbc:mysql://localhost/valuutat","olso","olso");
		}catch(SQLException e){
			System.err.println("Yhteyden avaus epäonnistui.");
		}
		try{
			PreparedStatement prepared = connect.prepareStatement("update valuutta set vaihtokurssi= ? where tunnus= ? and nimi= ?");
			prepared.setFloat(1, valuutta.vaihtokurssi);
			prepared.setString(2, valuutta.tunnus);
			prepared.setString(3, valuutta.nimi);
			prepared.executeUpdate();


			if(prepared != null){
				System.out.println("Vaihtokurssin muuttaminen onnistui!");
				prepared.close();
			}

			if(connect != null){
				connect.close();
				return true;
			}

		}catch(SQLException e){
			System.err.println("Kyselyä ei voida suorittaa.");
		}
		System.out.println("Vaihtokurssin muuttaminen ei onnistunut.");
		return false;
	}

	@Override
	public boolean deleteValuutta(String tunnus) {
		try{
			connect = DriverManager.getConnection("jdbc:mysql://localhost/valuutat","olso","olso");
		}catch(SQLException e){
			System.err.println("Yhteyden avaus epäonnistui.");
		}

		try{
			PreparedStatement prepared = connect.prepareStatement("delete from valuutta where tunnus = ?");
			prepared.setString(1, tunnus);
			prepared.executeUpdate();

			if(prepared != null){
				System.out.println("Rivin poistaminen onnistui!");
				prepared.close();
			}

			if(connect != null){
				connect.close();
				return true;
			}
		}catch(SQLException e){
			System.err.println("Kyselyä ei voida suorittaa.");
		}
		System.out.println("Rivin poistaminen epäonnistui.");
		return false;
	}

	public static void main(String[] args){

		ValuuttaAccessObject vao = new ValuuttaAccessObject();
		String valinta, rahatunnus, rahanimi;
		float rahakurssi;
		Scanner lukija = new Scanner(System.in);
		Valuutta valuutta = null;

		do{
			System.out.println("C: Lisää uusi valuutta tietokantaan");
			System.out.println("R: Listaa tietokannassa olevien valuuttojen tiedot");
			System.out.println("U: Päivitä valuutan vaihtokurssi tietokantaan");
			System.out.println("D: Poista valuutta tietokannasta");
			System.out.println("Q: Lopetus");
			System.out.print("Valintasi: ");
			valinta = lukija.next();

			switch(valinta){
			case "C": System.out.println("Anna valuutan arvot tietokantaan lisättäväksi: ");
			          System.out.println("Tunnus: ");
			          rahatunnus = lukija.next();

			          System.out.println("Vaihtokurssi: ");
			          rahakurssi = lukija.nextFloat();

			          System.out.println("Nimi: ");
			          rahanimi = lukija.next();

			          valuutta = new Valuutta(rahatunnus, rahakurssi, rahanimi);
				      vao.createValuutta(valuutta);
			          break;
			case "R": vao.readValuutat();
			          break;
			case "U": System.out.print("Anna rahayksikön tunnus: ");
					  rahatunnus = lukija.next();

					  vao.readValuutta(rahatunnus);

					  System.out.println("Muuta sen vaihtokurssi: ");
					  rahakurssi = lukija.nextFloat();
					  valuutta = new Valuutta(rahatunnus, rahakurssi, vao.readValuutta(rahatunnus).nimi);

			          vao.updateValuutta(valuutta);
			          break;
			case "D": System.out.println("Anna rahayksikön tunnus: ");
					  rahatunnus = lukija.next();

					  vao.deleteValuutta(rahatunnus);
			          break;
			case "Q": valinta = "Q";
			}
		}while(valinta != "Q");
		System.out.println("Kiitos käynnistä!");
	}
}
