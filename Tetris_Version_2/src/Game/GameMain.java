package Game;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GameMain extends JPanel {
	private static final long serialVersionUID = -8715353373678321308L;
	private static final int FIRST_TIME = 100000000;
	Color color1 = new Color(255, 18, 18);// red
	Color color2 = new Color(255, 130, 36);// orange
	Color color3 = new Color(0, 180, 219);// skyblue
	Color color4 = new Color(65, 175, 57);// green
	Color color5 = new Color(131, 36, 255);// purple
	Color color6 = new Color(19, 18, 255);// blue
	Color color7 = new Color(255, 228, 0);// yellow
	protected final Color[] tetraminoColors = { color1, color2, color3, color4, color5, color6, color7 };
	protected Point pieceOrigin;
	protected Point pieceOrigin2;
	protected int currentPiece;
	protected int nextPiece;
	protected int rotation;

	protected ArrayList<Integer> nextPieces = new ArrayList<Integer>();
	public int score;
	public static int high_Score = 0;
	public static int least_time = FIRST_TIME;
	public int mode;
	public int count;
	protected Color[][] well;
	protected Color[][] well2;
	protected Color[][] well3;

	protected final Point[][][] Tetraminos = {
			// I-Piece
			{ { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
					{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
					{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
					{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) } },

			// J-Piece
			{ { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
					{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
					{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
					{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) } },

			// L-Piece
			{ { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
					{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
					{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
					{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) } },

			// O-Piece
			{ { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
					{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
					{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
					{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) } },

			// S-Piece
			{ { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
					{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
					{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
					{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) } },

			// T-Piece
			{ { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
					{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
					{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
					{ new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) } },

			// Z-Piece
			{ { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
					{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
					{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
					{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) } } };//Tetris block


	public void newPiece() {
		pieceOrigin = new Point(5, 2);
		pieceOrigin2 = new Point(14, 3);
		rotation = 0;
		int num;
		if (nextPieces.isEmpty()) {
			num = (int) (Math.random() * 7);
			nextPieces.add(nextPieces.size(), num);
			num = (int) (Math.random() * 7);
			nextPieces.add(nextPieces.size(), num);

		}
		currentPiece = nextPieces.get(0);
		nextPiece = nextPieces.get(1);
		nextPieces.remove(0);
		num = (int) (Math.random() * 7);
		nextPieces.add(nextPieces.size(), num);

	}

}
