package com.jack.tank;

import java.awt.Graphics;

public class Tank {

	private int x = 200; 
	private int y = 200;
	private Dir dir = Dir.LEFT;
	private static final int SPEED = 10;
	
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
}
