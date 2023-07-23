package http.header;

import java.util.HashMap;
import java.util.Map;

public class Header {
	public static final String HEADER_DELIMITER = ": ";
	private Map<String, String> header = new HashMap<>();

	public String getHeaderLines() {
		StringBuilder stringBuilder = new StringBuilder();
		for (String key : header.keySet()) {
			stringBuilder.append(key + HEADER_DELIMITER + header.get(key) + "\r\n");
		}
		stringBuilder.append("\r\n");
		return stringBuilder.toString();
	}

	public void addHeader(String key, String value) {
		header.put(key, value);
	}
}
