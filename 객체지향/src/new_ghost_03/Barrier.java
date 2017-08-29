package new_ghost_03;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Barrier extends JLabel {
	
private Image barrierImage;
	
	public int x, y;
	
	private Rectangle2D barrierR;
	
	public Barrier(int x, int y, String type) {
		this.x = x;
		this.y = y;
		if(type.equals("S")) {
			barrierImage = new ImageIcon(Main.class.getResource("../images/barrier(SMALL).png")).getImage();
			barrierR = new Rectangle2D.Double(x, y, 60, 80);
			setBounds(x, y, 60, 80);
		}
		if(type.equals("B")) {
			barrierImage = new ImageIcon(Main.class.getResource("../images/barrier(BIG).png")).getImage();
			barrierR = new Rectangle2D.Double(x, y, 60, 300);
			setBounds(x, y, 60, 300);

		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(barrierImage, 0, 0, null);
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

	public Rectangle2D getBarrierR() {
		return barrierR;
	}

	public void setBarrierR(Rectangle2D barrierR) {
		this.barrierR = barrierR;
	}
	}
