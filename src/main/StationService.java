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
	//remplir le r�servoir � plein
	public void fillTank (Reservoir reservoir) {
		System.out.println("");
		System.out.println("D�but de remplissage du r�servoir...");
		System.out.println("Les voitures ne peuvent plus passer...");
		reservoir.setVolume(reservoir.getCapacity());
		//apr�s faire en sorte que le temps de remplissage soit proportionnel
		//au volume � remplir
		try {
			Thread.sleep((int) (reservoir.getFILL_DELAY() * Math.random()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin de remplissage du r�servoir.");
		System.out.println("Les voitures peuvent passer maintenant...");
	}
	
	
	//cette m�thode doit �tre dans run()
	public void passer(Voiture v, StationService s) {
		try {
			System.out.printf("Passage n� %d", s.getPassage());
			System.out.println("");
			System.out.println("Demande d'acc�s...");
			//on peut afficher ici le volume de la voiture
			Thread.sleep((int) (v.getDELAY() * Math.random()));
			Reservoir r = s.getReservoir();
			if(r.getVolume()>v.getVolume()) {
				System.out.println("Acc�s autoris�!");
				System.out.printf("Passage en cours...");
				System.out.println("");
				r.setVolume(r.getVolume()-v.getVolume());
				s.setReservoir(r);
				System.out.printf("Passage n� %d termin�.",s.getPassage());
				System.out.printf("Le volume restant du r�servoir est de %5.2f sur %5.2f",r.getVolume(),r.getCapacity());
				s.setPassage(++passage);
				System.out.println("");
				//Pour mieux simuler la r�alit�, on peut mettre une
				//condition pour remplir ou non le r�servoir 
				//afin de ne pas attendre que �a se vide compl�tement
				if(r.getVolume()<5) {
					System.out.println("Demande d'acc�s...");
					System.out.println("Acc�s refus�!");
					System.out.println("Le r�servoir est presque �puis�.");
					fillTank(r);
				}
			}
			else {
				System.out.println("Acc�s refus�!");
				System.out.println("Le r�servoir doit �tre rempli.");
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
