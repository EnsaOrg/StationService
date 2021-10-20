package main;

public class StationWorkingProcess implements Runnable {
	private StationService stationService;
	
	public StationWorkingProcess(StationService s) {
		stationService = s;
	}

	public void run() {
	while (true) {  
		 synchronized(this.stationService) {
			 Voiture car = new Voiture();
			 this.stationService.passer(car,this.stationService);
			 
		 }
	}
		
	}

}
