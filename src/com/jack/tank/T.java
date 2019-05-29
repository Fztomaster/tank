package com.jack.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {

	public static void main(String[] args) {
		Frame f = new Frame();
		// 设置窗口可见
		f.setVisible(true);
		// 设置窗体标题
		f.setTitle("tank war");
		// 设置窗体宽高
		f.setSize(800, 600);
		// 设置窗体不可随意改变宽高
		f.setResizable(false);
		
		// 监听窗口关闭
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
			
		});

	}

}
