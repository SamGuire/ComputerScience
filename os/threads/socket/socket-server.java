import java.net.*;
import java.io.*;
class SocketServer {
	private static ServerSocket server;
	public static void startListening() throws Exception {
		PrintWriter outputStream;
		BufferedReader inputStream; 
		try {
		SocketServer.server = new ServerSocket(3000);
		while (true) {
			System.out.println("Waiting for connections....");
			Socket connection = server.accept();
			System.out.println("Connection has been made and accepted !");
			outputStream = new PrintWriter(connection.getOutputStream(),true);
			inputStream=  new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String clientMsg = inputStream.readLine();
			System.out.println(String.format("Client sent %s from %s",clientMsg,connection.getRemoteSocketAddress()));
			outputStream.println("Hello client my name is server");
		}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		try {
		SocketServer.startListening();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

