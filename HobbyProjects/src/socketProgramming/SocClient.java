package socketProgramming;

import java.net.Socket;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
public class SocClient {
	
	public static void main(String[] args)throws Exception
	{
		String ip="localhost";
		int port=9999; //0-1023 are blocked maximum 65535
		Socket s =new Socket(ip,port); //Creates a socket from the clienet side
		String str="Pradosa patnaik"; //Data to be sent from the client
		
		OutputStreamWriter os=new OutputStreamWriter(s.getOutputStream()); // this class is bridge to convert characters to byte
		PrintWriter out=new PrintWriter(os);//prints the formatted objects to text-output stream
//		os.write(str);
//		os.flush();
		out.println(str);
		out.flush();
		
		BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream()));
		String nickName=br.readLine();
		System.out.println("Nickname:"+nickName);
//		System.out.print("connection successful");
		s.close();
//		os.close();
	}

}
