package new_ghost_03;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import ghost_08.Ghost;
import new_ghost_01.Main;

public class Monster extends JLabel implements Runnable {
	private final int SPEED = 1;
	private final int SLEEP = 10;
	
	public int x, y;
	
	private Image monsterBasicImage = new ImageIcon(Main.class.getResource("../images/monster.png")).getImage();
	
	private boolean isStop;
	
	private Rectangle2D monsterR;
	
	public Thread thread;
	
	private Game game;
	
	public Monster(int x, int y, Game game) {
		isStop = false;
		this.game = game;
		this.x = x;
		this.y = y;
		setMonsterR(new Rectangle2D.Double(x, y, 50, 50));
		setBounds(x, y, 50, 50);
		thread = new Thread(this);
	}
	


	public void run() {
		try {
			while(!isStop) {
//				int tempX = x;
//				int tempY = y;
//				move();
//				monsterR.setRect(x, y, 50, 50);
//				if(monsterR.intersects(game.getCharacter().getCharR())) {
////					isStop = true;
////					x = tempX;
////					y = tempY;
//				} else {
//					for(int i = 0; i < game.getBarrierList().size(); i++) {
//						if(monsterR.intersects(game.getBarrierList().get(i).getBarrierR())) {
//							x = tempX;
//							y = tempY;
//						}
//					}
//				}
//				setLocation(x, y);
//				Thread.sleep(100);
				
				int tempX = x;
				int tempY = y;
				
				for(int j = 0; j < game.getMonsterList().size(); j++) {
					if(this == game.getMonsterList().get(j)) continue;
					if(monsterR.intersects(game.getMonsterList().get(j).monsterR)) {
						x = tempX;
						y = tempY;
						monsterR.setRect(x, y, 50, 50);
					}
				}
				
				if(game.getCharacter().getX() > x) {
					if(game.getCharacter().getY() > y) {
						x += SPEED;
						y += SPEED;
						monsterR.setRect(x, y, 50, 50);
						
						for(int i = 0; i < game.getBarrierList().size(); i++) {
							if(monsterR.intersects(game.getBarrierList().get(i).getBarrierR())) {
								x = tempX + SPEED;
								y = tempY;
								monsterR.setRect(x, y, 50, 50);
							}
							if(monsterR.intersects(game.getBarrierList().get(i).getBarrierR())) {
								x = tempX;
								y = tempY + SPEED;
								monsterR.setRect(x, y, 50, 50);
							}
						}
					} else {
						x += SPEED;
						y -= SPEED;
						monsterR.setRect(x, y, 50, 50);
						
						for(int i = 0; i < game.getBarrierList().size(); i++) {
							if(monsterR.intersects(game.getBarrierList().get(i).getBarrierR())) {
								x = tempX + SPEED;
								y = tempY;
								monsterR.setRect(x, y, 50, 50);
							}
							if(monsterR.intersects(game.getBarrierList().get(i).getBarrierR())) {
								x = tempX;
								y = tempY - SPEED;
								monsterR.setRect(x, y, 50, 50);
							}
						}
					}
				} else {
					if(game.getCharacter().getY() > y) {
						x -= SPEED;
						y += SPEED;
						monsterR.setRect(x, y, 50, 50);
						
						for(int i = 0; i < game.getBarrierList().size(); i++) {
							if(monsterR.intersects(game.getBarrierList().get(i).getBarrierR())) {
								x = tempX - SPEED;
								y = tempY;
								monsterR.setRect(x, y, 50, 50);
							}
							if(monsterR.intersects(game.getBarrierList().get(i).getBarrierR())) {
								x = tempX;
								y = tempY + SPEED;
								monsterR.setRect(x, y, 50, 50);
							}
						}
					} else {
						x -= SPEED;
						y -= SPEED;
						monsterR.setRect(x, y, 50, 50);
						
						for(int i = 0; i < game.getBarrierList().size(); i++) {
							if(monsterR.intersects(game.getBarrierList().get(i).getBarrierR())) {
								x = tempX - SPEED;
								y = tempY;
								monsterR.setRect(x, y, 50, 50);
							}
							if(monsterR.intersects(game.getBarrierList().get(i).getBarrierR())) {
								x = tempX;
								y = tempY - SPEED;
								monsterR.setRect(x, y, 50, 50);
							}
						}
					}
				}
				setLocation(x, y);
				Thread.sleep(SLEEP);
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void move() {
		x += SPEED;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(monsterBasicImage, 0, 0, null);
	}
	
	public boolean isStop() {
		return isStop;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}

	public Rectangle2D getMonsterR() {
		return monsterR;
	}

	public void setMonsterR(Rectangle2D monsterR) {
		this.monsterR = monsterR;
	}
	
	
}
