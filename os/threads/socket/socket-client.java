import java.net.*;
import java.io.*;


class ClientSocket {
	public static String sendMessage(String msg) throws Exception {
		try {
		Socket socket = new Socket("127.0.0.1",3000);
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out.println(msg);
		String response = in.readLine();
		socket.close();
		return response;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
	public static void main(String[] args) {
		try {
			ClientSocket.sendMessage("Hello from client!");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
		
