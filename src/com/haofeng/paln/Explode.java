package com.haofeng.paln;

import java.awt.Graphics;
import java.awt.Image;

import com.haofeng.util.GameUtils;

/**
 * 
 * �ɻ���ը Ч����ʾ
 * 
 * @author feng
 *
 */
public class Explode {
	double x, y;
	Image img = GameUtils.getImage("images/died.jpg");

	public void draw(Graphics g) {
		g.drawImage(img, (int) x, (int) y, null);
	}

	public Explode(double x, double y) {
		this.x = x;
		this.y = y;
	}

}