package new_ghost_03;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Character extends JLabel implements Runnable {
	private final int SPEED = 3;
	private final int SLEEP = 10;

	private int x, y;

	private Image ghostBasicImage = new ImageIcon(Main.class.getResource("../images/testGhostCharacter.png")).getImage();
	private Image ghostBackImage = new ImageIcon(Main.class.getResource("../images/testGhostBack.png")).getImage();

	private boolean isUP = false;
	private boolean isDOWN = false;
	private boolean isLEFT = false;
	private boolean isRIGHT = false;
	
	private boolean isStop;

	


	private Rectangle2D charR;

	public Thread charThread;

	public Character(int x, int y, Game game) {
		isStop = false;
		this.game = game;
		this.x = x;
		this.y = y;
		charR = new Rectangle2D.Double(x, y, 50, 50);
		setBounds(x, y, 50, 50);
		charThread = new Thread(this);
	}
	
	public void run() {
		try {
			while(!isStop) {
				int tempX = x;
				int tempY = y;
				pressKey();
				charR.setRect(x, y, 50, 50);
				for(int i = 0; i < game.getMonsterList().size(); i++) {
					if(charR.intersects(game.getMonsterList().get(i).getMonsterR())) {
//						isStop = true;
//						x = tempX;
//						y = tempY;
					} else {
						for(int j = 0; j < game.getBarrierList().size(); j++) {
							if(charR.intersects(game.getBarrierList().get(j).getBarrierR())) {
								x = tempX;
								y = tempY;		
							}
						}
					}
				}
				charR.setRect(x, y, 50, 50);
				setLocation(x, y);
				Thread.sleep(SLEEP);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void pressKey() {
		if(isUP == true) {
			y -= SPEED;
		}
		if(isDOWN == true) {
			y += SPEED;
		}
		if(isLEFT == true) {
			x -= SPEED;
		}
		if(isRIGHT == true) {
			x += SPEED;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(ghostBasicImage, 0, 0, null);
	}
	
	public boolean isStop() {
		return isStop;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isUP() {
		return isUP;
	}

	public void setUP(boolean isUP) {
		this.isUP = isUP;
	}

	public boolean isDOWN() {
		return isDOWN;
	}

	public void setDOWN(boolean isDOWN) {
		this.isDOWN = isDOWN;
	}

	public boolean isLEFT() {
		return isLEFT;
	}

	public void setLEFT(boolean isLEFT) {
		this.isLEFT = isLEFT;
	}

	public boolean isRIGHT() {
		return isRIGHT;
	}

	public void setRIGHT(boolean isRIGHT) {
		this.isRIGHT = isRIGHT;
	}

	public Rectangle2D getCharR() {
		return charR;
	}

	public void setCharR(Rectangle2D charR) {
		this.charR = charR;
	}


	private Game game;


}
