package com.jack.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

	Tank myTank = new Tank(200, 200, Dir.LEFT);	
	Bullet bullet = new Bullet(300, 300, Dir.DOWN);
	static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
	
	public TankFrame() {
		// 设置窗口可见
		setVisible(true);
		// 设置窗体标题
		setTitle("tank war");
		// 设置窗体宽高
		setSize(GAME_WIDTH, GAME_HEIGHT);
		// 设置窗体不可随意改变宽高
		setResizable(false);
		
		// 窗口监听事件
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
			
		});
		
		this.addKeyListener(new MyKeyListener());
	}
	
	/**
	 * 双缓冲解决闪烁问题
	 */
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	/**
	   * 窗口重新绘制会被自动调用
	 */
	@Override
	public void paint(Graphics g) {
		myTank.paint(g);
		bullet.paint(g);
	}

	class MyKeyListener extends KeyAdapter {	
		
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch (keyCode) {
				case KeyEvent.VK_LEFT:
					bL = true;
					break;
				case KeyEvent.VK_UP:
					bU = true;
					break;
				case KeyEvent.VK_RIGHT:
					bR = true;
					break;
				case KeyEvent.VK_DOWN:
					bD = true;
					break;
				default:
					break;
			}
			
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch (keyCode) {
				case KeyEvent.VK_LEFT:
					bL = false;
					break;
				case KeyEvent.VK_UP:
					bU = false;
					break;
				case KeyEvent.VK_RIGHT:
					bR = false;
					break;
				case KeyEvent.VK_DOWN:
					bD = false;
					break;
				default:
					break;
			}
			setMainTankDir();
		}

		private void setMainTankDir() {
			if (!bL && !bU && !bR && !bD) {
				myTank.setMoving(false);
			} else {
				myTank.setMoving(true);
				
				if (bL) myTank.setDir(Dir.LEFT);
				if (bU) myTank.setDir(Dir.UP);
				if (bR) myTank.setDir(Dir.RIGHT);
				if (bD) myTank.setDir(Dir.DOWN);
			}
		}
		
	}

}
