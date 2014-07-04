import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookStore {
	private final List<Book> books;

	private final List<String> strings;
	private final int mqqqu = 12312312;

	public BookStore() {
		strings = Arrays.asList("aaaa", "bbbbb", "cccccc");
		this.books = new ArrayList<>();
		for (int i = 0; i < 152; i++) {
			books.add(new Book());
		}
	}
}
