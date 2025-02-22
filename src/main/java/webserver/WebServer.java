package webserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import annotations.DeclaredControllers;
import annotations.DeclaredViewPolicies;

public class WebServer {
	private static final ExecutorService executorService = Executors.newWorkStealingPool();
	private static final int DEFAULT_PORT = 8080;
	private static final Logger logger = LoggerFactory.getLogger(WebServer.class);

	public static void main(String[] args) throws Exception {
		// 서버소켓을 생성한다. 웹서버는 기본적으로 8080번 포트를 사용한다.
		int port = getPort(args);

		try (ServerSocket listenSocket = new ServerSocket(port)) {
			logger.info("Web Application Server started {} port.", port);

			DeclaredControllers.initialize();
			DeclaredViewPolicies.initialize();

			// 클라이언트가 연결될때까지 대기한다.
			Socket connection;
			while ((connection = listenSocket.accept()) != null) {
				Runnable requestHandler = new RequestHandler(connection);
				executorService.submit(requestHandler);
			}
		} finally {
			executorService.shutdown();
		}
	}

	private static int getPort(final String[] args) {
		if ((args == null) || (args.length == 0)) {
			return DEFAULT_PORT;
		}
		return Integer.parseInt(args[0]);
	}
}
