package com.reji.study.java;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Documented 
@interface ClassHeader { 
	String author() ;
	String description () ;
}

@ClassHeader ( 
	author = "Reji ",
	description = "Test Brackers Class"
)

public class TestBr {
	private Map<Character, Character> bracketPairs = new HashMap<Character, Character >() ;

	public TestBr () {
		bracketPairs.put('{', '}');
		bracketPairs.put('[', ']');
		bracketPairs.put('(', ')');
	}

	public static void main ( String args[]) {
		System.out.println("hello world, from docker");
		
		TestBr t = new TestBr () ; 
		System.out.println(t.testBracketsSyntax("{ [ ] (   )   }")  + ":Expected true");
		System.out.println(t.testBracketsSyntax("{ [ (    ] ) }")  + ":Expected false");
		System.out.println(t.testBracketsSyntax("{ [ }")  + ":Expected false");
		System.out.println(t.testBracketsSyntax(" ")  + ":Expected true");
		System.out.println(t.testBracketsSyntax("")  + ":Expected true");
		System.out.println(t.testBracketsSyntax(" { ")  + ":Expected false");
		System.out.println(t.testBracketsSyntax("}")  + ":Expected false");
		System.out.println(t.testBracketsSyntax("this is another test")  + ":Expected true");
	}
/*
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		@NonNull String str = null;
		System.out.println(str);
		Test t = new Test () ;
		Class<?> cls = t.getClass();
		System.out.println(cls.getSimpleName());
		System.out.println(cls.getTypeName());
		System.out.println(cls.getName());
		System.out.println(cls.getCanonicalName());
		
		while (sc.hasNext()) {
			String input=sc.next();
			System.out.println(t.testBracketsSyntax(input));
            //Complete the code
		}
		System.out.println("Came out");
		
	}
	*/
	
	/**
     * Checks if the 'input' is syntactically correct
     * @param input
     * @return true/false
     */
    public boolean testBracketsSyntax ( String input ) {
        Stack<Character> sBrakcets = new Stack <Character>() ;
        for ( Character c : input.toCharArray()) { 
            if (bracketPairs.keySet().contains(c))
                sBrakcets.push(c);
            else if (bracketPairs.values().contains(c)) { 
                Character popped = (Character) sBrakcets.pop();
                if (popped==null || !bracketPairs.get(popped).equals(c)) {
                	return false;
                }
            }
        }
        return sBrakcets.isEmpty() ;
    }
    
    /**
     * A helper stack class
     * @author reji
     *
     */
    private class Stack <T> {
        private List<T> listItems = new ArrayList<T>() ;
        
        public void push (T p) { 
            listItems.add(p);
        }
        
        public T pop ( ) { 
            if (listItems.size()>0) 
                return listItems.remove(listItems.size()-1);
            return null;
        }
        
        public boolean isEmpty ()  { 
            return listItems.isEmpty();
        }
    }
}