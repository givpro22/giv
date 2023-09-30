package stock_game_1.copy;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class INITIAL extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	// 배경화면 타이틀
	private Image title = new ImageIcon(Main.class.getResource("/images/title.png")).getImage();// kpx200의 그림 제목 title

	// 메뉴바 시작하기 구성
	private ImageIcon start_mover = new ImageIcon(Main.class.getResource("/images/start_mover.png"));
	private ImageIcon start_mdown = new ImageIcon(Main.class.getResource("/images/start_mdown.png"));

	// 메뉴바 시작하기 클릭시
	private JButton startButton = new JButton(start_mover);

	// 화면 백그라운드랑 창화면 만드는 거 .화면 불러 올때 버퍼링 줄이기 위한 방법
	public INITIAL() {
		// setUndecorated(true); // 4강 메뉴바 없애는 거임
		setTitle("KPX200");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 사용자가 창 크기 변경x
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 창 종료 하면 게임 종료
		setVisible(true); // 우리눈에 게임창 보이게 해줌
		// setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		startButton.setBounds(500, 500, 240, 43); // 게임시작 버튼의 위치와 크기 조정
		startButton.setBorderPainted(false); // jbutton의 외곽선을 없애준다
		startButton.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		startButton.setFocusPainted(false); // 선택되었을때 생기는 테두리 사용x

		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(start_mdown);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(start_mover);

			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});

		add(startButton);

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		paintComponents(g); // 4강 3분 30초
		g.drawImage(title, 0, 0, null);
		this.repaint();

	}
}