package com.jack.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

	public TankFrame() {
		// 设置窗口可见
		setVisible(true);
		// 设置窗体标题
		setTitle("tank war");
		// 设置窗体宽高
		setSize(800, 600);
		// 设置窗体不可随意改变宽高
		setResizable(false);
		
		// 监听窗口关闭事件
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
			
		});
		
	}

	/**
	   * 窗口重新绘制会被自动调用
	 */
	@Override
	public void paint(Graphics g) {
		g.fillRect(200, 200, 50, 50);		
	}

}
