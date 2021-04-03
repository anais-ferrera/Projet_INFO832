package action;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import discreteBehaviorSimulator.Clock;
import timer.OneShotTimer;

class DiscreteActionDependentTest {


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
        System.out.println("ici");
        actionDependent.addDependence(clock,"toString",oneShotTimer);
        actionDependent.addDependence(clock,"getTime",oneShotTimer);
        System.out.println("ici2");
        actionDependent.nextMethod();
        assertEquals(clock.getClass().getDeclaredMethod("toString", new Class<?>[0]),actionDependent.getMethod());
        actionDependent.nextMethod();
        assertEquals(clock.getClass().getDeclaredMethod("getTime", new Class<?>[0]),actionDependent.getMethod());
        actionDependent.nextMethod();
        assertEquals(clock.getClass().getDeclaredMethod("getInstance", new Class<?>[0]),actionDependent.getMethod());
	}

	// Test 12
	@Test
	void testSpendTime() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneShotTimer = new OneShotTimer(10);
        DiscreteActionDependent actionDependent = new DiscreteActionDependent(clock,"getInstance",oneShotTimer);
        actionDependent.addDependence(clock,"getTime",oneShotTimer);
        actionDependent.spendTime(20);
        Integer integer =10;
	    assertEquals(integer,actionDependent.getCurrentLapsTime());
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
	
	// Test 15
	@Test
	void testGetCurrentLapsTime() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneShotTimer = new OneShotTimer(10);
        DiscreteActionDependent actionDependent = new DiscreteActionDependent(clock,"getInstance",oneShotTimer);
        assertEquals(null,actionDependent.getCurrentLapsTime());
	}
	
	// Test 16
	@Test
	void testGetObject() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneShotTimer = new OneShotTimer(10);
        DiscreteActionDependent actionDependent = new DiscreteActionDependent(clock,"getInstance",oneShotTimer);
        assertSame(clock,actionDependent.getObject());
	}
	
	// Test 17
	@Test
	void testCompareTo() {
		Clock clock1 = Clock.getInstance();
		Clock clock2 = Clock.getInstance();
        OneShotTimer oneShotTimer = new OneShotTimer(10);
        DiscreteActionDependent discreteAction1 = new DiscreteActionDependent(clock1,"getInstance",oneShotTimer);
        DiscreteActionDependent discreteAction2 = new DiscreteActionDependent(clock2,"getInstance",oneShotTimer);
        assertEquals(1,discreteAction1.compareTo(discreteAction2));
        
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
