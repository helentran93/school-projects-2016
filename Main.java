package adapter;

public class Main {

	public static void main(String[] args) {

		Pelikonsoli ps4 = new PS4peli();

		//adaptee-olio
		PS3peli ps3peli = new PS3peli();

		//olioadapteriin v‰litet‰‰n adaptee-olio
		Pelikonsoli pelikonsoli = new SuperAdapter(ps3peli);

		ps4.pelaa("Mirror's Edge: Catalyst");
		pelikonsoli.pelaa("Uncharted 2");
	}

}
