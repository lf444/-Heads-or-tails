import java.util.Random;

public class ModelePile {
	
	
	private Random r ;
	
	public ModelePile() {};
	
	public Boolean Valeur() {
		  this.r= new Random();
	      int chance = this.r.nextInt(2);
	      if (chance == 1) {
	         return true;
	      } else {
	         return false;
	      }
	}

}
