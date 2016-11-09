package system;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.nio.MappedByteBuffer;

import javax.swing.JFrame;

import level.Level;
import level.RandomLevel;
import Entity.Entity;
import Entity.Mob.Player;
import Entity.Mob.Enemies.JellyHater;
import Input.KeyboardInput;
import Input.Mouse;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static int width = 1000;
	public static int height = width / 16 * 9;
	public static int scale = 1;
	
	public double mapZoom = 1.4;
	private boolean mapToggle = false;
	private int mapXSize = 300;
	private int mapYSize = mapXSize / 16 * 9;
	
	

	private Thread gameThread;
	private JFrame gameFrame;
	private Level level;
	private Player player;
	private boolean running = false;
	private Screen screen;
	private Screen mapScreen;
	private BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);
	private BufferedImage miniMap = new BufferedImage((int)(width*mapZoom), (int)(height*mapZoom),
			BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();
	private int[] miniMapPixels = ((DataBufferInt) miniMap.getRaster().getDataBuffer())
			.getData();
	private KeyboardInput KB;

	public Game() {
		Dimension windowSize = new Dimension(width * scale, height * scale);
		setPreferredSize(windowSize);
		screen = new Screen(width, height);
		mapScreen = new Screen((int)(width*mapZoom), (int)(height*mapZoom));
		gameFrame = new JFrame("Gametitle");
		KB = new KeyboardInput();
		player = new Player(153, 72, KB);
		level = new RandomLevel(100, 100, player);
		player.initialize(level);

		Mouse mouse = new Mouse();
		addKeyListener(KB);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	public synchronized void Start() {
		running = true;
		gameThread = new Thread(this, "Gamethread title");
		gameThread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.gameFrame.setResizable(false);
		game.gameFrame.add(game);
		game.gameFrame.pack();
		game.gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.gameFrame.setLocationRelativeTo(null);
		game.gameFrame.setVisible(true);

		game.Start();
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				gameFrame.setTitle("Dango! | " + frames + "fps, " + updates
						+ " ups.   X: " + player.x + ", Y:" + player.y);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		mapScreen.clear();
		int xScroll = (int) (player.x - (width - 8) / 2);
		int yScroll = (int) (player.y - (height - 8) / 2);
		level.render(xScroll, yScroll, screen);
		level.miscRender(screen);
		player.render(screen);
		level.renderFG(yScroll, yScroll, screen);

		int xMapScroll = (int) (player.x - (mapScreen.width - 4) / 2);
		int yMapScroll = (int) (player.y - (mapScreen.height - 4) / 2);
		level.render(xMapScroll, yMapScroll, mapScreen);
		player.render(mapScreen);
//		level.renderFG(yMapScroll, yMapScroll, mapScreen);		
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		for(int i = 0; i < miniMapPixels.length;i++){
			miniMapPixels[i] = mapScreen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		if(mapToggle) g.drawImage(miniMap, width*scale-mapXSize, 0, (mapXSize), (mapYSize), null);
		//g.setColor(Color.MAGENTA);
		//g.fillRect(97, 75, 400, 30);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		//g.drawString("Mouse Button> " + Mouse.getButton() + " X: "
		//		+ Mouse.getX() + "Y: " + Mouse.getY(), 100, 100);
		g.dispose();
		bs.show();
	}

	
	
	private void update() {
		KB.update();
		level.update();
		player.update();
	}
}
