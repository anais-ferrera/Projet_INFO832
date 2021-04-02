package discreteBehaviorSimulator;

public class Observer implements ClockObserver {
	
	private int time;

	public Observer(int time) {
		this.time = time;
		
	}

	public void clockChange(int time) {
		this.time = time;
	}
	
	public void nextClockChange(int nextJump) {
		this.time += nextJump;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	
}
