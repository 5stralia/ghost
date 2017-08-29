package new_ghost_03;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
	
	private Game game;
	private Main main;
	
	public KeyListener(Main main) {
		this.main = main;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			main.getGame().getCharacter().setUP(true);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			main.getGame().getCharacter().setDOWN(true);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			main.getGame().getCharacter().setLEFT(true);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			main.getGame().getCharacter().setRIGHT(true);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			main.getGame().getCharacter().setUP(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			main.getGame().getCharacter().setDOWN(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			main.getGame().getCharacter().setLEFT(false);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			main.getGame().getCharacter().setRIGHT(false);
		}
	}
}
