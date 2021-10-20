package main;

public class Voiture {
	private double volume = 2.5;
	private int DELAY = 10000;
	
	public Voiture () {
		volume = volume * Math.random();
		DELAY = (int) (DELAY * Math.random());
	}
	
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public int getDELAY() {
		return DELAY;
	}
	public void setDELAY(int dELAY) {
		DELAY = dELAY;
	}
	
	
	

}
