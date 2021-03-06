package no.hvl.dat110.messaging;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MessagingServer {

	private ServerSocket welcomeSocket;

	public MessagingServer(int port) {

		try {

			this.welcomeSocket = new ServerSocket(port);

		} catch (IOException ex) {

			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	// accept an incoming connection from a client
	public Connection accept() {

		Connection connection = null;

		// TODO:COMPLETE
		// accept TCP connection on welcome socket and create messaging connection
		Socket socket;
		
		try {
			socket = welcomeSocket.accept();
			connection = new Connection(socket);
			return connection;
		} catch (IOException e) {
			System.out.println("Connection error: " + e.getMessage());
			e.printStackTrace();
			return null;
			
		}


	}

	public void stop() {

		if (welcomeSocket != null) {

			try {
				welcomeSocket.close();
			} catch (IOException ex) {

				System.out.println("Messaging server: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

}
