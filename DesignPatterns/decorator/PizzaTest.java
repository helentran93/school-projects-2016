package decorator;

public class PizzaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pizza hawaiiPizza = new HawaiiDecorator(new PizzaPohja());
		Pizza pepperoniPizza = new PepperoniDecorator(new PizzaPohja());
		Pizza margheritaPizza = new MargheritaDecorator(new PizzaPohja());

		System.out.println("---- Á la halpa Pizza ----");
		hawaiiPizza.luoPizza();
		System.out.println(hawaiiPizza.getPizzaInfo());
		pepperoniPizza.luoPizza();
		System.out.println(pepperoniPizza.getPizzaInfo());
		margheritaPizza.luoPizza();
		System.out.println(margheritaPizza.getPizzaInfo());

	}

}
