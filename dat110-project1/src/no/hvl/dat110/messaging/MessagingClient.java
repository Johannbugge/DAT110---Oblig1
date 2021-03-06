package no.hvl.dat110.messaging;

import java.io.IOException;

import java.net.Socket;


public class MessagingClient {

	private String server;
	private int port;

	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}

	// connect to messaging server
	@SuppressWarnings("resource")
	public Connection connect() {

		Socket clientSocket = new Socket();
		Connection connection = null;

		// TODO: COMPLETE
		// create TCP socket for client and connection
		// create connection object
		
		try {
			clientSocket = new Socket(server, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		connection = new Connection(clientSocket); 

		return connection;
	}
}