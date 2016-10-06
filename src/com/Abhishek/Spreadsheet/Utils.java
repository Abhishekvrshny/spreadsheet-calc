package com.Abhishek.Spreadsheet;

import java.math.BigDecimal;

class Utils {
	
	public static boolean isInteger(String s) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),10) < 0) return false;
	    }
	    return true;
	}
	public static void printCell(double value) {
		BigDecimal bDec = new BigDecimal(value);
		bDec = bDec.setScale(5, BigDecimal.ROUND_HALF_UP);
		System.out.println(String.format("%.5f",bDec));
	}


}
