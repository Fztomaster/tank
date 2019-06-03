package com.jack.tank;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tf = new TankFrame();
		
		int tankCount = Integer.parseInt((String) PropertyMgr.get("tankInitCount"));
		
		for (int i = 0; i < tankCount; i++) {
			tf.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, tf));
		}
		
		// new Thread(() -> new Audio("audio/war1.wav").loop()).start();
		
		while (true) {
			Thread.sleep(50);
			tf.repaint();
		}
	}

}
