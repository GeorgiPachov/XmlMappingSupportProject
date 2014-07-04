import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EGN {
	private final long number;

	public EGN() {
		this(900000);
	}

	public EGN(long number) {
		this.number = number;
	}

	public long getNumber() {
		return number;
	}
}
