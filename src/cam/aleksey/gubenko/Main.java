package cam.aleksey.gubenko;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.WindowConstants;

public class Main {

	public static void main(String[] args) {
		GUITicTacToe w = new GUITicTacToe();
		w.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		w.setResizable(false);
		w.pack();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		w.setLocation(dim.width / 2 - w.getSize().width / 2, dim.height / 2 - w.getSize().height / 2);
		w.setVisible(true);
	}
}