package com.studentarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentNameArrayList {
   
	public static void main(String[] args) {
		ArrayList<String> a1=new ArrayList<String>();
		
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of students :");
		n=sc.nextInt();
		System.out.println("Enter the student names :");
		
		for (int i=0; i<n; i++) {
			
			a1.add(sc.next());
			
		}
		System.out.println("student list :");
		
		for (String string : a1) {
			
			System.out.println("Enter the name of serachable student :");
			String st=sc.next();
			int position=Collections.binarySearch(a1,st);
			System.out.println("position of"+st+"is :"+position);
			
		}
	}

}