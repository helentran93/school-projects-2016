package valuuttakone;

public interface ValuuttakoneenGUI_IF {
	public abstract int getLähtöIndeksi();
	public abstract int getKohdeIndeksi();
	public abstract double getMäärä();
	public abstract void setTulos(double määrä);
}
