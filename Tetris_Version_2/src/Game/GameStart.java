
package Game;

import java.util.*;
import java.util.Timer;

import javax.swing.*;

import Block.Tetris_Block;

public class GameStart extends JFrame {

	Tetris_Block block;
	final GameMain game = new GameMain();
	JFrame f = new JFrame("Tetris");
	private static final long serialVersionUID = -8715353373678321308L;
	
	
	public void normal_run() {

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(19 * 26 + 17, 26 * 23 + 41);
		f.setVisible(true);

		Tetris_Block block = new Tetris_Block();
		block.init();
		f.add(block);
		f.addKeyListener(new myKeyListener(block));

		new Thread() {
			@Override
			public void run() {
				double time=1000;
				int Limit_Score = 100;
				while (true) {
					try {
						if (block.score >= Limit_Score) {
							time = time * 0.9;
							Limit_Score +=500;
							Thread.sleep((long) time);
							block.dropDown();
						} else if (block.gameOver() == true) {
							interrupt();
						} else {
							Thread.sleep((long)time);
							block.dropDown();
						}
					} catch (InterruptedException e) {
					}
				}
			}
		}.start();
	}

	public void time_run() {

		JFrame f = new JFrame("Tetris");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(19 * 26 + 17, 26 * 23 + 41);
		f.setVisible(true);

		Tetris_Block block = new Tetris_Block();
		block.init();
		f.add(block);
		f.addKeyListener(new myKeyListener(block));
		block.mode = 1;
		block.count = 0;
		Timer m_timer = new Timer();
		TimerTask m_task = new TimerTask() {
			public void run() {
				if (block.score < 1000) {
					block.count++;
				} else {
					m_timer.cancel();
				}
			}
		};
		m_timer.schedule(m_task, 0, 1000);
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						if (block.timeAttack() == true) {
							interrupt();
							m_timer.cancel();
						} else {
							Thread.sleep(1000);
							block.dropDown();
						}
					} catch (InterruptedException e) {
					}
				}
			}
		}.start();
	}

	public static void main(String[] args) {
		Mode_Select modeselect = new Mode_Select();
		modeselect.Start();
	}
}