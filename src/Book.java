import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
public class Book {
	@XmlElement
	private final int meh = 3;
	private final String title = "MyBook";
	private final String iSBN = "5125125";

	public int getMeh() {
		return meh;
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	@XmlElement
	public String getiSBN() {
		return iSBN;
	}
}
