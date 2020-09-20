// client implementation

import java.net.*;
import java.io.*;
import java.util.*;
import java.rmi.*;

public class AddClient
{
    public static void main(String args[])
    {
        String host = "localhost";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:- ");
        int a = sc.nextInt();
        System.out.println("Enter the second number:- ");
        int b = sc.nextInt();

        try
        {
            AddRem remobj = (AddRem)Naming.lookup("rmi://"+host+"/AddRem");
            System.out.println(" The Addition of 2 numbers is: - ", remobj.addNum(a,b));

        }

      
         catch(RemoteException re)
        {
            re.printStackTrace();
        }

         catch(NotBoundException nbe)
        {
            nbe.printStackTrace();
        }

        catch(MalformedURLException mfe)
        {
            mfe.printStackTrace();
        }

    }
}
