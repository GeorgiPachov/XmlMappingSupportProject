import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamReader;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;
import org.json.simple.parser.JSONParser;

public class Main {
	public static void main(String[] args) throws IOException, JAXBException {

		Person person = new Person();
		person.addRelative(new Person());
		person.addRelative(new Person());
		person.addRelative(new Person());
		person.addRelative(new Person());


		File file = Paths.get("/tmp/meh.xml").toFile();

		JAXBContext jaxbContext = JAXBContext.newInstance(Person.class, EGN.class);

		MappedNamespaceConvention mappedNamespaceConvention = new MappedNamespaceConvention();
		// XMLStreamWriter jsonStreamWriter = new
		// MappedXMLStreamWriter(mappedNamespaceConvention, new
		// FileWriter(file));

		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(person, file/* , jsonStreamWriter */);

		// String json = new String(Files.readAllBytes(file.toPath()));
		// try {
		// JSONObject jsonObject = new JSONObject(json);
		// System.out.println(jsonObject);
		// } catch (JSONException e) {
		//
		// e.printStackTrace();
		// }

		// System.out.println(person2);

	}
}

// BookStore bookStore = new BookStore();
// Book book = new Book();
// JAXBContext jaxbContext = JAXBContext.newInstance(BookStore.class,
// Book.class);
// Marshaller marshaller = jaxbContext.createMarshaller();
// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
// Boolean.TRUE);
//
//
// File f = Paths.get("/tmp/meh.xml").toFile();
// marshaller.marshal(book, f);
//
// Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
// book = (Book) unmarshaller.unmarshal(f);