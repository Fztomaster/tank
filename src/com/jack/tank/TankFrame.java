package com.jack.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

	int x = 200; int y = 200;
	
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
		x += 20;
		y += 20;
	}
	
	class MyKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("key pressed");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("key released");
		}
		
		
	}

}
