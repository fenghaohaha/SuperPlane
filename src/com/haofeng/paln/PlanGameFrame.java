package com.haofeng.paln;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import com.haofeng.util.Const;
import com.haofeng.util.GameUtils;
import com.haofeng.util.MyFrame;

public class PlanGameFrame extends MyFrame {

	Image bg = GameUtils.getImage(Const.getBackgd());

	Plane p = new Plane(Const.getHero(), 50, 50);
	public int BulletCount=Const.getBulletCount();
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();// �ӵ�����

	Date startTime;
	Date endTime;
	Explode bao;

	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		for (Bullet b : bulletList) {
			b.draw(g);
			// �����ɻ�����ײ
			boolean crash = b.getRect().intersects(p.getRect());
			if (crash) {
				p.setLife(false);// �ɻ�����
				if (bao == null) {
					bao = new Explode(p.x, p.y);
					endTime = new Date();
				}
			}
		}
		if (!p.isLife()) {
			bao.draw(g);
			// printGameOver(g, "GAME OVER", 100, 200, 100);
			int LiveTime = (int) (endTime.getTime() - startTime.getTime()) / 1000;
			printGameOver(g, Color.yellow, "���ʱ�䣺" + LiveTime + "��", 430, 500,
					60);
			printGameOver(g, Color.black, "--�����Ʒ--", 430, 620, 60);
			printGameOver(g, Color.black, "--��ϵ��hao_fong@qq.com", 430, 690, 60);

			switch (LiveTime / 10) {
			case 0:
				printGameOver(g, Color.red, "U R A LOSER!", 400, 300, 100);
				break;
			case 1:
				printGameOver(g, Color.red, "U R A LOSER!", 400, 300, 100);
				break;
			case 2:
				printGameOver(g, Color.yellow, "������!", 460, 300, 100);
				break;
			case 3:
				printGameOver(g, Color.yellow, "�����ԣ�", 460, 300, 100);
				break;
			case 4:
				printGameOver(g, Color.yellow, "������!", 460, 300, 100);
				break;
			case 5:
				printGameOver(g, Color.yellow, "������!", 460, 300, 100);
				break;
			case 6:
				printGameOver(g, Color.blue, "����ô�����!", 400, 300, 100);
				break;
			case 7:
				printGameOver(g, Color.blue, "����ô�����!", 400, 300, 100);
				break;
			case 8:
				printGameOver(g, Color.blue, "����ô�����!", 400, 300, 100);
				break;
			case 9:
				printGameOver(g, Color.green, "��̫����!", 450, 300, 100);
				break;
			case 10:
				printGameOver(g, Color.green, "��̫����!", 450, 300, 100);
				break;
			case 11:
				printGameOver(g, Color.green, "��̫����!", 450, 300, 100);
				break;
			default:
				printGameOver(g, Color.orange, "��������Ҳ!", 450, 300, 100);
				break;
			}
		}
	}

	public void printGameOver(Graphics g, Color color, String strGG, int x,
			int y, int size) {
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("����", Font.BOLD, size);
		g.setFont(f);
		g.drawString(strGG, x, y);
		g.setColor(c);
	}

	public void LaunchFrame() {
		super.LaunchFrame();// �Ѹ���ļ��ؽ���
		// ���Ӽ��̼���
		addKeyListener(new keyMonitor());
		// �����ӵ�
		for (int i = 0; i < BulletCount; i++) {
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		// ����Ϸ����ʱ ��ʼ��ʱ
		startTime = new Date();
	}

	// ����Ϊ�ڲ��� ���Է����ʹ���ⲿ�����ͨ����
	class keyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p.minusSirection(e);
		}
	}
}
