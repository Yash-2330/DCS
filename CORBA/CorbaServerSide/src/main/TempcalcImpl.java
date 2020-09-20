package main;

import Tempconvcalc._TempcalcImplBase;

public class TempcalcImpl extends _TempcalcImplBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public double get_celsius(String symbol) {
		double celsius = Double.parseDouble(symbol);
		double fahrenheit =  (1.8 * celsius) + 32;
		return fahrenheit;
	}
	
	public TempcalcImpl()
	{
		super();
	}

}
