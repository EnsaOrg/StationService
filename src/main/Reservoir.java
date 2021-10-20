package main;

public class Reservoir {
	private double volume;
	private double capacity;
	private int FILL_DELAY;
	
	public Reservoir(double volume, int fill_delay, double capacity) {
		this.volume =  volume;
		this.FILL_DELAY = fill_delay;
		this.capacity = capacity;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public int getFILL_DELAY() {
		return FILL_DELAY;
	}

	public void setFILL_DELAY(int fILL_DELAY) {
		FILL_DELAY = fILL_DELAY;
	}
	
	
	

}
