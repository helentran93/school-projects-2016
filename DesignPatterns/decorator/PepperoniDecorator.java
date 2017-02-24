package decorator;

public class PepperoniDecorator extends PizzaDecorator {
	private int hinta = 7;

	public PepperoniDecorator(Pizza pizzaKoristeltavaksi) {
		super(pizzaKoristeltavaksi);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getHinta() {
		// TODO Auto-generated method stub
		return hinta;
	}

	@Override
	public String getPizzaInfo() {
		// TODO Auto-generated method stub
		return super.getPizzaInfo() + "tomaattikastiketta, pepperonimakkaraa, tonnikalaa ja juustoa";
	}

	@Override
	public void luoPizza() {
		super.luoPizza();
		koristelePepperonilla();
	}

	private void koristelePepperonilla() {
		int menuHinta = getHinta() + super.getHinta();
		System.out.println("Pepperoni-täytteellä, " + menuHinta + " euroa");
	}

}
