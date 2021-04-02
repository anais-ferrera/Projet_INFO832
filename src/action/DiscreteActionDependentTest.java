package action;

import static org.junit.jupiter.api.Assertions.*;
import java.util.TreeSet;
import org.junit.jupiter.api.Test;
import discreteBehaviorSimulator.Clock;
import timer.OneShotTimer;

class DiscreteActionDependentTest {

	// REFACTORING
	// Test 4'
	@Test
	void testSpendTime() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneShotTimer = new OneShotTimer(10);
        DiscreteActionDependent actionDependent = new DiscreteActionDependent(clock,"getInstance",oneShotTimer);
        actionDependent.addDependence(clock,"getTime",oneShotTimer);
        actionDependent.setLapsTime(10);
        actionDependent.spendTime(20);
        Integer integer =10;
	    assertEquals(integer,actionDependent.getCurrentLapsTime());
	}
	
	// REFACTORING
	// Test 5'
	@Test
	void testGetCurrentLapsTime() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneShotTimer = new OneShotTimer(10);
        DiscreteActionDependent actionDependent = new DiscreteActionDependent(clock,"getInstance",oneShotTimer);
        actionDependent.setLapsTime(20);
        assertEquals(20,actionDependent.getCurrentLapsTime());
	}
	
	// REFACTORING
	// Test 6'
	@Test
	void testCompareTo() {
		Clock clock1 = Clock.getInstance();
		Clock clock2 = Clock.getInstance();
        OneShotTimer oneShotTimer = new OneShotTimer(10);
        DiscreteActionDependent discreteAction1 = new DiscreteActionDependent(clock1,"getInstance",oneShotTimer);
        DiscreteActionDependent discreteAction2 = new DiscreteActionDependent(clock2,"getInstance",oneShotTimer);;
        
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
	
	// Test 10
		@Test
	    void testAddDependence() {
	        Clock clock = Clock.getInstance();
	        OneShotTimer oneShotTimer1 = new OneShotTimer(10);
	        DiscreteActionDependent actionDependent = new DiscreteActionDependent(clock,"getInstance",oneShotTimer1);
	        OneShotTimer oneShotTimer2 = new OneShotTimer(15);
	        actionDependent.addDependence(clock,"getTime",oneShotTimer2);
	        assertTrue(actionDependent.hasNext());

	    }
		
		// Test 11
		@Test
		void testNextMethod() throws NoSuchMethodException, SecurityException {
			Clock clock = Clock.getInstance();
	        OneShotTimer oneShotTimer = new OneShotTimer(10);
	        DiscreteActionDependent actionDependent = new DiscreteActionDependent(clock,"getInstance",oneShotTimer);
	        actionDependent.addDependence(clock,"toString",oneShotTimer);
	        actionDependent.addDependence(clock,"getTime",oneShotTimer);
	        actionDependent.nextMethod();
	        assertEquals(clock.getClass().getDeclaredMethod("toString", new Class<?>[0]),actionDependent.getMethod());
	        actionDependent.nextMethod();
	        assertEquals(clock.getClass().getDeclaredMethod("getTime", new Class<?>[0]),actionDependent.getMethod());
	        actionDependent.nextMethod();
	        assertEquals(clock.getClass().getDeclaredMethod("getInstance", new Class<?>[0]),actionDependent.getMethod());
		}
		
		// Test 13
		@Test
		void testUpdateTimeLaps() throws NoSuchMethodException, SecurityException {
			Clock clock = Clock.getInstance();
	        OneShotTimer oneShotTimer = new OneShotTimer(10);
	        DiscreteActionDependent actionDependent = new DiscreteActionDependent(clock,"getInstance",oneShotTimer);
	        actionDependent.addDependence(clock,"toString",oneShotTimer);
	        actionDependent.updateTimeLaps();
	        assertEquals(clock.getClass().getDeclaredMethod("toString", new Class<?>[0]),actionDependent.getMethod());
		}

		// Test 14
		@Test
		void testGetMethod() throws NoSuchMethodException, SecurityException {
			Clock clock = Clock.getInstance();
	        OneShotTimer oneShotTimer = new OneShotTimer(10);
	        DiscreteActionDependent actionDependent = new DiscreteActionDependent(clock,"getInstance",oneShotTimer);
	        assertEquals(clock.getClass().getDeclaredMethod("getInstance", new Class<?>[0]),actionDependent.getMethod());
		}
		
		// Test 16
		@Test
		void testGetObject() {
			Clock clock = Clock.getInstance();
	        OneShotTimer oneShotTimer = new OneShotTimer(10);
	        DiscreteActionDependent actionDependent = new DiscreteActionDependent(clock,"getInstance",oneShotTimer);
	        assertSame(clock,actionDependent.getObject());
		}
		
		@Test
		void testIsEmpty() {
			Clock clock = Clock.getInstance();
	        OneShotTimer oneShotTimer1 = new OneShotTimer(10);
	        DiscreteActionDependent actionDependent = new DiscreteActionDependent(clock,"getInstance",oneShotTimer1);
	        // Test 18
	        assertFalse(actionDependent.isEmpty());
	        // Test 19
	        oneShotTimer1.next();
	        assertTrue(actionDependent.isEmpty()); 
		}
		
		// Test 20
		@Test
		void testNext() {
			Clock clock = Clock.getInstance();
	        OneShotTimer oneShotTimer = new OneShotTimer(10);
	        DiscreteActionDependent actionDependent = new DiscreteActionDependent(clock,"getInstance",oneShotTimer);
	        DiscreteActionInterface result = actionDependent.next();
	        assertEquals(actionDependent,result);
		}
		
		
		@Test
		void testHasNext() {
			Clock clock = Clock.getInstance();
	        OneShotTimer oneShotTimer = new OneShotTimer(10);
	        DiscreteActionDependent actionDependent = new DiscreteActionDependent(clock,"getInstance",oneShotTimer);
	        // Test 21
	        assertTrue(actionDependent.hasNext());
	        // Test 22
	        oneShotTimer.next();
	        assertFalse(actionDependent.hasNext());
		}
		
}
	        


