package proxy;

public class ProxyImage implements Image {

	private RealImage image = null;
	private String filename = null;

	public ProxyImage(final String filename) {
		this.filename = filename;
	}

	//p‰‰tt‰‰, pit‰‰kˆ ladata kuvaa tai esitt‰‰ se samantien
	@Override
	public void displayImage() {
		// TODO Auto-generated method stub
		//jos kuva ei ole viel‰ ladattu
		if(image == null) {
			image = new RealImage(filename);
		}
		image.displayImage();
	}

	//n‰ytet‰‰n kuvan tieto ilman lataamista
	@Override
	public String showData() {
		// TODO Auto-generated method stub
		return this.filename;
	}

}
