package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Block.Tetris_Block;

class myKeyListener extends GameStart implements KeyListener {
	public myKeyListener(Tetris_Block b) {
		this.block = b;
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			block.rotate(-1);
			break;
		case KeyEvent.VK_DOWN:
			block.dropDown();
			break;
		case KeyEvent.VK_LEFT:
			block.move(-1);
			break;
		case KeyEvent.VK_RIGHT:
			block.move(+1);
			break;
		case KeyEvent.VK_SPACE:
			block.drop();
			break;
		case KeyEvent.VK_ESCAPE:
			block.Escape();
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
	}

}