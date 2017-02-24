package proxy;

public class RealImage implements Image {

	private String filename = null;

	public RealImage(final String filename) {
		this.filename = filename;
		loadImageFromDisk();
	}

	//lataa kuvan levylt‰
	private void loadImageFromDisk() {
		System.out.println("Loading " + filename);
	}

	//esitt‰‰ kuvaa
	@Override
	public void displayImage() {
		// TODO Auto-generated method stub
		System.out.println("Displaying " + filename);
	}

	//n‰ytt‰‰ kuvan nimen
	@Override
	public String showData() {
		// TODO Auto-generated method stub
		return "Name of the file: "+ this.filename;
	}

}
