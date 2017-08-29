package socketProgramming;

import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
public class SocServer {
	
	public static void main(String[] args) throws Exception
	{
		System.out.println("S:Serve has started");
		ServerSocket ss=new ServerSocket(9999); //Create a 
		System.out.println("S:Waiting for client");
		Socket s=ss.accept();
		System.out.println("S:client connected");
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str=br.readLine();
		System.out.print(str);
		
		String nickName= str.substring(0, 7); //Extract the first name from the the fullname
		
		OutputStreamWriter osw=new OutputStreamWriter(s.getOutputStream());
		PrintWriter writer=new PrintWriter(osw);
		writer.println(nickName);
		writer.flush();
		ss.close();
		
		
		
		
	}

}
