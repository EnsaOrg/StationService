package main;

public class StationService {
	private Long id;
	private String adress;
	private Reservoir reservoir;
	private int passage;
	
	public StationService(Long id, String adress, Reservoir reservoir, int passage) {
		this.id = id;
		this.adress = adress;
		this.reservoir = reservoir;
		this.passage = passage;
	}
	//remplir le réservoir à plein
	public void fillTank (Reservoir reservoir) {
		System.out.println("");
		System.out.println("Début de remplissage du réservoir...");
		System.out.println("Les voitures ne peuvent plus passer...");
		reservoir.setVolume(reservoir.getCapacity());
		//après faire en sorte que le temps de remplissage soit proportionnel
		//au volume à remplir
		try {
			Thread.sleep((int) (reservoir.getFILL_DELAY() * Math.random()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin de remplissage du réservoir.");
		System.out.println("Les voitures peuvent passer maintenant...");
	}
	
	
	//cette méthode doit être dans run()
	public void passer(Voiture v, StationService s) {
		try {
			System.out.printf("Passage n° %d", s.getPassage());
			System.out.println("");
			System.out.println("Demande d'accès...");
			//on peut afficher ici le volume de la voiture
			Thread.sleep((int) (v.getDELAY() * Math.random()));
			Reservoir r = s.getReservoir();
			if(r.getVolume()>v.getVolume()) {
				System.out.println("Accès autorisé!");
				System.out.printf("Passage en cours...");
				System.out.println("");
				r.setVolume(r.getVolume()-v.getVolume());
				s.setReservoir(r);
				System.out.printf("Passage n° %d terminé.",s.getPassage());
				System.out.printf("Le volume restant du réservoir est de %5.2f sur %5.2f",r.getVolume(),r.getCapacity());
				s.setPassage(++passage);
				System.out.println("");
				//Pour mieux simuler la réalité, on peut mettre une
				//condition pour remplir ou non le réservoir 
				//afin de ne pas attendre que ça se vide complétement
				if(r.getVolume()<5) {
					System.out.println("Demande d'accès...");
					System.out.println("Accès refusé!");
					System.out.println("Le réservoir est presque épuisé.");
					fillTank(r);
				}
			}
			else {
				System.out.println("Accès refusé!");
				System.out.println("Le réservoir doit être rempli.");
				//System.out.print(Thread.currentThread());
				fillTank(r);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Reservoir getReservoir() {
		return reservoir;
	}

	public void setReservoir(Reservoir reservoir) {
		this.reservoir = reservoir;
	}

	public int getPassage() {
		return passage;
	}

	public void setPassage(int passage) {
		this.passage = passage;
	}
	

}
