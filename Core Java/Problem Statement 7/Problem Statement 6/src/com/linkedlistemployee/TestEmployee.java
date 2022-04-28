package com.linkedlistemployee;

import java.util.Vector;

public class TestEmployee {
	
	

	
	public static void main(String[] args) {
		Vector<Employee> v = addInput();
		display(v);
	}

	private static Vector<Employee> addInput() {
		// TODO Auto-generated method stub
		Employee e1 = new Employee(101,"Samruddhi","Nagpur") ;
		Employee e2 = new Employee(102,"mohit","Pune") ;
		Employee e3 = new Employee(103,"nirmal","Chennai") ;
		Vector<Employee> v = new Vector<Employee>();
		v .add(e1);
		v.add(e2);
		v.add(e3);
		return v;
	}

	private static void display(Vector<Employee> v) {
		// TODO Auto-generated method stub
		for(Employee e:v)
		{
			System.out.println(e.getEmpid()+"\t"+e.getEname()+"\t"+e.getAddress());
		}
	}
	}