package Block;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import Game.GameMain;
import Game.GameOver;

public class Tetris_Block extends GameMain {
	Color EdgeColor = new Color(18, 102, 183);
	Color BackGroundColor = new Color(0, 0, 44);
	Color ScoreBackGroundColor=new Color(0, 0, 44);
	Color ScoreEdgeColor=new Color(18, 102, 183);
	GameOver gameover = new GameOver();

	public void init() {
		well = new Color[12][24];
		well2 = new Color[19][8];
		well3 = new Color[19][24];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 23; j++) {
				if (i == 0 || i == 11 || j == 0 || j == 22) {
					well[i][j] = EdgeColor;
				} else {
					well[i][j] = BackGroundColor;
				}
			}
		}
		for (int i = 12; i < 19; i++) {
			for (int j = 0; j < 8; j++) {
				if (i == 12 || i == 18 || j == 0 || j == 7) {
					well2[i][j] = EdgeColor;
				} else {
					well2[i][j] = BackGroundColor;
				}
			}
		}

		for (int i = 12; i < 19; i++) {
			for (int j = 8; j < 23; j++) {
				if (i == 12 || i == 18 || j == 8 || j == 22) {
					well3[i][j] = ScoreEdgeColor;
				} else {
					well3[i][j] = ScoreBackGroundColor;
				}
			}
		}
		newPiece();
	}

	private void drawPiece(Graphics g) {
		g.setColor(tetraminoColors[currentPiece]);
		for (Point p : Tetraminos[currentPiece][rotation]) {
			g.fillRect((p.x + pieceOrigin.x) * 26, (p.y + pieceOrigin.y) * 26, 25, 25);
		}
	}

	private void drawPiece2(Graphics g) {
		g.setColor(tetraminoColors[nextPiece]);
		for (Point p : Tetraminos[nextPiece][2]) {
			g.fillRect((p.x + pieceOrigin2.x) * 26, (p.y + pieceOrigin2.y) * 26, 25, 25);
		}
	}
	public void paintComponent(Graphics g) {
		if (timeAttack() == true && mode == 1) {
			gameover.label(1, high_Score, score, count, least_time);

		} else if (gameOver() == true && mode == 0) {
			gameover.label(0, high_Score, score, count, least_time);
			setVisible(false);
		} else {
			// Paint the well
			g.fillRect(0, 0, 26 * 12, 26 * 23);
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 23; j++) {
					g.setColor(well[i][j]);
					g.fillRect(26 * i, 26 * j, 25, 25);
				}
			}
			g.setColor(new Color(3, 0, 102));
			g.fillRect(26 * 12, 0, 26 * 7, 26 * 8);

			g.setColor(Color.DARK_GRAY);
			g.fillRect(26 * 12, 26 * 0, 26 * 7, 26 * 14);
			for (int i = 12; i < 19; i++) {
				for (int j = 0; j < 8; j++) {
					g.setColor(well2[i][j]);
					g.fillRect(26 * i, 26 * j, 25, 25);
				}
			}

			g.setColor(Color.DARK_GRAY);
			g.fillRect(26 * 12, 26 * 8, 26 * 7, 26 * 15);
			for (int i = 12; i < 19; i++) {
				for (int j = 8; j < 23; j++) {
					g.setColor(well3[i][j]);
					g.fillRect(26 * i, 26 * j, 25, 25);
				}
			}
			// Display the score
			g.setColor(Color.WHITE);
			g.setFont(new Font("Gothic", Font.BOLD, 18));

			if (mode == 1) {

				g.drawString("GOAL SCORE ", 343, 280);
				g.drawString("1000", 385, 300);

				g.drawString("SCORE", 370, 420);
				g.drawString(""+score, 395, 440);
				g.drawString("TIME", 380, 480);
				g.drawString(""+count, 395, 500);
				if (least_time == 100000000) {
					g.drawString("RECORD", 363, 360);
				    g.drawString(" - ", 395, 380);
				}
				else {
					g.drawString("RECORD", 363, 360);
					g.drawString("" + least_time, 395, 380);
				}
			} else {
				g.drawString("HIGH SCORE", 345, 320);
				g.drawString("" + high_Score, 395, 340);
				g.drawString("SCORE" , 370, 420);
				g.drawString("" + score, 395, 440);
			}

			// Draw the currently falling piece
			drawPiece2(g);
			drawPiece(g);
		}
	}

	public void rotate(int i) {
		int newRotation = (rotation + i) % 4;
		if (newRotation < 0) {
			newRotation = 3;
		}
		if (!collidesAt(pieceOrigin.x, pieceOrigin.y, newRotation)) {
			rotation = newRotation;
		}
		repaint();
	}

	public void move(int i) {
		if (!collidesAt(pieceOrigin.x + i, pieceOrigin.y, rotation)) {
			pieceOrigin.x += i;
		}
		repaint();
	}

	public void dropDown() {
		if (!collidesAt(pieceOrigin.x, pieceOrigin.y + 1, rotation)) {
			pieceOrigin.y += 1;
		} else {
			fixToWell();
		}
		repaint();
	}

	public void drop() {
		while (!collidesAt(pieceOrigin.x, pieceOrigin.y + 1, rotation)) {
			pieceOrigin.y += 1;

		}

		for (Point p : Tetraminos[currentPiece][rotation]) {
			well[pieceOrigin.x + p.x][pieceOrigin.y + p.y] = tetraminoColors[currentPiece];
		}
		clearRows();
		newPiece();
	}

	public void Escape() {
		System.exit(0);
	}

	private boolean collidesAt(int x, int y, int rotation) {
		for (Point p : Tetraminos[currentPiece][rotation]) {
			if (well[p.x + x][p.y + y] != BackGroundColor) {
				return true;
			}
		}
		return false;
	}

	// Make the dropping piece part of the well, so it is available for
	// collision detection.
	public void fixToWell() {
		for (Point p : Tetraminos[currentPiece][rotation]) {
			well[pieceOrigin.x + p.x][pieceOrigin.y + p.y] = tetraminoColors[currentPiece];
		}
		clearRows();
		newPiece();
	}

	public void deleteRow(int row) {
		for (int j = row - 1; j > 0; j--) {
			for (int i = 1; i < 11; i++) {
				well[i][j + 1] = well[i][j];
			}
		}
	}

	public boolean gameOver() {
		if (collidesAt(5, 2, 0) == true) {
			return true;
		} else
			return false;
	}

	public boolean timeAttack() {
		if ((score >= 1000 && mode == 1) || (gameOver() == true && mode == 1))
		{
			if (score >= 1000 && mode == 1) {
				if (least_time > count)
					least_time = count;
			}

			return true;
		} else
			return false;
	}

	// Clear completed rows from the field and award score according to
	// the number of simultaneously cleared rows.
	public void clearRows() {
		boolean gap;
		int numClears = 0;

		for (int j = 21; j > 0; j--) {
			gap = false;
			for (int i = 1; i < 11; i++) {
				if (well[i][j] == BackGroundColor) {
					gap = true;
					break;
				}
			}
			if (!gap) {
				deleteRow(j);
				j += 1;
				numClears += 1;
			}
		}

		switch (numClears) {
		case 1:
			score += 100;
			if (high_Score < score)
				high_Score = score;
			break;
		case 2:
			score += 300;
			if (high_Score < score)
				high_Score = score;
			break;
		case 3:
			score += 500;
			if (high_Score < score)
				high_Score = score;
			break;
		case 4:
			score += 800;
			if (high_Score < score)
				high_Score = score;
			break;
		}
	}

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
}
