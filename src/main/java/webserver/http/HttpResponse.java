package webserver.http;

import static webserver.http.header.HeaderConst.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import webserver.http.header.Header;
import webserver.http.header.MimeType;
import webserver.http.statusline.StatusCode;
import webserver.http.statusline.ResponseLine;
import webserver.http.header.Cookie;
import webserver.http.header.HeaderConst;

public class HttpResponse {
	private ResponseLine responseLine = new ResponseLine();
	private Header header = new Header();
	private byte[] body = new byte[0];
	public void response(OutputStream out) throws IOException {
		DataOutputStream dos = new DataOutputStream(out);
		responseStatusLine(dos);
		responseHeader(dos);
		responseBody(dos, body);
	}

	public void addFile(Path path) throws IOException, IllegalArgumentException {
		body = Files.readAllBytes(path);
		String fileName = path.getFileName().toString();
		String extension = fileName.substring(fileName.lastIndexOf("."));
		header.addHeader(CONTENT_TYPE, MimeType.typeOf(extension).extension + ";charset=utf-8");
		header.addHeader(CONTENT_LENGTH, String.valueOf(body.length));
	}

	public void setRedirect(final String redirectPath, StatusCode statusCode) {
		responseLine.setStatusCode(statusCode);
		header.addHeader(LOCATION, redirectPath);
	}

	public void addCookie(String cookieName, String sessionId) {
		Cookie cookie = Cookie.newCookie();
		cookie.add(cookieName, sessionId);
		header.addHeader(SET_COOKIE, cookie.toHeaderValue());
	}

	private void responseStatusLine(DataOutputStream dos) throws IOException {
		dos.writeBytes(responseLine.getStatusLineForHeader() + HeaderConst.CRLF);
	}

	private void responseHeader(DataOutputStream dos) throws IOException {
		dos.writeBytes(header.getHeaderLines());
	}

	private void responseBody(DataOutputStream dos, byte[] body) throws IOException {
		dos.write(body, 0, body.length);
		dos.flush();
	}
}
