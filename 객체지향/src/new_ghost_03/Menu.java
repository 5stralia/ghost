package new_ghost_03;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel{
	
	private Image backGroundImage = new ImageIcon(getClass().getClassLoader().getResource("images/mainScreenResize.png")).getImage();
	
	private ImageIcon startButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/startButton.png"));
	private ImageIcon startButtonEntered = new ImageIcon(getClass().getClassLoader().getResource("images/startButtonEntered.png"));
	private ImageIcon helpButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/helpButton.png"));
	private ImageIcon helpButtonEntered = new ImageIcon(getClass().getClassLoader().getResource("images/helpButtonEntered.png"));
	private ImageIcon exitButtonBasic = new ImageIcon(getClass().getClassLoader().getResource("images/exitButton.png"));
	private ImageIcon exitButtonEntered = new ImageIcon(
			getClass().getClassLoader().getResource("images/exitButtonEntered.png"));
	
	private JButton startButton = new JButton(startButtonBasic);
	private JButton helpButton = new JButton(helpButtonBasic);
	private JButton exitButton = new JButton(exitButtonBasic);
	
	private Music introMusic = new Music("mainScreenMusic.mp3", true);
	
	private Main main;
	
	
	
	public Menu(Main main) {
		this.main = main;
		setLayout(null);
		introMusic.start();
		// buttonSet 메소드를 통해서 버튼들을 넣어준다
		buttonSet(startButton, 93, 250, 339, 123);
		buttonSet(helpButton, 93, 392, 339, 123);
		buttonSet(exitButton, 93, 546, 339, 123);
		
		// startButton 이벤트처리
				startButton.addMouseListener(new MouseAdapter() {
					// 마우스가 버튼에 들어왓을때 이벤트 처리
					@Override
					public void mouseEntered(MouseEvent e) {
						// Entered이미지로 변경 시켜준다.
						startButton.setIcon(startButtonEntered);
						// 커서의 모양을 바꿔준다
						startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
						// 효과음 재생
						Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
						menuEnteredMusic.start();
					}

					// 마우스가 버튼에 나갔을때 이벤트 처리
					@Override
					public void mouseExited(MouseEvent e) {
						startButton.setIcon(startButtonBasic);
						// 커서의 모양을 바꿔준다
						startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}

					// 버튼을 클릭했을때 이벤트 처리
					@Override
					public void mousePressed(MouseEvent e) {
						// 효과음 재생
						Music menuClickMusic = new Music("menuClickMusic.mp3", false);
						menuClickMusic.start();
						// 메인화면 음악은 꺼주고 게임음악을 튼다.
						introMusic.close();
						// 다른 화면은 안보이게 변경시킨다.
						startButton.setVisible(false);
						helpButton.setVisible(false);
						exitButton.setVisible(false);
						main.gameStart();
						
					}
				});

				// helpButton 이벤트처리
				helpButton.addMouseListener(new MouseAdapter() {
					// 마우스가 버튼에 들어왓을때 이벤트 처리
					@Override
					public void mouseEntered(MouseEvent e) {
						// Entered이미지로 변경 시켜준다.
						helpButton.setIcon(helpButtonEntered);
						// 커서의 모양을 바꿔준다
						helpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
						// 효과음 재생
						Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
						menuEnteredMusic.start();
					}

					// 마우스가 버튼에 나갔을때 이벤트 처리
					@Override
					public void mouseExited(MouseEvent e) {
						helpButton.setIcon(helpButtonBasic);
						// 커서의 모양을 바꿔준다
						helpButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}

					// 버튼을 클릭했을때 이벤트 처리
					@Override
					public void mousePressed(MouseEvent e) {
						// 효과음 재생
						Music menuClickMusic = new Music("menuClickMusic.mp3", false);
						menuClickMusic.start();
						// 게임 도움말 이벤트
					}
				});

				// exitButton 이벤트처리
				exitButton.addMouseListener(new MouseAdapter() {
					// 마우스가 버튼에 들어왓을때 이벤트 처리
					@Override
					public void mouseEntered(MouseEvent e) {
						// Entered이미지로 변경 시켜준다.
						exitButton.setIcon(exitButtonEntered);
						// 커서의 모양을 바꿔준다
						exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
						// 효과음 재생
						Music menuEnteredMusic = new Music("menuEnteredMusic.mp3", false);
						menuEnteredMusic.start();
					}

					// 마우스가 버튼에 나갔을때 이벤트 처리
					@Override
					public void mouseExited(MouseEvent e) {
						exitButton.setIcon(exitButtonBasic);
						// 커서의 모양을 바꿔준다
						exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}

					// 버튼을 클릭했을때 이벤트 처리
					@Override
					public void mousePressed(MouseEvent e) {
						// 효과음 재생
						Music menuClickMusic = new Music("menuClickMusic.mp3", false);
						menuClickMusic.start();
						// 프로그램이 바로 꺼지지 않고 1초정도 있다가 꺼지게금 설정
						try {
							Thread.sleep(1000);
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
						System.exit(0);
					}
				});
		
	}
	
	
	// 버튼 셋팅 메소드 모든 버튼마다 설정값을 넣기 귀찮으므로 메소드로 만들었다.
	public void buttonSet(JButton button, int x, int y, int width, int height) {
		button.setBounds(x, y, width, height);
		// 버튼 테두리 제거
		button.setBorderPainted(false);
		// 누르는 느낌 제거
		button.setContentAreaFilled(false);
		// 글씨 테두리 제거
		button.setFocusPainted(false);
		// 버튼 추가
		add(button);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(backGroundImage, 0, 0, null);
		
	}
	
	
}
