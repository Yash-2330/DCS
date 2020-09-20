package main;

import org.omg.CORBA.*;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;

public class TempConvServer {

	public static void main(String[] args) {
		
		try
		{
			// create and initialize orb object
			ORB orb = ORB.init(args,null);
			
			// instantiate servant object 
			TempcalcImpl tempImpl = new TempcalcImpl();
			orb.connect(tempImpl);
			
			// obtain intial naming context
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			
			//narrow object refernece
			NamingContext ncRef = NamingContextHelper.narrow(objRef);
			
			// register servant with Name Server
			NameComponent nc = new NameComponent("TEMPCALC","");
			
			NameComponent path[] = {nc};
			
			ncRef.rebind(path,tempImpl);
			
			System.out.println("Temperature conversion Server is ready...");
			Thread.currentThread().join();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
