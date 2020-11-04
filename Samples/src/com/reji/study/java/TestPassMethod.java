package com.reji.study.java;

/**
 * @author reji
 * Test passing methods as parameters. 
 * Interface Command, having a method execute() , implement concrete command class. 
 */
public class TestPassMethod {
	public interface Command { 
		public void executeNoReturn (Object [] params) ;
		public Object[] execute(Object [] params);
	}
	
	public class PrintCommand implements Command {
		@Override
		public void executeNoReturn(Object[] params) {
			for ( Object p : params ) { 
				System.out.println(p);
			}
		}
		@Override
		public Object[] execute(Object[] params) {
			// TODO Auto-generated method stub
			return null;
		} 
	}
	
	public class AddCommand implements Command {

		@Override
		public void executeNoReturn(Object[] params) {
			Integer sum = 0;
			for ( Object p : params ) { 
				if (p.getClass().equals(Integer.class) ) { 
					sum+=(Integer) p ;
				}
			}
			System.out.println(sum);
			
		}

		@Override
		public Object[] execute(Object[] params) {
			// TODO Auto-generated method stub
			return null;
		} 
		
	}

	public static void main(String[] args) {
		TestPassMethod tps = new TestPassMethod();
		tps.test();
	}
	
	public void  test () { 
		AddCommand ac = new AddCommand();
		Integer [] iA = {1,2};
		ac.executeNoReturn( iA);
		
		
		PrintCommand pc = new PrintCommand(); 
		pc.executeNoReturn(iA);
	}
	
	public void testPassingParams ( Command cmd , Object[] arr ) { 
		cmd.executeNoReturn(arr);
		
	}
}
