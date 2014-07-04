import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	@Override
	public String toString() {
		return "Person [name=" + name + ", egn=" + egn + ", relatives=" + relatives + "]";
	}

	@XmlElement
	private final String name;
	@XmlElement
	private final EGN egn;
	@XmlElement
	private final List<Person> relatives;

	public Person() {
		this.egn = new EGN(9012054411L);
		this.relatives = new ArrayList<>();
		this.name = "Grigor Dimitrov";
	}

	public void addRelative(Person p) {
		relatives.add(p);
	}

	public List<Person> getRelatives() {
		return relatives;
	}
}
