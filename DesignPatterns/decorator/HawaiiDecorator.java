package decorator;

public class HawaiiDecorator extends PizzaDecorator{

	private int hinta = 5;

	public HawaiiDecorator(Pizza pizzaKoristeltavaksi) {
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
		return super.getPizzaInfo() + "ananasta, kinkkua";
	}

	@Override
	public void luoPizza() {
		// TODO Auto-generated method stub
		super.luoPizza();
		koristeleHawaiilla();
	}

	private void koristeleHawaiilla() {
		int menuHinta = getHinta() + super.getHinta();
		System.out.println("Hawaii-täyteellä, " + menuHinta + " euroa");
	}

}
