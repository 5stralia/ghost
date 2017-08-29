package new_ghost_01;

import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.ImageIcon;



public class Monster extends Thread {
	private static final int SPEED = 1;
	private static final int SLEEP_TIME = 10;

	private int x, y;
	private boolean stop;

	private Image monsterBasicImage = new ImageIcon(Main.class.getResource("../images/monster.png")).getImage();

	Random rd = new Random();
	int ttt;
	private Rectangle2D monsterR;
	private Game game;
	
	public Monster(int x, int y, Game game) {
		this.game = game;
		this.setX(x);
		this.setY(y);
		setMonsterR(new Rectangle2D.Double(x, y, 50 ,50));
		stop = false;
		//		this.start();
	}

	public void run() {
		try{
			while(!stop){
				//				if(stop) break;
				System.out.println(getMonsterR());
				int tempX = getX();
				int tempY = getY();
				
				for(int j = 0; j < game.getMonsterList().size(); j++) {
					if(this == game.getMonsterList().get(j)) continue;
					if(getMonsterR().intersects(game.getMonsterList().get(j).monsterR)) {
						setX(tempX);
						setY(tempY);
						getMonsterR().setRect(getX(), getY(), 50, 50);
					}
				}
				
				if(game.getGhostCharacter().getX() > getX()) {
					if(game.getGhostCharacter().getY() > getY()) {
						setX(getX() + SPEED);
						setY(getY() + SPEED);
						getMonsterR().setRect(getX(), getY(), 50, 50);
						
						for(int i = 0; i < game.getBarrierList().size(); i++) {
							if(getMonsterR().intersects(game.getBarrierList().get(i).getBarrierR())) {
								setX(tempX + SPEED);
								setY(tempY);
								getMonsterR().setRect(getX(), getY(), 50, 50);
							}
							if(getMonsterR().intersects(game.getBarrierList().get(i).getBarrierR())) {
								setX(tempX);
								setY(tempY + SPEED);
								getMonsterR().setRect(getX(), getY(), 50, 50);
							}
						}
					} else {
						setX(getX() + SPEED);
						setY(getY() - SPEED);
						getMonsterR().setRect(getX(), getY(), 50, 50);
						
						for(int i = 0; i < game.getBarrierList().size(); i++) {
							if(getMonsterR().intersects(game.getBarrierList().get(i).getBarrierR())) {
								setX(tempX + SPEED);
								setY(tempY);
								getMonsterR().setRect(getX(), getY(), 50, 50);
							}
							if(getMonsterR().intersects(game.getBarrierList().get(i).getBarrierR())) {
								setX(tempX);
								setY(tempY - SPEED);
								getMonsterR().setRect(getX(), getY(), 50, 50);
							}
						}
					}
				} else {
					if(game.getGhostCharacter().getY() > getY()) {
						setX(getX() - SPEED);
						setY(getY() + SPEED);
						getMonsterR().setRect(getX(), getY(), 50, 50);
						
						for(int i = 0; i < game.getBarrierList().size(); i++) {
							if(getMonsterR().intersects(game.getBarrierList().get(i).getBarrierR())) {
								setX(tempX - SPEED);
								setY(tempY);
								getMonsterR().setRect(getX(), getY(), 50, 50);
							}
							if(getMonsterR().intersects(game.getBarrierList().get(i).getBarrierR())) {
								setX(tempX);
								setY(tempY + SPEED);
								getMonsterR().setRect(getX(), getY(), 50, 50);
							}
						}
					} else {
						setX(getX() - SPEED);
						setY(getY() - SPEED);
						getMonsterR().setRect(getX(), getY(), 50, 50);
						
						for(int i = 0; i < game.getBarrierList().size(); i++) {
							if(getMonsterR().intersects(game.getBarrierList().get(i).getBarrierR())) {
								setX(tempX - SPEED);
								setY(tempY);
								getMonsterR().setRect(getX(), getY(), 50, 50);
							}
							if(getMonsterR().intersects(game.getBarrierList().get(i).getBarrierR())) {
								setX(tempX);
								setY(tempY - SPEED);
								getMonsterR().setRect(getX(), getY(), 50, 50);
							}
						}
					}
				}
				
				
				
				
				
				Thread.sleep(SLEEP_TIME);
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public void monsterStop() {
		stop = true;
	}

	public void move(int chk, int x, int y) {
		switch(chk){
		case 0: 
			if(x < 1230){
				this.setX(this.getX() + SPEED);
				break;
			}
			else {
				this.setX(this.getX() - SPEED);
				break;
			}
		case 1: 
			if(x > 0){
				this.setX(this.getX() - SPEED);
				break;
			} 
			else {
				this.setX(this.getX() + SPEED);
				break;
			}
		case 2: 
			if(y < 670){
				this.setY(this.getY() + SPEED);
				break;
			}
			else {
				this.setY(this.getY() - SPEED);
				break;				
			}
		case 3: 
			if(y > 0){
				this.setY(this.getY() - SPEED);
				break;
			}
			else {
				this.setY(this.getY() + SPEED);
				break;
			}
		}
	}

	public void followMove() {
		if((game.getGhostCharacter().getX()) > getX()) {
			this.setX(this.getX() + SPEED);
			getMonsterR().setRect(getX(), getY(), 50, 50);
		}
		else if((game.getGhostCharacter().getX()) < getX()){
			this.setX(this.getX() - SPEED);
			getMonsterR().setRect(getX(), getY(), 50, 50);
		}
		else if((game.getGhostCharacter().getY()) > getY()) {
			this.setY(this.getY() + SPEED);
			getMonsterR().setRect(getX(), getY(), 50, 50);
		}
		else if((game.getGhostCharacter().getY()) < getY()){
			this.setY(this.getY() - SPEED);
			getMonsterR().setRect(getX(), getY(), 50, 50);
		}
	}

	//	public boolean isGo() {
	//		
	//	}

	public Image getBasicImage() {
		return getMonsterBasicImage();
	}

	public Rectangle2D getMonsterR() {
		return monsterR;
	}

	public void setMonsterR(Rectangle2D monsterR) {
		this.monsterR = monsterR;
	}

	public Image getMonsterBasicImage() {
		return monsterBasicImage;
	}

	public void setMonsterBasicImage(Image monsterBasicImage) {
		this.monsterBasicImage = monsterBasicImage;
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

}
