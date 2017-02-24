package decorator;

public class PizzaPohja implements Pizza {

	private int hinta = 3;

	@Override
	public int getHinta() {
		// TODO Auto-generated method stub
		return hinta;
	}

	@Override
	public String getPizzaInfo() {
		// TODO Auto-generated method stub
		return "Pizzapohjaan tulee ";
	}

	@Override
	public void luoPizza() {
		System.out.print("Pizza ");
	}


}
