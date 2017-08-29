package new_ghost_03;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Main extends JFrame {
	private final static int WIDTH = 1280;
	private final static int HEIGHT = 720;
	
	private Container contentpane;
	private Menu menu;
	private Game game;
	
	public Main() {
		setTitle("GHOST");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentpane = getContentPane();
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		
		newStart();
		
		setVisible(true);
		
		setFocusable(true);
		addKeyListener(new KeyListener(this));
	}
	
	public void newStart() {
		contentpane.removeAll();
		menu = new Menu(this);
		menu.setBounds(0, 0, WIDTH, HEIGHT);
		contentpane.add(menu);
		repaint();
		
	}
	
	public void gameStart() {
		contentpane.removeAll();
		game = new Game(this);
		game.setBounds(0, 0, WIDTH, HEIGHT);
		contentpane.add(game);
		repaint();
		
	}
	
//	public void paintComponent(Graphics g) {
//		super.paintComponents(g);
//		Graphics2D g2 = (Graphics2D) g;
//	}

	
	public static void main(String[] args) {
		new Main();

	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
