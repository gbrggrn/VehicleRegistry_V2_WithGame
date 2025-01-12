package fordonsregister;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

@SuppressWarnings("serial")
public class FordonGame extends JPanel implements Runnable, KeyListener{

//game variables
	private boolean running;
	private boolean shouldStartText = true;
	private boolean gameOver;
	private Random random;
	private int runCounter;
	private int randGenerateFrequency = 250;
	
//road variables
	private int roadHeight = 1000;
	private int roadWidth = 550;
	private int midLineHeight = 50;
	private int midLineWidth = 18;
	private int midLinePosX = roadWidth/2 - midLineWidth/2;
	private int midLinePosY = midLineHeight;
	private int midLine2Y = -roadHeight + midLineHeight;
	private int midLine2X = roadWidth/2 - midLineWidth/2;
	
//player variables
	private int playerHeight = 250;
	private int playerWidth = 150;
	private int playerPosX = (roadWidth - playerWidth)/2;
	private int playerPosY = (roadHeight -25) - playerHeight;
	private int playerSpeed = 7;
	
//obstacle variables
	private int rockHeight = 70;
	private int rockWidth = 70;
	private int rockPosX;
	private int rockPosY;
	private boolean generateRock;
	
	private int plankHeight = 150;
	private int plankWidth = 30;
	private int plankPosX;
	private int plankPosY;
	private boolean generatePlank; 

//constructor
	public FordonGame() {
		setPreferredSize(new Dimension(550,1000));
		setBackground(Color.black);
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		random = new Random();
		
		running = true;
		
		new Thread(this).start();
	}
	
//main method
	/*public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> {
	        new FordonGame().start();
	    });
	}*/
	
//override paintComponent()
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawFordonGame(g);
	}
	
//draws the game
	public void drawFordonGame(Graphics g) {
		if(gameOver == true) {
			g.setColor(Color.red);
			g.drawString("Du kraschade!", roadWidth / 7, roadHeight / 2);
		}
		
		g.setColor(Color.white);
		for(int y = midLinePosY; y < roadHeight; y += midLineHeight*2) {
	        g.fillRect(midLinePosX, y, midLineWidth, midLineHeight);
		}
		
		for(int y = midLine2Y; y < roadHeight; y +=midLineHeight*2) {
			g.fillRect(midLine2X, y, midLineWidth, midLineHeight);
		}
		
		if(shouldStartText == true) {
			g.setColor(Color.green);
			g.drawString("Undvik Hinder! Rör du dör du!", roadWidth / 7, roadHeight / 2);
		}
		
		g.setColor(Color.orange);
		//g.fillRect(playerPosX, playerPosY, playerWidth, playerHeight);
		g.fill3DRect(playerPosX, playerPosY, playerWidth, playerHeight, true);
		
		if(generateRock == true) {
			g.setColor(Color.gray);
			g.fill3DRect(rockPosX, rockPosY, rockWidth, rockHeight, true);
		}
		
		if(generatePlank == true) {
			g.setColor(Color.yellow);
			g.fill3DRect(plankPosX, plankPosY, plankWidth, plankHeight, true);
		}
	}

//game logic loop
	@Override
	public void run() {
		while(running) {
			
			midLinePosY++;
			if(midLinePosY >= roadHeight) {
				midLinePosY = midLine2Y - roadHeight + midLineHeight*2;
			}
			
			midLine2Y++;
			if(midLine2Y >= roadHeight){
				midLine2Y = -roadHeight + midLineHeight*2;
			}
			
			if(runCounter > 400) {
				shouldStartText = false;
			}
			
			if(runCounter % randGenerateFrequency == 0) {
				int randNr = random.nextInt(0, 3);
				System.out.println(randNr);
				if(shouldGenerateObstacle(randNr) == true) {
					if(randNr == 1 && generateRock != true) {
						System.out.println("generateRock()");
						rockPosX = random.nextInt(0, roadWidth - rockWidth);
						rockPosY = 0 - rockHeight;
						generateRock = true;
					} else if(generatePlank != true) {
						System.out.println("generatePlank()");
						plankPosX = random.nextInt(0, roadWidth - plankWidth);
						plankPosY = 0 - plankHeight;
						generatePlank = true;
					}
				}
			}
			
			if(generateRock == true) {
				rockPosY++;
				Rectangle playerBounds = new Rectangle(playerPosX, playerPosY, playerWidth, playerHeight);
				Rectangle rockBounds = new Rectangle(rockPosX, rockPosY, rockWidth, rockHeight);
				if(playerBounds.intersects(rockBounds)) {
					System.out.println("Träffade en sten");
					gameOver = true;
					repaint();
					try {
						Thread.sleep(2000);
						gameOverClose();
					} catch (InterruptedException ie) {
						
					}
				}
				if(rockPosY >= roadHeight + rockHeight) {
					generateRock = false;
				}
			}
			
			if(generatePlank == true) {
				plankPosY++;
				Rectangle playerBounds = new Rectangle(playerPosX, playerPosY, playerWidth, playerHeight);
				Rectangle plankBounds = new Rectangle(plankPosX, plankPosY, plankWidth, plankHeight);
				if(playerBounds.intersects(plankBounds)) {
					System.out.println("Träffade en planka");
					gameOver = true;
					repaint();
					try {
						Thread.sleep(2000);
						gameOverClose();
					} catch (InterruptedException ie) {
						
					}
				}
				if(plankPosY >= roadHeight + plankHeight) {
					generatePlank = false;
				}
			}
			
			repaint();
			runCounter++;
			
			if(runCounter > Integer.MAX_VALUE) {
				runCounter = 401;
			}
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException ie) {
				
			}
		}
	}
	
//create platform
	private JFrame platform;
	
	public void start() {
		platform = new JFrame();
		platform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		platform.getContentPane().add(this);
		platform.pack();
		platform.setResizable(false);
		platform.setLocationRelativeTo(null);
		platform.setVisible(true);
	}
	
	public void gameOverClose() {
		this.setVisible(false);
		this.platform.setVisible(false);
		this.running = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

//movement logic
	@Override
	public void keyPressed(KeyEvent e) {
		int pressedKey = e.getKeyCode();
		if(pressedKey == KeyEvent.VK_LEFT) {
			playerPosX -= playerSpeed;
			if(playerPosX < 0) {
				playerPosX = 0;
			}
		} else if (pressedKey == KeyEvent.VK_RIGHT) {
			playerPosX += playerSpeed;
			if(playerPosX + playerWidth > roadWidth) {
				playerPosX = roadWidth - playerWidth;
			}
		} else if (pressedKey == KeyEvent.VK_UP) {
			playerPosY -= playerSpeed;
			if(playerPosY < 0) {
				playerPosY = 0;
			}
		} else if (pressedKey == KeyEvent.VK_DOWN) {
			playerPosY += playerSpeed;
			if(playerPosY + playerHeight > roadHeight) {
				playerPosY = roadHeight - playerHeight;
			}
		}
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO
		
	}

//if object is to be generated
	public boolean shouldGenerateObstacle(int randNr) {
		if(randNr == 1 || randNr == 2) {
			return true;
		} else {
			return false;
		}
	}
}


