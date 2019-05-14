package cam.aleksey.gubenko;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class GUITicTacToe extends JFrame {
	private JLabel cells[][] = new JLabel[3][3];

	public GUITicTacToe() throws HeadlessException {
		super("Tic-tac-toe");
		createGameUITable();
	}

	public void createGameUITable() {
		setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				final int number = i * 3 + j + 1;
				JLabel p = new JLabel();
				cells[i][j] = p;
				p.setPreferredSize(new Dimension(150, 150));
				p.setHorizontalAlignment(SwingConstants.CENTER);
				p.setVerticalAlignment(SwingConstants.CENTER);
				p.setFont(new Font(Font.SERIF, Font.PLAIN, 35));
				p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				add(p);
				p.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						handleHumanTurn(number);
					}
				});
			}
		}
		printGameTable();
	}

	public void handleHumanTurn(int number) {
		if (TicTacToe.isCellFree(number)) {
			TicTacToe.makeTurn(number, TicTacToe.HUMAN);
			printGameTable();
			if (TicTacToe.getWinner() == TicTacToe.HUMAN) {
				JOptionPane.showMessageDialog(this, "Game over: User win!");
				System.exit(0);
			}
			if (TicTacToe.isDraw()) {
				JOptionPane.showMessageDialog(this, "Game over: Draw!");
				System.exit(0);
			}
			TicTacToe.makeComputerTurn();
			printGameTable();
			if (TicTacToe.getWinner() == TicTacToe.COMPUTER) {
				JOptionPane.showMessageDialog(this, "Game over: Computer wins!");
				System.exit(0);
			}
			if (TicTacToe.isDraw()) {
				JOptionPane.showMessageDialog(this, "Game over: Draw!");
				System.exit(0);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Cell is not free! Type other number");
		}
	}

	public void printGameTable() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cells[i][j].setText(String.valueOf(TicTacToe.gameTable[i][j]));
			}
		}
	}
}