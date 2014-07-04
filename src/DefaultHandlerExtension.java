import java.util.HashMap;
import java.util.Map;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

final class DefaultHandlerExtension extends DefaultHandler {
	private final Map<String, Integer> tagCount = new HashMap<>();
	private boolean inTheZone;
	private String lastUsername;
	private boolean inId;

	@Override
	public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
			throws SAXException {

		if (qName.equals("username")) {
			this.inTheZone = true;
		} else if (qName.equals("id")) {
			inId = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("username")) {
			inTheZone = false;
		} else if (qName.equals("id")) {
			inId = false;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (inTheZone) {
			String contributor = new String(ch, start, length);
			lastUsername = contributor;
			if (!tagCount.containsKey(contributor)) {
				tagCount.put(contributor, 1);
			} else {
				tagCount.put(contributor, tagCount.get(contributor) + 1);
			}
		}
	}

	public Map<String, Integer> getTagCount() {
		return tagCount;
	}
}