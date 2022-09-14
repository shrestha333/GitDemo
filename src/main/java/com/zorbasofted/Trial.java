package com.zorbasofted;

public class Trial {

	public static void main(String[] args) {
		String s1="aawash shrestha";
		String s2 = new String("aawash shrestha");
		String s3= new String("deewa shrestha");
		String [] s= s3.split(" ");
		//System.out.println(s[0]);
		//System.out.println(s[1]);
		
		for(int i=s1.length()-1;i>=0;i--) {
			
			System.out.print(s1.charAt(i));
			
			
		}
		
		
	}
}
