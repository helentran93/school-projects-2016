package decorator;

public class PizzaDecorator implements Pizza {

	protected Pizza pizzaKoristeltavaksi;

	public PizzaDecorator(Pizza pizzaKoristeltavaksi) {
		this.pizzaKoristeltavaksi = pizzaKoristeltavaksi;
	}

	@Override
	public int getHinta() {
		return pizzaKoristeltavaksi.getHinta();
	}

	@Override
	public String getPizzaInfo() {
		// TODO Auto-generated method stub
		return pizzaKoristeltavaksi.getPizzaInfo();
	}

	@Override
	public void luoPizza() {
		// TODO Auto-generated method stub
		pizzaKoristeltavaksi.luoPizza();
	}

}
