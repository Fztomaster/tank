package com.jack.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {

	private int x, y;
	private Dir dir;
	private static final int SPEED = 5;
	private boolean moving = false;
	
	public Tank(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}
	
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public void paint(Graphics g) {
		Color color = g.getColor();
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 50, 50);
		g.setColor(color);
		move();
	}

	private void move() {
		if (!moving) return;
		
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
}
