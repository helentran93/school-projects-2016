package adapter;

public class PS4peli implements Pelikonsoli {

	@Override
	public void pelaa(String peli) {
		// TODO Auto-generated method stub
		System.out.println("PS4 k�ynnistyy..");
		System.out.println("Pelikonsoliin on sy�tetty " + peli + ".");
		System.out.println("Peli� valmistellaan...");
		System.out.println("Nyt voit pelata!");
	}

}
