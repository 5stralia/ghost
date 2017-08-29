package new_ghost_03;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Game extends JPanel implements Runnable {
	
	private Image backGroundImage;
	
	private Music gameMusic;
	
	private Main main;
	
	private boolean isStop;

	private Character character;
	private ArrayList<Barrier> barrierList = new ArrayList<Barrier>();
	private ArrayList<Monster> monsterList = new ArrayList<Monster>();
	
	public Game(Main main) {
		isStop = false;
		this.main = main;
		setLayout(null);
		gameMusic = new Music("gamePlayMusic.mp3", true);
		gameMusic.start();
		backGroundImage = new ImageIcon(getClass().getClassLoader().getResource("images/gameBackground.png")).getImage();
		character = new Character(100, 100, this);
		add(character);
		
		monsterList.add(new Monster(500, 500, this));
		add(getMonsterList().get(0));
		
		barrierList.add(new Barrier(500, 0, "B"));
		barrierList.add(new Barrier(600, 0, "B"));
		barrierList.add(new Barrier(700, 0, "B"));
		add(barrierList.get(0));
		add(barrierList.get(1));
		add(barrierList.get(2));
		
		
		
		Thread thread = new Thread(this);
		thread.start();
		character.charThread.start();
		monsterList.get(0).thread.start();
		
		
	}
	
	public void run() {
		try {
			while(!isStop) {
				for(int i = 0; i < monsterList.size(); i++) {
					if(character.getCharR().intersects(monsterList.get(i).getMonsterR())) {
						System.out.println("GAME OVER");
						gameMusic.close();
						character.setStop(true);
						for(int j = 0; j < monsterList.size(); j++) {
							monsterList.get(j).setStop(true);
						}
						isStop = true;
					}
				}
				Thread.sleep(10);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(backGroundImage, 0, 0, null);

	}
	
	public Image getBackGroundImage() {
		return backGroundImage;
	}

	public void setBackGroundImage(Image backGroundImage) {
		this.backGroundImage = backGroundImage;
	}

	public ArrayList<Barrier> getBarrierList() {
		return barrierList;
	}

	public void setBarrierList(ArrayList<Barrier> barrierList) {
		this.barrierList = barrierList;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public ArrayList<Monster> getMonsterList() {
		return monsterList;
	}

	public void setMonsterList(ArrayList<Monster> monsterList) {
		this.monsterList = monsterList;
	}
}
