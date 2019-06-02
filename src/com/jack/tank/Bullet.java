package com.jack.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {

	// 子弹位置
	private int x, y;
	// 子弹方向
	private Dir dir;
	// 子弹速度
	private static final int SPEED = 6;
	// 子弹高度和宽度
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();	
	// 子弹临界范围判断
    boolean living = true;
	private TankFrame tf = null;
	private Group group = Group.BAD;
	
	Rectangle rect = new Rectangle();
	
	public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.tf = tf;
		
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void paint(Graphics g) {
		// 超出临界范围
		if (!living) {
			tf.bullets.remove(this);
		}
		
		switch(dir) {
			case LEFT:
				g.drawImage(ResourceMgr.bulletL, x, y, null);
				break;
			case UP:
				g.drawImage(ResourceMgr.bulletU, x, y, null);
				break;
			case RIGHT:
				g.drawImage(ResourceMgr.bulletR, x, y, null);
				break;
			case DOWN:
				g.drawImage(ResourceMgr.bulletD, x, y, null);
				break;
		}
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
		
		// update rect
		rect.x = this.x;
		rect.y = this.y;
		
		if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
			living = false;
		}
		
	}

	/**
	 * 坦克和子弹的碰撞检测
	 * @param tank
	 */
	public void collideWith(Tank tank) {
		if (this.group == tank.getGroup()) {
			return;
		}
		if (rect.intersects(tank.rect)) {
			tank.die();
			this.die();
			int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
			int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
			tf.explodes.add(new Explode(x, y, tf));
		}
		
	}

	private void die() {
		this.living = false;
	}
	
}
