package main;

public class StationTest {
	public static void main(String[] args) {
		Reservoir r = new Reservoir(0, 10000,10);
		StationService s = new StationService((long) 1, "Marrakech", r , 1);
		s.setReservoir(r);
		StationWorkingProcess work = new StationWorkingProcess(s);
		Thread t = new Thread(work);
		t.start();
	}

}
