package com.jack.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

	int x = 200; int y = 200;
	Dir dir = Dir.LEFT;
	private static final int SPEED = 10;
	
	public TankFrame() {
		// 设置窗口可见
		setVisible(true);
		// 设置窗体标题
		setTitle("tank war");
		// 设置窗体宽高
		setSize(800, 600);
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
	   * 窗口重新绘制会被自动调用
	 */
	@Override
	public void paint(Graphics g) {
		System.out.println("paint...");
		g.fillRect(x, y, 50, 50);
		switch (dir) {
			case LEFT:
				x -= SPEED;
				break;
			case UP:
				y -= SPEED;
				break;
			case RIGHT:
				x += SPEED;
				break;
			case DOWN:
				y += SPEED;
				break;
			default:
				break;
		}
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
			if (bL) {
				dir = Dir.LEFT;
			} else if (bU) {
				dir = Dir.UP;
			} else if (bR) {
				dir = Dir.RIGHT;
			} else if (bD) {
				dir = Dir.DOWN;
			}
		}
		
	}

}
