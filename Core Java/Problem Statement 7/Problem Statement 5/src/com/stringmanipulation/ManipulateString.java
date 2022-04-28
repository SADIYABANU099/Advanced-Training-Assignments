package com.stringmanipulation;

public class ManipulateString {

public static void main(String[] args) {
			
		
		String txt= "JAVA is Simple";
		
		System.out.println(txt.toUpperCase()); //UpperCase
		
		System.out.println(txt.toLowerCase()); //LowerCase
		
		
		String[] s1=txt.split("\\s");	//1st words of letter
		for(String w:s1){  
			System.out.print(w.charAt(0)); 
			System.out.print(" ");
		}
		System.out.println(" ");
		
		
		String[] s2=txt.split("\\s"); // Change order 
		for(String w:s2){  
			System.out.println(w); 
		}
		
		//String Builder reverse
		StringBuilder s3= new StringBuilder("JAVA is Simple");
		
		Object words21;
		System.out.println("String = " + s3.toString());
		StringBuilder reverseStr = s3.reverse();
		System.out.println("Reverse String = " + reverseStr.toString());
		
		//Total Length
		System.out.println("length of string " + txt.length());
	}
	}
