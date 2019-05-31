package com.jack.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {

	// 子弹位置
	private int x, y;
	// 子弹方向
	private Dir dir;
	// 子弹速度
	private static final int SPEED = 10;
	// 子弹高度和宽度
	private static int WIDTH = 30, HEIGHT = 30;	
	// 子弹临界范围判断
    boolean live = true;
	private TankFrame tf = null;
	
	public Bullet(int x, int y, Dir dir, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	
	public void paint(Graphics g) {
		// 超出临界范围
		if (!live) {
			tf.bullets.remove(this);
		}
		// 设置子弹的形状
		Color color = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(color);
		move();
	}

	private void move() {
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
		
		if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
			live = false;
		}
		
	}
	
}
