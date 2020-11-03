package com.reji.study.java;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMyTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		TestBr t = new TestBr() ; 
		assert (t.testBracketsSyntax("{ [ ] (   )   }")) ;
		assert (t.testBracketsSyntax("{ [ (    ] ) }") == true);
		assertEquals( true, t.testBracketsSyntax("{ [ (    ] ) }"));
		System.out.println(t.testBracketsSyntax("{ [ (    ] ) }")  + ":Expected false");
		
		/*
		System.out.println(t.testBracketsSyntax("{ [ ] (   )   }")  + ":Expected true");
		System.out.println(t.testBracketsSyntax("{ [ (    ] ) }")  + ":Expected false");
		System.out.println(t.testBracketsSyntax("{ [ }")  + ":Expected false");
		System.out.println(t.testBracketsSyntax(" ")  + ":Expected true");
		System.out.println(t.testBracketsSyntax("")  + ":Expected true");
		System.out.println(t.testBracketsSyntax(" { ")  + ":Expected false");
		System.out.println(t.testBracketsSyntax("}")  + ":Expected false");
		System.out.println(t.testBracketsSyntax("this is another test")  + ":Expected true");
*/
		
	}

}
