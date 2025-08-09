package task;

import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(12345);
		System.out.println("Server started...");

		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("New client connected: " + socket);
			ClientHandler clientHandler = new ClientHandler(socket);
			clientHandler.start();
		}
	}
}

class ClientHandler extends Thread {
	private Socket socket;

	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);) {
			String message;
			while ((message = reader.readLine()) != null) {
				System.out.println("Received message: " + message);
				writer.println("Echo: " + message); // Echo back to client
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
