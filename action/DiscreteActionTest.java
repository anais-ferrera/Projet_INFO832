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
	// Test 1
	@Test
	void testSpendTime() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneShotTimer = new OneShotTimer(10);
        DiscreteAction discreteAction = new DiscreteAction(clock,"getInstance",oneShotTimer);
	    discreteAction.spendTime(5);
	    Integer integer =5;
	    assertEquals(integer,discreteAction.getCurrentLapsTime());
	}
	
	// Test 2
	@Test
	void testCompareTo() {
		Clock clock1 = Clock.getInstance();
		Clock clock2 = Clock.getInstance();
        OneShotTimer oneShotTimer = new OneShotTimer(10);
        DiscreteAction discreteAction1 = new DiscreteAction(clock1,"getInstance",oneShotTimer);
        DiscreteAction discreteAction2 = new DiscreteAction(clock2,"getInstance",oneShotTimer);
        assertEquals(1,discreteAction1.compareTo(discreteAction2));
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
	
	// Test 7
	@Test
	void testGetCurrentLapsTime() {
		Clock clock = Clock.getInstance();
        OneShotTimer oneShotTimer = new OneShotTimer(10);
        DiscreteAction discreteAction = new DiscreteAction(clock,"getInstance",oneShotTimer);
        assertEquals(null,discreteAction.getCurrentLapsTime());
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

