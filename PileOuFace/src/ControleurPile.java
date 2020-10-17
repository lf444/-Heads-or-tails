import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ControleurPile implements ActionListener  {

	private VuePile Vp;
	private ModelePile Mp;
	public enum Etat{DEBUT_PARTI,CHOIX_PARTI,};
	private Etat etat;
	private int somme;
	
	public ControleurPile(VuePile v, ModelePile m) {
		this.Vp= v;
		this.Mp=m;
		this.etat=Etat.DEBUT_PARTI;
		this.somme=0;
		this.Vp.deinitiliaser();
		this.Vp.RecommencerOf();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton source  = (JButton) arg0.getSource();

	
		 switch(this.etat) {
		 
		 	case DEBUT_PARTI:
		 		this.Vp.initiliaser();
		 		this.Vp.RecommencerOf();
		 		this.Vp.CommencerOff();
		 		 if(this.somme<1) {
		 			 this.somme=1000;
		 			 this.Vp.afficherResultat("Nouvelle partie !");
		 		 }
		 		this.Vp.afficherSomme(this.somme);
		 		this.etat=Etat.CHOIX_PARTI;
		 		break;
		 	case CHOIX_PARTI:
		 	
				 boolean lancer = this.Mp.Valeur();
		 		 if(this.Vp.AppartientButton(source)==lancer) {
		 			this.Vp.afficherResultat("Gagné gain multiplié par 2");  
		 			this.somme = this.somme*2;
		 			this.Vp.afficherSomme(this.somme);
		 			this.etat=Etat.CHOIX_PARTI;
		 		 }else {
		 		    this.Vp.afficherResultat("Vous avez tout perdu ");
		 		    this.somme=0;
	
		 			this.Vp.deinitiliaser();
		 		    this.Vp.afficherSomme(this.somme);
		 		    this.Vp.RecommencerOn();
			 		this.Vp.afficherResultat("Vous devriez partir :') ");

			 		this.etat=Etat.DEBUT_PARTI;
			 		
		 		}
		 		 
		 		
		 		break;
	
		 
		 }

	
	}
}
