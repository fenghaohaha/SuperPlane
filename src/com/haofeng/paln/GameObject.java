package com.haofeng.paln;

/**
 * ��Ϸ������
 * ��ȡ���ӵ� �ɻ��Ĺ�ͬ��
 */
import java.awt.Image;
import java.awt.Rectangle;

import com.haofeng.util.Const;

public class GameObject {
	Image img;// ͼƬ
	double x, y;// ����
	int speed = Const.getSpeed();// �����ٶ�

	int width, height;

	public Rectangle getRect() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	public GameObject(Image img, double x, double y, int speed, int width,
			int height) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	public GameObject() {
	}

}