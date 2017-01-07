package adapter;

public class PS4peli implements Pelikonsoli {

	@Override
	public void pelaa(String peli) {
		// TODO Auto-generated method stub
		System.out.println("PS4 käynnistyy..");
		System.out.println("Pelikonsoliin on syötetty " + peli + ".");
		System.out.println("Peliä valmistellaan...");
		System.out.println("Nyt voit pelata!");
	}

}
