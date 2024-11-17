import java.io.*;
import java.net.*;

class ServerFile
{
    public static void main(String Arg[]) throws Exception
    {
        System.out.println("Server of Chat Messenger running.....");
        ServerSocket ssobj = new ServerSocket(2100);
        System.out.println("Server of Chat Messenger in listening mode at port no: 2100");

        Socket sobj = ssobj.accept();
        System.out.println("Client and server connection is successfull...");

        PrintStream ps = new PrintStream(sobj.getOutputStream());

        BufferedReader br1= new BufferedReader(new InputStreamReader(sobj.getInputStream()));
        BufferedReader br2= new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Marvellous chat started...");

        String str1, str2;

        while((str1=br1.readLine())!=null)
        {
            System.out.println("Client Says: "+str1);
            System.out.println("Enter message for client: ");
            str2 = br2.readLine();
            ps.println(str2);
        }

        System.out.println("Thakyou for using chat messeger..");

        sobj.close();
        ps.close();
        br1.close();
        br2.close();

    }
}
