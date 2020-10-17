import java.awt.GridLayout;

import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setLayout(new GridLayout(1,1));
		f.add(new VuePile());
		f.pack();
		f.setVisible(true);
		f.setSize(700,400);
		f.setTitle("Jeu  Test");

	}

}
