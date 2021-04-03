package action;

import static org.junit.jupiter.api.Assertions.*;

import java.util.TreeSet;

import org.junit.jupiter.api.Test;


import discreteBehaviorSimulator.Clock;
import discreteBehaviorSimulator.LogFormatter;
import timer.DateTimer;
import timer.OneShotTimer;
import timer.Timer;



class DiscreteActionTest {
	
	// REFACTORING
	// Test 1'
	@Test
	void testSpendTime() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneShotTimer = new OneShotTimer(10);
        DiscreteAction discreteAction = new DiscreteAction(clock,"getInstance",oneShotTimer);
        discreteAction.setLapsTime(10);
        discreteAction.spendTime(7);
        Integer integer =3;
        assertEquals(integer,discreteAction.getCurrentLapsTime());
	}
	
	// REFACTORING
	// Test 2'
	@Test
	void testCompareTo() {
		Clock clock1 = Clock.getInstance();
		Clock clock2 = Clock.getInstance();
        OneShotTimer oneShotTimer = new OneShotTimer(10);
        DiscreteAction discreteAction1 = new DiscreteAction(clock1,"getInstance",oneShotTimer);
        DiscreteAction discreteAction2 = new DiscreteAction(clock2,"getInstance",oneShotTimer);
        
        // 1 - lapstime == nul
        discreteAction1.setLapsTime(null);
        assertEquals(1,discreteAction1.compareTo(discreteAction2));
        
        // 2 - c.getCurrentLapsTime() == null
        discreteAction1.setLapsTime(3);
        discreteAction2.setLapsTime(null);
        assertEquals(-1,discreteAction1.compareTo(discreteAction2));
        
        // 3 - this.lapsTime > c.getCurrentLapsTime()
        discreteAction2.setLapsTime(2);
        assertEquals(1,discreteAction1.compareTo(discreteAction2));
        
        // 4 - this.lapsTime < c.getCurrentLapsTime()
        discreteAction1.setLapsTime(1);
        assertEquals(-1,discreteAction1.compareTo(discreteAction2));
        
        // 5 - this.lapsTime == c.getCurrentLapsTime()
        discreteAction1.setLapsTime(0);
        discreteAction2.setLapsTime(0);
        assertEquals(0,discreteAction1.compareTo(discreteAction2));               
	}	
	
	// REFACTORING
	// Test 3'
	@Test
	void testGetCurrentLapsTime() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneShotTimer = new OneShotTimer(10);
        DiscreteAction discreteAction = new DiscreteAction(clock,"getInstance",oneShotTimer);
        discreteAction.setLapsTime(5);
        assertEquals(5,discreteAction.getCurrentLapsTime());
	}
	
	// Test 3
		@Test
		void testNext() {
			Clock clock = Clock.getInstance();
	        OneShotTimer oneShotTimer = new OneShotTimer(10);
	        DiscreteAction discreteAction = new DiscreteAction(clock,"getInstance",oneShotTimer);
	        assertEquals(discreteAction,discreteAction.next());
		}
		
		
		@Test
		void testHasNext() {
			Clock clock = Clock.getInstance();
	        OneShotTimer oneShotTimer = new OneShotTimer(10);
	        DiscreteAction discreteAction = new DiscreteAction(clock,"getInstance",oneShotTimer);
	        // Test 4
	        assertTrue(discreteAction.hasNext());
	        // Test 4'
	        oneShotTimer.next();
	        assertFalse(discreteAction.hasNext());
	        
		}
		
		// Test 5
		@Test
		void testToString() {
			Clock clock = Clock.getInstance();
	        OneShotTimer oneShotTimer = new OneShotTimer(10);
	        DiscreteAction discreteAction = new DiscreteAction(clock,"getInstance",oneShotTimer);
	        assertEquals("Object : "+ discreteAction.getObject().getClass().getName()+"\n"
	        		+ " Method : "+discreteAction.getMethod().getName()+"\n"
	        		+ " Stat. : "+oneShotTimer+"\n"
	        		+ " delay: "+ discreteAction.getCurrentLapsTime(),discreteAction.toString());
		}


		// Test 6
		@Test
	    void testgetMethod() throws NoSuchMethodException, SecurityException {
	        Clock clock = Clock.getInstance();
	        OneShotTimer oneShotTimer = new OneShotTimer(10);
	        DiscreteAction discreteAction = new DiscreteAction(clock,"getInstance",oneShotTimer);
	        assertEquals(clock.getClass().getDeclaredMethod("getInstance", new Class<?>[0]),discreteAction.getMethod());
	    }
		
		// Test 8
		@Test
		void testGetObject() {
			Clock clock = Clock.getInstance();
	        OneShotTimer oneShotTimer = new OneShotTimer(10);
	        DiscreteAction discreteAction = new DiscreteAction(clock,"getInstance",oneShotTimer);
	        assertSame(clock,discreteAction.getObject());
		}
		
		// Test9
		@Test
		void testAction() throws Exception {
			Clock clock = Clock.getInstance();
			OneShotTimer oneShotTimer = new OneShotTimer(10);
			DiscreteAction discreteAction = new DiscreteAction(clock,"setTime",oneShotTimer);
		
		}
		
}

