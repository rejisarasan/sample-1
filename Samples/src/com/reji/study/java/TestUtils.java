package com.reji.study.java;

import java.util.ArrayList;

public class TestUtils {

	interface StringFunctionOne {
		String  run ( String str ); 
	}
	
	public static void doIt ( String s, StringFunctionOne func) { 
		System.out.println(func.run(s));
	}
	
	public static void main(String[] args) {
		ArrayList <Integer> iArr = new ArrayList<Integer> () ;
		iArr.add(2);
		iArr.add(4);
		iArr.add(5);
		iArr.add(1);
		iArr.add(0);
		
		iArr.forEach( (i) -> { System.out.println(i);});
		
		StringFunctionOne sOneJustPrint = (s) -> { System.out.println(s + " from strFn1"); return s;};
		StringFunctionOne sOneQuestion = (s) -> { return s + "?";};
		StringFunctionOne sOneExclaim = (s) -> { return s + "!";};
		doIt("test print", sOneJustPrint);
		doIt("Ask", sOneQuestion);
		doIt("Exclaim", sOneExclaim);
		
	}
	
	
}
