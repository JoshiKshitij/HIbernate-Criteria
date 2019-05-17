package com.hibern.app;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Test {
	
	
	public static void main(String[] args) {
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		String rounded = nf.format(12.1234);
	System.out.println(rounded);
	}

}
