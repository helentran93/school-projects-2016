package decorator;

public class MargheritaDecorator extends PizzaDecorator {

	private int hinta = 4;

	public MargheritaDecorator(Pizza pizzaKoristeltavaksi) {
		super(pizzaKoristeltavaksi);
	}

	@Override
	public int getHinta() {
		// TODO Auto-generated method stub
		return hinta;
	}

	@Override
	public String getPizzaInfo() {
		// TODO Auto-generated method stub
		return super.getPizzaInfo() + "mozzarellaa, kirsikkatomaatteja, basilikaa";
	}

	@Override
	public void luoPizza() {
		// TODO Auto-generated method stub
		super.luoPizza();
		koristeleMargheritalla();
	}

	private void koristeleMargheritalla() {
		int menuHinta = getHinta() + super.getHinta();
		System.out.println("Margherita-täyteellä, " + menuHinta + " euroa");
	}
}
