package com.reji.study.java;

import java.lang.reflect.Method;

import javax.swing.plaf.synth.SynthScrollPaneUI;

//import com.ibm.team.integration.reporting.model.services.Folder;

public class TestReflection {

	public static void main( String [] args) { 
		System.out.println("Inside the TestReflection");
		
		System.out.println(TestReflection.class.getName());
		TestReflection tr = new TestReflection();
		//tr.iterate(Folder.class, 0);
		
	}
	
	private String getAppeneder (  int i ) {
		StringBuffer sb = new StringBuffer("");
		for (int x = 0; x <=i ; x ++  ) { 
			sb.append("--" ); 
		}
		return sb.toString();
	}
	
	public /*Class<?> */ void iterate (Class<?> thisClass , int i) {
		//printMyDetails(thisClass, i);
		Class<?> c = thisClass.getSuperclass();
		if (c !=null ) { 
			//printMyDetails(c, i);
			/*return */ iterate(c, i + 1) ; 
		}
		printMyDetails(c, i);
		//return null ;
	}
	
	public void printMyDetails (Class <?> c, int i) {
		if ( c!=null ) {
			System.out.println(getAppeneder(i) + "**********" + c.getName());
			printInterfaces ( c, getAppeneder(i) ); 
			printMethods ( c , getAppeneder(i)) ;
		}
	}
	
	public void printInterfaces (Class <?> c, String appender) { 
		if ( c!=null ) { 
			Class<?>[] iFs  = c.getInterfaces() ; 
			for ( Class<?> iC : iFs ) { 
				System.out.println(appender + "Interface : " + iC.getName());
			}
		}
	}
	
	public void printMethods (Class <?> c, String appender) { 
		if ( c!=null ) { 
			Method [] methods = c.getDeclaredMethods() ;
			
			for (Method m : methods ) {
				if (m.isDefault()) 
					return;
				StringBuffer methodSignature = new StringBuffer();
				int paramCnt = 0;
				methodSignature.append(m.getReturnType().getName() + " " );
				methodSignature.append( m.getName());
				Class <?> params[] = m.getParameterTypes();
				methodSignature.append("(");
				for ( Class <?> p :  params) { 
					if (paramCnt > 0 ) 
						methodSignature.append(", ");
					methodSignature.append( p.getName());
				}
				methodSignature.append(");");
				System.out.println(appender + methodSignature);
			}
		}
	}
		
}
