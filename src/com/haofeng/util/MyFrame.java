package com.haofeng.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
	public void LaunchFrame() {
		setSize(Const.Frame_Width, Const.Frame_Height);
		setLocation(0, 0);
		setVisible(true);
		setTitle(Const.Game_name);
		
		new PaintFrame().start();

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}

	/**
	 * �ػ��߳��ڲ��� ����ˢ�½���
	 */
	class PaintFrame extends Thread {
		@Override
		public void run() {
			super.run();
			while (true) {
				repaint();// �ػ�����
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private Image offScreenImage = null;// ʹ��˫���弼�������˸

	public void update(Graphics g) {
		if (offScreenImage == null)
			offScreenImage = this.createImage(Const.Frame_Width,
					Const.Frame_Height);
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
}
