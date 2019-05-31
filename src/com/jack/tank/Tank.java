package com.jack.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tank {

	// 坦克的位置
	private int x, y;
	// 坦克的方向
	private Dir dir = Dir.DOWN;
	// 坦克的移动速度
	private static final int SPEED = 1;
	// 坦克是否移动标志
	private boolean moving = true;
	private TankFrame tf = null;
	// 坦克的宽和高
	public static int WIDTH = ResourceMgr.tankD.getWidth();
	public static int HEIGHT = ResourceMgr.tankD.getHeight();	
	
	public boolean living = true;
	private Group group = Group.BAD;
	private Random random = new Random();
	
	public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.tf = tf;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void paint(Graphics g) {
		if (!living) {
			tf.tanks.remove(this);
		}
		
		switch(dir) {
			case LEFT:
				g.drawImage(ResourceMgr.tankL, x, y, null);
				break;
			case UP:
				g.drawImage(ResourceMgr.tankU, x, y, null);
				break;
			case RIGHT:
				g.drawImage(ResourceMgr.tankR, x, y, null);
				break;
			case DOWN:
				g.drawImage(ResourceMgr.tankD, x, y, null);
				break;
		}
		move();
	}
	
	public void fire() {
		int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
		int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
		tf.bullets.add(new Bullet(bX, bY, this.dir, this.group, this.tf));
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
		
		if (random.nextInt(10) > 8) this.fire();
	}

	public void die() {
		this.living = false;
	}
}
