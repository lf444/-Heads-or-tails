import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VuePile extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	private static String [] de = {"PILE","FACE"};
	private JButton[] bouton;
	private  JTextField Resultat;
	private  JTextField Somme;
	private JButton Recommencer;
	private JButton Commencer;



	public VuePile() {
		this.setLayout(new BorderLayout());
		
		// Partie du haut 

		JPanel upper = new JPanel(new FlowLayout()); 
		JLabel Titre = new JLabel("Pile ou face ");
		
		upper.add(Titre);
		this.add(upper, BorderLayout.NORTH);
		
		
		// Partie Central
		JPanel center =  new JPanel(new FlowLayout()); 
		JPanel BoutonCentral = new JPanel(new GridLayout(2,2));
		this.bouton=new JButton[2];
		for(int i=0;i<2;i++) {
			this.bouton[i]= new JButton(""+VuePile.de[i]);
			BoutonCentral.add(this.bouton[i]);
		}
		this.Resultat = new JTextField(20);
		Resultat.setEditable(false);
		Resultat.setBackground(Color.white);
		
		center.add(BoutonCentral);
		center.add(Resultat);
		this.add(center,BorderLayout.CENTER);
		

		
		// Partie du bas 
		
		
		JPanel sud =  new JPanel(new FlowLayout()); 
		JPanel BoutonduBas = new JPanel(new GridLayout(2,2));
		this.Commencer = new JButton("Commencer");
		this.Recommencer = new JButton("Recommencer");
		BoutonduBas.add(Commencer);
		BoutonduBas.add(Recommencer);
		
		sud.add(BoutonduBas);
		this.Somme = new JTextField(20);
		Somme.setEditable(false);
		Somme.setBackground(Color.white);
		
		sud.add(Somme);
		
		this.add(sud, BorderLayout.SOUTH);
		
		ControleurPile cp = new ControleurPile(this, new ModelePile());
		for(JButton b :this.bouton) {
			b.addActionListener(cp);
		}
		Recommencer.addActionListener(cp);
		Commencer.addActionListener(cp);

		
		
		}
	
	public boolean AppartientButton(JButton b) {

		if(b.getText().equals("PILE")){
			return true;
		}
		return false;
		
	}
	public void afficherResultat(String t ) {
		this.Resultat.setText(""+t);
	}

	public void afficherSomme(int somme) {
		this.Somme.setText("Vous avez "+somme+" € ");
	}
		
	public void initiliaser(){
		for(JButton b: this.bouton) {
			b.setEnabled(true);		
			}
	}
	
	public void deinitiliaser(){
		for(JButton b: this.bouton) {
			b.setEnabled(false);		
			}
	}
	
	public void RecommencerOn() {
		this.Recommencer.setEnabled(true);
	}
	public void RecommencerOf() {
		this.Recommencer.setEnabled(false);
	}
	public void CommencerOn() {
		this.Commencer.setEnabled(true);
		
	}
	
	public void CommencerOff() {
		this.Commencer.setEnabled(false);
		
	}
}