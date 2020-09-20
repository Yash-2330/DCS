package main;

import java.util.Scanner;

import org.omg.CORBA.*;

import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;

import Tempconvcalc.Tempcalc;
import Tempconvcalc.TempcalcHelper;


public class TempConvClient {

	public static void main(String[] args) {
		
		try {
		// create and initialize orb object 
		ORB orb = ORB.init(args,null);
		
		// obtain the initial Naming Context
		NamingContext ncRef = NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
		NameComponent path[] = {new NameComponent("TEMPCALC","")};
		
		// create a reference object for a Tempcalc and Narrow Object Refernce
		Tempcalc calc = TempcalcHelper.narrow(ncRef.resolve(path));
			
		// fetch the celsius value from the console and store it in a string variable
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the temperature in Celsius:- ");
		String cel = sc.nextLine();
		
		// call get_celsius() to get fahrenheit value
		System.out.println("Temperature in Fahrenheit is:- " + calc.get_celsius(cel));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
